package java8.stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * 流Stream
 *
 * Stream（流）是一个来自 [数据源] 的 [元素]队列并支持 [聚合操作]
 *
 * 1、[数据源] 流的来源。 可以是集合，数组，I/O channel， 产生器generator 等。
 *
 * 2、[元素] 是特定类型的对象，形成一个队列。 Java中的Stream并不会存储元素，而是按需计算。
 *
 * 3、[聚合操作] 类似SQL语句一样的操作， 比如filter, map, reduce, find, match, sorted等。
 *
 *
 * Stream操作还有两个基础的特征：
 *
 * 1、 Pipelining: 中间操作都会返回流对象本身。 这样多个操作可以串联成一个管道， 如同流式风格（fluent style）。
 * 这样做可以对操作进行优化，比如延迟执行(laziness)和短路( short-circuiting)。
 *
 * 2、内部迭代： 以前对集合遍历都是通过Iterator或者For-Each的方式, 显式的在集合外部进行迭代， 这叫做外部迭代。 Stream提供了内部迭代的方式，
 * 通过访问者模式(Visitor)实现。
 *
 * @author niuhaijun
 * @date 2018/9/6 10:01
 */
public class StreamTest {

  private static List<String> strings;
  private static List<Integer> numbers;
  private static List<Integer> integers;
  private static Random random;
  private static long count;

  static {
    strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
    numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
    integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);
    random = new Random();
  }

  /**
   * filter()方法
   *
   * 用于通过设置的条件过滤出元素
   */
  @Test
  public void filterTest() {

    count = strings.stream().filter(String::isEmpty).count();
    System.out.println("空字符串数量为: " + count);

    count = strings.stream().filter(string -> string.length() == 3).count();
    System.out.println("字符串长度为3的数量为: " + count);
  }

  /**
   * map()方法
   *
   * 用于映射每个元素到对应的结果
   */
  @Test
  public void mapTest() {

    List<Integer> squaresList = numbers.stream().map(i -> i * i)
        .collect(toList());
    System.out.println("Squares List: " + squaresList);

    List<Integer> distinctSquaresList = numbers.stream().map(i -> i * i).distinct()
        .collect(toList());
    System.out.println("Distinct SquaresList List: " + distinctSquaresList);
  }

  /**
   * flatMap()方法
   *
   * 摊平流
   */
  @Test
  public void flatMapTest() {

    Stream<String> stream = Stream.of("Q,Q,Q", "W,W,W", "E,E,E");
//    stream.flatMap(s -> Stream.of(s.split(","))).forEach(System.out::println);
    stream.map(s -> s.split(",")).flatMap(ss -> Stream.of(ss)).forEach(System.out::println);
  }

  /**
   * limit()方法
   *
   * 产生一个流，它包含当前流中的前maxSize个元素
   */
  @Test
  public void limitTest() {

    Stream<String> stream = strings.stream();
    stream.limit(3).forEach(System.out::println);
  }

  /**
   * skip()方法
   *
   * 产生一个流，它的元素是当前流中除了前n个元素之外的所有元素
   */
  @Test
  public void skipTest() {

    Stream<Integer> stream = integers.stream();
    stream.skip(3).forEach(System.out::println);
  }

  /**
   * concat()方法
   *
   * 连接两个流
   */
  @Test
  public void concatTest() {

    Stream<Object> stream = Stream.concat(strings.stream(), numbers.stream());
    stream.forEach(System.out::println);
  }

  /**
   * distinct() 方法
   *
   * 产生一个流，包含当前流中所有不同的元素
   */
  @Test
  public void distinctTest() {

    Stream<String> stream = strings.stream();
    stream.distinct().forEach(System.out::println);
  }

  /**
   * sorted()
   *
   * 产生一个流,它的元素是当前流中的所有元素按照顺序排列的。
   */
  @Test
  public void sortedTest() {

    Stream<String> stringStream = strings.stream().sorted();
    stringStream.forEach(System.out::println);

    System.out.println("-----------------");

    Stream<Integer> integerStream = numbers.stream().sorted((a, b) -> a.compareTo(b) * -1);
    integerStream.forEach(System.out::println);
  }

  /**
   * peek()方法
   *
   * 产生一个流，它与当前流中的元素相同，在获取其中每个元素时间，会将其传递给action
   */
  @Test
  public void peekTest() {

    Stream<Integer> integerStream = integers.stream();
    integerStream.peek(t -> t = t - 100).forEach(System.out::println);
  }

  /**
   * max(), min()
   *
   * 产生这个流中的最大元素, 产生这个流中的最小元素
   */
  @Test
  public void maxTest() {

    Stream<Integer> integerStream = integers.stream();
    Optional<Integer> optional = integerStream.max(Comparator.naturalOrder());
    if (optional.isPresent()) {
      System.out.println(optional.get());
    }
  }

  /**
   * min()
   *
   * 产生这个流中的最小元素
   */
  @Test
  public void minTest() {

    Stream<Integer> integerStream = integers.stream();
    Optional<Integer> optional = integerStream.min(Comparator.naturalOrder());
    if (optional.isPresent()) {
      System.out.println(optional.get());
    }
  }

  /**
   * findFirst()
   *
   * 产生这个流中的第一元素
   */
  @Test
  public void findFirstTest() {

    Optional<String> optional = strings.stream().findFirst();
    if (optional.isPresent()) {
      System.out.println(optional.get());
    }
  }

  /**
   * findAny()
   *
   * 产生这个流中的任意一个元素
   */
  @Test
  public void findAnyTest() {

    Stream<Integer> integerStream = integers.parallelStream();
    Optional<Integer> optional = integerStream.findAny();
    if (optional.isPresent()) {
      System.out.println(optional.get());
    }
  }

  /**
   * anyMatch()
   *
   * 这个流中的任意元素匹配给定断言时返回true
   */
  @Test
  public void anyMatchTest() {

    Stream<Integer> integerStream = integers.parallelStream();
//    integerStream = Stream.empty();
    System.out.println(integerStream.anyMatch(t -> t == 19));
  }

  /**
   * allMathch()
   *
   * 这个流中的所有元素都匹配断言时返回true
   */
  @Test
  public void allMatchTest() {

    Stream<String> stringStream = strings.stream();
    System.out.println(stringStream.allMatch(Objects::isNull));
  }

  /**
   * noneMatch()
   *
   * 这个流中的所有元素都不匹配断言时，返回true
   */
  @Test
  public void noneMatchTest() {

    boolean result = strings.parallelStream().noneMatch(s -> s.length() > 100);
    System.out.println(result);
  }

  /**
   * iterator()
   *
   * 产生一个用于获取当前流中各个元素的迭代器
   */
  @Test
  public void iteratorTest() {

    Stream<String> stringStream = strings.stream();
    Iterator<String> iterator = stringStream.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

  }

  /**
   * limit(),方法用于获取指定数量的流
   *
   * sorted(),sorted 方法用于对流进行排序
   *
   * forEach(), stream 提供了新的方法 'forEach' 来迭代流中的每个数据
   */
  @Test
  public void forEachTest() {

    integers.stream().limit(4).sorted().forEach(System.out::println);

    random.ints(3).sorted().forEach(System.out::println);
  }

  /**
   * forEachOrdered() 按顺序遍历流中的元素
   */
  @Test
  public void forEachOrderedTest() {

    integers.stream().limit(4).sorted().forEachOrdered(System.out::println);

    random.ints(3).sorted().forEachOrdered(System.out::println);
  }

  /**
   * Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串
   *
   * Collectors.toList() 返回 列表
   *
   * Collectors.joining() 返回 字符串
   */
  @Test
  public void collectTest() {

    List<String> filtered = strings.stream().filter(string -> !string.isEmpty())
        .collect(toList());
    System.out.println("筛选后的列表: " + filtered);

    String mergedString = strings.stream().filter(string -> !string.isEmpty())
//        .collect(Collectors.joining(", ", "AAA", "BBB"));
//        .collect(Collectors.joining(", "));
        .collect(Collectors.joining());
    System.out.println("合并字符串: " + mergedString);
  }


  /**
   * 统计
   *
   * 最大、最小、求和、平均数、个数等
   */
  @Test
  public void statisticsTest() {

    IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
    System.out.println("列表中最大的数 : " + stats.getMax());
    System.out.println("列表中最小的数 : " + stats.getMin());
    System.out.println("所有数之和 : " + stats.getSum());
    System.out.println("列表中元素的个数：" + stats.getCount());
    System.out.println("平均数 : " + stats.getAverage());
  }

  /**
   * parallelStream() 并行流
   */
  @Test
  public void parallelStreamTest() {

    count = strings.parallelStream().filter(String::isEmpty).count();
    System.out.println("空字符串的数量为: " + count);
  }


  @Test
  public void objectsTest() throws ParseException {

    int i = 1;
    Integer ii = 1;
//    System.out.println(Objects.equals(i, ii));

    Date startDate = Date.from(
        LocalDateTime.of(LocalDate.now(), LocalTime.MIN).atZone(ZoneId.systemDefault())
            .toInstant());
    Date endDate = new Date();

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = simpleDateFormat.parse("2018-09-13 14:41:24");

    System.out.println((date.compareTo(startDate) > 0) && (date.compareTo(endDate) < 0));

  }


  /**
   * filter方法只会过滤小不满足条件的元素
   */
  @Test
  public void test11() {

    IntStream stream = IntStream.rangeClosed(0, 10);
    stream.filter(e -> e > 2).forEach(System.out::println);
  }

  /**
   * 素数
   */
  @Test
  public void test12() {

    IntStream.rangeClosed(1, 100).boxed()
        .flatMap(a -> IntStream.rangeClosed(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
            .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));

    IntStream.rangeClosed(1, 100).boxed().flatMap(a -> IntStream.rangeClosed(a, 100)
        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)}).filter(t -> t[2] % 1 == 0));

    Stream.iterate(new int[]{0, 1}, e -> new int[]{e[1], e[0] + e[1]}).limit(20).map(e -> e[0])
        .forEach(System.out::println);
  }

  /**
   * 下游收集器
   */
  @Test
  public void test13() {

    Map<String, Integer> map = Stream.of("A,A,A,b", "b,b,b").flatMap(e -> Stream.of(e.split(",")))
        .collect(
            groupingBy(e -> e, collectingAndThen(toList(), List::size)));

    Set<Entry<String, Integer>> set = map.entrySet();
    set.stream().forEach(e -> {
      System.out.println(e.getKey() + "-->" + e.getValue());
    });

  }
}
