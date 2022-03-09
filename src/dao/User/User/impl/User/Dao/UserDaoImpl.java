package dao.User.User.impl.User.Dao;

import Util.JDBCUtil;
import dao.User.User.Dao;
import entiy.Admin;
import entiy.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements Dao {
    private List<User> users = new ArrayList<>();
    Connection con = null;
    PreparedStatement ps =null;
    ResultSet rs = null;
    int flag = 0;
    User user1=new User();
    @Override
    public int add(User user) {

        try {
            con = JDBCUtil.getConnection();

            // Integer a_id = admin.getId();
            String u_name=user.getName();
            String u_psd = user.getPassword();
            Integer u_tel = user.getTel();

            String sql = "insert into user values(null , ?, ?, ? )";
            ps = con.prepareStatement(sql);
            //ps.setInt(1,a_id);
            ps.setString(1,u_name);
            ps.setString(2, u_psd);
            ps.setInt(3,u_tel);

            //System.out.println("insertAdmin(Admin admin)" + sql);

            flag = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResource(con, ps, rs);
            return flag  ;
        }}

    @Override
    public User findUserbyname(String name) {
        try {
            con = JDBCUtil.getConnection();

            String u_name = name;

            String sql = "select * from user where u_Name = ?";

            ps = con.prepareStatement(sql);
            //System.out.println("selectAdmin(Admin admin)" + sql);

            ps.setString(1,u_name);

            rs = ps.executeQuery();

            while (rs.next()) {
                user1 = new User(name);
                user1.setId(rs.getInt("u_ID"));
                user1.setPassword(rs.getString("u_PSWD"));
                user1.setTel(rs.getInt("u_tel"));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResource(con, ps, rs);
            return user1;
        }
    }

    @Override
    public int Update(User user) {
        Admin a=null;
        try {
            con =JDBCUtil.getConnection();
            String psd =user.getPassword();
            Integer tel = user.getTel();
            String sql = "UPDATE user set u_PSWD = ? , u_tel = ?  where u_Name = ?";
            ps =con.prepareStatement(sql);
            ps.setString(1,psd);
            ps.setInt(2,tel);
            ps.setString(3,user.getName());
            flag = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeResource(con,ps,rs);
            return flag;
        }
    }
    @Override
    public List<User> Findall() {
        List<User> list=new ArrayList();
        try {
            con = JDBCUtil.getConnection();
            String sql = "select * from user";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user=new User();
                user.setId(rs.getInt("u_ID"));
                user.setName(rs.getString("u_Name"));
                user.setPassword(rs.getString("u_PSWD"));
                user.setTel(rs.getInt("u_tel"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.closeResource(con, ps, rs);
            return list;
        }
    }

    @Override
    public int delete(User user) {
        try {
            con = JDBCUtil.getConnection();
            String u_name = user.getName();
            String sql = "delete from user where u_Name = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,u_name);
            flag = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeResource(con,ps,rs);
            return flag;
        }
    }
}
