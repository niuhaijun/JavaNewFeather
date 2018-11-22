package java8.date;

import static java.time.temporal.ChronoField.HOUR_OF_DAY;
import static java.time.temporal.ChronoField.MINUTE_OF_HOUR;
import static java.time.temporal.ChronoField.NANO_OF_SECOND;
import static java.time.temporal.ChronoField.SECOND_OF_MINUTE;
import static java.time.temporal.ChronoUnit.HOURS;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.junit.Test;

/**
 * @author niuhaijun
 * @date 2018/11/21 22:52
 */
public class LocalTimeTest {

  @Test
  public void testNow() {

    /**
     * 获取默认时区或指定时区的时间
     */
    LocalTime time0 = LocalTime.now();
    System.out.println("time0 = " + time0);

    LocalTime time1 = LocalTime.now(ZoneId.of("America/New_York"));
    System.out.println("time1 = " + time1);
  }

  @Test
  public void testOf() {

    LocalTime time0 = LocalTime.of(12, 35, 35, 88);
    System.out.println("time0 = " + time0);

    LocalTime time1 = LocalTime.of(23, 45, 13);
    System.out.println("time1 = " + time1);

    LocalTime time2 = LocalTime.of(23, 59);
    System.out.println("time2 = " + time2);

    LocalTime time3 = LocalTime.ofSecondOfDay(30);
    System.out.println("time3 = " + time3);

    LocalTime time4 = LocalTime.ofNanoOfDay(10_000_000);
    System.out.println("time4 = " + time4);
  }

  @Test
  public void testFrom() {

  }

  @Test
  public void testParse() {

    /**
     * 使用默认的或者指定的 日期-时间格式化器 将字符串格式化为时间
     */

    LocalTime time0 = LocalTime.parse("03:15:30");
    System.out.println("time0 = " + time0);

    LocalTime time1 = LocalTime.parse("03/15/30", DateTimeFormatter.ofPattern("HH/mm/ss"));
    System.out.println("time1 = " + time1);
  }

  @Test
  public void testGet() {

    /**
     * 使用get方法可以获取时间的特定字段
     */

    LocalTime time = LocalTime.now();

    int hour0 = time.get(HOUR_OF_DAY);
    int hour1 = time.getHour();
    System.out.println("hour0 = " + hour0 + "; " + " hour1 = " + hour1);

    int minute0 = time.get(MINUTE_OF_HOUR);
    int minute1 = time.getMinute();
    System.out.println("minute0 = " + minute0 + "; " + "minute1 = " + minute1);

    int second0 = time.get(SECOND_OF_MINUTE);
    int second1 = time.getSecond();
    System.out.println("second0 = " + second0 + "; " + "second1 = " + second1);

    int nano0 = time.get(NANO_OF_SECOND);
    int nano1 = time.getNano();
    System.out.println("nano0 = " + nano0 + "; " + "nano1 = " + nano1);


  }

  @Test
  public void testWith() {

    /**
     * 修改时间，指定时间的特定字段
     */

    LocalTime time0 = LocalTime.now();
    String s0 = "time0 = " + time0.toString() + "; ";

    LocalTime time1 = time0.with(HOUR_OF_DAY, 21);
    System.out.println(s0 + "time1 = " + time1);

    LocalTime time2 = time0.withHour(23);
    System.out.println(s0 + "time2 = " + time2);

    LocalTime time3 = time0.withMinute(59);
    System.out.println(s0 + "time3 = " + time3);

    LocalTime time4 = time0.withSecond(59);
    System.out.println(s0 + "time4 = " + time4);

    LocalTime time5 = time0.withNano(1_00_000);
    System.out.println(s0 + "time5 = " + time5);
  }

  @Test
  public void testPlusAndMinus() {

    /**
     * 修改时间， 在特定的字段上进行加减运算
     */
    LocalTime time0 = LocalTime.now();
    String s0 = "time0 = " + time0.toString() + "; ";

    LocalTime time1 = time0.plus(1, HOURS);
    System.out.println(s0 + "time1 = " + time1);

    LocalTime time2 = time0.plusHours(5);
    System.out.println(s0 + "time2 = " + time2);

    LocalTime time3 = time0.plusMinutes(20);
    System.out.println(s0 + "time3 = " + time3);

    LocalTime time4 = time0.plusSeconds(10);
    System.out.println(s0 + "time4 = " + time4);

    LocalTime time5 = time0.plusNanos(100_000_000);
    System.out.println(s0 + "time5 = " + time5);
  }

  @Test
  public void testAt() {

    /**
     * 将时间与日期组合
     */

    LocalTime time = LocalTime.now();
    LocalDate date = LocalDate.now();

    LocalDateTime dateTime = time.atDate(date);
    System.out.println("dateTime = " + dateTime);
    System.out.println("date     = " + date);
    System.out.println("time     = " + time);
  }

  @Test
  public void testFormat() {

    LocalTime time = LocalTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH -:- mm -:- ss");
    String s = time.format(formatter);
    System.out.println(s);
  }

}
