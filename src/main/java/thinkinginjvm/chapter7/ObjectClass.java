package thinkinginjvm.chapter7;

/**
 * @author niuhaijun
 * @date 2018/12/19 22:56
 */
public class ObjectClass {

  public static final String HELLO_WORLD = "hello world";

  static {
    System.out.println("ObjectClass init!");
  }

  public static int number = 456;
}
