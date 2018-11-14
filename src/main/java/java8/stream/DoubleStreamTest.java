package java8.stream;

import java.util.stream.DoubleStream;
import org.junit.Test;

/**
 * @author niuhaijun
 * @date 2018/9/20 9:38
 */
public class DoubleStreamTest {

  @Test
  public void testRange() {

    DoubleStream doubleStream = DoubleStream.of(1, 2, 3);
    doubleStream.forEach(System.out::println);
  }
}
