package java8.methodRefrence;

/**
 * @author niuhaijun
 * @date 2018/9/3 9:43
 */
public class Car {

  public static Car create(Supplier<Car> supplier) {

    return supplier.get();
  }

  public static void collide(final Car car) {

    System.out.println("collide " + car.toString());
  }

  public void follow(final Car car) {

    System.out.println("follow " + car.toString());
  }

  public void repair() {

    System.out.println("repair " + this.toString());
  }

}
