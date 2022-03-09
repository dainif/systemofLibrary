package Service;

import entiy.Admin;

import java.util.List;

public interface AdminService {
    int add(Admin admin);
    int AdminUpdate(Admin admin);
    int Admindelete(Admin admin);
    List<Admin>FindAll();
    Admin findAdminByName(String name);
    Admin findAdminByNamewithpsd(Admin admin);
}
