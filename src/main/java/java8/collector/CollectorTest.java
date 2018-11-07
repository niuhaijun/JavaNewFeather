package java8.collector;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 * @author niuhaijun
 * @date 2018/9/26 11:22
 */
public class CollectorTest {

  @Test
  public void test() {
    Map<Boolean, List<Integer>> map = IntStream.rangeClosed(2, 10).boxed()
        .collect(new PrimeNumbersCollector());
    map.get(Boolean.TRUE).stream().forEach(System.out::println);
  }
}
