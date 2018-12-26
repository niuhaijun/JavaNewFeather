package designpattern.strategypattern;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author niuhaijun
 * @date 2018/12/26 14:04
 */
public class ZipCompressionStrategy implements CompressionStrategy {

  @Override
  public OutputStream compress(OutputStream data) throws IOException {

    return new ZipOutputStream(data);
  }
}
