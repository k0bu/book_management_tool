import java.util.*;

public class Book implements Element{
  /*Example of the parametres
  private String _title;
  private String _isbn;
  private Stirng _author;
  private String _publisher;
  private String  _year;
  */
  private Map<String, String> _detail;

  public Book(){
    this._detail = new LinkedHashMap<>();
  }

  public Book(Map<String, String> initial){
    this._detail = initial;
  }

  public boolean addParametre(String key, String value){
    if(existParametre(key)) {
      return false;
    }

    this._detail.put(key,value); return true;
  }

  public boolean removeParametre(String key){
    if(existParametre(key)){
      return false;
    }

    this._detail.remove(key); return true;
  }

  public boolean modifyParametre(String key, String value){
    if(existParametre(key)){
      return false;
    }

    this._detail.replace(key,value); return true;
  }

  public void setBookDetail(Map<String, String> bookDetail){
    this._detail = bookDetail;
  }

  public Map<String,String> getBookDetail(){
    return this._detail;
  }


  public boolean existParametre(String key){
    return this._detail.containsKey(key);
  }

  public boolean equalsParamaetre(String value){
    return this._detail.containsValue(value);
  }

  public boolean equals(Book b){
    return this._detail.equals(b.getBookDetail());
  }



}