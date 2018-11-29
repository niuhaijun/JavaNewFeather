package java8.fulu.b.number;

import org.junit.Test;

/**
 * 处理无符号数的类
 *
 * Integer
 *    parseUnsignedInt
 * Long
 *    parseUnsignedLong
 *
 *
 *
 * @author niuhaijun
 * @date 2018/11/29 11:25
 */
public class UnsignedNumberTest {

  /**
   * compareUnsigned
   */
  @Test
  public void testCompareUnsigned() {

    int res = Integer.compareUnsigned(-1111, 111);
    System.out.println(res);
  }

  /**
   * divideUnsigned
   */
  @Test
  public void testDivideUnsigned() {

    int res = Integer.divideUnsigned(-111, 111);
    System.out.println(res);
  }

  /**
   * remainderUnsigned
   */
  @Test
  public void testRemainderUnsigned() {

    int res = Integer.remainderUnsigned(-1111, 111);
    System.out.println(res);
  }

  /**
   * parseUnsignedInt
   */
  @Test
  public void testParseUnsignedInt() {

    int num = Integer.parseUnsignedInt("123456");
    System.out.println(num);
  }

  /**
   * Number、Boolean类涉及的新增方法
   */
  @Test
  public void test() {

    StringBuilder builder = new StringBuilder();
    builder
        .append("Short\n")
        .append("Integer\n")
        .append("Long\n")
        .append("Float\n")
        .append("Double\n")
        .append("  max\n")
        .append("  min\n")
        .append("  sum\n\n");

    builder
        .append("Integer\n")
        .append("Long\n")
        .append("  compareUnsigned\n")
        .append("  divideUnsigned\n")
        .append("  remainderUnsigned\n")
        .append("  toUnsignedLong\n\n");

    builder
        .append("Integer\n")
        .append("  parseUnsignedInt\n")
        .append("  toUnsignedInt\n")
        .append("Long\n")
        .append("  parseUnsignedLong\n\n");

    builder
        .append("Byte\n")
        .append("Short\n")
        .append("  toUnsignedInt\n")
        .append("  toUnsignedLong\n\n");

    builder
        .append("Float\n")
        .append("Double\n")
        .append("  isFinite\n\n");

    builder
        .append("Boolean\n")
        .append("  logicalAnd\n")
        .append("  logicalOr\n")
        .append("  logicalXor\n\n");

    builder
        .append("BigInteger\n")
        .append("  byteValueExact\n")
        .append("  shortValueExact\n")
        .append("  intValueExact\n")
        .append("  longValueExact\n\n");

    System.out.println(builder.toString());
  }

}
