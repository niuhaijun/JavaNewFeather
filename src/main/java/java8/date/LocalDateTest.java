package java8.date;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.DAY_OF_WEEK;
import static java.time.temporal.ChronoField.DAY_OF_YEAR;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import static java.time.temporal.ChronoField.YEAR;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import org.junit.Test;

/**
 * @author niuhaijun
 * @date 2018/11/21 20:50
 */
public class LocalDateTest {

  @Test
  public void testNow() {

    /**
     * 从默认时区中的系统时钟获取当前日期实例。
     */
    LocalDate date0 = LocalDate.now();
    System.out.println(date0);

    /**
     * 从指定时区中的系统时钟获取当前日期实例。
     */
    LocalDate date1 = LocalDate.now(ZoneId.of("Pacific/Guadalcanal"));
    System.out.println(date1);

    /**
     *
     */
    LocalDate date2 = LocalDate.now(Clock.systemDefaultZone());
    System.out.println(date2);
  }

  @Test
  public void testOf() {

    /**
     * 获取指定年、月(数字)、日的日期实例
     */
    LocalDate date0 = LocalDate.of(2018, 12, 13);
    System.out.println(date0);

    /**
     * 获取指定年、月(枚举)、日的日期实例
     */
    LocalDate date1 = LocalDate.of(2018, Month.JANUARY, 12);
    System.out.println(date1);
  }

  @Test
  public void testOfYearDay() {

    /**
     * 获取指定年、日（一年中的第几日）的日期实例
     */
    LocalDate date = LocalDate.ofYearDay(2018, 32);
    System.out.println(date);
  }

  @Test
  public void testParse() {

    /**
     * 使用默认格式化器格式字符串获取日期实例
     */
    LocalDate date = LocalDate.parse("2018-12-29");
    System.out.println(date);

    /**
     * 使用指定的格式化器格式字符串获取日期实例
     */
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDate date1 = LocalDate.parse("2018/11/12", formatter);
    System.out.println(date1);
  }

  @Test
  public void testIsLeapYear() {

    LocalDate date = LocalDate.now();
    boolean isLeapYear = date.isLeapYear();
    System.out.println(isLeapYear);
  }

  @Test
  public void testFormat() {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy->MM->dd");
    LocalDate date = LocalDate.of(2018, 1, 29);
    String strDate = date.format(formatter);
    System.out.println(strDate);

  }

  @Test
  public void testGet() {

    LocalDate date = LocalDate.of(2018, 2, 19);

    System.out.println("get()方法是最通用的");

    /**
     * 通过get()方法获取日期实例中特定的字段
     */

    int year = date.getYear();
    System.out.println("year = " + year + "; " + date.get(YEAR));

    Month month = date.getMonth();
    int monthOfYear0 = month.getValue();
    int monthOfYear1 = date.getMonthValue();
    System.out.println("monthOfYear0 = " + monthOfYear0 + "; " + date.get(MONTH_OF_YEAR));
    System.out.println("monthOfYear1 = " + monthOfYear1 + "; " + date.get(MONTH_OF_YEAR));

    int dayOfYear = date.getDayOfYear();
    System.out.println("dayOfYear = " + dayOfYear + "; " + date.get(DAY_OF_YEAR));

    int dayOfMonth = date.getDayOfMonth();
    System.out.println("dayOfMonth = " + dayOfMonth + "; " + date.get(DAY_OF_MONTH));

    DayOfWeek dayOfWeek = date.getDayOfWeek();
    int dayOfWeek1 = dayOfWeek.get(DAY_OF_WEEK);
    System.out.println("dayOfWeek = " + dayOfWeek1 + "; " + date.get(DAY_OF_WEEK));
  }

  @Test
  public void testWith() {

    /**
     * 使用with方法可以指定日期的特定字段
     */

    LocalDate date = LocalDate.now();
    System.out.println("date = " + date);

    LocalDate date1 = date.with(YEAR, 1999);
    System.out.println("date1 = " + date1);

    LocalDate date2 = date.withYear(2008);
    System.out.println("date2 = " + date2);

    LocalDate date3 = date.withMonth(7);
    System.out.println("date3 = " + date3);

    LocalDate date4 = date.withDayOfMonth(11);
    System.out.println("date4 = " + date4);

    LocalDate date5 = date.withDayOfYear(1);
    System.out.println("date5 = " + date5);


  }

  @Test
  public void testPlusAndMinus() {

    /**
     * plus方法和minus方法可以在特定的字段上做加减法
     */

    LocalDate date = LocalDate.now();
    System.out.println("date = " + date);

    LocalDate date1 = date.plus(Period.ofDays(3));
    System.out.println("date1 = " + date1);

    LocalDate date2 = date.plus(2, ChronoUnit.DAYS);
    System.out.println("date2 = " + date2);

    LocalDate date3 = date.plusYears(10);
    System.out.println("date3 = " + date3);

    LocalDate date4 = date.plusMonths(13);
    System.out.println("date4 = " + date4);

    LocalDate date5 = date.plusWeeks(100);
    System.out.println("date5 = " + date5);

    LocalDate date6 = date.plusDays(200);
    System.out.println("date6 = " + date6);

  }

  @Test
  public void testAtTime() {

    /**
     * 合并日期时间
     */

    LocalDate date = LocalDate.now();
    LocalTime time = LocalTime.now();
    System.out.println("date = " + date + "" + "; time = " + time);

    LocalDateTime dateTime1 = date.atTime(time);
    System.out.println("dateTime1 = " + dateTime1);

    LocalDateTime dateTime2 = date.atTime(19, 30);
    System.out.println("dateTime2 = " + dateTime2);

    LocalDateTime dateTime3 = date.atTime(23, 23, 23);
    System.out.println("dateTime3 = " + dateTime3);

    LocalDateTime dateTime4 = date.atTime(23, 23, 23, 23);
    System.out.println("dateTime4 = " + dateTime4);

    OffsetDateTime offsetDateTime = date.atTime(OffsetTime.parse("10:15:30+01:00"));
    System.out.println("offsetDateTime = " + offsetDateTime);
  }

}
