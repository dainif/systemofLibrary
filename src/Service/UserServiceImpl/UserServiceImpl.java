package Service.UserServiceImpl;

import Service.UserService;
import dao.User.User.Dao;
import dao.User.User.impl.User.Dao.UserDaoImpl;
import entiy.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    Dao userDao = new UserDaoImpl();
    @Override
    public boolean addUser(User u) {
        List<User> list = userDao.Findall();
     for (int i = 0; i<list.size(); i++){
         if(list.get(i).getName().equals(u.getName())){
             return  false;
         }
     }
     userDao.add(u);
     return true;
    }

    @Override
    public void delete(User u) {userDao.delete(u);}

    @Override
    public List<User>Findall() { return userDao.Findall();}

    @Override
    public void brrow() {

    }

    @Override
    public void back() {

    }

    @Override
    public User findUserbyname(String name) {
       return userDao.findUserbyname(name);
    }

    @Override
    public void update(User user) {
        userDao.Update(user);
    }
}
