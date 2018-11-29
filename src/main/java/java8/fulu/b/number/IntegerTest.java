package java8.fulu.b.number;

import org.junit.Test;

/**
 * Short
 * Integer
 * Long
 * Float
 * Double
 *   新增了静态方法
 *   min
 *   max
 *   sum
 *
 * @author niuhaijun
 * @date 2018/11/29 11:11
 */
public class IntegerTest {

  /**
   * max
   */
  @Test
  public void testMax() {

    System.out.println(Integer.max(100, 20));
  }

  /**
   * max
   */
  @Test
  public void testMin() {

    System.out.println(Integer.min(100, 20));
  }

  /**
   * sum
   */
  @Test
  public void testSum() {

    System.out.println(Integer.sum(100, 20));
  }

}
