package me.kingtux.simpleconfig.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
      if (split[1].startsWith("[") && split[1].endsWith("]")) {
        String array = split[1].replace("[", "");
        array = array.replace("]", "");
        List<String> myList = new ArrayList<String>(Arrays.asList(array.split(", ")));
        theFull.put(split[0], myList);
      } else {
        List<String> addThis = splitString(line);
        theFull.put(addThis.get(0), addThis.get(1));
      }
    }
    return theFull;
  }

  /**
   *
   * @param line
   * @return
   */
  public List<String> splitString(String line) {
    char[] lineArray = line.toCharArray();
    List<String> returnValue = new ArrayList<>();
    int currentChar = 0;
    int length = lineArray.length;
    for (char chara : lineArray) {

      if (chara == ':') {
        returnValue.add(getBetween(lineArray, 0, (currentChar)));
        returnValue.add(getBetween(lineArray, currentChar + 2, length));
        break;
      }
      currentChar++;
    }
    return returnValue;
  }
  public String getBetween(char[] idk, int beginAt, int endAt) {
    String returnValue = "";
    int current = beginAt;
    while (endAt > current) {
      //Debug get Between System.out.println(endAt + " " + beginAt + " " + " " + current + " " + idk[current]);
      returnValue = returnValue + idk[current];
      current++;
    }
    return returnValue;
  }
}
