package java8.functionalInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import org.junit.Test;

/**
 * 函数式接口
 *
 * @author niuhaijun
 * @date 2018/9/3 14:16
 */
public class FuncInterfaceTest {

  /**
   * lambda表达式抛出异常
   * 任何函数式接口都不允许抛出受检异常
   */
  @Test
  public void test1() {

    /**
     * 自定义的函数式接口
     */
    BufferedReaderProcessor brp = br -> br.readLine();

    /**
     * 系统预定义的函数式接口
     */
    Function<BufferedReader, String> f = (BufferedReader br) -> {
      try {
        return br.readLine();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    };
  }

  /**
   * 特殊的void兼容规则
   */
  @Test
  public void test2() {

    List<String> list = new ArrayList<>();

    Predicate<String> predicate = s -> list.add(s);

    Consumer<String> consumer = s -> list.add(s);
  }


}
