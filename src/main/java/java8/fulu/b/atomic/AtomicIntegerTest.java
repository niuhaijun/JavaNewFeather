package java8.fulu.b.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import org.junit.Test;

/**
 *
 * 原子类
 *    AtomicInteger
 *    AtomicLong
 *
 * @author niuhaijun
 * @date 2018/11/29 10:34
 */
public class AtomicIntegerTest {

  /**
   * getAndUpdate
   *    以原子的方式用给定的方法更新当前值，并返回变变更之前的值
   */
  @Test
  public void testGetAndUpdate() {

    AtomicInteger count = new AtomicInteger(3);
    int preValue = count.getAndUpdate(t -> t * t);
    System.out.println(preValue);
    System.out.println(count.get());
  }

  /**
   * updateAndGet
   *    以原子的方式用给定的方法更新当前值，并返回变变更之后的值
   */
  @Test
  public void testUpdateAndGet() {

    AtomicInteger count = new AtomicInteger(3);
    int currentValue = count.updateAndGet(t -> t * t);
    System.out.println(currentValue);
    System.out.println(count.get());
  }


  /**
   * getAndAccumulate
   *    以原子的方式用给定的方法对当前给定的值进行更新，并返回更新之前的值
   */
  @Test
  public void testGetAndAccumulate() {

    AtomicInteger count = new AtomicInteger(3);

    int currentValue = count.getAndAccumulate(7, (t, u) -> t * u);
    System.out.println(currentValue);
    System.out.println(count.get());
  }

  /**
   * accumulateAndGet
   *    以原子的方式用给定的方法对当前给定的值进行更新，并返回更新之后的值
   */
  @Test
  public void testAccumulateAndGet() {

    AtomicInteger count = new AtomicInteger(3);

    int currentValue = count.accumulateAndGet(7, (t, u) -> t * u);
    System.out.println(currentValue);
    System.out.println(count.get());
  }

  /**
   * 适用于更新多，读取少操作的原子类
   *    LongAdder
   *    LongAccumulator
   *    DoubleAdder
   *    DoubleAccumulator
   */
  @Test
  public void testAdderAccumulator() {

    LongAdder adder = new LongAdder();
    adder.add(4);
    adder.increment();
    adder.increment();
    adder.decrement();
    System.out.println(adder.sum());

    LongAccumulator accumulator = new LongAccumulator((t, u) -> t * u, 1);
    accumulator.accumulate(3);
    accumulator.accumulate(5);
    System.out.println(accumulator.get());

  }


}
