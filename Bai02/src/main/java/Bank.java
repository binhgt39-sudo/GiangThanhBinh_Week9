import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Stores customers and reads their records from a text stream. */
public class Bank {
  private static final Logger LOGGER = LoggerFactory.getLogger(Bank.class);
  private static final int CUSTOMER_ID_LENGTH = 9;
  private static final String CUSTOMER_ID_PATTERN = "\\d{" + CUSTOMER_ID_LENGTH + "}";

  private List<Customer> customerList;

  /** Creates an empty bank. */
  public Bank() {
    customerList = new ArrayList<>();
  }

  /** Returns the customers held by this bank. */
  public List<Customer> getCustomerList() {
    return customerList;
  }

  /** Replaces the customer list, using an empty list for {@code null}. */
  public void setCustomerList(List<Customer> customerList) {
    this.customerList = customerList == null ? new ArrayList<>() : customerList;
  }

  /** Reads customer and account records from the supplied stream. */
  public void readCustomerList(InputStream inputStream) {
    if (inputStream == null) {
      LOGGER.warn("Customer data stream was null; no records were loaded");
      return;
    }
    LOGGER.info("Starting customer data import");
    Customer currentCustomer = null;
    int customersRead = 0;
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    try {
      String line;
      while ((line = reader.readLine()) != null) {
        String record = line.trim();
        if (record.isEmpty()) {
          continue;
        }
        int lastSpace = record.lastIndexOf(' ');
        if (lastSpace > 0 && record.substring(lastSpace + 1).matches(CUSTOMER_ID_PATTERN)) {
          currentCustomer = new Customer(
              Long.parseLong(record.substring(lastSpace + 1)), record.substring(0, lastSpace));
          customerList.add(currentCustomer);
          customersRead++;
        } else if (currentCustomer != null) {
          addAccountRecord(currentCustomer, record);
        } else {
          LOGGER.warn("Ignoring account record before a customer record: {}", record);
        }
      }
      LOGGER.info("Customer data import completed: {} customers loaded", customersRead);
    } catch (IOException exception) {
      LOGGER.error("Could not read customer data after loading {} customers", customersRead,
          exception);
    }
  }

  private void addAccountRecord(Customer customer, String record) {
    String[] parts = record.split("\\s+");
    if (parts.length < 3) {
      LOGGER.warn("Ignoring malformed account record: {}", record);
      return;
    }
    try {
      long accountNumber = Long.parseLong(parts[0]);
      double balance = Double.parseDouble(parts[2]);
      if (Account.CHECKING_TYPE.equals(parts[1])) {
        customer.addAccount(new CheckingAccount(accountNumber, balance));
      } else if (Account.SAVINGS_TYPE.equals(parts[1])) {
        customer.addAccount(new SavingsAccount(accountNumber, balance));
      } else {
        LOGGER.warn("Ignoring account with unknown type {}", parts[1]);
      }
    } catch (NumberFormatException exception) {
      LOGGER.warn("Ignoring account record with invalid numeric data: {}", record, exception);
    }
  }

  /** Returns customer information ordered by ID. */
  public String getCustomersInfoByIdOrder() {
    return getCustomerInfo(Comparator.comparingLong(Customer::getIdNumber));
  }

  /** Returns customer information ordered by name and then ID. */
  public String getCustomersInfoByNameOrder() {
    return getCustomerInfo(Comparator.comparing(Customer::getFullName)
        .thenComparingLong(Customer::getIdNumber));
  }

  private String getCustomerInfo(Comparator<Customer> comparator) {
    List<Customer> sortedCustomers = new ArrayList<>(customerList);
    sortedCustomers.sort(comparator);
    StringBuilder result = new StringBuilder();
    for (Customer customer : sortedCustomers) {
      if (result.length() > 0) {
        result.append('\n');
      }
      result.append(customer.getCustomerInfo());
    }
    return result.toString();
  }
}
