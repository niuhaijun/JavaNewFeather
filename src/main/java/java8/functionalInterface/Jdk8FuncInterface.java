package java8.functionalInterface;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import org.junit.Test;

/**
 * JDK8的函数式接口
 *
 * @author niuhaijun
 * @date 2018/9/4 17:08
 */
public class Jdk8FuncInterface {

  /**
   * BiConsumer<T,U> 代表了一个接受两个输入参数的操作，并且不返回任何结果
   */
  @Test
  public void biConsumerTest() {
    BiConsumer<String, Integer> biConsumer = (a, b) -> System.out.println(a + b);
    biConsumer.accept("12", 34);
  }

  /**
   * BiFunction<T,U,R> 代表了一个接受两个输入参数的方法，并且返回一个结果
   */
  @Test
  public void biFunctionTest() {
    BiFunction<String, String, Integer> biFunction = (a, b) -> Integer.valueOf(a) + Integer
        .valueOf(b);
    Integer sum = biFunction.apply("1200", "34");
    System.out.println(sum);
  }

  /**
   * BinaryOperator<T> 代表了一个作用于于两个同类型操作符的操作，并且返回了操作符同类型的结果
   */
  @Test
  public void binaryOperatorTest() {
    BinaryOperator<Integer> max = BinaryOperator.maxBy(Comparator.naturalOrder());
    System.out.println(max.apply(1, 2));

    BinaryOperator<Integer> min = BinaryOperator.minBy(Comparator.naturalOrder());
    System.out.println(min.apply(1, 2));

    BinaryOperator<Integer> add = (n1, n2) -> n1 + n2;
    System.out.println(add.apply(1, 2));
  }

  /**
   * BiPredicate<T,U> 代表了一个两个参数的boolean值方法
   */
  @Test
  public void biPredicateTest() {
    BiPredicate<String, Integer> biPredicate = Objects::equals;
    System.out.println(biPredicate.test("123", 123));
  }

  /**
   * BooleanSupplier 代表了boolean值结果的提供方
   */
  @Test
  public void booleanSupplierTest() {
    BooleanSupplier booleanSupplier = () -> Boolean.FALSE;
    System.out.println(booleanSupplier.getAsBoolean());
  }

  /**
   * Consumer<T> 代表了接受一个输入参数并且无返回的操作
   */
  @Test
  public void consumerTest() {
    Consumer<String> consumer = System.out::println;
    consumer.accept("hello world !!!");
  }

  /**
   * DoubleBinaryOperator 代表了作用于两个double值操作符的操作，并且返回了一个double值的结果。
   */
  @Test
  public void doubleBinaryOperatorTest() {
    DoubleBinaryOperator sum = (a, b) -> a + b;
    System.out.println(sum.applyAsDouble(1.1, 2.2));
  }

  /**
   * DoubleConsumer 代表一个接受double值参数的操作，并且不返回结果。
   */
  @Test
  public void doubleConsumerTest() {
    DoubleConsumer doubleConsumer = System.out::println;
    doubleConsumer.accept(12.34);
  }

  /**
   * DoubleFunction<R> 代表接受一个double值参数的方法，并且返回结果
   */
  @Test
  public void doubleFunctionTest() {
    DoubleFunction<Long> doubleFunction = Double::doubleToLongBits;
    System.out.println(doubleFunction.apply(1234.5678));
  }

  /**
   * DoublePredicate 代表一个拥有double值参数的boolean值方法
   */
  @Test
  public void doublePredicateTest() {
    DoublePredicate doublePredicate = (a) -> a > 100;
    System.out.println(doublePredicate.test(11));
  }

  /**
   * DoubleSupplier 代表一个double值结构的提供方
   */
  @Test
  public void doubleSupplierTest() {
    DoubleSupplier doubleSupplier = () -> Double.valueOf("111");
    System.out.println(doubleSupplier.getAsDouble());
  }

  /**
   * DoubleToIntFunction 接受一个double类型输入，返回一个int类型结果。
   */
  @Test
  public void doubleToIntFunctionTest() {
    DoubleToIntFunction doubleToIntFunction = (a) -> (int) a;
    Integer b = doubleToIntFunction.applyAsInt(12.34);
    System.out.println(b);
  }

  /**
   * DoubleToLongFunction 接受一个double类型输入，返回一个long类型结果
   */
  @Test
  public void doubleToLongFunctionTest() {
    DoubleToLongFunction doubleToLongFunction = (d) -> (long) d;
    Long b = doubleToLongFunction.applyAsLong(123.4);
    System.out.println(b);
  }


  /**
   * java.util.Function
   */
  @Test
  public void functionTest() {
    Function<String, Integer> function = Integer::valueOf;
    Integer num = function.apply("123");
    System.out.println(num);
  }

  @Test
  public void unaryOperatorTest() {
    UnaryOperator<String> unaryOperator = null;
  }
}
