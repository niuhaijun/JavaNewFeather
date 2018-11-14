package java8.stream;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 创建流
 *
 * @author niuhaijun
 * @date 2018/9/13 9:58
 */
public class CreatingStreams {

  public static <T> void show(String title, Stream<T> stream) {

    final int SIZE = 10;
    List<T> firstElements = stream
        .limit(SIZE + 1)
        .collect(Collectors.toList());
    System.out.print(title + ": ");
    for (int i = 0; i < firstElements.size(); i++) {
      if (i > 0) {
        System.out.print(", ");
      }
      if (i < SIZE) {
        System.out.print(firstElements.get(i));
      } else {
        System.out.print("...");
      }
    }
    System.out.println();
  }

  public static void main(String[] args) throws IOException {

    Path path = Paths.get("D:/IdeaWorkSpace/Java8/src/main/java/files/alice30.txt");
    String contents = new String(Files.readAllBytes(path),
        StandardCharsets.UTF_8);

    // 数组
    Stream<String> words = Stream.of(contents.split("\\PL+"));
    show("words", words);

    // 可变参数
    Stream<String> song = Stream.of("gently", "down", "the", "stream");
    show("song", song);

    // 空流
    Stream<String> silence = Stream.empty();
    show("silence", silence);

    // 无限流
    Stream<String> echos = Stream.generate(() -> "Echo");
    show("echos", echos);

    // 无限流
    Stream<Double> randoms = Stream.generate(Math::random);
    show("randoms", randoms);

    // 无限流
    Stream<BigInteger> integers = Stream.iterate(BigInteger.ONE,
        n -> n.add(BigInteger.ONE));
    show("integers", integers);

    Stream<String> wordsAnotherWay = Pattern.compile("\\PL+").splitAsStream(
        contents);
    show("wordsAnotherWay", wordsAnotherWay);

    try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
      show("lines", lines);
    }
  }
}

