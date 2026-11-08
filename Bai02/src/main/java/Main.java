import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Provides the command-line entry point required by the submission instructions. */
public final class Main {
  private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

  private Main() {}

  /** Runs a small account transaction to demonstrate the bank system. */
  public static void main(String[] args) {
    CheckingAccount account = new CheckingAccount(100000001L, 2500.00);
    account.deposit(500.00);
    LOGGER.info("Transaction history:\n{}", account.getTransactionHistory());
  }
}
