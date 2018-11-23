package java8.date;

import java.time.Clock;
import java.time.LocalDate;

/**
 * @author niuhaijun
 * @date 2018/11/23 23:37
 */
public class ClockTest {

  public static void main(String[] args) {

    Clock clock0 = Clock.systemUTC();
    LocalDate date0 = LocalDate.now(clock0);
    System.out.println("clock0 = " + clock0);
    System.out.println("date0 = " + date0);

    Clock clock1 = Clock.systemDefaultZone();
    LocalDate date1 = LocalDate.now(clock1);
    System.out.println("clock1 = " + clock1);
    System.out.println("date1 = " + date1);

  }
}
