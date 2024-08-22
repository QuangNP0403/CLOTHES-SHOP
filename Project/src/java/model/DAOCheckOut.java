/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.CheckOut;
import entity.Products;
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
public class DAOCheckOut extends DBConnect {

    public Vector<CheckOut> getAllByCheckOut(String sql, int userId) {
        Vector<CheckOut> vector = new Vector<CheckOut>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId); // Đặt tham số userId vào câu lệnh SQL

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String usernameUa = rs.getString(1);
                String addressUa = rs.getString(2);
                int phoneUa = rs.getInt(3);
                String productNameP = rs.getString(4);
                int productid = rs.getInt(5);
                double priceP = rs.getDouble(6);
                String imgP = rs.getString(7);
                int status = rs.getInt(8);
                String oderDateO = rs.getString(9);
                int orderid = rs.getInt(10);
                int quantityOd = rs.getInt(11);
                double unitPriceOd = rs.getDouble(12);
                double totalOd = rs.getDouble(13);
                CheckOut checkOut = new CheckOut(usernameUa, addressUa, phoneUa, productNameP, productid, imgP, status, priceP, oderDateO, orderid, quantityOd, unitPriceOd, totalOd);
                vector.add(checkOut);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

}
