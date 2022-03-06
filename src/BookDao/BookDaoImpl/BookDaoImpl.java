package BookDao.BookDaoImpl;

import BookDao.BookDao;
import entiy.Book;
import entiy.User;

import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
     private List<Book> books = new ArrayList<>();
    @Override
    public Book findBookByName(String name) {
        for (int i=0;i<books.size();i++){
            if(books.get(i).getBookname().equals(name)){
                return books.get(i);
            }
        }
        return null;
    }

    @Override
    public void add(Book book) {
       book.setId(books.size()+1);
       books.add(book);
    }
    public void Update(Book book) {
        for(Book book1:books){
            if(book1.getBookname().equals(book.getBookname())) {
               book1.setNum(book.getNum()+1);
                break;
            }
        }
    }

    @Override
    public void delete(Book book) {
    books.remove(book.getId()-1);
    }

    @Override
    public List<Book> FindAllBook() {
         List<Book> list =new ArrayList<>();
        books.forEach(item->{
           list.add(item);
        });
        return list;
    }
}
