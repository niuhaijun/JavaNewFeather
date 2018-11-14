package java8.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;
import org.junit.Test;


/**
 * @author niuhaijun
 * @date 2018/9/28 10:56
 */
public class ForkJoinSumCalculatorTest {

  @Test
  public void test() {

    long n = 10_0000_000;
    long[] numbers = LongStream.rangeClosed(1, n).toArray();
    ForkJoinSumCalculator task = new ForkJoinSumCalculator(numbers);
    ForkJoinPool pool = new ForkJoinPool();
    long sum = pool.invoke(task);
    System.out.println(sum);
  }
}
