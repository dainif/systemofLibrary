package dao.User.User;

import entiy.User;

import java.util.List;

public interface Dao {
     int add(User user);
     User findUserbyname(String name);
     int Update(User user);
     List<User> Findall();
     int delete(User user);
}
