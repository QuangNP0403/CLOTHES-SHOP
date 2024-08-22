/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.OrderDetails;
import entity.Products;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quang
 */
public class DAOCart extends DBConnect{

    public Vector<OrderDetails> getCart(String txt) {
        Vector<OrderDetails> vector = new Vector<OrderDetails>();
        String[] a = txt.split("/");
        DAOProducts dao = new DAOProducts();
        double total = 0;
        for (String i : a) {
            String[] b = i.split(":");
            int productId = Integer.parseInt(b[0]);
            int quantity = Integer.parseInt(b[1]);
            int unitPrice = dao.getPriceFromProduct(productId);
            total += unitPrice * quantity;
            OrderDetails od = new OrderDetails(1, productId, quantity, unitPrice, total, 1);
            vector.add(od);
        }
        return vector;
    }

}
