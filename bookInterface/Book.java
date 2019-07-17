package bookInterface;

import java.util.*;

public class Book implements Element {
  /*
   * Example of the parametres private String _title; private String _isbn;
   * private Stirng _author; private String _publisher; private String _year;
   */
  private Map<String, String> _detail;

  public Book() {
    this._detail = new LinkedHashMap<>();
  }

  public Book(Map<String, String> initial) {
    this._detail = initial;
  }

  public boolean addParametre(String key, String value) {
    if (existsParametre(key)) {
      return false;
    }

    this._detail.put(key, value);
    return true;
  }

  public boolean removeParametre(String key) {
    if (existsParametre(key)) {
      return false;
    }

    this._detail.remove(key);
    return true;
  }

  public boolean modifyParametre(String key, String value) {
    if (existsParametre(key)) {
      return false;
    }

    this._detail.replace(key, value);
    return true;
  }

  public void setBookDetail(Map<String, String> bookDetail) {
    this._detail = bookDetail;
  }

  public Map<String, String> getBookDetail() {
    return this._detail;
  }

  public boolean existsParametre(String key) {
    return this._detail.containsKey(key);
  }

  public boolean existsDetail(String key, String value) {
    if (!this.existsParametre(key)) {
      return false;
    }

    return this._detail.containsValue(value);
  }

  public boolean equals(Book b) {
    return this._detail.equals(b.getBookDetail());
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    this._detail.forEach((k, v) -> {
      builder.append(k + ":" + v + "\n");
    });
    return builder.toString();
  }

  public void setString2Book(String inputBookString) {
    inputBookString.replaceAll("\r\n", "\n");
    String[] str = inputBookString.split("\n");
    Map<String, String> bookDetail = new LinkedHashMap<>();
    for(var s: str){
      String[] keyValue = s.split(":");
      if(keyValue.length == 2){
        bookDetail.put(keyValue[0],keyValue[1]);
      }
    }

    this._detail = bookDetail;
  }

}