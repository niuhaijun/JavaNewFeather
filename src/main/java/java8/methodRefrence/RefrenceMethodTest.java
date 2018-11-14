package java8.methodRefrence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * 方法引用,有4中引用方法的方式
 */
public class RefrenceMethodTest {

  /**
   * 方法引用方式1：引用类的构造器
   */
  @Test
  public void test1() {

    Car car = Car.create(Car::new);
    System.out.println(car);
  }

  /**
   * 方法引用方式2：引用类的静态方法
   */
  @Test
  public void test2() {

    Car car = Car.create(Car::new);
    List<Car> cars = Arrays.asList(car);
    cars.forEach(Car::collide);
  }

  /**
   * 方法引用方式3：引用特定类的特定方法
   */
  @Test
  public void test3() {

    Car car = Car.create(Car::new);
    List<Car> cars = Arrays.asList(car);
    cars.forEach(Car::repair);
  }

  /**
   * 方法引用方式4：引用特定对象的特定方法
   */
  @Test
  public void test4() {

    Car car = Car.create(Car::new);
    List<Car> cars = Arrays.asList(car);
    cars.forEach(car::follow);
  }

  /**
   * 方法引用
   */
  @Test
  public void test5() {

    List<String> names = new ArrayList<>();
    names.add("Google");
    names.add("Sina");
    names.forEach(System.out::println);
  }

}
