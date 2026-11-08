import java.util.Locale;

/** Exception raised when an account cannot cover a withdrawal. */
public class InsufficientFundsException extends BankException {
  /** Creates an exception describing the requested amount. */
  public InsufficientFundsException(double amount) {
    super("Số dư tài khoản không đủ $" + String.format(Locale.US, "%.2f", amount)
        + " để thực hiện giao dịch");
  }
}
