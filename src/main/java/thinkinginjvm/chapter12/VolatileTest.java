package thinkinginjvm.chapter12;

/**
 * volatile关键字
 *
 * @author niuhaijun
 * @date 2019/1/8 14:20
 */
public class VolatileTest {

  public static volatile int race = 0;

  public static final int COUNT = 1_000;

  public synchronized static void increase() {

    race++;
  }

  public static void main(String[] args) {

    Thread[] threads = new Thread[COUNT];
    for (int i = 0; i < COUNT; i++) {
      threads[i] = new Thread(() -> {
        for (int j = 0; j < COUNT; j++) {
          increase();
        }
      });
      threads[i].start();
    }


    while (Thread.activeCount() > 1) {
      Thread.yield();
    }

    System.out.println(race);
  }

}
