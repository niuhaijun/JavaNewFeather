package java8.future.cascadeapi.server;

import java.util.Random;

/**
 * @author niuhaijun
 * @date 2018/12/6 11:30
 */
public class DelayServer {

  private static Random random = new Random();

  /**
   * 固定时间的延迟服务
   *
   * @param time 延迟时间
   */
  public static void fixedDelay(long time) {

    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * 固定时间的延迟服务
   */
  public static void fixedDelay() {

    try {
      Thread.sleep(1_000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * 随机时间的延迟服务
   *  延迟时间的范围[1000, 2001)
   */
  public static void randomDelay() {

    long time = random.longs(1000, 2001).findAny().orElse(1000);
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
