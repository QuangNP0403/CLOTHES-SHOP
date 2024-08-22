/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Products;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quang
 */
public class DAOProducts extends DBConnect {

    public int insertProduct(Products pro) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Products] "
                + "([product_id], [product_name], [img], [description], [price], [stock_quantity], [category_id]) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            // Đặt các tham số cho câu lệnh PreparedStatement
            ps.setInt(1, pro.getProduct_id());
            ps.setString(2, pro.getProduct_name());
            ps.setString(3, pro.getImg());
            ps.setString(4, pro.getDescription());
            ps.setDouble(5, pro.getPrice());
            ps.setInt(6, pro.getStock_quantity());
            ps.setInt(7, pro.getCategory_id());

            // Thực hiện câu lệnh SQL
            n = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Products> getAll(String sql) {
        Vector<Products> vector = new Vector<Products>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int product_id = rs.getInt(1);
                int category_id = rs.getInt(7);
                String product_name = rs.getString(2);
                String img = rs.getString(3);
                String description = rs.getString(4);
                Double price = rs.getDouble(5);
                int stoc_quantity = rs.getInt(6);
                Products products = new Products(product_id, product_name, img, description, price, stoc_quantity, category_id);
                vector.add(products);
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
        } catch (SQLException ex) {
            Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public Vector<Products> getProductsByPrice(String txtSearch, String txtSearch2) {
        Vector<Products> vector = new Vector<Products>();
        String sql = "SELECT * FROM Products WHERE price BETWEEN ? AND ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txtSearch);
            ps.setString(2, txtSearch2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Products product = new Products();
                product.setProduct_id(rs.getInt(1));
                product.setProduct_name(rs.getString(2));
                product.setImg(rs.getString(3));
                product.setDescription(rs.getString(4));
                product.setPrice(rs.getDouble(5));
                product.setStock_quantity(rs.getInt(6));
                vector.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Vector<Products> getProductsByCID(int cid) {
        Vector<Products> vector = new Vector<Products>();
        String sql = "SELECT * FROM Products WHERE category_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cid); // Thiết lập giá trị tham số cho câu lệnh SQL
            ResultSet rs = ps.executeQuery(); // Thực thi câu lệnh SQL và nhận kết quả
            while (rs.next()) {
                // Đọc dữ liệu từ ResultSet và tạo đối tượng Products
                Products product = new Products();
                product.setProduct_id(rs.getInt(1));
                product.setProduct_name(rs.getString(2));
                product.setImg(rs.getString(3));
                product.setDescription(rs.getString(4));
                product.setPrice(rs.getDouble(5));
                product.setStock_quantity(rs.getInt(6));
                // Thêm sản phẩm vào Vector
                vector.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Products getByPID(int pid) {
        Products product = null;
        String sql = "SELECT * FROM Products WHERE product_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Khởi tạo một đối tượng Products với dữ liệu từ ResultSet
                product = new Products();
                product.setProduct_id(rs.getInt("product_id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setImg(rs.getString("img"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setStock_quantity(rs.getInt("stock_quantity"));
                product.setCategory_id(rs.getInt("category_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }

    public int removeProduct(int productId) {
        int n = 0;
        String sql = "DELETE FROM Products WHERE product_id = " + productId
                + " AND (" + productId + " NOT IN (SELECT DISTINCT product_id FROM OrderDetails))";
        try {
            Statement st = conn.createStatement();
            n = st.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return n;
    }

    public Vector<Products> getProductsByName(String txtSearch) {
        Vector<Products> vector = new Vector<Products>();
        String sql = "SELECT * FROM Products WHERE [product_name] like ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + txtSearch + "%"); // Thiết lập giá trị tham số cho câu lệnh SQL
            ResultSet rs = ps.executeQuery(); // Thực thi câu lệnh SQL và nhận kết quả
            while (rs.next()) {
                // Đọc dữ liệu từ ResultSet và tạo đối tượng Products
                Products product = new Products();
                product.setProduct_id(rs.getInt(1));
                product.setProduct_name(rs.getString(2));
                product.setImg(rs.getString(3));
                product.setDescription(rs.getString(4));
                product.setPrice(rs.getDouble(5));
                product.setStock_quantity(rs.getInt(6));

                // Thêm sản phẩm vào Vector
                vector.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public int updateProduct(Products pro) {
        int n = 0;
        String sql = "UPDATE Products "
                + "SET product_name = ?, "
                + "    img = ?, "
                + "    description = ?, "
                + "    price = ?, "
                + "    stock_quantity = ?, "
                + "    category_id = ? "
                + "WHERE product_id = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, pro.getProduct_name());
            pre.setString(2, pro.getImg());
            pre.setString(3, pro.getDescription());
            pre.setDouble(4, pro.getPrice());
            pre.setInt(5, pro.getStock_quantity());
            pre.setInt(6, pro.getCategory_id());
            pre.setInt(7, pro.getProduct_id());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    private static final Logger logger = Logger.getLogger(DAOProducts.class.getName());
    
    public static void main(String[] args) {
        DAOProducts dao = new DAOProducts();

        // Thực hiện truy vấn để lấy danh sách sản phẩm với mức giá nằm trong khoảng từ 1000 đến 2000
        String txtSearch = "300";
        String txtSearch2 = "500";
        Vector<Products> products = dao.getProductsByPrice(txtSearch, txtSearch2);

        // Hiển thị thông tin sản phẩm trong Vector
        if (products != null) {
            logger.log(Level.INFO, "Danh sách sản phẩm có mức giá từ {0} đến {1}:", new Object[]{txtSearch, txtSearch2});
            for (Products product : products) {
                logger.log(Level.INFO, "ID: {0}", product.getProduct_id());
                logger.log(Level.INFO, "Tên sản phẩm: {0}", product.getProduct_name());
                logger.log(Level.INFO, "Ảnh: {0}", product.getImg());
                logger.log(Level.INFO, "Mô tả: {0}", product.getDescription());
                logger.log(Level.INFO, "Giá: {0}", product.getPrice());
                logger.log(Level.INFO, "Số lượng tồn kho: {0}", product.getStock_quantity());
                logger.log(Level.INFO, "");
            }
        } else {
            logger.log(Level.INFO, "Không có sản phẩm nào trong khoảng giá từ {0} đến {1}", new Object[]{txtSearch, txtSearch2});
        }
    }

}
