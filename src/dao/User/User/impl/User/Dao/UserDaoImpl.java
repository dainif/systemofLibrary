package dao.User.User.impl.User.Dao;

import dao.User.User.Dao;
import entiy.Book;
import entiy.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements Dao {
    private List<User> users = new ArrayList<>();
    @Override
    public void add(User user) {
        user.setId(users.size()+1);
        users.add(user);}

    @Override
    public User findUserbyname(String name) {
       for( User u :users){
           if (u.getName().equals(name)){
               return  u;
           }
       }
       return null;
    }

    @Override
    public void Update(User user) {
    for(User u:users){
        if(u.getName().equals(user.getName())) {
            u.setPassword(user.getPassword());
            u.setTel(user.getTel());
            break;
        }
    }
    }
    @Override
    public List<User> Findall() {
        List<User> list=new ArrayList();
        users.forEach(item ->{
            list.add(item);
        });
        return list;
    }

    @Override
    public void delete(User user) {
        users.remove(user.getId()-1);
    }
}
