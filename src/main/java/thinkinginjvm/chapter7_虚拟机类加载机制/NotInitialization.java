package thinkinginjvm.chapter7_虚拟机类加载机制;

/**
 * @author niuhaijun
 * @date 2018/12/19 22:48
 */
public class NotInitialization {

  static {
    System.out.println("NotInitialization init!");
  }

  public static void main(String[] args) {

//    test1();
//    test2();
//    test3();

  }

  /**
   * 通过子类引用父类的静态字段，不会导致子类初始化，但是直接定义了静态字段的父类才会被初始化
   */
  public static void test1() {

    System.out.println(SuperClass.value);
  }

  /**
   * 通过数组定义来引用类，不会触发此类的初始化
   */
  public static void test2() {

    ObjectClass[] array = new SubClass[10];
  }

  /**
   * 常量类在编译阶段会存入调用类的常量池中，本质上没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
   */
  public static void test3() {

    System.out.println(ObjectClass.HELLO_WORLD);
  }
}
