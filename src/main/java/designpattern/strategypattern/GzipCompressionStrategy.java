package designpattern.strategypattern;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author niuhaijun
 * @date 2018/12/26 14:03
 */
public class GzipCompressionStrategy implements CompressionStrategy {

  @Override
  public OutputStream compress(OutputStream data) throws IOException {

    return new GZIPOutputStream(data);
  }
}
