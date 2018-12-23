package niu;

import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.stream.Stream;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

/**
 * Hello world!
 *
 */
public class App {

  public static void main(String[] args) {

    System.out.println("Hello World!");
  }

  @Test
  public void testAppend() {

    StringBuilder builder = new StringBuilder();

    builder.append(1);
    System.out.println(builder);

    builder.append(1);
    System.out.println(builder);

    builder.append(1);
    System.out.println(builder);

    String message = "abc%sabc";
    if (3 > 2) {
      message = String.format(message, "1111");
    }
    System.out.println(message);

    System.out.println(0 % 10);

  }

  /**
   * 去除HTML标签
   */
  @Test
  public void test() {

    String html = "<p>&nbsp;张笑老师毕业于华中农业大学，现为学而思小学数学优秀老师，从小数学功底深厚。"
        + "对待孩子十分耐心，极具亲和力，得到广大学生和家长的喜爱。授课深入浅出，生动有趣，吸引孩子主动学习，"
        + "注重学习方法和学习习惯的培养，让孩子真正融入学习。</p>\r\n<div>&nbsp;</div>";
    Document doc = Jsoup.parse(html);
//    System.out.println(doc.body());
    System.out.println(doc.text());
  }

  @Test
  public void test1() {

    String str = "<p>&nbsp;张笑老师毕业于华中农业大学，现为学而思小学数学优秀老师，从小数学功底深厚。"
        + "对待孩子十分耐心，极具亲和力，得到广大学生和家长的喜爱。授课深入浅出，生动有趣，吸引孩子主动学习，"
        + "注重学习方法和学习习惯的培养，让孩子真正融入学习。</p>\r\n<div>&nbsp;</div>";
    String regexHtml = "[<][^<]+[>]";
    String regEx_space = "\\s*|\t|\r|\n";
    System.out.println(str.replaceAll(regexHtml, "").replaceAll(regEx_space, ""));


  }

  @Test
  public void test2() {

    Byte b = Byte.valueOf("12");
    Short s = Short.valueOf("123");
    Integer i = Integer.valueOf("123");
    Long l = Long.valueOf(123);
    Character c = Character.valueOf((char) 0);
  }

  @Test
  public void test3() {

    Stream<Integer> stream = Stream.of(1, 2, 3, 1);
    Map<Integer, Integer> map = stream.collect(toMap(key -> key, value -> value, (oldValue, newValue) -> oldValue + newValue));
    System.out.println(map.get(1));
  }
}
