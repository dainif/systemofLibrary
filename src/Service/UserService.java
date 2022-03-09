package Service;

import entiy.User;

import java.util.List;

public interface UserService {
    int addUser(User u);
    int delete(User u);
     List<User>Findall();
   void brrow();
   void back();
   User findUserbyname(String name);
   int update(User user);

}
