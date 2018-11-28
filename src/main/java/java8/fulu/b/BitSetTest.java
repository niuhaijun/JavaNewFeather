package java8.fulu.b;

import java.util.BitSet;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 * BitSet
 *  stream
 *
 * @author niuhaijun
 * @date 2018/11/27 22:05
 */
public class BitSetTest {

  /**
   * stream
   */
  @Test
  public void testStream() {

    BitSet set = new BitSet(100);
    IntStream stream = set.stream();
    stream.forEach(System.out::println);

  }

}
