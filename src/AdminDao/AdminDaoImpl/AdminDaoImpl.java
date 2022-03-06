package AdminDao.AdminDaoImpl;

import AdminDao.AdminDao;
import entiy.Admin;

import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    private List<Admin> admins = new ArrayList<>();
    @Override
    public void Adminadd(Admin admin) {
        admin.setId(admins.size()+1);
        admins.add(admin);
    }

    @Override
    public void Admindelete(Admin admin) {admins.remove(admin.getId()-1);}

    @Override
    public void AdminUpdate(Admin admin) {
        for (Admin a:admins){
            if(a.getName().equals(admin.getName())){
                a.setPassword(admin.getPassword());
                a.setTel(admin.getTel());
            }
        }
    }

    @Override
    public List<Admin> FindAll() {
     List<Admin>list = new ArrayList<>();
     admins.forEach(item->{
         list.add(item);
     });
     return list;
    }

    @Override
    public Admin findAdminByName(String name) {
       for (Admin admin:admins){
           if(admin.getName().equals(name)){
               return admin;
           }
       }
        return null;
    }

}
