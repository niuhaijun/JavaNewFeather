package java8.fulu.b.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

/**
 * List
 *    replaceIf
 *    sort
 *
 * Collection
 *    removeIf
 *
 * @author niuhaijun
 * @date 2018/11/24 22:09
 */
public class ListTest {

  /**
   * sort
   */
  @Test
  public void testSort() {

    List<Integer> list = null;

    list = getList();
    System.out.println(list);

    list.sort(Comparator.naturalOrder());
    System.out.println(list);
  }

  /**
   * replaceAll
   */
  @Test
  public void testReplaceAll() {

    List<Integer> list = getList();

    System.out.println(list);
    list.replaceAll(t -> t * t);
    System.out.println(list);

  }

  /**
   * removeIf
   */
  @Test
  public void testRemoveIf() {

    List<Integer> list = getList();
    list.removeIf(t -> t <= 1);

    System.out.println(list);
  }

  /**
   * forEach
   */
  @Test
  public void testForEach() {

    List<Integer> list = getList();
    list.forEach(System.out::println);
  }

  private List<Integer> getList() {

    return new ArrayList<Integer>() {
      {
        add(3);
        add(2);
        add(1);
      }
    };
  }
}
