package java8.future;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author niuhaijun
 * @date 2018/12/3 22:52
 */
public class AsyncDemo {

  Random random = new Random();

  public static void main(String[] args) {

    AsyncDemo demo = new AsyncDemo();
    long start = System.nanoTime();

    Future<Double> futurePrice = demo.getPriceAsync("1 2 3");
    long invocationTime = (System.nanoTime() - start) / 1_000_000;
    System.out.println(invocationTime);

    delay();

    try {
      /**
       * 不推荐使用
       */
//      double price = futurePrice.get();

      double price = futurePrice.get(100L, MILLISECONDS);

    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    } catch (TimeoutException e) {
      e.printStackTrace();
    }

    long retrievalTime = (System.nanoTime() - start) / 1_000_000;
    System.out.println(retrievalTime);
  }

  /**
   * 模拟1s的延迟
   */
  public static void delay() {

    try {
      Thread.sleep(1_000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * 同步方法
   *    根据产品名称获取产品价格
   *
   * @param product 产品名称
   * @return 返回产品价格
   */
  public double getPrice(String product) {

    return calculatePrice(product);
  }

  /**
   * 异步方法（自定义）
   *    根据产品名称获取产品价格
   *
   * @param product 产品名称
   * @return 返回产品价格
   */
  public Future<Double> getPriceAsync(String product) {

    /**
     * 创建CompletableFuture对象
     * 该对象会包含异步操作的结果
     */
    CompletableFuture<Double> future = new CompletableFuture<>();
    new Thread(() -> {

      try {
        double price = calculatePrice(product);

        if (price > 100) {
          throw new Exception("价格大于20");
        }

        /**
         * 设置future的返回值
         */
        future.complete(price);
      } catch (Exception e) {
        future.completeExceptionally(e);
      }

    }).start();

    /**
     * 无需等待还没结束的计算，
     * 直接返回future对象
     */
    return future;
  }

  /**
   * 异步方法（工厂方法）
   *    根据产品名称获取产品价格
   *
   * @param product 产品名称
   * @return 返回产品价格
   */
  public Future<Double> getPriceAsyncByJDK(String product) {
    return CompletableFuture.supplyAsync(() -> calculatePrice(product));
  }


  private double calculatePrice(String product) {

    delay();
    return random.nextDouble() * product.charAt(0) + product.charAt(1);
  }
}
