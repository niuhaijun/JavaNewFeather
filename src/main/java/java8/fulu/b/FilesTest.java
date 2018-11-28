package java8.fulu.b;

/**
 * Files
 *    lines：生成Stream<String>流
 *    list：生成Stream<Path>流动
 *    walk：生成Stream<Path>流动
 *    find：生成Stream<Path>流动
 *
 * @author niuhaijun
 * @date 2018/11/28 23:32
 */
public class FilesTest {

  public static void main(String[] args) {

    String str = String.join(", ", "lines", "list", "walk", "find");
    System.out.println(str);
  }

}
