import bookInterface.*;
import java.util.List;

public class Test{
  public static void main(String[] args){
    BookShelf books = new BookShelf();
    for(int i = 0; i < 10; i++){
      var book = new Book();
      book.addParametre( "title", "value " + i);
      books.addElement(book);
    }

    System.out.print(books.toString());

    // books.toStrings().forEach(s->{
    //   System.out.print(s);
    // });

    // books.getBooks().forEach(b->{
    //   b.getBookDetail().forEach((k,v)->{
    //     System.out.println(k + ": " + v);
    //   });
    // });
    
    System.out.println();
    System.out.println("REMOVED 3:");

    books.filterBooks("title", "value 3").forEach(b->{
      books.removeElement(b);
    });

    books.getBooks().forEach(b->{
      b.getBookDetail().forEach((k,v)->{
        System.out.println(k + ": " + v);
      });
    });

    List<Book> arrangedBooks = Recommend.interest(books.getBooks());
    System.out.println();
    System.out.println("INTEREST:");

    arrangedBooks.forEach(b->{
      b.getBookDetail().forEach((k,v)->{
        System.out.println(k + ": " + v);
      });
    });

    arrangedBooks = Recommend.popularity(books.getBooks());
    System.out.println();
    System.out.println("POPULARITY:");

    arrangedBooks.forEach(b->{
      b.getBookDetail().forEach((k,v)->{
        System.out.println(k + ": " + v);
      });
    });
  }
}