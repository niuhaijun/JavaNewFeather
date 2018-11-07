package java8.optional;

import java.util.OptionalInt;
import org.junit.Test;

/**
 * @author niuhaijun
 * @date 2018/9/20 9:58
 */
public class OptionalIntTest {
  @Test
  public void testOf() {
    OptionalInt optionalInt = OptionalInt.of(1);
    System.out.println(optionalInt.getAsInt());
  }
}
