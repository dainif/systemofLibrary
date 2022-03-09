package UI.choice;

import Service.AdminService;
import Service.AdminServiceImpl.AdminServiceImpl;
import Service.UserService;
import Service.UserServiceImpl.UserServiceImpl;
import UI.Ui;
import UI.login.Adminlogin;
import UI.login.Userlogin;
import entiy.Admin;
import entiy.User;

import java.util.Scanner;

import static UI.Ui.ui;

public class Uicho {
    public static void choice() {
        boolean keep = true;
        while (keep) {
            ui();
            Scanner sc = new Scanner(System.in);
            UserService userService =new UserServiceImpl();
            AdminService adminService =new AdminServiceImpl();
            System.out.println("请输入选择：");
            switch (sc.nextInt()) {
                case 1:
                    boolean y= Userlogin.userlogin();
                    if(y){
                        System.out.println("登陆成功!");
                        Ui.Usershow();
                       Usercho.Userchoice();
                    }
                    else{System.out.println("用户不存在或密码错误！");}
                    break;

                case 2:
                    boolean l= Adminlogin.adminlogin();
                    if(l){
                        System.out.println("登录成功！");
                        Ui.Adminshow();
                      Admincho.cho();
                    }
                    else{System.out.println("用户不存在或密码错误！");}
                    break;

                case 3:
                    System.out.println("请输入姓名：");
                    String name =sc.next();
                    System.out.println("请输入密码：");
                    String psd1 = sc.next();
                    System.out.println("请输入电话：");
                    Integer tel1 = sc.nextInt();
                    User user =new User(name,psd1,tel1);
                   User u=new User();
                    u = userService.findUserbyname(name);
                    if(u!=null){
                        System.out.println("用户名已存在！");
                    }else {
                        int flag =userService.addUser(user);
                        if(flag == 1){
                            System.out.println("注册成功!");
                        }else {
                            System.out.println("注册失败！");
                        }
                    }
                    break;
                case 4:
                    System.out.println("请输入姓名：");
                    String name1 =sc.next();
                    System.out.println("请输入密码：");
                    String psd = sc.next();
                    System.out.println("请输入电话：");
                    Integer tel = sc.nextInt();
                    Admin admin = new Admin(name1,psd,tel);
                    Admin a=new Admin();
                    a=adminService.findAdminByName(name1);
                    if(a!=null){
                        System.out.println("用户名已存在！");
                    }else {
                        int flag =adminService.add(admin);
                        if(flag == 1){
                            System.out.println("注册成功!");
                        }else {
                            System.out.println("注册失败！");
                        }
                    }
//                new Ui() ;
//                break;
                case 5:

                    keep=false;
                    break;
            }
        }
    }
}
