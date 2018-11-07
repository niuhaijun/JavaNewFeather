package java8.collector;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author niuhaijun
 * @date 2018/9/26 10:50
 */
public class PrimeNumbersCollector implements
    Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {

  /**
   *  截取长度合适的素数列表
   *
   * @param list 素数列表
   * @param p 测试
   * @param <E> 泛型
   * @return 返回一个list
   */
  public static <E> List<E> takeWhile(List<E> list, Predicate<E> p) {
    int i = 0;
    for (E e : list) {
      if (!p.test(e)) {
        return list.subList(0, i);
      }
      i++;
    }

    return list;
  }

  /**
   * 判断一个整数是否为素数
   *
   * @param primes 长度合适的素数列表
   * @param candidate 待测整数
   * @return 返回一个布尔值
   */
  public static boolean isPrime(List<Integer> primes, int candidate) {
    int candidateRoot = (int) Math.sqrt(candidate);
    return takeWhile(primes, e -> e <= candidateRoot).stream().noneMatch(e -> candidate % e == 0);
  }


  @Override
  public Supplier<Map<Boolean, List<Integer>>> supplier() {
    return () -> new HashMap<Boolean, List<Integer>>() {{
      put(Boolean.TRUE, new ArrayList<>());
      put(Boolean.FALSE, new ArrayList<>());
    }};
  }

  @Override
  public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
    return (Map<Boolean, List<Integer>> acc, Integer candidate) ->
        acc.get(isPrime(acc.get(Boolean.TRUE), candidate)).add(candidate);
  }

  @Override
  public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
    return (m1, m2) -> {
      m1.get(Boolean.TRUE).addAll(m2.get(Boolean.TRUE));
      m1.get(Boolean.FALSE).addAll(m2.get(Boolean.FALSE));
      return m1;
    };
  }

  @Override
  public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
    return Function.identity();
  }

  @Override
  public Set<Characteristics> characteristics() {
    return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH, CONCURRENT));
  }
}
