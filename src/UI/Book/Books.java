package UI.Book;

import java.util.List;
import java.util.Scanner;

import Service.BookService;
import Service.BookServiceImpl.BookServiceImpl;
import UI.Ui;
import entiy.Book;

import static UI.Ui.bookService;

public class Books {
    static BookService b=new BookServiceImpl();
    public static void bookui(){
        System.out.println("1、添加书籍");
        System.out.println("2、删除书籍");
        System.out.println("3、查询全部书籍");
        System.out.println("4、按名查询书籍");

    }
    public static void bookcho() {
        System.out.println("请输入选择：");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
            System.out.println("请输入书籍名称：");
            Scanner sc = new Scanner(System.in);
            String name = sc.next();
            System.out.println("请输入书籍出版社:");
            String press = sc.next();
            System.out.println("请输入书籍作者：");
            String author = sc.next();
            System.out.println("请输入书籍数目：");
            int num = sc.nextInt();
            Book book = new Book(name, press, author, num);
            boolean k = b.BookAdd(book);
            if (k) {
                System.out.println("添加成功");
            } else {
                System.out.println("重复添加书籍！！");
            }
            bookui();
            bookcho();
            break;
            case 2:
                Ui.ui();
                break;
            case 3:
                List<Book> list = b.FindAllBook();
                for(Book book1:list){
                    System.out.println(book1.toString());
                }
               bookui();
                bookcho();
                break;
        }
    }
}