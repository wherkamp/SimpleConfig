package me.kingtux.simpleconfig.tests;

import java.io.File;
import java.io.IOException;
import me.kingtux.simpleconfig.SimpleConfig;

public class Main {

  private static SimpleConfig simpleConfig;

  public static void main(String[] args) throws IOException {
    File file = new File("test.tux");
    if (!file.exists()) {
      file.createNewFile();
    }
    simpleConfig = new SimpleConfig(file);
    simpleConfig.dump();
  }
}
