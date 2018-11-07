package java8.collector;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author niuhaijun
 * @date 2018/10/8 17:13
 */
public class FileUtils {

  public static Stream<String> noVowels(String path) throws IOException {
    String contents = new String(Files.readAllBytes(
        Paths.get(path)), UTF_8);
    List<String> wordList = Arrays.asList(contents.split("\\PL+"));
    Stream<String> words = wordList.stream();
    return words.map(s -> s.replaceAll("[aeiouAEIOU]", ""));
  }
}
