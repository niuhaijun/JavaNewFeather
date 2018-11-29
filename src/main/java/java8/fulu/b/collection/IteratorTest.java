package java8.fulu.b.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

/**
 * Iterator
 *  forEachRemaining
 *
 * @author niuhaijun
 * @date 2018/11/27 22:07
 */
public class IteratorTest {

  /**
   *  forEachRemaining
   *
   *  while (hasNext())
   *    action.accept(next());
   */
  @Test
  public void testForEachRemaining() {

    List<Integer> list = new ArrayList<Integer>() {
      {
        add(1);
        add(2);
        add(3);
      }
    };

    Iterator<Integer> iterator = list.iterator();
    iterator.forEachRemaining(System.out::println);
  }


}
