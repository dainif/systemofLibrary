package UI.login;

import Service.AdminService;
import Service.AdminServiceImpl.AdminServiceImpl;
import Service.UserService;
import Service.UserServiceImpl.UserServiceImpl;
import entiy.Admin;
import entiy.User;

import java.util.Scanner;

public class Userlogin {
    static UserService userService =new UserServiceImpl();
    public static boolean userlogin(){
        System.out.println("请输入姓名：");
        Scanner sc=new Scanner(System.in);
        String name = sc.next();
        System.out.println("请输入密码：");
        String psd = sc.next();
        User u =userService.findUserbyname(name);
        if(u!=null) {
            if (u.getPassword().equals(psd)) {
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }
    }
}
