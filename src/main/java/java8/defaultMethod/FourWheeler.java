package java8.defaultMethod;

/**
 * @author niuhaijun
 * @date 2018/9/5 9:57
 */
public interface FourWheeler {

  default void print() {

    System.out.println("我是一辆四轮车!");
  }
}
