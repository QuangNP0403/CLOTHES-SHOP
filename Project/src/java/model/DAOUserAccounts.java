/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.UserAccounts;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quang
 */
public class DAOUserAccounts extends DBConnect {

    public UserAccounts checkAccountExist(String user) {
        String sql = "SELECT * FROM UserAccounts WHERE [user] = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUserAccounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public UserAccounts loginAccounts(String user, String pass) {
        String sql = "select * from UserAccounts\n"
                + "WHERE [username] = ?\n"
                + "and password = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new UserAccounts(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUserAccounts.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Tạo 2 option để đăng kí 1 option đăng kí dịch vụ 
    // 1 option đăng kí người bán và quản trị viên
    
    public void signup(String user, String pass, String address, int phone) {
        String sql = "insert into UserAccounts\n"
                + "values(?,?,?,?,0,0)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, address);
            ps.setInt(4, phone);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUserAccounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertAccount(UserAccounts user) {
        String sql = "insert into UserAccounts\n"
                + "values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getAddress());
            ps.setInt(4, user.getPhone());
            ps.setInt(5, user.getIsUser());
            ps.setInt(6, user.getIsAdmin());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUserAccounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int updateUserAccounts(UserAccounts pro) {
        int n = 0;
        String sql = "UPDATE UserAccounts "
                + "SET username = ?, "
                + "    address = ?, "
                + "    phone = ?, "
                + "    isUser = ?, "
                + "    isAdmin = ?, "
                + "WHERE user_id = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, pro.getUsername());
            pre.setString(2, pro.getPassword());
            pre.setString(3, pro.getAddress());
            pre.setDouble(4, pro.getPhone());
            pre.setInt(5, pro.getIsUser());
            pre.setInt(6, pro.getIsAdmin());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<UserAccounts> getAll(String sql) {
        Vector<UserAccounts> vector = new Vector<UserAccounts>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int user_id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String address = rs.getString(4);
                int phone = rs.getInt(5);
                int isUser = rs.getInt(6);
                int isAdmin = rs.getInt(7);
                UserAccounts ua = new UserAccounts(user_id, username, password, address, phone, isUser, isAdmin);
                vector.add(ua);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUserAccounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public UserAccounts getByUserName(String uname) {
        String sql = "SELECT * FROM UserAccounts WHERE username = '" + uname + "'";
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int user_id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String address = rs.getString(4);
                int phone = rs.getInt(5);
                int isUser = rs.getInt(6);
                int isAdmin = rs.getInt(7);
                UserAccounts ua = new UserAccounts(user_id, username, password, address, phone, isUser, isAdmin);
                return ua;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUserAccounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public UserAccounts getByAccID(int uID) {
        String sql = "select * from UserAccounts where user_id = " + uID;
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int user_id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String address = rs.getString(4);
                int phone = rs.getInt(5);
                int isUser = rs.getInt(6);
                int isAdmin = rs.getInt(7);
                UserAccounts ua = new UserAccounts(user_id, username, password, address, phone, isUser, isAdmin);
                return ua;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUserAccounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int removeUser(int uID) {
        int n = 0;
        String sql = "DELETE FROM UserAccounts WHERE user_id = " + uID
                + " AND (" + uID + " NOT IN (SELECT DISTINCT user_id FROM Orders))";
        try {
            Statement st = conn.createStatement();
            n = st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

//    public UserAccounts checkUserEqualsStatment(String uName, String uPass) {
//        String sql = "select * from UserAccounts where 1=1 AND username= '" + uName + "' AND password= '" + uPass + "'";
//        try {
//            Statement state = conn.createStatement(
//                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            ResultSet rs = state.executeQuery(sql);
//            if (rs.next()) {
//                int user_id = rs.getInt(1);
//                String username = rs.getString(2);
//                String password = rs.getString(3);
//                String address = rs.getString(4);
//                int phone = rs.getInt(5);
//                int isUser = rs.getInt(6);
//                int isAdmin = rs.getInt(7);
//                UserAccounts ua = new UserAccounts(user_id, username, password, address, phone, isUser, isAdmin);
//                return ua;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOUserAccounts.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
    
}