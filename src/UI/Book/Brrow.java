//package UI.Book;
//
//import Service.BookService;
//import Service.BookServiceImpl.BookServiceImpl;
//
//import java.util.List;
//import java.util.Scanner;
//
//import UI.Ui;
//import entiy.Book;
//
////import static UI.Ui.Userchoice;
//
//public class Brrow {
//    public static void bookUi() {
//        System.out.println("1、按书名查找");
//        System.out.println("2、全部查找");
//        System.out.println("3、返回上一级");
//
//    }
//    public static void bookChoice(){
//        BookService bookService = new BookServiceImpl();
//
//        Scanner sc= new Scanner(System.in);
//        switch (sc.nextInt()){
//            case 1:
//                System.out.println("请输入书名：");
//                String name = sc.next();
//               Book book=bookService.FindBookByName(name);
//               if(book != null){
//                   System.out.println(book.toString());
//                   if(book.getNum()!=0){
//                       book.setNum(book.getNum()-1);
//                       System.out.println("借书成功");
//                   }
//                   System.out.println("书已借完！！");
//
//               }
//               else {
//                   System.out.println("未收录此书!");}
//                bookUi();
//               bookChoice();
//                break;
//
//            case 2:
//                List<Book> list = bookService.FindAllBook();
//                for(Book book1:list){
//                    System.out.println(book1.toString());
//                }
//                    bookUi();
//                    bookChoice();
//                break;
//            case 3:
//                Ui.Usershow();
//                Userchoice();
//                break;
//
//
//
//
//
//        }
//
//    }
//}
