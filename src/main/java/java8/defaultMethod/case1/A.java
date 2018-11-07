package java8.defaultMethod.case1;

/**
 * @author niuhaijun
 * @date 2018/10/11 16:15
 */
public interface A {

  default void hello() {
    System.out.println("A");
  }
}
