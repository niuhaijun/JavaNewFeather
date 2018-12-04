package niu;

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
}
