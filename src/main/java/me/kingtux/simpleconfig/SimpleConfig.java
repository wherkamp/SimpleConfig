package me.kingtux.simpleconfig;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import me.kingtux.simpleconfig.utils.FileParser;

public class SimpleConfig {

  private Map<String, Object> fileContents;
  private FileParser fileParser;
  private SimpleWriter simpleWriter;

  public SimpleConfig(File file) throws IOException {
    fileParser = new FileParser(file);
    fileContents = fileParser.loadFromFile();
    simpleWriter = new SimpleWriter(file);
  }

  public void dump() {
    for (Entry<String, Object> e : fileContents.entrySet()) {
      System.out.println(e.getKey() + " " + e.getValue());
    }
  }

  public void set(String path, Object value) throws IOException {
    fileContents.put(path, value);
    simpleWriter.write(fileContents);
  }

  public void save() {

  }

  public void reload() throws IOException {
    fileContents = fileParser.loadFromFile();
  }
}
