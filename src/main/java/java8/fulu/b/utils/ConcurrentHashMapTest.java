package java8.fulu.b.utils;

import java.util.concurrent.ConcurrentHashMap;
import org.junit.Test;

/**
 * @author niuhaijun
 * @date 2018/11/29 23:13
 */
public class ConcurrentHashMapTest {

  /**
   * forEach
   */
  @Test
  public void testForEach() {

    ConcurrentHashMap<String, Integer> map = getMap();
    map.forEach((k, v) -> System.out.println(k + " --> " + v));
  }

  /**
   * reduce
   */
  @Test
  public void testReduce() {

    ConcurrentHashMap<String, Integer> map = getMap();
    int res = map.reduce(2, (k, v) -> Integer.valueOf(v), Integer::sum);
    System.out.println(res);
  }

  @Test
  public void testSearch() {

    ConcurrentHashMap<String, Integer> map = getMap();
    Object obj = map.search(2, (k, v) -> k + v);
    System.out.println(obj);

  }


  private ConcurrentHashMap<String, Integer> getMap() {

    return new ConcurrentHashMap<String, Integer>() {
      {
        put("d", 44);
        put("b", 22);
        put("a", 11);
        put("c", 33);
      }
    };
  }

}
