package java8.future.cascadeapi;

import static java.util.concurrent.CompletableFuture.supplyAsync;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Stream;
import java8.future.cascadeapi.obj.ObjEnd;
import java8.future.cascadeapi.obj.ObjOne;
import java8.future.cascadeapi.obj.ObjThree;
import java8.future.cascadeapi.obj.ObjTwo;
import java8.future.cascadeapi.server.ServerOne;
import java8.future.cascadeapi.server.ServerThree;
import java8.future.cascadeapi.server.ServerTwo;
import org.junit.Test;

/**
 * 展示详细的信息
 *
 * @author niuhaijun
 * @date 2018/12/6 11:36
 */
public class DetailInfo {

  public void parallel_stream(Executor executor) {

    List<ObjEnd> list = getList();
    Stream<CompletableFuture<ObjThree>> stream = list.stream()
        .map(objEnd -> supplyAsync(() -> ServerOne.get(objEnd.getId()), executor))
        .map(future -> future
            .thenCompose(
                objOne -> supplyAsync(() -> ServerTwo.get(objOne.getTeacherId()), executor)))
        .map(future -> future
            .thenCompose(
                objTwo -> supplyAsync(() -> ServerThree.get(objTwo.getPictureId()), executor)));

    stream.map(future -> future.join())
        .forEach(objThree -> System.out.println(objThree.getPictureUrl()));

  }

  public void parallel_parallelStream(Executor executor) {

    List<ObjEnd> list = getList();
    Stream<CompletableFuture<ObjThree>> stream = list.parallelStream()
        .map(objEnd -> supplyAsync(() -> ServerOne.get(objEnd.getId()), executor))
        .map(future -> future
            .thenCompose(
                objOne -> supplyAsync(() -> ServerTwo.get(objOne.getTeacherId()), executor)))
        .map(future -> future
            .thenCompose(
                objTwo -> supplyAsync(() -> ServerThree.get(objTwo.getPictureId()), executor)));

    stream.map(future -> future.join())
        .forEach(objThree -> System.out.println(objThree.getPictureUrl()));

  }

  public void sequence() {

    List<ObjEnd> list = getList();
    list.stream()
        .map(objEnd -> ServerOne.get(objEnd.getId()))
        .map(objOne -> ServerTwo.get(objOne.getTeacherId()))
        .map(objTwo -> ServerThree.get(objTwo.getPictureId()))
        .forEach(objThree -> System.out.println(objThree.getPictureUrl()));
  }

  @Test
  public void computeTime() {

    Executor executor = getExecutor(getList());

    long start = System.nanoTime();
    sequence();
    System.out.println("sequence()花费的时间为\n  " + (System.nanoTime() - start) / 1000_000L);

    start = System.nanoTime();
    parallel_stream(executor);
    System.out.println("parallel_stream()花费的时间\n  " + (System.nanoTime() - start) / 1000_000L);

    start = System.nanoTime();
    parallel_parallelStream(executor);
    System.out
        .println("parallel_parallelStream()花费的时间为\n  " + (System.nanoTime() - start) / 1000_000L);
  }

  /**
   * 顺序流合并信息
   *
   * 顺序流值使用一个线程，并且是当前线程
   */
  private void sequentialStreamMergeInfo() {

    List<ObjEnd> list = getList();
    Stream<ObjEnd> stream = list.stream()
        .peek(objEnd -> {
          CompletableFuture<ObjOne> future = supplyAsync(() -> ServerOne.get(objEnd.getId()));
          ObjOne objOne = future.join();
          objEnd.setTeacherId(objOne.getTeacherId());
        })
        .peek(objEnd -> {
          CompletableFuture<ObjTwo> future = supplyAsync(
              () -> ServerTwo.get(objEnd.getTeacherId()));
          ObjTwo objTwo = future.join();
          objEnd.setTeacherName(objTwo.getTeacherName());
          objEnd.setPictureId(objTwo.getPictureId());
        })
        .peek(objEnd -> {
          CompletableFuture<ObjThree> future = supplyAsync(
              () -> ServerThree.get(objEnd.getPictureId()));
          ObjThree objThree = future.join();
          objEnd.setPictureUrl(objThree.getPictureUrl());
        });

    stream.forEach(objEnd -> System.out.println(objEnd.toString()));
  }

  /**
   * 并行流合并信息
   *
   * 并行流就是一个内容分成多个数据块，并用不同的线程分别每个数据块的流
   */
  private void parallelStreamMergeInfo() {

    List<ObjEnd> list = getList();
    Executor executor = getExecutor(list);

    Stream<ObjEnd> stream = list.parallelStream()
        .peek(objEnd -> {
          System.out.println("------------" + Thread.currentThread().getId());
          CompletableFuture<ObjOne> future = supplyAsync(
              () -> ServerOne.get(objEnd.getId()), executor);
          ObjOne objOne = future.join();
          objEnd.setTeacherId(objOne.getTeacherId());
        })
        .peek(objEnd -> {
          CompletableFuture<ObjTwo> future = supplyAsync(
              () -> ServerTwo.get(objEnd.getTeacherId()), executor);
          ObjTwo objTwo = future.join();
          objEnd.setTeacherName(objTwo.getTeacherName());
          objEnd.setPictureId(objTwo.getPictureId());
        })
        .peek(objEnd -> {
          CompletableFuture<ObjThree> future = supplyAsync(
              () -> ServerThree.get(objEnd.getPictureId()), executor);
          ObjThree objThree = future.join();
          objEnd.setPictureUrl(objThree.getPictureUrl());
        });

    stream.forEach(objEnd -> System.out.println(objEnd.toString()));
  }

  @Test
  public void computeMergeTime() {

    long start = System.nanoTime();
    sequentialStreamMergeInfo();
    System.out.println(
        "sequentialStreamMergeInfo()花费的时间为\n  "
            + (System.nanoTime() - start) / 1_000_000L);

    start = System.nanoTime();
    parallelStreamMergeInfo();
    System.out.println("parallelStreamMergeInfo()花费的时间\n  "
        + (System.nanoTime() - start) / 1_000_000L);
  }

  public List<ObjEnd> getList() {

    ObjEnd one = new ObjEnd();
    one.setId("111");

    ObjEnd two = new ObjEnd();
    two.setId("222");

    ObjEnd three = new ObjEnd();
    three.setId("333");

    ObjEnd four = new ObjEnd();
    four.setId("444");

    ObjEnd five = new ObjEnd();
    five.setId("555");

    return Arrays.asList(one, two, three, four, five);
  }

  private Executor getExecutor(List<ObjEnd> objList) {

    return Executors.newFixedThreadPool(10, r -> {
      Thread t = new Thread(r);
      /**
       * 使用守护线程
       * 这种方式不会阻止程序的关停
       */
      t.setDaemon(true);
      return t;
    });
  }
}
