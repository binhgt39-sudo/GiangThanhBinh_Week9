import java.util.Locale;

/** Describes a deposit or withdrawal and the balances before and after it. */
public class Transaction {
  /** Deposit to a checking account. */
  public static final int TYPE_DEPOSIT_CHECKING = 1;
  /** Withdrawal from a checking account. */
  public static final int TYPE_WITHDRAW_CHECKING = 2;
  /** Deposit to a savings account. */
  public static final int TYPE_DEPOSIT_SAVINGS = 3;
  /** Withdrawal from a savings account. */
  public static final int TYPE_WITHDRAW_SAVINGS = 4;

  private int type;
  private double amount;
  private double initialBalance;
  private double finalBalance;

  /** Creates a transaction record. */
  public Transaction(int type, double amount, double initialBalance, double finalBalance) {
    this.type = type;
    this.amount = amount;
    this.initialBalance = initialBalance;
    this.finalBalance = finalBalance;
  }

  /** Returns the transaction type. */
  public int getType() {
    return type;
  }

  /** Sets the transaction type. */
  public void setType(int type) {
    this.type = type;
  }

  /** Returns the transaction amount. */
  public double getAmount() {
    return amount;
  }

  /** Sets the transaction amount. */
  public void setAmount(double amount) {
    this.amount = amount;
  }

  /** Returns the balance before the transaction. */
  public double getInitialBalance() {
    return initialBalance;
  }

  /** Sets the balance before the transaction. */
  public void setInitialBalance(double initialBalance) {
    this.initialBalance = initialBalance;
  }

  /** Returns the balance after the transaction. */
  public double getFinalBalance() {
    return finalBalance;
  }

  /** Sets the balance after the transaction. */
  public void setFinalBalance(double finalBalance) {
    this.finalBalance = finalBalance;
  }

  /** Returns the localized name for a transaction type. */
  public static String getTypeString(int transactionType) {
    switch (transactionType) {
      case TYPE_DEPOSIT_CHECKING:
        return "Nạp tiền vãng lai";
      case TYPE_WITHDRAW_CHECKING:
        return "Rút tiền vãng lai";
      case TYPE_DEPOSIT_SAVINGS:
        return "Nạp tiền tiết kiệm";
      case TYPE_WITHDRAW_SAVINGS:
        return "Rút tiền tiết kiệm";
      default:
        return "Không rõ";
    }
  }

  /** Returns a formatted summary of the transaction. */
  public String getTransactionSummary() {
    return String.format(Locale.US,
        "- Kiểu giao dịch: %s. Số dư ban đầu: $%.2f. Số tiền: $%.2f. Số dư cuối: $%.2f.",
        getTypeString(type), initialBalance, amount, finalBalance);
  }
}
