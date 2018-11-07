package java8.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import org.junit.Test;

/**
 * @author niuhaijun
 * @date 2018/9/11 18:27
 */
public class LocalDateTimeTest {

  @Test
  public void test() {
    //当天零点
    LocalDateTime start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);

    //当天零点
    LocalDateTime end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);

    System.out.println(Date.from(start.atZone(ZoneId.systemDefault()).toInstant()));
    System.out.println(Date.from(end.atZone(ZoneId.systemDefault()).toInstant()));
  }

}
