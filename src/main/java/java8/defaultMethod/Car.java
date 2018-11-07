package java8.defaultMethod;

/**
 * 一个类实现了多个接口，且这些接口有相同的默认方法，以下实例说明了这种情况的解决方法：
 *
 * @author niuhaijun
 * @date 2018/9/5 9:58
 */
public class Car implements Vehicle, FourWheeler {

  /**
   * 解决多个接口默认方法的冲突：使用 super 来调用指定接口的默认方法：
   */
  public void print() {
    Vehicle.super.print();
    FourWheeler.super.print();
    Vehicle.blowHorn();
  }
}


