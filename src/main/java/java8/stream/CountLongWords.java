package java8.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * 统计长单词
 *
 * @author niuhaijun
 * @date 2018/9/13 9:27
 */
public class CountLongWords {

  @Test
  public void test() throws IOException {
    String contents = new String(Files.readAllBytes(
        Paths.get("D:/IdeaWorkSpace/Java8/src/main/java/files/alice30.txt")),
        StandardCharsets.UTF_8);
    List<String> words = Arrays.asList(contents.split("\\PL+"));
    long count = 0;
    for (String w : words) {
      if (w.length() > 12) {
        count++;
      }
    }
    System.out.println(count);

    count = words.stream().filter(w -> w.length() > 12).count();
    System.out.println(count);

    count = words.parallelStream().filter(w -> w.length() > 12).count();
    System.out.println(count);
  }
}
