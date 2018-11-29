package java8.fulu.b.utils;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.Test;

/**
 * @author niuhaijun
 * @date 2018/11/29 22:51
 */
public class ArraysTest {

  /**
   * parallelSort
   */
  @Test
  public void testParallelSort() {

    Integer[] array = null;

    array = getArray();
    System.out.println(Arrays.toString(array));

    System.out.println();

    array = getArray();
    Arrays.parallelSort(array);
    System.out.println(Arrays.toString(array));

    array = getArray();
    Arrays.parallelSort(array, Comparator.naturalOrder());
    System.out.println(Arrays.toString(array));

  }

  /**
   * setAll
   * parallelSetAll
   */
  @Test
  public void testSetAll() {

    Integer[] array = null;

    array = getArray();
    System.out.println(Arrays.toString(array));

    Arrays.setAll(array, i -> i * i);
    System.out.println(Arrays.toString(array));

    Arrays.parallelSetAll(array, i -> i * i);
    System.out.println(Arrays.toString(array));
  }

  /**
   * parallelPrefix
   */
  @Test
  public void testParallelPrefix() {

    Integer[] data = getArray();
    System.out.println(Arrays.toString(data));

    Arrays.parallelPrefix(data, (a, b) -> a * b);
    System.out.println(Arrays.toString(data));
  }

  private Integer[] getArray() {

    return new Integer[]{3, 2, 1, 0, 1, 0};
  }
}
