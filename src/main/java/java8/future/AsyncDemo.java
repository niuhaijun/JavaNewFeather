package java8.future;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
      double price = futurePrice.get();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }

    long retrievalTime = (System.nanoTime() - start) / 1_000_000;
    System.out.println(retrievalTime);
  }

  public static void delay() {

    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public double getPrice(String product) {

    return calculatePrice(product);
  }

  public Future<Double> getPriceAsync(String product) {

    CompletableFuture<Double> future = new CompletableFuture<>();
    new Thread(() -> {
      double price = calculatePrice(product);
      future.complete(price);
    }).start();

    return future;
  }

  private double calculatePrice(String product) {

    delay();
    return random.nextDouble() * product.charAt(0) + product.charAt(1);
  }
}
