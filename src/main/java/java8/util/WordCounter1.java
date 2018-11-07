package java8.util;

import java.util.Objects;

/**
 * @author niuhaijun
 * @date 2018/9/28 17:17
 */
public class WordCounter1 {
  private static long sum;

  public static long count(String words) {
    if (Objects.isNull(words) || "".equals(words)) {
      return sum;
    }

    boolean isSpace = true;
    for (char c : words.toCharArray()) {
      if (Character.isWhitespace(c)) {
        isSpace = true;
      } else {
        if (isSpace) {
          sum++;
        }
        isSpace = false;
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    String words = "A b c d ";
    System.out.println(WordCounter1.count(words));
  }
}
