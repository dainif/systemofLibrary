package Service;

import entiy.Book;

import java.util.List;

public interface BookService {
    Book FindBookByName(String name);
    boolean BookAdd(Book book);
    void  Bookdelete(Book book);
    List<Book>FindAllBook();
    void Update(Book book);
}
