package java8.fulu.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * Collection
 *   removeIf
 *   stream
 *   parallelStream
 *
 * @author niuhaijun
 * @date 2018/11/27 22:00
 */
public class CollectionTest {

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
   * stream
   */
  @Test
  public void testStream() {

    Collection<Integer> list = getList();

    Stream<Integer> stream = list.stream();
  }

  /**
   * parallelStream
   */
  @Test
  public void testParallelStream() {

    Collection<Integer> list = getList();

    Stream<Integer> stream = list.parallelStream();
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
