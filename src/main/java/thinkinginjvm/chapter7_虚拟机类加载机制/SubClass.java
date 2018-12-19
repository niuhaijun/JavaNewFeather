package thinkinginjvm.chapter7_虚拟机类加载机制;

/**
 * @author niuhaijun
 * @date 2018/12/19 22:46
 */
public class SubClass extends SuperClass {

  static {
    System.out.println("SubClass init!");
  }
}
