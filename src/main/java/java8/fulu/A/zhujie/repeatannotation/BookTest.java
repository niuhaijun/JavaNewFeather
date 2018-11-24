package java8.fulu.a.zhujie.repeatannotation;

import java.util.Arrays;

/**
 * @author niuhaijun
 * @date 2018/11/17 15:49
 */
public class BookTest {

  public static void main(String[] args) {
    Author[] authors = Book.class.getAnnotationsByType(Author.class);
    Arrays.asList(authors).stream().forEach(e -> System.out.println(e.name()));
  }

}
