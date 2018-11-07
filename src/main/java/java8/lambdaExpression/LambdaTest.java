package java8.lambdaExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * lambda表达式
 */
public class LambdaTest {

  private static int operate(int a, int b, MathOperation mathOperation) {
    return mathOperation.operation(a, b);
  }

  /**
   * lambda表达式的语法一：(parameters) ->{ statements; }
   */
  @Test
  public void test0() {
    MathOperation add = (int a, int b) -> {
      return a + b;
    };
    int result = LambdaTest.operate(1, 2, add);
    System.out.println(result);
  }

  /**
   * lambda表达式的语法二：(parameters) -> expression
   */
  @Test
  public void test1() {
    MathOperation sub = (int a, int b) -> a - b;
    int result = LambdaTest.operate(2, 1, sub);
    System.out.println(result);
  }

  /**
   * lambda表达式特性1： 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
   */
  @Test
  public void test2() {
    MathOperation mul = (a, b) -> {
      return a * b;
    };
    int result = LambdaTest.operate(2, 3, mul);
    System.out.println(result);
  }

  /**
   * lambda表达式特性2：可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
   */
  @Test
  public void test3() {
    GreetingService service1 = message -> System.out.println(message);
    service1.say("菜鸟你好！！！");

    MathOperation div = (a, b) -> a / b;
    int result = LambdaTest.operate(4, 2, div);
    System.out.println(result);
  }

  /**
   * lambda表达式特性3：可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
   */
  /**
   * lambda表达式特性4：可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。
   */
  @Test
  public void test4() {
    MathOperation add = (a, b) -> a + b;
    System.out.println(LambdaTest.operate(1, 2, add));

    MathOperation div = (a, b) -> {
      if (b == 0) {
        throw new RuntimeException("0不可作除数");
      } else {
        return a / b;
      }
    };
    System.out.println(LambdaTest.operate(2, 1, div));
  }

  /**
   * 特殊的void兼容规则
   */
  @Test
  public void testVoidMatchConfig() {
    List<String> list = new ArrayList<>();
    Predicate<String> p = s -> list.add(s);
    Consumer<String> b = s -> list.add(s);
  }

  /**
   * 1 到 100 的勾股数
   */
  @Test
  public void testGouGu() {
    Stream<int[]> triples = IntStream.rangeClosed(1, 100)
        .boxed().flatMap(a -> IntStream.rangeClosed(a, 100)
            .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
            .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
    triples.forEach(e -> System.out.println(e[0] + ", " + e[1] + ", " + e[2]));
  }

  @Test
  public void testFib() {
    Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
        .limit(10).map(e -> e[0]).forEach(e -> System.out.print(e + ", "));
  }

}
