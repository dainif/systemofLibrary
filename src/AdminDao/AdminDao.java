package AdminDao;

import entiy.Admin;

import java.util.List;

public interface AdminDao {
    void Adminadd(Admin admin);
    void Admindelete(Admin admin);
    void AdminUpdate(Admin admin);
    List<Admin>FindAll();
    Admin  findAdminByName(String name);
}
