package java8.util;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author niuhaijun
 * @date 2018/9/28 17:33
 */
public class WordCounter2 {

  private final int counter;
  private final boolean lastSpace;

  public WordCounter2(int counter, boolean lastSpace) {

    this.counter = counter;
    this.lastSpace = lastSpace;
  }

  private static int countWords(Stream<Character> stream) {

    WordCounter2 wc = stream
        .reduce(new WordCounter2(0, true), WordCounter2::accumulate, WordCounter2::combine);

    return wc.getCounter();
  }

  public static void main(String[] args) {

    String words = "A b c d ee";
    System.out.println(
        WordCounter2.countWords(IntStream.range(0, words.length()).mapToObj(words::charAt)));
  }

  public WordCounter2 accumulate(Character c) {

    if (Character.isWhitespace(c)) {
      return lastSpace ? this : new WordCounter2(counter, true);
    } else {
      return lastSpace ? new WordCounter2(counter + 1, false) : this;
    }
  }

  public WordCounter2 combine(WordCounter2 other) {

    return new WordCounter2(counter + other.getCounter(), false);
  }

  public int getCounter() {

    return counter;
  }
}
