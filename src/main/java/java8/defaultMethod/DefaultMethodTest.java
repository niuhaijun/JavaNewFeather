package java8.defaultMethod;

import org.junit.Test;

/**
 * 默认方法；默认方法就是接口可以有实现方法，而且不需要实现类去实现其方法。只需在方法名前面加个default关键字即可实现默认方法。
 *
 * JDK8之前的接口是个双刃剑， 好处是面向抽象而不是面向具体编程， 缺陷是当需要修改接口时候，需要修改全部实现该接口的类
 *
 * @author niuhaijun
 * @date 2018/9/5 9:52
 */
public class DefaultMethodTest {

  @Test
  public void test() {

    Vehicle vehicle = new Car();
    vehicle.print();
  }

}
