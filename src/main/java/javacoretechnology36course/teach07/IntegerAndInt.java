package javacoretechnology36course.teach07;

import org.junit.Test;

/**
 * @author niuhaijun
 * @date 2018/12/23 14:24
 */
public class IntegerAndInt {

  @Test
  public void testCache() {

    int[] nums = {-129, -128, 127, 128};
    Integer num1 = nums[0];
    Integer num2 = new Integer(nums[0]);
    Integer num3 = Integer.valueOf(nums[0]);
    System.out.println(num1 == num2);
    System.out.println(num1 == num3);
    System.out.println("<------------------->");

    num1 = nums[1];
    num2 = new Integer(num1);
    num3 = Integer.valueOf(num1);
    System.out.println(num1 == num2);
    System.out.println(num1 == num3);
    System.out.println("<------------------->");

    num1 = nums[2];
    num2 = new Integer(num1);
    num3 = Integer.valueOf(num1);
    System.out.println(num1 == num2);
    System.out.println(num1 == num3);
    System.out.println("<------------------->");

    num1 = nums[3];
    num2 = new Integer(num1);
    num3 = Integer.valueOf(num1);
    System.out.println(num1 == num2);
    System.out.println(num1 == num3);
    System.out.println("<------------------->");
  }
}
