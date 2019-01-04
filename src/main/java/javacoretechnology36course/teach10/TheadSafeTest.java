package javacoretechnology36course.teach10;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.SynchronousQueue;
import org.junit.Test;

/**
 * @author niuhaijun
 * @date 2019/1/2 17:45
 */
public class TheadSafeTest {

  /**
   * 传统集合框架
   */
  @Test
  public void test1() {

    Map<String, String> map1 = new Hashtable<>();

    Map<String, String> map2 = Collections.synchronizedMap(map1);

    map2.forEach((k, v) -> System.out.println(k + " --> " + v));
  }

  /**
   * 并发包
   */
  @Test
  public void test2() {

    ConcurrentHashMap<String, String> map1 = new ConcurrentHashMap<>();
    CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<>();
    ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
    SynchronousQueue<String> queue1 = new SynchronousQueue<>();
  }


}
