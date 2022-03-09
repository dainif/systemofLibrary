package UI.choice;


import Service.AdminService;
import Service.AdminServiceImpl.AdminServiceImpl;
import Service.UserService;
import Service.UserServiceImpl.UserServiceImpl;
import UI.Ui;
import entiy.Admin;
import entiy.User;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class Admincho {
    static AdminService adminService = new AdminServiceImpl();
    static UserService userService = new UserServiceImpl();
    public static void cho(){
        System.out.println("请输入选择：");
      Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()){
            case 1:
                System.out.println("请输入要删除的用户名：");
                String nam = scanner.next();
                Admin admin = new Admin(nam);
                int flag1 = adminService.Admindelete(admin);
                if(flag1==1){
                    System.out.println("删除成功！");
                }else {
                    System.out.println("删除失败！");
                }
                Ui.Adminshow();
                cho();
                break;
            case 2:
                System.out.println("请输入要修改的用户名：");
                String name = scanner.next();
                System.out.println("请输入修改后的密码：");
                String psd = scanner.next();
                System.out.println("请输入修改后的电话：");
                Integer tel = scanner.nextInt();
                Admin a=new Admin(name,psd,tel);
                int flag = adminService.AdminUpdate(a);
                if(flag ==1){
                    System.out.println("修改成功！！");
                }else {
                    System.out.println("修改失败！！");
                }
                Ui.Adminshow();
                cho();
                break;
                //用户添加
            case 3:
                System.out.println("请输入姓名：");
                String name1 =scanner.next();
                System.out.println("请输入密码：");
                String psd1 = scanner.next();
                System.out.println("请输入电话：");
                Integer tel1 = scanner.nextInt();
                User user =new User(name1,psd1,tel1);
                User u=new User();
                u = userService.findUserbyname(name1);
                if(u!=null){
                    System.out.println("用户名已存在！");
                }else {
                    int flag2 =userService.addUser(user);
                    if(flag2 == 1){
                        System.out.println("注册成功!");
                    }else {
                        System.out.println("注册失败！");
                    }
                }
                Ui.Adminshow();
                cho();
                break;
            case 4:
                List<User> list = userService.Findall();
                for (User user1:list){
                    System.out.println(user1.toString());
                }
                Ui.Adminshow();
                cho();
                break;
            case 5:
                System.out.println("请输入要修改的用户名：");
                String name2 = scanner.next();
                System.out.println("请输入修改后的密码：");
                String psd2 = scanner.next();
                System.out.println("请输入修改后的电话：");
                Integer tel2 = scanner.nextInt();
                User u1=new User(name2,psd2,tel2);
                int flag3 =userService.update(u1);
                if(flag3 ==1){
                    System.out.println("修改成功！！");
                }else {
                    System.out.println("修改失败！！");
                }
                Ui.Adminshow();
                cho();
                break;
            case 6:
                System.out.println("请输入要删除的用户名：");
                String nam1 = scanner.next();
               User user1 = new User(nam1);
                int flag4 = userService.delete(user1);
                if(flag4==1){
                    System.out.println("删除成功！");
                }else {
                    System.out.println("删除失败！");
                }
                Ui.Adminshow();
                cho();
                break;
            case 7:
                Bookcho.bookui();
                Bookcho.bookcho();
                break;
            case 8:
                Ui.ui();


        }

    }
}
