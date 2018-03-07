package me.kingtux.simpleconfig;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SimpleWriter {

  public File fileToWriteToo;
  public BufferedWriter fileWriter;

  public SimpleWriter(File fileToWriteToo) throws IOException {
    this.fileToWriteToo = fileToWriteToo;
    fileWriter = new BufferedWriter(new FileWriter(fileToWriteToo));
  }

  public void write(Map<String, Object> e) throws IOException {
    emtpyFile();
    List<String> lines = new ArrayList<>();
    for (Entry<String, Object> line : e.entrySet()) {
      lines.add(line.getKey() + ": " + line.getValue().toString());
    }
    for(String line: lines){
      fileWriter.append(line);
      fileWriter.newLine();

    }
    fileWriter.flush();
    fileWriter.close();
  }

  private void emtpyFile() throws FileNotFoundException {
    PrintWriter writer = new PrintWriter(fileToWriteToo);
    writer.print("");
    writer.close();
  }
}
