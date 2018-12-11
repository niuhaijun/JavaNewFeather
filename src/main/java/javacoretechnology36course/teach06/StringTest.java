package javacoretechnology36course.teach06;

import org.junit.Test;

/**
 * @author niuhaijun
 * @date 2018/12/11 14:23
 */
public class StringTest {


  @Test
  public void testStringBuffer() {

    StringBuffer buffer = new StringBuffer();
    System.out.println(buffer.capacity());

    for (int i = 1; i <= 143; i++) {
      buffer.append(0);
      System.out.println(buffer.length() + "->" + buffer.capacity());
    }

  }

  @Test
  public void testStringBuilder() {

    StringBuilder buffer = new StringBuilder();
    System.out.println(buffer.capacity());

    for (int i = 1; i <= 143; i++) {
      buffer.append(0);
      System.out.println(buffer.length() + "->" + buffer.capacity());
    }

  }

  @Test
  public void test() {

    String ss2 = "abc";
    String ss1 = "a" + "bc";
    System.out.println(ss1 == ss2);//true

    ss2 = "abc" + "def";
    ss1 = ss1 + "def";
    System.out.println(ss1 == ss2);//false---为什么?
  }
}
