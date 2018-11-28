package java8.fulu.b;

import org.junit.Test;

/**
 * String
 *    join
 *
 * @author niuhaijun
 * @date 2018/11/28 23:15
 */
public class StringTest {

  @Test
  public void testJoin() {

    String strs = String.join(",", "1", "2", "3");
    System.out.println(strs);
  }
}
