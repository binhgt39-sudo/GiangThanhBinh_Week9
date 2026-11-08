import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** A checking account that records deposits and withdrawals. */
public class CheckingAccount extends Account {
  private static final Logger LOGGER = LoggerFactory.getLogger(CheckingAccount.class);

  /** Creates a checking account. */
  public CheckingAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public void deposit(double amount) {
    double initialBalance = getBalance();
    try {
      doDepositing(amount);
      addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_CHECKING, amount, initialBalance,
          getBalance()));
      LOGGER.info("Deposit completed for checking account {}: amount={}, balance={}",
          getAccountNumber(), amount, getBalance());
    } catch (BankException exception) {
      LOGGER.error("Deposit failed for checking account {}: amount={}", getAccountNumber(),
          amount, exception);
    }
  }

  @Override
  public void withdraw(double amount) {
    double initialBalance = getBalance();
    try {
      doWithdrawing(amount);
      addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_CHECKING, amount, initialBalance,
          getBalance()));
      LOGGER.info("Withdrawal completed for checking account {}: amount={}, balance={}",
          getAccountNumber(), amount, getBalance());
    } catch (BankException exception) {
      LOGGER.error("Withdrawal failed for checking account {}: amount={}", getAccountNumber(),
          amount, exception);
    }
  }
}
