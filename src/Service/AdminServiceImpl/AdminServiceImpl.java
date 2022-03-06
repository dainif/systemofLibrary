package Service.AdminServiceImpl;

import AdminDao.AdminDao;
import AdminDao.AdminDaoImpl.AdminDaoImpl;
import Service.AdminService;
import entiy.Admin;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();
    @Override
    public boolean add(Admin admin) {
        List<Admin> list = adminDao.FindAll();
        for (int i=0; i<list.size();i++){
            if(list.get(i).getName().equals(admin.getName())){
                return false;
            }
        }
        adminDao.Adminadd(admin);
        return true;
    }

    @Override
    public void AdminUpdate(Admin admin) {
    adminDao.AdminUpdate(admin);
    }

    @Override
    public void Admindelete(Admin admin) {

    }

    @Override
    public List<Admin> FindAll() {
       return adminDao.FindAll();
    }

    @Override
    public Admin findAdminByName(String name) {
        return adminDao.findAdminByName(name);
    }
}
