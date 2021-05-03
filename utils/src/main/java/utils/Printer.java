package utils;

import java.util.LinkedList;
import java.util.List;

public class Printer {
  private final transient List<String> lines;

  public Printer() {
    lines = new LinkedList<>();
  }

  public void print(String line) {
    lines.add(line);
  }

  public List<String> getLines() {
    return lines;
  }
}
