package java8.optional;

import java.util.Optional;
import java.util.function.Supplier;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import org.junit.Test;

/**
 * Optional类
 *
 * 该类时一个容器类，可以很好的解决空指针异常问题
 *
 * 该类可以保持类型为T的值，或者保存null
 *
 * 该类提供了很多方法，可以不用进行显示非空检测。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
 *
 * @author niuhaijun
 * @date 2018/9/10 9:56
 */
public class OptionalTest {

  /**
   * static <T> Optional<T> empty()
   *
   * 返回空的 Optional 实例。
   */
  @Test
  public void test1() {
    Optional<String> optional = Optional.empty();
    if (optional.isPresent()) {
      System.out.println(optional.get());
    }
  }

  /**
   * boolean equals(Object obj)
   *
   * 判断其他对象是否等于 Optional。
   */
  @Test
  public void test2() {
    Optional<Integer> optional1 = Optional.of(1);
    Optional<Integer> optional2 = Optional.of(1);
    System.out.println(optional1.equals(optional2));
  }

  /**
   * Optional<T> filter(Predicate<? super <T> predicate)
   *
   * 如果值存在，并且这个值匹配给定的 predicate，返回一个Optional用以描述这个值，否则返回一个空的Optional。
   */
  @Test
  public void test3() {
    Optional<Integer> optional = Optional.of(1);
    optional = optional.filter(t -> t > 0);
    if (optional.isPresent()) {
      System.out.println(optional.get());
    }
  }

  /**
   * <U> Optional<U> flatMap(Function<? super T,Optional<U>> mapper)
   *
   * 如果值存在，返回基于Optional包含的映射方法的值，否则返回一个空的Optional
   */
  @Test
  public void test4() {
    Optional<Integer> optional = Optional.ofNullable(3);
    Optional<Integer> result = optional.flatMap(t -> Optional.of(t * t));
    System.out.println(result.get());
  }

  /**
   * T get()
   *
   * 如果在这个Optional中包含这个值，返回值，否则抛出异常：NoSuchElementException
   */
  @Test
  public void test5() {
    Optional<String> optional = Optional.of("123");
    if (optional.isPresent()) {
      System.out.println(optional.get());
    }
  }

  /**
   * int hashCode()
   *
   * 返回存在值的哈希码，如果值不存在 返回 0。
   */
  @Test
  public void test6() {
    Optional<Integer> optional = Optional.of(123);
    if (optional.isPresent()) {
      System.out.println(optional.hashCode());
    }
  }

  /**
   * void ifPresent(Consumer<? super T> consumer)
   *
   * 如果值存在则使用该值调用 consumer , 否则不做任何事情。
   */
  @Test
  public void test7() {
    Optional<String> optional = Optional.of("123");
    optional.ifPresent(System.out::println);
  }

  /**
   * boolean isPresent()
   *
   * 如果值存在则方法会返回true，否则返回 false。
   */
  @Test
  public void test8() {
    Optional<String> optional = Optional.ofNullable("ssss");
    if (optional.isPresent()) {
      System.out.println(optional.get());
    }
  }

  /**
   * <U>Optional<U> map(Function<? super T,? extends U> mapper)
   *
   * 如果存在该值，提供的映射方法，如果返回非null，返回一个Optional描述结果。
   */
  @Test
  public void test9() {
    Optional<Integer> optional = Optional.of(2);
    optional = optional.map(t -> t * t);
    if (optional.isPresent()) {
      System.out.println(optional.get());
    }
  }

  /**
   * static <T> Optional<T> of(T value)
   *
   * 返回一个指定非null值的Optional。
   */
  @Test
  public void test10() {
    Optional<Integer> optional = Optional.of(123);
    System.out.println(optional.get());
  }

  /**
   * static <T> Optional<T> ofNullable(T value)
   *
   * 如果为非空，返回 Optional 描述的指定值，否则返回空的 Optional。
   */
  @Test
  public void test11() {
    Optional<String> optional = Optional.ofNullable(null);
    if (optional.isPresent()) {
      System.out.println(optional.get());
    } else {
      System.out.println("empty");
    }

  }

  /**
   * T orElse(T other)
   *
   * 如果存在该值，返回值， 否则返回 other。
   */
  @Test
  public void test12() {
    Optional<Integer> optional = Optional.ofNullable(null);
    System.out.println(optional.orElse(234));
  }

  /**
   * T orElseGet(Supplier<? extends T> other)
   *
   * 如果存在该值，返回值， 否则触发 other，并返回 other 调用的结果。
   */
  @Test
  public void test13() {
    Optional<String> optional = Optional.ofNullable(null);
    Supplier<String> supplier = () -> "123";
    System.out.println(optional.orElseGet(supplier));
  }

  /**
   * <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier)
   *
   * 如果存在该值，返回包含的值，否则抛出由 Supplier 继承的异常
   */
  @Test
  public void test14() {
  }

  /**
   * String toString()
   *
   * 返回一个Optional的非空字符串，用来调试
   */
  @Test
  public void test15() {
    Optional<Integer> optional = Optional.ofNullable(null);
    System.out.println(optional.toString());
  }


}