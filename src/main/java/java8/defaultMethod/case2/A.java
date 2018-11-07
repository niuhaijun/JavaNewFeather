package java8.defaultMethod.case2;

/**
 * @author niuhaijun
 * @date 2018/10/11 16:18
 */
public interface A {

  default void hello() {
    System.out.println("A");
  }
}
