package java8.fulu.b.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import org.junit.Test;

/**
 * @author niuhaijun
 * @date 2018/11/27 22:14
 */
public class IterableTest {

  /**
   * forEach
   */
  @Test
  public void testForEach() {

    Iterable<Integer> list = getList();
    list.forEach(System.out::println);
  }

  @Test
  public void testSpliterator() {

    Iterable<Integer> list = getList();
    Spliterator<Integer> spliterator = list.spliterator();
  }


  private List<Integer> getList() {

    return new ArrayList<Integer>() {
      {
        add(1);
        add(2);
        add(3);
      }
    };
  }

}
