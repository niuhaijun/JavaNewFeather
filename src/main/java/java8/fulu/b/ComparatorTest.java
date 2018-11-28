package java8.fulu.b;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

/**
 * @author niuhaijun
 * @date 2018/11/28 18:16
 */
public class ComparatorTest {

  /**
   * naturalOrder
   */
  @Test
  public void testNaturalOrder() {

    Comparator<Integer> comparator = Comparator.naturalOrder();
    List<Integer> list = getList();

    System.out.println(list);

    list.sort(comparator);

    System.out.println(list);
  }


  /**
   * reversed
   */
  @Test
  public void testReversed() {

    Comparator<Integer> comparator = Comparator.naturalOrder();

    List<Integer> list = getList();
    System.out.println(list);

    list.sort(comparator);
    System.out.println(list);

    comparator = comparator.reversed();
    list.sort(comparator);
    System.out.println(list);
  }


  /**
   * reverseOrder
   */
  @Test
  public void testReverseOrder() {

    Comparator<Integer> comparator = Comparator.reverseOrder();

    List<Integer> list = getList();
    System.out.println(list);

    list.sort(comparator);
    System.out.println(list);
  }


  private List<Integer> getList() {

    return new ArrayList<Integer>() {
      {
        add(4);
        add(2);
        add(1);
        add(3);
      }
    };
  }

}
