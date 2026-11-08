import java.util.ArrayList;
import java.util.List;

/** Represents a bank customer and the customer's accounts. */
public class Customer {
  private long idNumber;
  private String fullName;
  private List<Account> accountList;

  /** Creates an empty customer. */
  public Customer() {
    this(0L, "");
  }

  /** Creates a customer with an ID and full name. */
  public Customer(long idNumber, String fullName) {
    this.idNumber = idNumber;
    this.fullName = fullName;
    this.accountList = new ArrayList<>();
  }

  /** Returns the customer's ID number. */
  public long getIdNumber() {
    return idNumber;
  }

  /** Sets the customer's ID number. */
  public void setIdNumber(long idNumber) {
    this.idNumber = idNumber;
  }

  /** Returns the customer's full name. */
  public String getFullName() {
    return fullName;
  }

  /** Sets the customer's full name. */
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  /** Returns the customer's accounts. */
  public List<Account> getAccountList() {
    return accountList;
  }

  /** Replaces the account list, using an empty list for {@code null}. */
  public void setAccountList(List<Account> accountList) {
    this.accountList = accountList == null ? new ArrayList<>() : accountList;
  }

  /** Adds an account if it is non-null and is not already present. */
  public void addAccount(Account account) {
    if (account != null && !accountList.contains(account)) {
      accountList.add(account);
    }
  }

  /** Removes the specified account. */
  public void removeAccount(Account account) {
    if (account != null) {
      accountList.remove(account);
    }
  }

  /** Returns a concise text description of this customer. */
  public String getCustomerInfo() {
    return "Số CMND: " + idNumber + ". Họ tên: " + fullName + ".";
  }
}
