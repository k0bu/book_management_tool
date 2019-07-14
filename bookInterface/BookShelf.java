package bookInterface;

import java.util.*;
import java.util.stream.Collectors;

public class BookShelf implements Aggregation {
  private List<Book> _bookShelf;

  public BookShelf() {
    this._bookShelf = new ArrayList<>();
  }

  public BookShelf(List<Book> books){
    this._bookShelf = books;
  }

  public void setAggregation(List<Element> books){
    if(!(books.get(0).getClass().isAssignableFrom(Book.class))){
      return;
    }
    this._bookShelf = books.stream().map(
      e -> (Book)e
      ).collect(Collectors.toList());
  }

  // public void addBook(Book b){
  //   this._bookShelf.add(b);
  // }

  public void addBooks(List<Book> books){
    books.forEach(b->{
      this.addElement(b);
    });
  }

  public List<Book> getBookShelf(){
    return this._bookShelf;
  }

  @Override
  public void addElement(Element e) {
    if(!(e instanceof Book) ) return;
    Book b = (Book) e;
    this._bookShelf.add(b);
  }

  @Override
  public void removeElement(Element e) {
    if(!(e instanceof Book) ) return;
    Book b = (Book) e;
    this._bookShelf.remove(b);
  }

  @Override
  public boolean existElement(Element e) {
    if(!(e instanceof Book) ) return false;
    Book b = (Book) e;
    return this._bookShelf.contains(b);
  }

  @Override
  public void removeAggregation(){
    this._bookShelf.clear();
  }

  public List<Book> filterBooks(String value){
    List<Book> filteredBooks = new ArrayList<>();
    this._bookShelf.forEach(b->{
      if(b.equalsParamaetre(value)){
        filteredBooks.add(b);
      }
    });
    return filteredBooks;
  }

}