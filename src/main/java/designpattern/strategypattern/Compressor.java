package designpattern.strategypattern;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author niuhaijun
 * @date 2018/12/26 14:05
 */
public class Compressor {

  private final CompressionStrategy strategy;

  public Compressor(CompressionStrategy strategy) {

    this.strategy = strategy;
  }

  public void compress(Path inFile, File outFile) throws IOException {

    try (OutputStream outStream = new FileOutputStream(outFile)) {
      Files.copy(inFile, strategy.compress(outStream));
    }
  }
}
