package java8.stream;

import java.util.Random;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 * @author niuhaijun
 * @date 2018/9/20 9:47
 */
public class RandomTest {

  @Test
  public void testInts() {
    Random random = new Random(1);
    IntStream intStream = random.ints().limit(3);
    intStream.forEach(System.out::println);
  }
}
