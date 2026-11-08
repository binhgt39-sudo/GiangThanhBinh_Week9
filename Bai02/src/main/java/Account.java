import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Account {
  private static final Logger LOGGER = LoggerFactory.getLogger(Account.class);
  public static final String CHECKING_TYPE = "CHECKING";
  public static final String SAVINGS_TYPE = "SAVINGS";

  private long accountNumber;
  private double balance;
  protected List<Transaction> transactions;

  public Account(long accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.transactions = new ArrayList<>();
  }

  public long getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(long accountNumber) {
    this.accountNumber = accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  protected void setBalance(double balance) {
    this.balance = balance;
  }

  public List<Transaction> getTransactionList() {
    return transactions;
  }

  public void setTransactionList(List<Transaction> transactionList) {
    this.transactions = transactionList == null ? new ArrayList<>() : transactionList;
  }

  public abstract void deposit(double amount);

  public abstract void withdraw(double amount);

  protected void doDepositing(double amount) throws InvalidFundingAmountException {
    if (amount <= 0) {
      throw new InvalidFundingAmountException(amount);
    }
    balance += amount;
  }

  protected void doWithdrawing(double amount)
      throws InvalidFundingAmountException, InsufficientFundsException {
    if (amount <= 0) {
      throw new InvalidFundingAmountException(amount);
    }
    if (amount > balance) {
      throw new InsufficientFundsException(amount);
    }
    balance -= amount;
  }

  public void addTransaction(Transaction transaction) {
    if (transaction != null) {
      transactions.add(transaction);
    }
  }

  public String getTransactionHistory() {
    LOGGER.debug("Reading history for account {} with {} transactions", accountNumber,
        transactions.size());
    StringBuilder history = new StringBuilder("Lịch sử giao dịch của tài khoản ")
        .append(accountNumber).append(":\n");
    for (int index = 0; index < transactions.size(); index++) {
      if (index > 0) {
        history.append('\n');
      }
      history.append(transactions.get(index).getTransactionSummary());
    }
    return history.toString();
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof Account)) {
      return false;
    }
    Account other = (Account) object;
    return accountNumber == other.accountNumber;
  }

  @Override
  public int hashCode() {
    return Long.hashCode(accountNumber);
  }
}
