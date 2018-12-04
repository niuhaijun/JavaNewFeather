package java8.future;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author niuhaijun
 * @date 2018/12/4 21:49
 */
public class Shop {

  private String name;
  private Random random = new Random();
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

  public double getPrice(String product) {

    return calculatePrice(product);
  }

  public Future<Double> getPriceAsync(String product) {

//    return CompletableFuture.supplyAsync(() -> calculatePrice(product), executorService);
    return CompletableFuture.supplyAsync(() -> calculatePrice(product));
  }

  private double calculatePrice(String product) {

    delay();
    return random.nextDouble() * product.charAt(0) + product.charAt(1);
  }

  public static void delay() {

    try {
      Thread.sleep(1000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
