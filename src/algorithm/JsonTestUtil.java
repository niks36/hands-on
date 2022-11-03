package algorithm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import lombok.SneakyThrows;
import org.mvel2.templates.TemplateCompiler;
import org.mvel2.templates.TemplateRuntime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonTestUtil {
  private static final Logger LOGGER = LoggerFactory.getLogger(JsonTestUtil.class);
  private static ObjectMapper objectMapper = new ObjectMapper();

  private JsonTestUtil() {}

  public static String getTransformedJSON(String inputFile, Map<String, String> dynaParams) {
    return (String)
        TemplateRuntime.execute(
            TemplateCompiler.compileTemplate(prepareInputOutput(inputFile)), dynaParams);
  }

  public static String prepareInputOutput(String inputFile) {
    try {
      return new String(
          Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(inputFile).toURI())));
    } catch (URISyntaxException | IOException e) {
      LOGGER.error("Unable to read the classpath Json File: " + inputFile);
      throw new RuntimeException(e.getMessage());
    }
  }

  @SneakyThrows
  private static String convertToJson(Object value, ObjectWriter writer) {
    return writer.writeValueAsString(value);
  }
}
