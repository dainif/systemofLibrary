package Service.UserServiceImpl;

import Service.UserService;
import dao.User.User.Dao;
import dao.User.User.impl.User.Dao.UserDaoImpl;
import entiy.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    Dao userDao = new UserDaoImpl();
    @Override
    public int addUser(User u) {
     return userDao.add(u);
    }

    @Override
    public int delete(User u) {return userDao.delete(u);}

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
    public int update(User user) {
        return userDao.Update(user);
    }
}
