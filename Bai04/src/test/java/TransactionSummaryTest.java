import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TransactionSummaryTest {
  @Test
  void namesTransactionTypes() {
    assertEquals("Deposit", TransactionSummary.typeName(TransactionSummary.TYPE_DEPOSIT));
    assertEquals("Withdrawal", TransactionSummary.typeName(TransactionSummary.TYPE_WITHDRAWAL));
    assertEquals("Unknown", TransactionSummary.typeName(99));
  }

  @Test
  void formatsTransactionAmounts() {
    assertEquals("Deposit: $500.00, balance $3000.00",
        TransactionSummary.format(TransactionSummary.TYPE_DEPOSIT, 500, 3000));
  }
}
