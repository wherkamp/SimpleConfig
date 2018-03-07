package me.kingtux.simpleconfig.tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    List<String> ls = new ArrayList<>();
    ls.add("Welcome");
    ls.add("To");
    ls.add("New Age");
    System.out.println(simpleConfig.getString("file"));
    simpleConfig.set("WelcomeToTheNewAge", ls);
    simpleConfig.reload();
    for (String s : simpleConfig.getStringList("WelcomeToTheNewAge")) {
      System.out.println(s);
    }
  }
}
