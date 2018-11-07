package java8.defaultMethod.case1;

/**
 * @author niuhaijun
 * @date 2018/10/11 16:15
 */
public interface B extends A {

  @Override
  default void hello() {
    System.out.println("B");
  }
}
