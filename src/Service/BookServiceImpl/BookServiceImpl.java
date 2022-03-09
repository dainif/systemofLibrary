package Service.BookServiceImpl;

import BookDao.BookDao;
import BookDao.BookDaoImpl.BookDaoImpl;
import Service.BookService;
import entiy.Book;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();
    @Override
    public Book FindBookByName(String name) {
        return bookDao.findBookByName(name);
    }

    @Override
    public int BookAdd(Book book) {
        return bookDao.add(book);
    }

    @Override
    public int Bookdelete(Book book) {
    return bookDao.delete(book);
    }

    @Override
    public List<Book> FindAllBook() {
        return bookDao.FindAllBook();
    }

    @Override
    public int Update(Book book) {
      return  bookDao.Update(book);
    }
}
