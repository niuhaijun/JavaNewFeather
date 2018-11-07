package java8.optional.op;

import java.util.Optional;
import org.junit.Test;

/**
 * @author niuhaijun
 * @date 2018/10/11 17:23
 */
public class OPTest {

  @Test
  public void testMap() {
    Insurance insurance = new Insurance();
    Optional<Insurance> optInsurance = Optional.of(insurance);

    Optional<String> optString = optInsurance.map(Insurance::getName);
  }


  @Test
  public void testFlatMap() {
    Person person = new Person();
    Optional<Person> optPerson = Optional.of(person);

    Optional<Optional<Car>> optCar = optPerson.map(Person::getCar);

    Optional<String> optString = optPerson.flatMap(Person::getCar).flatMap(Car::getInsurance)
        .map(Insurance::getName);


  }


}
