package designpattern.strategypattern;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author niuhaijun
 * @date 2018/12/26 14:02
 */
@FunctionalInterface
public interface CompressionStrategy {


  OutputStream compress(OutputStream data) throws IOException;
}
