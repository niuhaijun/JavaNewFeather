package niu;

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

    String html = "<p>xxx</p>";
    Document doc = Jsoup.parse(html);
    System.out.println(doc.body());
  }

  @Test
  public void test1() {

    String str = "<p><span style=\"text-transform: none; background-color: rgb(255,255,255); text-indent: 0px; display: inline !important; font: 14px/24px 'Lucida Grande', 'Lucida Sans Unicode', sans-serif; white-space: normal; float: none; letter-spacing: normal; color: rgb(0,0,0); word-spacing: 0px; -webkit-text-stroke-width: 0px\">学而思初中生物学科负责人，\r\n两年毕业年级教学经验。</span></p>";
    String regexHtml = "[<][^<]+[>]";
    String regEx_space = "\\s*|\t|\r|\n";
    System.out.println(str.replaceAll(regexHtml, "").replaceAll(regEx_space, ""));


  }
}
