import java.util.*;

public class BookShelf extends Aggregation{
  private List<Book> _bookShelf;
  
  public BookShelf(){
    this._bookShelf = new ArrayList<Book>();
  }

  @Override
  public void setElement(Book b){
    this._bookShelf.add(b);
  }

  @Override
  public void removeElement(Book b){
    this._bookShelf.remove(b);    
  }

  @Override
  public boolean existElement(Book b){
    return this._bookShelf.contains(b);
  }

  @Override
  public Book searchElement(String s){
    Book book;
    this._bookShelf.forEach(b -> {
      if(b.existParametre(s)){
        book = b;
      }
    });
    
    return book;
  }
}