package designpattern.strategypattern;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;
import org.junit.Test;

/**
 * 策略模式
 *
 * @author niuhaijun
 * @date 2018/12/26 14:06
 */
public class StrategyTest {

  @Test
  public void test() throws IOException {

    Path inFile = Paths.get("");
    File outFile = new File("");

    /**
     * old
     */
//    Compressor gzipCompressor = new Compressor(new GzipCompressionStrategy());
//    gzipCompressor.compress(inFile, outFile);
//    Compressor zipCompressor = new Compressor(new ZipCompressionStrategy());
//    zipCompressor.compress(inFile, outFile);

    /**
     * new
     */
    Compressor gzipCompressor = new Compressor(GZIPOutputStream::new);
    gzipCompressor.compress(inFile, outFile);
    
    Compressor zipCompressor = new Compressor(ZipOutputStream::new);
    zipCompressor.compress(inFile, outFile);
  }
}
