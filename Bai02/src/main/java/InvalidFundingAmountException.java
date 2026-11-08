import java.util.Locale;

/** Exception raised when a transaction amount is not valid. */
public class InvalidFundingAmountException extends BankException {
  /** Creates an exception describing the invalid amount. */
  public InvalidFundingAmountException(double amount) {
    super("Số tiền không hợp lệ: $" + String.format(Locale.US, "%.2f", amount));
  }
}
