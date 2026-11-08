import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AccountServiceTest {
  private final AccountService service = new AccountService();

  @Test
  void logsAndCompletesDeposit() {
    assertEquals(3000.0, service.deposit(123456789L, 2500.0, 500.0));
  }

  @Test
  void logsAndRejectsInvalidDeposit() {
    assertThrows(IllegalArgumentException.class,
        () -> service.deposit(123456789L, 2500.0, -1.0));
  }
}
