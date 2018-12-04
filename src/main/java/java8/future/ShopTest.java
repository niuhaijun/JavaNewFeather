package java8.future;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.junit.Test;

/**
 * @author niuhaijun
 * @date 2018/12/4 21:59
 */
public class ShopTest {

  /**
   * 顺序查询所有商店的价格
   */
  @Test
  public void sequentialTime() {

    String product = "you are the best";
    long start = System.nanoTime();
    List<Shop> shops = getShopList();
    List<String> price = shops.stream()
        .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
        .collect(toList());
    long duration = (System.nanoTime() - start) / 1_000_000L;
    System.out.println("顺序流 同步");
    System.out.println("Done in " + duration + " msecs!");
  }

  /**
   * 并行查询所有商店的价格
   */
  @Test
  public void parallelTime() {

    String product = "you are the best";
    long start = System.nanoTime();
    List<Shop> shops = getShopList();
    List<String> price = shops.parallelStream()
        .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
        .collect(toList());
    long duration = (System.nanoTime() - start) / 1_000_000L;
    System.out.println("并行流 同步");
    System.out.println("Done in " + duration + " msecs!");
  }

  /**
   * 异步获取商品在不同商店的价格
   * 顺序流
   */
  @Test
  public void asyncSequentialTime() {

    String product = "you are the best";

    long start = System.nanoTime();

    List<CompletableFuture<String>> priceFuture = getShopList().stream().map(
        shop -> {
          return CompletableFuture
              .supplyAsync(() -> shop.getName() + " price is " + shop.getPrice(product));
        }).collect(toList());

    List<String> price = priceFuture.stream().map(CompletableFuture::join).collect(toList());

    long duration = (System.nanoTime() - start) / 1_000_000L;
    System.out.println("顺序流 异步");
    System.out.println("Done in " + duration + " msecs!");
  }

  /**
   * CompletableFuture使用自定义的执行器
   */
  @Test
  public void selfDefineExecutor() {

    String product = "you are the best";
    List<Shop> shops = getShopList();

    final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 50),
        new ThreadFactory() {
          @Override
          public Thread newThread(Runnable r) {

            Thread t = new Thread(r);
            /**
             * 使用守护线程
             * 这种方式不会阻止程序的关停
             */
            t.setDaemon(true);
            return t;
          }
        });

    long start = System.nanoTime();

    List<CompletableFuture<String>> priceFuture = getShopList().stream().map(
        shop -> {
          return CompletableFuture
              .supplyAsync(() -> shop.getName() + " price is " + shop.getPrice(product), executor);
        }).collect(toList());
    List<String> price = priceFuture.stream().map(CompletableFuture::join).collect(toList());

    /**
     * 并行效率并不高
     */
//    List<CompletableFuture<String>> priceFuture = getShopList().parallelStream().map(
//        shop -> {
//          return CompletableFuture
//              .supplyAsync(() -> shop.getName() + " price is " + shop.getPrice(product), executor);
//        }).collect(toList());
//    List<String> price = priceFuture.parallelStream().map(CompletableFuture::join).collect(toList());

    long duration = (System.nanoTime() - start) / 1_000_000L;
    System.out.println("顺序流 异步 自定义执行器");
    System.out.println("Done in " + duration + " msecs!");
  }

  /**
   * 异步获取商品在不同商店的价格
   * 并行流
   */
  @Test
  public void asyncParallelTime() {

    String product = "you are the best";

    long start = System.nanoTime();

    List<CompletableFuture<String>> priceFuture = getShopList().parallelStream().map(
        shop -> {
          return CompletableFuture
              .supplyAsync(() -> shop.getName() + " price is " + shop.getPrice(product));
        }).collect(toList());

    List<String> price = priceFuture.parallelStream().map(CompletableFuture::join)
        .collect(toList());

    long duration = (System.nanoTime() - start) / 1_000_000L;

    System.out.println("并行流 异步");
    System.out.println("Done in " + duration + " msecs!");
  }

  private List<Shop> getShopList() {

    return Arrays
        .asList(new Shop("11"), new Shop("22"), new Shop("33"), new Shop("44"), new Shop("55"),
            new Shop("66"), new Shop("77"), new Shop("88"), new Shop("99"), new Shop("00"),
            new Shop("66"), new Shop("77"), new Shop("88"), new Shop("99"), new Shop("00"),
            new Shop("66"), new Shop("77"), new Shop("88"), new Shop("99"), new Shop("00"));
  }

}