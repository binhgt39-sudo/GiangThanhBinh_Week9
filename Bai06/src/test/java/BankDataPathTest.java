import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class BankDataPathTest {
  @Test
  void resolvesFileNamesUsingPlatformPathRules() {
    assertEquals(Path.of("data", "accounts.csv"),
        BankDataPath.resolve("data", "accounts.csv"));
  }
}
