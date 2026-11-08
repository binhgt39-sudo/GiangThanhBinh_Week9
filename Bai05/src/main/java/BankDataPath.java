import java.nio.file.Path;

/** Builds platform-independent paths for bank data files. */
public final class BankDataPath {
  private BankDataPath() {}

  /** Resolves a file name under a data directory. */
  public static Path resolve(String directory, String fileName) {
    return Path.of(directory, fileName);
  }
}
