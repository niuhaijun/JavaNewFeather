package java8.defaultMethod;

/**
 * @author niuhaijun
 * @date 2018/9/5 9:56
 */
public interface Vehicle {

  /**
   * 静态默认方法
   */
  static void blowHorn() {

    System.out.println("按喇叭!!!");
  }

  /**
   * 默认方法；接口可以声明（并且可以提供实现）静态方法
   */
  default void print() {

    System.out.println("我是一辆车!");
  }
}
