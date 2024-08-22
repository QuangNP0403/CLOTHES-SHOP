/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Orders;
import entity.UserAccounts;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quang
 */
public class DAOOrders extends DBConnect {

    public int addOrder(Orders order) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Orders]\n"
                + "           ([user_id]\n"
                + "           ,[order_date])\n"
                + "     VALUES\n"
                + "           (?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, order.getUser_id());
            pre.setString(2, order.getOrder_date());
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public int updateOrder(Orders order) {
        int n = 0;
        String sql = "UPDATE [dbo].[Orders]\n"
                + "   SET \n"
                + "      [user_id] = ?\n"
                + "      ,[order_date] = ?\n"
                + " WHERE order_id=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, order.getUser_id());
            pre.setString(2, order.getOrder_date());
            pre.setInt(4, order.getOrder_id());
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public Vector<Orders> getAll(String sql) {
        Vector<Orders> vector = new Vector<Orders>();
        try {
            Statement state = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int orderId = rs.getInt(1);
                int userId = rs.getInt(2);
                String order_Date = rs.getString(3);
                boolean status = rs.getBoolean(4);
                Orders order = new Orders(orderId, userId, order_Date);
                vector.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public int getOrderIdMax() {
        String sql = "SELECT MAX(order_id) as order_id  FROM Orders";
        int orderId = 0;
        try {
            Statement state = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            if (rs.next()) {
                orderId = rs.getInt("order_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderId;
    }

}
