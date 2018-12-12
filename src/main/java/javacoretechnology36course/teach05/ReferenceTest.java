package javacoretechnology36course.teach05;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * @author niuhaijun
 * @date 2018/12/10 11:06
 */
public class ReferenceTest {

  public static void main(String[] args) {

    Object counter = new Object();
    System.out.println(counter);

    ReferenceQueue refQueue = new ReferenceQueue();
    Reference<Object> p = new PhantomReference<>(counter, refQueue);

    counter = null;
    System.gc();

    try {
      /**
       * remove是一个阻塞方法，可以指定timeout，或者选择一直阻塞
       */
      Reference<Object> ref = refQueue.remove(5_000L);
      if (ref != null) {
        // do something
        System.out.println("counter已被GC");
      }
    } catch (InterruptedException e) {
      // handle it
      e.printStackTrace();
    }
  }

  ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

}
