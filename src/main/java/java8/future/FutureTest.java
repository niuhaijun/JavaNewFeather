package java8.future;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

/**
 * @author niuhaijun
 * @date 2018/12/3 22:20
 */
public class FutureTest {

  public static void main(String[] args) {

    ExecutorService executor = Executors.newCachedThreadPool();

    /**
     * 使用Callable封装耗时的操作，
     * 并将它提交到ExecutorService。
     */
    Future<String> future = executor.submit(new Callable<String>() {
      @Override
      public String call() throws Exception {
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        return LocalDateTime.now().toString();
      }
    });

    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    try {
      /**
       * 当需要获取异步操作的结果时，调用Future的get方法
       */
      String time = future.get(3, SECONDS);
      System.out.println(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    } catch (TimeoutException e) {
      e.printStackTrace();
    }

    System.out.println(LocalDateTime.now());
  }

}
