package Service;

import entiy.Book;

import java.util.List;

public interface BookService {
    Book FindBookByName(String name);
    int BookAdd(Book book);
    int Bookdelete(Book book);
    List<Book>FindAllBook();
    int Update(Book book);
}
