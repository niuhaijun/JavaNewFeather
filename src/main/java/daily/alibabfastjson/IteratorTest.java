package daily.alibabfastjson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

/**
 * @author niuhaijun
 * @date 2019/1/4 12:43
 */
public class IteratorTest {

  @Test
  public void testRemove() {

    /**
     * Arrays.asList(***)返回的大小固定的集合，对集合不能进行add remove操作
     */
    List<Integer> list = Arrays.asList(1, 2, 3, 4);

    list = new ArrayList<>(list);

    Iterator<Integer> iterator = list.iterator();
    int num;
    while (iterator.hasNext()) {
      num = iterator.next();
      if (num > 2) {
        iterator.remove();
      }
    }

    System.out.println(list);
  }
}
