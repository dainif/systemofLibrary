package BookDao.BookDaoImpl;

import BookDao.BookDao;
import Util.JDBCUtil;
import entiy.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
     List<Book> books = new ArrayList<>();
     Connection con =null;
     PreparedStatement ps=null;
     ResultSet rs=null;
     Book book=new Book();
     int flag =0;
    @Override
    public Book findBookByName(String name) {
        try {
            con = JDBCUtil.getConnection();
            String b_name = name;
            String sql = "select * from book where b_name = ?";
            ps=con.prepareStatement(sql);
            ps.setString(1,b_name);
            rs=ps.executeQuery();
            while (rs.next()){
                book.setId(rs.getInt("b_id"));
                book.setBookname(rs.getString("b_name"));
                book.setPress(rs.getString("b_p"));
                book.setAuthor(rs.getString("b_a"));
                book.setNum(rs.getInt("b_n"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
           JDBCUtil.closeResource(con,ps,rs);
           return book;
        }

    }

    @Override
    public int add(Book book) {
      try {
          con = JDBCUtil.getConnection();
          String b_name = book.getBookname();
          String b_p = book.getPress();
          String b_a = book.getAuthor();
          Integer b_n = book.getNum();
          String sql = "insert into book values(null ,?, ?, ?, ?) ";
          ps = con.prepareStatement(sql);
          ps.setString(1,b_name);
          ps.setString(2,b_p);
          ps.setString(3,b_a);
          ps.setInt(4,b_n);
          flag = ps.executeUpdate();

      } catch (Exception e) {
          e.printStackTrace();
      }finally {
          JDBCUtil.closeResource(con,ps,rs);
          return flag;
      }
    }
    public int Update(Book book) {
        try {
            con = JDBCUtil.getConnection();
            String b_name = book.getBookname();
            String b_p = book.getPress();
            String b_a = book.getAuthor();
            Integer b_n = book.getNum();
            String sql = "UPDATE book Set  b_n =? where b_name = ? ";
            ps = con.prepareStatement(sql);
            ps.setInt(1,b_n);
            ps.setString(2,b_name);
            flag = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeResource(con,ps,rs);
            return flag;
        }

    }

    @Override
    public int delete(Book book) {
   try {
       con =JDBCUtil.getConnection();
       String b_name = book.getBookname();
       String sql ="delete from book where b_name = ?";
       ps = con.prepareStatement(sql);
       flag = ps.executeUpdate();

   } catch (Exception e) {
       e.printStackTrace();
   }finally {
       JDBCUtil.closeResource(con,ps,rs);
       return flag;
   }
    }

    @Override
    public List<Book> FindAllBook() {
        List<Book> books=new ArrayList<>();
       try {
           con = JDBCUtil.getConnection();
           String sql ="select * from book";
           ps = con.prepareStatement(sql);
           rs= ps.executeQuery();
           while (rs.next()){
               Book book = new Book();
               book.setId(rs.getInt("b_id"));
               book.setPress(rs.getString("b_p"));
               book.setBookname(rs.getString("b_name"));
               book.setAuthor(rs.getString("b_a"));
               book.setNum(rs.getInt("b_n"));
                books.add(book);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }

    finally {
           JDBCUtil.closeResource(con,ps,rs);
           return books;
       }

    }

}
