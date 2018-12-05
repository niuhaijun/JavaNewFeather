package java8.future.asyncDemo;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Stream;
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

  /**
   * CompletableFuture使用自定义的执行器
   */
  @Test
  public void selfDefineExecutor() {

    String product = "you are the best";
    List<Shop> shops = getShopList();

    final Executor executor = getExecutor(shops);

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

  //A ---------------------------------------------//

  /**
   * 先获取商品在每个店铺的价格
   * 再去折扣中心计算最终的价格
   */
  @Test
  public void discountPriceSequenceSync() {

    String product = "you are the best";

    List<Shop> shops = getShopList();

    long start = System.nanoTime();
    List<String> list = shops.stream()
        .map(shop -> shop.getDetailPrice(product))
        .map(Quote::parse)
        .map(Discount::applyDiscount)
        .collect(toList());
    long duration = (System.nanoTime() - start) / 1_000_000L;

    System.out.println("顺序流 同步");
    System.out.println("Done in " + duration + " msecs!");
  }

  @Test
  public void discountPriceParallelSync() {

    String product = "you are the best";

    List<Shop> shops = getShopList();

    long start = System.nanoTime();
    List<String> list = shops.parallelStream()
        .map(shop -> shop.getDetailPrice(product))
        .map(Quote::parse)
        .map(Discount::applyDiscount)
        .collect(toList());
    long duration = (System.nanoTime() - start) / 1_000_000L;

    System.out.println("并行流 同步");
    System.out.println("Done in " + duration + " msecs!");
  }

  @Test
  public void cascadeAsyncTask() {

    String product = "you are the best";

    List<Shop> shops = getShopList();
    Executor executor = getExecutor(shops);

    long start = System.nanoTime();
    List<CompletableFuture<String>> list = shops.stream()
        /**
         * 异步
         * 以异步的方式取得product在每个Shop中的 原始价格，折扣码
         */
        .map(shop -> CompletableFuture.supplyAsync(() -> shop.getDetailPrice(product), executor))
        /**
         * Quote存在时，对其返回的值进行转换
         */
        .map(future -> future.thenApply(Quote::parse))
        /**
         * 异步
         * 使用另一个异步任务构造期望的Future,申请折扣
         *
         * 传入thenCompose()方法的对象类型为Function
         * 构建Function的入参为CompletableFuture执行完毕的结果
         */
        .map(future -> future.thenCompose(
            quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)))
        .collect(toList());

    List<String> res = list.stream()
        /**
         * 等待流中的所有Future执行完毕，并提取各自的返回值
         */
        .map(CompletableFuture::join)
        .collect(toList());

    long duration = (System.nanoTime() - start) / 1_000_000L;

    System.out.println("顺序流 异步");
    System.out.println("Done in " + duration + " msecs!");
  }
  //A ---------------------------------------------//

  //B ---------------------------------------------//

  /**
   * 使用CompletableFuture的thenCompose方法
   * 将有相互依赖的关系异步任务连接到一起
   */
  @Test
  public void testThenCompose() {

    CompletableFuture<String> cf1 = new CompletableFuture();
    cf1.complete("123");
    CompletableFuture<Integer> cf2 = cf1.thenCompose(t -> {
      CompletableFuture<Integer> cf = new CompletableFuture<>();
      cf.complete(Integer.valueOf(t));
      System.out.println("1----" + cf);
      return cf;
    });
    System.out.println("2----" + cf2);
    System.out.println(cf2.join());
  }

  /**
   * 将两个无相互依赖的CompletableFuture对象的结果整合起来，
   * 并且第二个任务不必等待第一个任务结束才开始
   */
  @Test
  public void testThenCombine() {

    CompletableFuture<Double> money = CompletableFuture.supplyAsync(() -> 123.45);
    CompletableFuture<Double> percentage = CompletableFuture.supplyAsync(() -> 0.1);
    CompletableFuture<Double> end = money.thenCombine(percentage, (pri, per) -> pri * per);
    System.out.println(end.join());
  }


  @Test
  public void testThenApply() {

    CompletableFuture<Double> money = CompletableFuture.supplyAsync(() -> 123.45);
    /**
     * 被传入thenApply()方法的参数类型为Function
     * 构建Function的入参为CompletableFuture执行完毕后的结果
     */
    CompletableFuture<String> endMoney = money.thenApply(t -> "123--->" + t);
    System.out.println(endMoney.join());
  }

  /**
   * 响应CompletableFuture的completion事件
   */
  @Test
  public void testThenAccept() {

    List<Shop> shops = getShopList();
    String product = "you are the best";
    Executor executor = getExecutor(shops);

    Stream<CompletableFuture<String>> stream = shops.stream()
        .map(shop -> CompletableFuture.supplyAsync(() -> shop.getDetailPrice(product), executor))
        .map(future -> future.thenApply(Quote::parse))
        .map(future -> future.thenCompose(
            quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)));

    Stream<CompletableFuture<Void>> middleStream = stream
        .map(future -> future.thenAccept(System.out::println));

    CompletableFuture[] futures = middleStream.toArray(size -> new CompletableFuture[size]);

    /**
     * allOf
     * 数组中所有的CompletableFuture对象执行完毕以后，它会返回一个CompletableFuture<Void>对象
     */
    CompletableFuture.allOf(futures).join();
    /**
     * anyOf
     * 返回数组中
     *  第一个执行完毕的CompletableFuture对象的返回值
     *     构成的CompletableFuture<Object>
     */
//    CompletableFuture.anyOf(futures).join();
  }
  //B ---------------------------------------------//

  private List<Shop> getShopList() {

    return Arrays
        .asList(
            new Shop("11"), new Shop("22"), new Shop("33"), new Shop("44"), new Shop("55"),
            new Shop("66"), new Shop("77"), new Shop("88"), new Shop("99"), new Shop("00"));
  }

  private Executor getExecutor(List<Shop> shops) {

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

    return executor;
  }

}