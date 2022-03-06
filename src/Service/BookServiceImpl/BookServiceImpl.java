package Service.BookServiceImpl;

import BookDao.BookDao;
import BookDao.BookDaoImpl.BookDaoImpl;
import Service.BookService;
import entiy.Book;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();
    @Override
    public Book FindBookByName(String name) {
        return bookDao.findBookByName(name);
    }

    @Override
    public boolean BookAdd(Book book) {
        List<Book> list= bookDao.FindAllBook();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getBookname().equals(book.getBookname())){
                return false;
            }
        }
        bookDao.add(book);
        return true;
    }

    @Override
    public void Bookdelete(Book book) {
    bookDao.delete(book);
    }

    @Override
    public List<Book> FindAllBook() {
        return bookDao.FindAllBook();
    }

    @Override
    public void Update(Book book) {
        bookDao.Update(book);
    }
}
