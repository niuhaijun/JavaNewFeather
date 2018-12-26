package designpattern.observerpattern;

import org.junit.Test;

/**
 * 观察者模式
 *
 * @author niuhaijun
 * @date 2018/12/26 15:09
 */
public class ObserverTest {

  @Test
  public void test() {

    Moon moon = new Moon();
    moon.startSpying(new NasaObserver());
    moon.startSpying(new AliensObserver());
    moon.land("An asteroid");
    moon.land("Apollo 11");
  }

  @Test
  public void test1() {

    Moon moon = new Moon();
    moon.startSpying(name -> {
      if (name.contains("Apollo")) {
        System.out.println("We made it!");
      }
    });

    moon.startSpying(name -> {
      if (name.contains("Apollo")) {
        System.out.println("They're distracted, lets invade earth!");
      }
    });

    moon.land("An asteroid");
    moon.land("Apollo 11");
  }

}
