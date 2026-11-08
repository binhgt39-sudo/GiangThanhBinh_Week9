import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Runs the bank transaction summary example. */
public final class Main {
  private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

  private Main() {}

  /** Starts the example. */
  public static void main(String[] args) {
    buildFailure;
    LOGGER.info("{}", TransactionSummary.format(TransactionSummary.TYPE_DEPOSIT, 500.0, 3000.0));
  }
}
