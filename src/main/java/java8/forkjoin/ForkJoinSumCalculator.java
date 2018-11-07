package java8.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @author niuhaijun
 * @date 2018/9/28 10:56
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

  public static final long THRESHOLD = 10_000;
  private final long[] numbers;
  private final int start;
  private final int end;


  public ForkJoinSumCalculator(long[] numbers) {
    this(numbers, 0, numbers.length);
  }

  private ForkJoinSumCalculator(long[] numbers, int start, int end) {
    this.numbers = numbers;
    this.start = start;
    this.end = end;
  }


  @Override
  protected Long compute() {
    int length = end - start;

    if (length <= THRESHOLD) {
      return computeSequentially();
    }

    ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
    leftTask.fork();

    ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
    long rightResult = rightTask.compute();
    long leftResult = leftTask.join();

    return leftResult + rightResult;
  }

  /**
   * 计算小数组的和
   *
   * @return 小数组的和
   */
  private long computeSequentially() {
    long sum = 0;
    for (int i = start; i < end; i++) {
      sum += numbers[i];
    }
    return sum;
  }

}
