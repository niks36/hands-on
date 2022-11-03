package algorithm;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

  public static String readFile(String inputFile) {
    try {
      return new String(
          Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(inputFile).toURI())));
    } catch (URISyntaxException | IOException e) {
      throw new RuntimeException(e);
    }
  }
}
