package AdminDao.AdminDaoImpl;

import AdminDao.AdminDao;
import Util.JDBCUtil;
import entiy.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    private List<Admin> admins = new ArrayList<>();
    @Override
    public int Adminadd(Admin admin) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int flag = 0;

        try {
            conn = JDBCUtil.getConnection();

           // Integer a_id = admin.getId();
            String a_name=admin.getName();
            String a_psd = admin.getPassword();
            Integer a_tel = admin.getTel();

            String sql = "insert into admin values(null , ?, ?, ? )";
            ps = conn.prepareStatement(sql);
            //ps.setInt(1,a_id);
            ps.setString(1,a_name);
            ps.setString(2, a_psd);
            ps.setInt(3,a_tel);

            //System.out.println("insertAdmin(Admin admin)" + sql);

            flag = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResource(conn, ps, rs);
            return flag  ;
        }
    }


    @Override
    public int Admindelete(Admin admin) {
        Connection con =null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        int flag=0;
        try {
            con = JDBCUtil.getConnection();
            String a_name = admin.getName();
            String sql = "delete from admin where a_name = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,a_name);
            flag = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeResource(con,ps,rs);
            return flag;
        }
    }

    @Override
    public int AdminUpdate(Admin admin) {
     Connection con =null;
     PreparedStatement ps =null;
     ResultSet rs =null;
     int flag=0;
     Admin a=null;
     try {
         con =JDBCUtil.getConnection();
         String psd =admin.getPassword();
         Integer tel = admin.getTel();
         String sql = "UPDATE admin set a_psd = ? , a_tel = ?  where a_name = ?";
         ps =con.prepareStatement(sql);
         ps.setString(1,psd);
         ps.setInt(2,tel);
         ps.setString(3,admin.getName());
         flag = ps.executeUpdate();

     } catch (Exception e) {
         e.printStackTrace();
     }finally {
         JDBCUtil.closeResource(con,ps,rs);
         return flag;
     }
    }

    @Override
    public List<Admin> FindAll() {
        List<Admin> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

            try {
                con = JDBCUtil.getConnection();
                String sql = "select * from admin";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Admin admin = new Admin();
                    admin.setId(rs.getInt("A_id"));
                    admin.setName(rs.getString("A_name"));
                    admin.setPassword(rs.getString("A_psd"));
                    admin.setTel(rs.getInt("A_tel"));
                    list.add(admin);
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
    public Admin findAdminByName(String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Admin admin1 = null;

        try {
            conn = JDBCUtil.getConnection();

            String a_name = name;

            String sql = "select * from admin where a_name = ?";

            ps = conn.prepareStatement(sql);
            //System.out.println("selectAdmin(Admin admin)" + sql);

            ps.setString(1, a_name);

            rs = ps.executeQuery();

            while (rs.next()) {
                admin1 = new Admin(name);
                admin1.setId(rs.getInt("A_ID"));
                admin1.setPassword(rs.getString("A_psd"));
                admin1.setTel(rs.getInt("A_tel"));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
                JDBCUtil.closeResource(conn, ps, rs);
                return admin1;
        }
    }

    @Override
    public Admin findAdminByNamewithpsd(Admin admin) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Admin admin1 = null;
        try {
            con = JDBCUtil.getConnection();
            String a_name = admin.getName();
            String a_psd = admin.getPassword();
            String sql = "Select * from admin where a_name= ? And a_psd = ? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, a_name);
            ps.setString(2, a_psd);

            rs = ps.executeQuery();
            while (rs.next()) {
                admin1 = new Admin(a_name, a_psd);
                admin1.setId(rs.getInt("a_id"));
                admin1.setTel(rs.getInt("a_tel"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResource(con,ps,rs);
            return admin1;
        }
    }
}
