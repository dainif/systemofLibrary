package BookDao;

import entiy.Book;

import java.util.List;

public interface BookDao {
    Book findBookByName(String name);
    int add(Book book);
    int delete(Book book);
    List<Book>FindAllBook();
    int Update(Book book);
}
