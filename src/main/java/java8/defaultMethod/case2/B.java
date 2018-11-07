package java8.defaultMethod.case2;

/**
 * @author niuhaijun
 * @date 2018/10/11 16:18
 */
public interface B extends A {

  @Override
  default void hello() {
    System.out.println("B");
  }
}
