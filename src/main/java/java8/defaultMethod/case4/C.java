package java8.defaultMethod.case4;

/**
 * @author niuhaijun
 * @date 2018/10/11 16:28
 */
public class C implements A, B {

  public static void main(String[] args) {

    new C().hello();
  }

  @Override
  public void hello() {

    B.super.hello();
  }
}
