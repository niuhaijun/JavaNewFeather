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

  /**
   * 该方法的责任
   *    1、拆分大任务
   *    2、计算小任务
   *    3、合并小任务的执行结果
   *
   *     逻辑执行
   *     if (任务不可再拆分) {
   *       顺序计算该任务;
   *     } else {
   *       将任务拆分为两个子任务;
   *       递归调用本方法,拆分每个子任务,等待所有子任务完成;
   *       合并每个子任务的结果;
   *     }
   *
   * @return 返回结果
   */
  @Override
  protected Long compute() {

    int length = end - start;

    if (length <= THRESHOLD) {
      return computeSequentially();
    }

    ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
    /**
     * 利用ForkJoinPool线程{异步执行}新创建的子任务
     */
    leftTask.fork();

    ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
    /**
     * 同步执行第二个子任务，有可能允许进一步递归划分
     */
    long rightResult = rightTask.compute();

    /**
     * 读取第一个子任务的结果，如果尚未完成就等待
     */
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
