package BookDao;

import entiy.Book;

import java.util.List;

public interface BookDao {
    Book findBookByName(String name);
    void add(Book book);
    void delete(Book book);
    List<Book>FindAllBook();
    void Update(Book book);
}
