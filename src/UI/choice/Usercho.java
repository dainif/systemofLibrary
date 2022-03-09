package UI.choice;

import Service.UserService;
import Service.UserServiceImpl.UserServiceImpl;
import UI.Ui;
import entiy.User;

import java.util.Scanner;

public class Usercho {
    public static void Userchoice(){
        System.out.println("请输入选择：");
        Scanner sc=new Scanner(System.in);
        UserService userService =new UserServiceImpl();
        String name = sc.next();
        switch (sc.nextInt()) {
            case 1:
                System.out.println("请输入要删除的用户名：");
                String name1 =sc.next();
                User user=new User(name1);
                int flag=userService.delete(user);
                if(flag==1){
                    System.out.println("删除成功！");
                }else {
                    System.out.println("删除失败！");
                }
                Ui.Usershow();
                Userchoice();
                break;
            case 2:
                System.out.println("请输入用户名：");
                name = sc.next();
                User u =userService.findUserbyname(name);
                System.out.println(u.toString());
                Ui.Usershow();
                Userchoice();
                break;

            case 3:
                System.out.println("请输入用户名：");
                name = sc.next();
                System.out.println("请输入修改后的密码：");
                String psd = sc.next();
                System.out.println("请输入修改后的电话：");
                Integer tel = sc.nextInt();
                User u3 = new User(name, psd, tel);
                int flag1=userService.update(u3);
                if(flag1==1){
                    System.out.println("修改成功！");
                }else {
                    System.out.println("修改失败！");
                }
                Ui.Usershow();
                Userchoice();
                break;
//            case 4:
//                System.out.println("请选择您要进行的服务：");
//                Brrow.bookUi();
//                Brrow.bookChoice();
//                break;
//            case 5:
//                System.out.println("请输入您要还的书名：");
//                String name3 = sc.next();
//                Book book = new Book();
//                Book book1 = new Book(name3,0);
//                book = bookService.FindBookByName(name3);
//                if(book!=null){
//                   bookService.Update(book);
//                }else {
//                    boolean k = bookService.BookAdd(book1);
//                    if (k) {
//                        bookService.Update(book1);
//                    }
//                }
//                System.out.println("还书成功！");
//                Usershow();
//                Userchoice();
//                break;

            case 6:
                Ui.ui();
                break;
        }
    }
}
