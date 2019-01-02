package javacoretechnology36course.teach09;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * @author niuhaijun
 * @date 2019/1/2 10:14
 */
public class LinkedHashMapTest {

  public static void main(String[] args) {
    /**
     * 构建占用空间敏感资源池
     *  删除最常不被访问的对象
     */
    LinkedHashMap<String, String> map = new LinkedHashMap<String, String>(16, 0.75f, true) {



      @Override
      protected boolean removeEldestEntry(Entry eldest) {

        /**
         * 自定义删除策略，否则行为就和普通的Map没有区别
         * This method is invoked by <tt>put</tt> and <tt>putAll</tt> after inserting a new entry into the map
         */
        return size() > 3;
      }
    };

    map.put("project1", "spring");
    map.put("project2", "spring mvc");
    map.put("project3", "spring boot");

    /**
     * 访问
     */
    map.get("project2");
    map.get("project2");
    map.get("project3");
    map.forEach((k, v) -> System.out.println(k + "->" + v));
    /**
     * 触发删除
     */
    map.put("project4", "redis");
    System.out.println("Oldest entry should be removed");
    map.forEach((k, v) -> System.out.println(k + "->" + v));
  }
}
