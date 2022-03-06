package dao.User.User;

import entiy.User;

import java.util.List;

public interface Dao {
     void add(User user);
     User findUserbyname(String name);
     void  Update(User user);
     List<User> Findall();
     void  delete(User user);
}
