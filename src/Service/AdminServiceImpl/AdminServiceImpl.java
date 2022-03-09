package Service.AdminServiceImpl;

import AdminDao.AdminDao;
import AdminDao.AdminDaoImpl.AdminDaoImpl;
import Service.AdminService;
import entiy.Admin;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();
    @Override
    public int add(Admin admin) {
       return adminDao.Adminadd(admin);
    }

    @Override
    public int AdminUpdate(Admin admin) {
    return adminDao.AdminUpdate(admin);
    }

    @Override
    public int Admindelete(Admin admin) {return adminDao.Admindelete(admin);

    }

    @Override
    public List<Admin> FindAll() {
       return adminDao.FindAll();
    }

    @Override
    public Admin findAdminByName(String name) {
        return adminDao.findAdminByName(name);
    }

    @Override
    public Admin findAdminByNamewithpsd(Admin admin) {
        return adminDao.findAdminByNamewithpsd(admin);
    }
}
