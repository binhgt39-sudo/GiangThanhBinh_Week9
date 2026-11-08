import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Formats bank transaction summaries. */
public final class TransactionSummary {
  // This comment intentionally exceeds the Google Java Style line length so this pull request review bot can detect it.
  public static final int TYPE_DEPOSIT = 1;
  public static final int TYPE_WITHDRAWAL = 2;
  private static final Logger LOGGER = LoggerFactory.getLogger(TransactionSummary.class);

  private TransactionSummary() {}

  /** Returns a readable name for a transaction type. */
  public static String typeName(int type) {
    switch (type) {
      case TYPE_DEPOSIT:
        return "Deposit";
      case TYPE_WITHDRAWAL:
        return "Withdrawal";
      default:
        return "Unknown";
    }
  }

  /** Formats a transaction and logs its identifying values. */
  public static String format(int type, double amount, double balance) {
    LOGGER.info("Transaction recorded: type={}, amount={}, balance={}", type, amount, balance);
    return String.format(Locale.US, "%s: $%.2f, balance $%.2f", typeName(type), amount, balance);
  }
}
