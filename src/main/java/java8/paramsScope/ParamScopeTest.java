package java8.paramsScope;

import lambdaExpression.GreetingService;
import org.junit.Test;

/**
 * lambda表达式变量作用域
 */
public class ParamScopeTest {

  private final String image = "I Love You !!!";

  /**
   * lambda表达式只能引用标记了[final]的外层局部变量，这就是说不能能在lambda内部修改定义在域外的局部变量，否则会编译错误。
   */
  @Test
  public void test1() {
    GreetingService service = System.out::println;
    service.say(image + " niu sir");
  }

  /**
   * 可以直接在lambda表达式中访问外层的局部变量：
   */
  @Test
  public void test2() {
    final int num = 1;
    Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
    s.convert(2);  // 输出结果为 3
  }

  /**
   * lambda表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有 final 的语义）
   */
  @Test
  public void test3() {
    int num = 2;
    Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
    s.convert(2);
//    局部内部类和匿名内部类访问的局部变量必须由final修饰，
//    java8开始，可以不加final修饰符，由系统默认添加。java将这个功能称为：Effectively final 功能。
//    num++;
  }


  /**
   * 在 Lambda 表达式当中不允许声明一个与局部变量同名的参数或者局部变量。
   */
  @Test
  public void test4() {
    String first = "";
//    编译会出错
//    Comparator<String> comparator = (first, second) -> Integer.compare(first.length(), second.length());
  }

}
