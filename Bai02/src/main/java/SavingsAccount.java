import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** A savings account with withdrawal limits and a minimum balance. */
public class SavingsAccount extends Account {
  private static final Logger LOGGER = LoggerFactory.getLogger(SavingsAccount.class);
  private static final double MAX_WITHDRAWAL = 1000.0;
  private static final double MINIMUM_BALANCE = 5000.0;

  /** Creates a savings account. */
  public SavingsAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public void deposit(double amount) {
    double initialBalance = getBalance();
    try {
      doDepositing(amount);
      addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS, amount, initialBalance,
          getBalance()));
      LOGGER.info("Deposit completed for savings account {}: amount={}, balance={}",
          getAccountNumber(), amount, getBalance());
    } catch (BankException exception) {
      LOGGER.error("Deposit failed for savings account {}: amount={}", getAccountNumber(),
          amount, exception);
    }
  }

  @Override
  public void withdraw(double amount) {
    double initialBalance = getBalance();
    try {
      if (amount > MAX_WITHDRAWAL) {
        throw new InvalidFundingAmountException(amount);
      }
      if (initialBalance - amount < MINIMUM_BALANCE) {
        throw new InsufficientFundsException(amount);
      }
      doWithdrawing(amount);
      addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS, amount, initialBalance,
          getBalance()));
      LOGGER.info("Withdrawal completed for savings account {}: amount={}, balance={}",
          getAccountNumber(), amount, getBalance());
    } catch (BankException exception) {
      LOGGER.error("Withdrawal failed for savings account {}: amount={}", getAccountNumber(),
          amount, exception);
    }
  }
}
