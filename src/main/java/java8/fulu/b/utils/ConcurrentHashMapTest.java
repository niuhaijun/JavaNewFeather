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
   * 对每个键值对进行特定的操作
   */
  @Test
  public void testForEach() {

    ConcurrentHashMap<String, Integer> map = getMap();
    map.forEach((k, v) -> System.out.println(k + " --> " + v));
  }

  /**
   * reduce
   * 使用给定的规约函数，将所有的键值对整合出一个结果
   */
  @Test
  public void testReduce() {

    ConcurrentHashMap<String, Integer> map = getMap();
    int res = map.reduce(2, (k, v) -> Integer.valueOf(v), Integer::sum);
    System.out.println(res);
  }

  /**
   * search
   * 对每个键值对都执行一个函数，直到函数的返回值为一个非空值
   */
  @Test
  public void testSearch() {

    ConcurrentHashMap<String, Integer> map = getMap();
    Object obj = map.search(2, (k, v) -> k + v);
    System.out.println(obj);
  }

  /**
   * 说明
   */
  @Test
  public void test() {

    StringBuilder builder = new StringBuilder();
    builder.append("使用K和V的操作\n").append("   forEach, reduce, search\n");
    builder.append("使用K的操作\n").append("   forEachKey, reduceKeys, searchKeys\n");
    builder.append("使用V的操作\n").append("   forEachValue, reduceValues, searchValues\n");
    builder.append("使用Map.Entry对象的操作\n").append("   forEachEntry, reduceEntries, searchEntries\n");

    builder.append("推荐使用mappingCount统计Map中的映射数");

    System.out.println(builder.toString());
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
