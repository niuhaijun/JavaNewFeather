package java8.stream;

import java.util.stream.LongStream;
import org.junit.Test;
import sun.util.calendar.LocalGregorianCalendar;

/**
 * @author niuhaijun
 * @date 2018/9/20 9:27
 */
public class LongStreamTest {

  @Test
  public void testRange() {
    LongStream longStream = LongStream.range(1, 10);
    longStream.forEach(System.out::println);
  }


}
