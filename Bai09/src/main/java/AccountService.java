import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Applies account deposits and withdrawals. */
public class AccountService {
  private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

  /** Deposits an amount and returns the updated balance. */
  public double deposit(long accountNumber, double balance, double amount) {
    if (amount <= 0) {
      IllegalArgumentException exception = new IllegalArgumentException("Amount must be positive");
      LOGGER.error("Deposit rejected: account={}, amount={}", accountNumber, amount, exception);
      throw exception;
    }
    double updatedBalance = balance + amount;
    LOGGER.info("Deposit completed: account={}, amount={}, balance={}", accountNumber, amount,
        updatedBalance);
    return updatedBalance;
  }
}
