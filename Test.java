import bookInterface.*;
import java.util.List;

public class Test{
  public static void main(String[] args){
    BookShelf books = new BookShelf();
    for(int i = 0; i < 10; i++){
      var book = new Book();
      book.addParametre( String.valueOf(i), "value" + i);
      books.addBook(book);
    }

    books.getBookShelf().forEach(b->{
      b.getBookDetail().forEach((k,v)->{
        System.out.println(k + ": " + v);
      });
    });

    List<Book> arrangedBooks = Recommend.interest(books.getBookShelf());
    System.out.println();

    arrangedBooks.forEach(b->{
      b.getBookDetail().forEach((k,v)->{
        System.out.println(k + ": " + v);
      });
    });
  }
}