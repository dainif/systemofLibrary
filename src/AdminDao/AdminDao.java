package AdminDao;

import entiy.Admin;

import java.util.List;

public interface AdminDao {
    int Adminadd(Admin admin);
    int Admindelete(Admin admin);
    int AdminUpdate(Admin admin);
    List<Admin>FindAll();
    Admin  findAdminByName(String name);
    Admin  findAdminByNamewithpsd(Admin admin);
}
