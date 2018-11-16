package java8.collector;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 * @author niuhaijun
 * @date 2018/9/26 11:22
 */
public class CollectorTest {

  /**
   * 使用自定义的收集器统计素数
   */
  @Test
  public void generatePrimeTest() {

    Map<Boolean, List<Integer>> map = IntStream.rangeClosed(2, 10).boxed()
        .collect(new PrimeNumbersCollector());
    map.get(Boolean.TRUE).stream().forEach(System.out::println);
  }

  /**
   * 使用预定义的收集器统计素数
   */
  @Test
  public void getPrimeTest() {

    Map<Boolean, List<Integer>> map = IntStream.rangeClosed(2, 100).boxed().collect(
        Collectors.partitioningBy(element -> isPrime(element)));

    System.out.println(map.get(Boolean.TRUE));
  }


  /**
   * 判断一个数是否为素数
   *
   * @param n 被测试的数
   * @return 如果为素数返回true, 否则返回false。
   */
  private boolean isPrime(int n) {

    int root = (int) Math.sqrt(n);
    return IntStream.rangeClosed(2, root).noneMatch(element -> n % element == 0);
  }

}
