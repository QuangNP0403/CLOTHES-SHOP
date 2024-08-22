/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.OrderDetails;
import entity.Orders;
import entity.Products;
import entity.UserAccounts;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quang
 */
public class DAOOrderDetails extends DBConnect {

    private static final Logger logger = Logger.getLogger(DAOOrderDetails.class.getName());
    
    public int removeOrderDetail(int orderId) {
        int n = 0;
        String sql = "DELETE FROM OrderDetails WHERE order_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, orderId);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "SQL Exception while removing order detail", e);
        }
        return n;
    }

    public int addOrderDetail(OrderDetails orderDetail) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[OrderDetails]\n"
                + "           ([order_id]\n"
                + "           ,[product_id]\n"
                + "           ,[quantity]\n"
                + "           ,[unit_price]\n"
                + "           ,[Total]\n"
                + "           ,[status])\n"
                + "     VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, orderDetail.getOrder_id());
            pre.setInt(2, orderDetail.getProduct_id());
            pre.setInt(3, orderDetail.getQuantity());
            pre.setDouble(4, orderDetail.getUnit_price());
            pre.setDouble(5, orderDetail.getTotal());
            pre.setInt(6, orderDetail.getStatus());
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public Vector<OrderDetails> getAll(String sql) {
        Vector<OrderDetails> vector = new Vector<OrderDetails>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int order_id = rs.getInt(1);
                int product_id = rs.getInt(2);
                int quantity = rs.getInt(3);
                double unit_price = rs.getDouble(4);
                double total = rs.getDouble(5);
                int status = rs.getInt(6);
                OrderDetails od = new OrderDetails(order_id, product_id, quantity, unit_price, total, status);
                vector.add(od);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public int getPriceFromProduct(int pId) {
        String sql = "select Price\n"
                + "from [dbo].[Products] \n"
                + "where product_id = " + pId;
        try {
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                double unit_Price = rs.getDouble("Price");
                return (int) unit_Price;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public String removeProductFromCart(String txt, int pIdRemove) {
        StringBuilder updatedCart = new StringBuilder(); // Sử dụng StringBuilder để xây dựng giỏ hàng mới
        String[] items = txt.split("/");
        boolean removed = false; // Biến để đánh dấu xem sản phẩm đã được xóa hay chưa

        for (String item : items) {
            String[] parts = item.split(":");
            int productId = Integer.parseInt(parts[0]);
            int quantity = Integer.parseInt(parts[1]);

            // Kiểm tra xem sản phẩm có phải là sản phẩm cần xóa không
            if (productId == pIdRemove) {
                removed = true; // Đánh dấu sản phẩm đã được xóa
                continue; // Bỏ qua sản phẩm cần xóa
            }

            // Nếu sản phẩm không phải là sản phẩm cần xóa hoặc không hợp lệ, thêm vào giỏ hàng mới
            if (productId != 0 && quantity != 0) {
                updatedCart.append(productId).append(":").append(quantity).append("/");
            }
        }

        // Nếu sản phẩm đã được xóa và giỏ hàng không rỗng
        if (removed && updatedCart.length() > 0) {
            // Xóa dấu / cuối cùng nếu có
            updatedCart.deleteCharAt(updatedCart.length() - 1);
        }
        return updatedCart.toString();
    }

    public Vector<OrderDetails> addToCart(String txt) {
        Vector<OrderDetails> vector = new Vector<>();
        String[] a = txt.split("/");
        DAOOrderDetails dao = new DAOOrderDetails();
        for (String i : a) {
            String[] b = i.split(":");
            int productId = Integer.parseInt(b[0]);
            int quantity = Integer.parseInt(b[1]);

            if (productId == 0 || quantity == 0) {
                continue; // Bỏ qua dữ liệu không hợp lệ
            }

            // Nếu sản phẩm chưa tồn tại, thêm vào giỏ hàng
            double unitPrice = dao.getPriceFromProduct(productId);
            double total = unitPrice * quantity;
            OrderDetails od = new OrderDetails(1, productId, quantity, unitPrice, total, 1);
            vector.add(od);
        }
        return vector;
    }

    public boolean isProductExists(int productId) {
        boolean exists = false;
        String sql = "SELECT COUNT(*) FROM Products WHERE product_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                exists = (count > 0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exists;
    }

    public int addToDB(String txt, String username) {

        LocalDateTime currentDateTime = LocalDateTime.now();

        // Định dạng ngày giờ theo yêu cầu: "yyyy-MM-dd HH:mm:ss"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Chuyển đổi ngày giờ sang định dạng chuỗi
        String odderDate = currentDateTime.format(formatter);

        String[] a = txt.split("/");
        DAOOrderDetails daoOd = new DAOOrderDetails();
        DAOUserAccounts daoU = new DAOUserAccounts();
        DAOOrders daoO = new DAOOrders();

        UserAccounts u = daoU.getByUserName(username); // để lấy id người dùng bằng getByName

        int userID = u.getIsUser();

        daoO.addOrder(new Orders(1, userID, odderDate)); // tạo đơn hàng

        int orderId = daoO.getOrderIdMax();
        for (String i : a) {
            String[] b = i.split(":");
            int productId = Integer.parseInt(b[0]);
            int quantity = Integer.parseInt(b[1]);

            if (productId == 0 || quantity == 0) {
                continue; // Bỏ qua dữ liệu không hợp lệ
            }

            // Nếu sản phẩm chưa tồn tại, thêm vào giỏ hàng
            double unitPrice = daoOd.getPriceFromProduct(productId);
            double total = unitPrice * quantity;

            daoOd.addOrderDetail(new OrderDetails(orderId, productId, quantity, unitPrice, total, 1)); // tạo đơn hàng chi tiết từ oder

        }

        return 1;
    }

    public int updateOrderDetailsStatus(int orderId) {
        int n = 0;
        String sql = "UPDATE OrderDetails "
                + "SET [status] = 0 "
                + "FROM OrderDetails "
                + "WHERE order_id = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, orderId);
            n = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return n;
    }

    public static void main(String[] args) {
        //        String txt = "1:2/3:1/2:3/3:4"; // Mỗi mục trong danh sách là một sản phẩm, định dạng là: productId:quantity
        //        String username = "Adam"; // Tên người dùng
        //
        //        DAOOrderDetails daood = new DAOOrderDetails();
        //        int result = daood.addToDB(txt, username);
        //
        //        if (result == 1) {
        //            System.out.println("Đã thêm đơn hàng thành công.");
        //        } else {
        //            System.out.println("Có lỗi xảy ra khi thêm đơn hàng.");
        //        }

        DAOOrderDetails daood = new DAOOrderDetails();
        daood.getAll("select * from OrderDetails");
        System.out.println(daood.getAll("select * from OrderDetails"));
    }
}
