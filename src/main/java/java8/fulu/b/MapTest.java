package java8.fulu.b;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * Map
 *   getOrDefault
 *   forEach
 *   compute
 *   computeIfAbsent
 *   computeIfPresent
 *   merge
 *   putIfAbsent
 *   remove(key, value)
 *   replace
 *   replaceAll
 *
 *
 * @author niuhaijun
 * @date 2018/11/24 18:31
 */
public class MapTest {


  private Map<String, String> getMap() {

    Map<String, String> map = new HashMap<String, String>() {
      {
        put("niu", "huang");
        put("hai", "wen");
        put("jun", "jun");
      }
    };

    return map;
  }


  /**
   * getOrDefault
   *  如果不存在，返回默认的值
   *  如果存在,就返回获取到的值
   */
  @Test
  public void testGetOrDefault() {

    Map<String, String> map = getMap();

    String value0 = map.get("ni");
    System.out.println(value0);

    String value1 = map.get("niu");
    System.out.println(value1);

    String value2 = map.getOrDefault("ni", "niu_huang");
    System.out.println(value2);
  }

  /**
   * forEach
   *   遍历map
   */
  @Test
  public void testForEach() {

    Map<String, String> map = getMap();

    map.forEach((key, value) -> System.out.println(key + " --> " + value));

  }

  /**
   * compute
   */
  @Test
  public void testCompute() {

    Map<String, String> map = null;

    map = getMap();
    String res0 = map.compute("niu", (t, u) -> t + " --> " + u);
    System.out.println("res0 = " + res0);
    map.forEach((k, v) -> System.out.println(k + " -> " + v));

    System.out.println();

    map = getMap();
    String res1 = map.compute("niu", (t, u) -> null);
    System.out.println("res1 = " + res1);
    map.forEach((k, v) -> System.out.println(k + " -> " + v));

    System.out.println();

    map = getMap();
    String res2 = map.compute("ni", (t, u) -> t);
    System.out.println("res2 = " + res2);
    map.forEach((k, v) -> System.out.println(k + " --> " + v));

    System.out.println();

    map = getMap();
    String res3 = map.compute("ni", (t, u) -> null);
    System.out.println("res3 = " + res3);
    map.forEach((k, v) -> System.out.println(k + " --> " + v));
  }

  /**
   * computeIfAbsent
   *  使用该方法可以非常方便地使用缓存模式
   *
   *
   *  如果Map中没有指定Key的键值对
   *     mappingFunction会根据key构建一个键值对，如果该键值对中的value不为null，
   *     则将这对键值对添加到Map中
   */
  @Test
  public void textComputeIfAbsent() {

    Map<String, String> map = null;

    map = getMap();
    String res0 = map.computeIfAbsent("niu", t -> t + t);
    System.out.println("res0 = " + res0);
    map.forEach((k, v) -> System.out.println(k + " -> " + v));

    System.out.println();

    map = getMap();
    String res1 = map.computeIfAbsent("niu", t -> null);
    System.out.println("res1 = " + res1);
    map.forEach((k, v) -> System.out.println(k + " -> " + v));

    System.out.println();

    map = getMap();
    String res2 = map.computeIfAbsent("niu0", t -> t + t);
    System.out.println("res2 = " + res2);
    map.forEach((k, v) -> System.out.println(k + " --> " + v));

    System.out.println();

    map = getMap();
    String res3 = map.computeIfAbsent("niu0", t -> null);
    System.out.println("res3 = " + res3);
    map.forEach((k, v) -> System.out.println(k + " --> " + v));
  }

  /**
   * computeIfPresent
   */
  @Test
  public void textComputeIfPresent() {

    Map<String, String> map = null;

    map = getMap();
    String res0 = map.computeIfPresent("niu", (t, u) -> t + " --> " + u);
    System.out.println("res0 = " + res0);
    map.forEach((k, v) -> System.out.println(k + " -> " + v));

    System.out.println();

    map = getMap();
    String res1 = map.computeIfPresent("niu", (t, u) -> null);
    System.out.println("res1 = " + res1);
    map.forEach((k, v) -> System.out.println(k + " -> " + v));

    System.out.println();

    map = getMap();
    String res2 = map.computeIfPresent("niu0", (t, u) -> t + " --> " + u);
    System.out.println("res2 = " + res2);
    map.forEach((k, v) -> System.out.println(k + " --> " + v));

    System.out.println();

    map = getMap();
    String res3 = map.computeIfPresent("niu0", (t, u) -> null);
    System.out.println("res3 = " + res3);
    map.forEach((k, v) -> System.out.println(k + " --> " + v));
  }

  /**
   * merge
   */
  @Test
  public void testMerge() {

    Map<String, String> map = getMap();

    String res0 = map.merge("niu0", "huang0", (t, u) -> t + " --> " + u);
    System.out.println("res0 = " + res0);
    map.forEach((k, v) -> System.out.println(k + " -> " + v));

    System.out.println();

    String res2 = map.merge("niu", "huang0", (t, u) -> t + " --> " + u);
    System.out.println("res2 = " + res2);
    map.forEach((k, v) -> System.out.println(k + " -> " + v));

  }

  /**
   * putIfAbsent
   */
  @Test
  public void testPutIfAbsent() {

    Map<String, String> map = null;

    map = getMap();
    map.putIfAbsent("niu0", "huang0");
    map.forEach((k, v) -> System.out.println(k + " -> " + v));

    System.out.println();

    map = getMap();
    map.putIfAbsent("niu", "huang0");
    map.forEach((k, v) -> System.out.println(k + " -> " + v));

  }

  /**
   * remove
   */
  @Test
  public void testRemove() {

    Map<String, String> map = null;

    map = getMap();
    boolean res0 = map.remove("niu", "huang");
    System.out.println("res0 = " + res0);
    map.forEach((k, v) -> System.out.println(k + " --> " + v));

    System.out.println();

    map = getMap();
    boolean res1 = map.remove("niu", "huang0");
    System.out.println("res1 = " + res1);
    map.forEach((k, v) -> System.out.println(k + " --> " + v));

  }

  /**
   * replace
   */
  @Test
  public void testReplace() {

    Map<String, String> map = null;

    map = getMap();
    String res0 = map.replace("niu", "huang0");
    System.out.println("res0 = " + res0);
    map.forEach((k, v) -> System.out.println(k + " --> " + v));

    System.out.println();

    map = getMap();
    String res1 = map.replace("ni", "huang0");
    System.out.println("res1 = " + res1);
    map.forEach((k, v) -> System.out.println(k + " --> " + v));

  }

  /**
   * replaceAll
   */
  @Test
  public void testReplaceAll() {

    Map<String, String> map = null;

    map = getMap();
    map.replaceAll((k, v) -> "abc");
    map.forEach((k, v) -> System.out.println(k + " --> " + v));
  }
}
