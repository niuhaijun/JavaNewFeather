package javacoretechnology36course.teach08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Vector;
import org.junit.Test;

/**
 * @author niuhaijun
 * @date 2018/12/23 14:34
 */
public class ListDiff {

  @Test
  public void defaultCapacity() {

    Vector<Integer> vector = new Vector<>();
    vector.add(1);
    ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList.add(1);
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.add(1);
  }

  @Test
  public void testSort() {

    int[] nums = {1, 3, 2};
    Arrays.sort(nums);

    Integer[] objNums = {1, 3, 2};
    Arrays.sort(objNums);

    Collections.sort(null);
  }

}
