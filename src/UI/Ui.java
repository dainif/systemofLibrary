package UI;

import BookDao.BookDao;
import BookDao.BookDaoImpl.BookDaoImpl;
import Service.AdminService;
import Service.AdminServiceImpl.AdminServiceImpl;
import Service.BookService;
import Service.BookServiceImpl.BookServiceImpl;
import Service.UserService;
import Service.UserServiceImpl.UserServiceImpl;
import UI.Book.Books;
import UI.Book.Brrow;
import entiy.Admin;
import entiy.Book;
import entiy.User;

import java.util.List;
import java.util.Scanner;

public class Ui {
    static UserService userService = new UserServiceImpl();
    static AdminService adminService = new AdminServiceImpl();
    public static BookService bookService = new BookServiceImpl();
    static BookDao bookDao = new BookDaoImpl();
    static Scanner sc = new Scanner(System.in);
    public static void ui() {
        System.out.println("*********欢迎来到图书管理系统***********");
        System.out.println("        请选择您要登录的身份        ");
        System.out.println("1、用户登录");
        System.out.println("2、管理员登录");
        System.out.println("3、用户注册");
        System.out.println("4、管理员注册");

        System.out.println("5、退出");

    }

    public static void Usershow() {
        System.out.println("请选择您要进行的服务：");
        System.out.println("1、销户");
        System.out.println("2、查询用户");
        System.out.println("3、修改信息");
        System.out.println("4、借书");
        System.out.println("5、还书");
        System.out.println("6、返回上一级");
    }

    public static void Adminshow() {
        System.out.println("登录成功！");
        System.out.println("请选择您要进行的服务：");
        System.out.println("1、管理员删除");
        System.out.println("2、管理员信息修改");
        System.out.println("3、用户添加");
        System.out.println("4、查询全部用户");
        System.out.println("5、用户信息修改");
        System.out.println("6、用户删除");
        System.out.println("7、书籍管理");
        System.out.println("8、返回上一级");
    }
    public static void choice() {
        boolean keep = true;
        while (keep) {
            ui();
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入选择：");
            switch (sc.nextInt()) {
                case 1:
                    boolean y= Userlogin();
                    if(y){
                        System.out.println("登陆成功!");
                        Ui.Usershow();
                        Userchoice();
                    }
                    else{System.out.println("用户不存在或密码错误！");}
                    break;

                case 2:
                    boolean l=Adminlogin();
                    if(l){
                        Ui.Adminshow();
                        Adminchoice();
                    }
                    else{System.out.println("用户不存在或密码错误！");}
                    break;

                case 3:
                    System.out.println("请输入用户名：");
                    String name = sc.next();
                    System.out.println("请输入密码：");
                    String psd1 = sc.next();
                    User user = new User(name,psd1);
                    boolean n = userService.addUser(user);
                    if (n) {
                        System.out.println("添加成功！");
                    } else {
                        System.out.println("名字重复了！");
                    }
                    break;
                case 4:
                    System.out.println("请输入用户名：");
                    String name2 = sc.next();
                    System.out.println("请输入密码：");
                    String psd=sc.next();
                    Admin admin = new Admin(name2,psd);
                    boolean t = adminService.add(admin);
                    if (t) {
                        System.out.println("添加成功！");
                    } else {
                        System.out.println("名字重复了！");
                    }
                    break;
                case 5:

                    keep=false;
                    break;
            }
        }
    }
    public static void Userchoice(){
        System.out.println("请输入选择：");
        String name = sc.next();
        switch (sc.nextInt()) {
            case 1:
                System.out.println("请输入用户id：");
                int id = sc.nextInt();
                User u1 = new User();
                u1.setId(id);
                userService.delete(u1);
                System.out.println("删除成功。");
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
                String tel = sc.next();
                User u3 = new User(name, psd, tel);
                userService.update(u3);
                Ui.Usershow();
                Userchoice();
                break;
            case 4:
                System.out.println("请选择您要进行的服务：");
                Brrow.bookUi();
                Brrow.bookChoice();
                break;
            case 5:
                System.out.println("请输入您要还的书名：");
                String name3 = sc.next();
                Book book = new Book();
                Book book1 = new Book(name3,0);
                book = bookService.FindBookByName(name3);
                if(book!=null){
                   bookService.Update(book);
                }else {
                    boolean k = bookService.BookAdd(book1);
                    if (k) {
                        bookService.Update(book1);
                    }
                }
                System.out.println("还书成功！");
                Usershow();
                Userchoice();
                break;

            case 6:
                Ui.ui();
                break;
        }
    }
    public static void Adminchoice(){
        System.out.println("请输入选择：");
        switch (sc.nextInt()){
            case 1:
                System.out.println("请输入用户id：");
                int id = sc.nextInt();
                Admin admin = new Admin(id);
                admin.setId(id);
                adminService.Admindelete(admin);
                System.out.println("删除成功。");
                Ui.Adminshow();
                Adminchoice();
                break;

            case 2:
                System.out.println("请输入管理员用户名：");
                String name = sc.next();
                System.out.println("请输入修改后的密码：");
                String psd = sc.next();
                System.out.println("请输入修改后的电话：");
                Integer tel = sc.nextInt();
                Admin admin1=new Admin(name,psd,tel);
                adminService.AdminUpdate(admin1);
                Ui.Adminshow();
                Adminchoice();
                break;
            case 3:
                System.out.println("请输入用户名：");
                String name1 = sc.next();
                System.out.println("请输入密码：");
                String psd1 = sc.next();
                User user = new User(name1,psd1);
                boolean n = userService.addUser(user);
                if (n) {
                    System.out.println("添加成功！");
                } else {
                    System.out.println("名字重复了！");
                }
                Ui.Adminshow();
                Adminchoice();
                break;
            case 4:
                List<User> list = userService.Findall();
                for(User user1:list){
                    System.out.println(user1.toString());
                }
                Ui.Adminshow();
                Adminchoice();
                break;
            case 5:
                System.out.println("请输入用户名：");
                name = sc.next();
                System.out.println("请输入修改后的密码：");
                String psd2 = sc.next();
                System.out.println("请输入修改后的电话：");
                String tel1 = sc.next();
                User u3 = new User(name, psd2, tel1);
                userService.update(u3);
                Ui.Adminshow();
                Adminchoice();
                break;
            case 6:
                System.out.println("请输入用户id：");
                int id1 = sc.nextInt();
                User u1 = new User();
                u1.setId(id1);
                userService.delete(u1);
                System.out.println("删除成功。");
                Ui.Adminshow();
                Adminchoice();
                break;
            case 7:
                Books.bookui();
                Books.bookcho();
                break;
            case 8:
                ui();
                break;





        }
    }
    public static boolean Userlogin() {
        List<User> list = userService.Findall();
        System.out.println("请输入用户名：");
        String name3 = sc.next();
        System.out.println("请输入密码：");
        String psd2 = sc.next();
        User u = new User(name3);
        u = userService.findUserbyname(name3);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPassword().equals(u.getPassword())) {
                return true;
            }

        }
        return false;
    }
    public static boolean Adminlogin() {
        List<Admin> list = adminService.FindAll();
        System.out.println("请输入用户名：");
        String name = sc.next();
        System.out.println("请输入密码：");
        String psd2 = sc.next();
        Admin a = new Admin(name);
        a = adminService.findAdminByName(name);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPassword().equals(a.getPassword())) {
                return true;
            }

        }
        return false;
    }

    public  static void main(String[] args) {
        Ui ui = new Ui();
        choice();
    }
}
