package java8.future.asyncDemo;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java8.future.asyncDemo.Discount.Code;

/**
 * @author niuhaijun
 * @date 2018/12/4 21:49
 */
public class Shop {

  private String name;
  private static Random random = new Random();

  private static ExecutorService executorService = Executors.newCachedThreadPool();

  public String getName() {

    return name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public Shop(String name) {

    this.name = name;
  }

  /**
   * 获取商品在该商铺的价格
   *
   * @param product 商品名称
   * @return 商品价格
   */
  public double getPrice(String product) {

    return calculatePrice(product);
  }

  /**
   * 获取商品在该商铺详细的价格信息
   *
   * @param product 商品名称
   * @return 商品详细的价格信息
   */
  public String getDetailPrice(String product) {

    double price = calculatePrice(product);
    Discount.Code code = Discount.Code.values()[random.nextInt(Code.values().length)];
    return String.format("%s:%.2f:%s", name, price, code);
  }

  public Future<Double> getPriceAsync(String product) {

//    return CompletableFuture.supplyAsync(() -> calculatePrice(product), executorService);
    return CompletableFuture.supplyAsync(() -> calculatePrice(product));
  }

  private double calculatePrice(String product) {

    delay();
//    randomDelay();
    return random.nextDouble() * product.charAt(0) + product.charAt(1);
  }

  public static void delay() {

    try {
      Thread.sleep(1000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void randomDelay() {

    int delay = 500 + random.nextInt(2000);
    try {
      Thread.sleep(delay);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
