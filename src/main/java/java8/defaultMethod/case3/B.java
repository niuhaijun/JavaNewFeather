package java8.defaultMethod.case3;

/**
 * @author niuhaijun
 * @date 2018/10/11 16:22
 */
public interface B extends A {

  @Override
  default void hello() {
    System.out.println("B");
  }
}
