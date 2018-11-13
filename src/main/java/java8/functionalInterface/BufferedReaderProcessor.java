package java8.functionalInterface;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 自定义函数式接口，并声明受检异常
 *
 * @author niuhaijun
 * @date 2018/10/10 14:58
 */
@FunctionalInterface
public interface BufferedReaderProcessor {

  String process(BufferedReader bufferedReader) throws IOException;
}
