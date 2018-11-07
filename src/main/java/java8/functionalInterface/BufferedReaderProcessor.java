package java8.functionalInterface;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author niuhaijun
 * @date 2018/10/10 14:58
 */
@FunctionalInterface
public interface BufferedReaderProcessor {

  String process(BufferedReader bufferedReader) throws IOException;
}
