package Service;

import entiy.User;

import java.util.List;

public interface UserService {
    boolean addUser(User u);
    void  delete(User u);
     List<User>Findall();
   void brrow();
   void back();
   User findUserbyname(String name);
   void  update(User user);

}
