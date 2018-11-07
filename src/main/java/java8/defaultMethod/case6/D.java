package java8.defaultMethod.case6;

/**
 * @author niuhaijun
 * @date 2018/10/11 16:48
 */
public class D implements B, C {

  @Override
  public void hello() {
    System.out.println("D");
  }

  public static void main(String[] args) {
    new D().hello();
  }
}
