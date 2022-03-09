package UI.login;

import Service.AdminService;
import Service.AdminServiceImpl.AdminServiceImpl;
import entiy.Admin;

import java.util.Scanner;

public class  Adminlogin {
    static AdminService adminService = new AdminServiceImpl();
    public static boolean adminlogin(){
        System.out.println("请输入姓名：");
        Scanner sc=new Scanner(System.in);
        String name = sc.next();
        System.out.println("请输入密码：");
        String psd = sc.next();
        Admin a =adminService.findAdminByName(name);
        if(a!=null) {
            if (a.getPassword().equals(psd)) {
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }
    }
}
