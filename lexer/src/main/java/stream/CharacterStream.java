package stream;

import java.util.LinkedList;

public class CharacterStream {
  private transient LinkedList<Character> chars;
  private transient int position;

  public CharacterStream(String str) {
    this.chars = new LinkedList<>();
    for (int i = 0; i < str.length(); i++) {
      chars.add(str.charAt(i));
    }
    this.position = 0;
  }

  public boolean shouldRead() {
    return position < chars.size();
  }

  public boolean hasNext() {
    return position < chars.size() - 1;
  }

  public char next() {
    return chars.get(++position);
  }

  public void skipNChars(int n) {
    position += n;
  }

  public char peek() {
    return chars.get(position);
  }

  public String peekNChars(int n) {
    StringBuilder result = new StringBuilder();
    for (int i = position; i < Math.min(position + n, chars.size()); i++) {
      result.append(chars.get(i));
    }
    return result.toString();
  }

  public String peekRemainingChars() {
    return peekNChars(chars.size() - position);
  }
}
