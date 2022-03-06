package Service;

import entiy.Admin;

import java.util.List;

public interface AdminService {
    boolean add(Admin admin);
    void AdminUpdate(Admin admin);
    void Admindelete(Admin admin);
    List<Admin>FindAll();
    Admin findAdminByName(String name);
}
