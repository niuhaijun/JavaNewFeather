package java8.defaultMethod.case4;

/**
 * @author niuhaijun
 * @date 2018/10/11 16:28
 */
public interface B {

  default void hello() {
    System.out.println("B");
  }
}
