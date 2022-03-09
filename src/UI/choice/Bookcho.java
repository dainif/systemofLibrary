package UI.choice;

import Service.BookService;
import Service.BookServiceImpl.BookServiceImpl;
import UI.Ui;
import entiy.Admin;
import entiy.Book;
import entiy.User;

import java.util.List;
import java.util.Scanner;

public class Bookcho {
    public static void bookui(){
        System.out.println("1、添加书籍");
        System.out.println("2、删除书籍");
        System.out.println("3、书籍列表");
        System.out.println("4、按名查找");
        System.out.println("5、书籍信息修改");
        System.out.println("6、返回上一级");
    }
    public static void bookcho(){
        Scanner sc=new Scanner(System.in);
        BookService bookService = new BookServiceImpl();
        switch (sc.nextInt()){
            case 1:
                System.out.println("请输入书名：");
                String name = sc.next();
                System.out.println("请输入出版社：");
                String press= sc.next();
                System.out.println("请输入作者：");
                String author = sc.next();
                System.out.println("请输入书籍数目：");
                Integer num = sc.nextInt();
                Book book = new Book(name,press,author,num);
                int flag =bookService.BookAdd(book);
                if(flag==1){
                    System.out.println("添加成功！");
                }else {
                    System.out.println("添加失败！");
                }
                bookui();
                bookcho();
                break;
            case 2:
                System.out.println("请输入要删除的书名：");
                String name1 =sc.next();
                Book book1=new Book(name1);
                int flag1=bookService.Bookdelete(book1);
                if(flag1==1){
                    System.out.println("删除成功！");
                }else {
                    System.out.println("删除失败！");
                }
                bookui();
                bookcho();
                break;
            case 3:
                List<Book> list =bookService.FindAllBook();
                for (Book book2:list){
                    System.out.println(book2.toString());
                }
                bookui();
                bookcho();
                break;
            case 4:
                System.out.println("请输入书名：");
                String name3 = sc.next();
                Book b = bookService.FindBookByName(name3);
                System.out.println(b.toString());
                bookui();
                bookcho();
                break;
            case 5:
                System.out.println("请输入要修改的书名：");
                String name4 = sc.next();
                System.out.println("请输入修改后的数量：");
                Integer num2 = sc.nextInt();
               Book book2 = new Book(name4,num2);
                int flag3 =bookService.Update(book2);
                if(flag3 ==1){
                    System.out.println("修改成功！！");
                }else {
                    System.out.println("修改失败！！");
                }
                bookui();
                bookcho();
                break;
            case 6:
                Ui.Adminshow();
                Admincho.cho();
                break;
        }
    }
}
