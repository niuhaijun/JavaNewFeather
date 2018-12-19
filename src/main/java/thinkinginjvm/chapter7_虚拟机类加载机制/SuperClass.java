package thinkinginjvm.chapter7_虚拟机类加载机制;

/**
 * @author niuhaijun
 * @date 2018/12/19 22:45
 */
public class SuperClass extends ObjectClass {

  static {
    System.out.println("SuperClass init!");
  }

  public static int value = 123;
}
