package java8.fulu.b;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

import org.junit.Test;

/**
 * @author niuhaijun
 * @date 2018/11/28 23:38
 */
public class MathTest {

  /**
   * 加法
   * addExact(int, int)
   * addExact(long, long)
   */
  @Test
  public void testAddExact() {

    Math.addExact(MAX_VALUE, 1);
  }

  /**
   * 减法
   * Math.subtractExact(int, int)
   * Math.subtractExact(long, long)
   */
  @Test
  public void testSubtractExact() {

    Math.subtractExact(MAX_VALUE, MIN_VALUE);
  }

  /**
   * 乘法
   * multiplyExact(int, int)
   * multiplyExact(long, long)
   */
  @Test
  public void testMultiplyExact() {

    Math.multiplyExact(MIN_VALUE, 3);
  }

  /**
   * 减1
   * decrementExact(int)
   * decrementExact(long)
   */
  @Test
  public void testDecrementExact() {

    Math.decrementExact(MIN_VALUE);
  }

  /**
   * 加1
   * incrementExact(int)
   * incrementExact(long)
   */
  @Test
  public void testincrementExact() {

    Math.incrementExact(MAX_VALUE);
  }

  /**
   * 取反
   * negateExact
   */
  @Test
  public void testNegateExact() {

    Math.negateExact(MIN_VALUE);

  }
}
