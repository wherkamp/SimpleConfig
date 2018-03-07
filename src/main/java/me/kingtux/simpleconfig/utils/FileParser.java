package me.kingtux.simpleconfig.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileParser {

  private File file;

  public FileParser(File file) {
    this.file = file;
  }

  public Map<String, Object> loadFromFile() throws IOException {
    Map<String, Object> theFull = new HashMap<>();
    BufferedReader br = new BufferedReader(new FileReader(file));
    String line = "";
    while ((line = br.readLine()) != null) {
      String[] split = line.split(": ", 2);
      theFull.put(split[0].toLowerCase(), split[1]);
    }
    return theFull;
  }
}
