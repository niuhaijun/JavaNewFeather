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
   * comparing
   * comparingInt
   * comparingLong
   * comparingDouble
   */
  @Test
  public void testComparing() {

    Comparator<String> comp = null;
    List<String> list = null;

    comp = Comparator.comparing(t -> t.length(), (o1, o2) -> o1 - o2);
    list = getStringList();
    System.out.println(list);
    list.sort(comp);
    System.out.println(list);

    System.out.println();

    comp = Comparator.comparingInt(t -> t.length());
    list = getStringList();
    System.out.println(list);
    list.sort(comp);
    System.out.println(list);
  }

  /**
   * thenComparing
   * thenComparingInt
   * thenComparingLong
   * thenComparingDouble
   */
  @Test
  public void testThenComparing() {

    List<String> list = getStringList();
    Comparator<String> comparator = Comparator.comparingInt(t -> t.length());
    comparator = comparator.thenComparing(e -> Integer.valueOf(e));
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

  private List<String> getStringList() {

    return new ArrayList<String>() {
      {
        add("1111");
        add("222");
        add("111");
        add("11");
        add("1");
      }
    };
  }

}
