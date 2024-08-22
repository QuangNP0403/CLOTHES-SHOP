/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Categories;
import entity.Products;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quang
 */
public class DAOCategories extends DBConnect {

    // insert
    public int insertCategories(Categories cate) {
        int n = 0;
        try {
            String sql = "INSERT INTO [dbo].[Categories]\n"
                    + "           ([category_id]\n"
                    + "           ,[category_name])\n"
                    + "     VALUES "
                    + "(?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, cate.getCategory_id());
            preparedStatement.setString(2, cate.getCategory_name());
            n = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Categories> getAllCate(String sql) {
        Vector<Categories> vector = new Vector<Categories>();
        try {
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int category_id = rs.getInt(1);
                String category_name = rs.getString(2);
                Categories cate = new Categories(category_id, category_name);
                vector.add(cate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public int removeCategory(int categoryId) {
        int n = 0;
        String sql = "DELETE FROM Categories WHERE category_id = " + categoryId + " AND (category_id NOT IN (SELECT DISTINCT category_id FROM Products))";
        try {
            Statement st = conn.createStatement();
            n = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateCategory(Categories cate) {
        int n = 0;
        String sql = "UPDATE Categories SET category_name = ? WHERE category_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cate.getCategory_name());
            ps.setInt(2, cate.getCategory_id());
            n = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Categories getByCID(int cid) {
        Categories category = null;
        String sql = "SELECT * FROM Categories WHERE category_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Khởi tạo một đối tượng Products với dữ liệu từ ResultSet
                category = new Categories();
                category.setCategory_id(rs.getInt("category_id"));
                category.setCategory_name(rs.getString("category_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return category;
    }

    public static void main(String[] args) {
//        DAOCategories dao = new DAOCategories();
//            
//            // Viết câu SQL để lấy tất cả các danh mục
//            String sql = "SELECT * FROM categories";
//            
//            // Gọi phương thức getAllCate để lấy tất cả các danh mục và lưu vào một Vector
//            Vector<Categories> categories = dao.getAllCate(sql);
//            
//            // In ra các danh mục được lấy được
//            for (Categories category : categories) {
//                System.out.println( category);
//            }
//        DAOCategories dao = new DAOCategories();
//
//        // Gọi phương thức getByCID để lấy thông tin về một danh mục dựa trên category_id
//        Categories category = dao.getByCID(2);
//
//        // In thông tin về danh mục được lấy được
//        if (category != null) {
//            System.out.println("Category ID: " + category.getCategory_id());
//            System.out.println("Category Name: " + category.getCategory_name());
//        } else {
//            System.out.println("Category not found!");
//        }
//
//        Categories newCategory = new Categories(4, "New Category");
//        DAOCategories dao = new DAOCategories();
//        int rowsAffected = dao.insertCategories(newCategory);
//        if (rowsAffected > 0) {
//            System.out.println("Category inserted successfully.");
//        } else {
//            System.out.println("Failed to insert category.");
//        }
//
//        DAOCategories dao = new DAOCategories(); // Truyền kết nối vào DAO
//
//        // Thử xóa một danh mục với categoryId là 1 (ví dụ)
//        int deletedRows = dao.removeCategory(4);
//
//        if (deletedRows > 0) {
//            System.out.println("Xóa thành công " + deletedRows + " danh mục.");
//        } else {
//            System.out.println("Không có danh mục nào được xóa.");
//        }
    }
}
