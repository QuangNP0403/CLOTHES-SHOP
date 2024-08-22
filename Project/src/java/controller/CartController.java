/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.OrderDetails;
import entity.ProductCart;
import entity.Products;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Vector;
import model.DAOOrderDetails;
import model.DAOProducts;

/**
 *
 * @author Quang
 */
@WebServlet(name = "CartController", urlPatterns = {"/cart"})
public class CartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int productId = 0;
        int quantity = 0;
        try {
            productId = Integer.parseInt(request.getParameter("pid"));
            quantity = Integer.parseInt(request.getParameter("quantity"));
        } catch (Exception e) {
            productId = 0;
            quantity = 0;
        }

        // Xử lý Cookie
        Cookie[] cookies = request.getCookies();
        String txt = "";

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart")) {
                    txt = cookie.getValue();
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    break;
                }
            }
        }

        // Cập nhật giỏ hàng
        StringBuilder updatedCart = new StringBuilder();
        boolean productExists = false;
        if (!txt.isEmpty()) {
            String[] items = txt.split("/");
            for (String item : items) {
                String[] parts = item.split(":");
                int existingProductId = Integer.parseInt(parts[0]);
                if (existingProductId == productId) {
                    int existingQuantity = Integer.parseInt(parts[1]);
                    existingQuantity += quantity;
                    item = existingProductId + ":" + existingQuantity;
                    productExists = true;
                }
                updatedCart.append(item).append("/");
            }
        }

        if (!productExists) {
            updatedCart.append(productId).append(":").append(quantity).append("/");
        }

        // Loại bỏ dấu / cuối cùng nếu có
        if (updatedCart.length() > 0 && updatedCart.charAt(updatedCart.length() - 1) == '/') {
            updatedCart.deleteCharAt(updatedCart.length() - 1);
        }

        // Tạo cookie mới
        Cookie newCookie = new Cookie("cart", updatedCart.toString());
        newCookie.setMaxAge(60 * 60 * 24); // set thời gian sống 1 days
        response.addCookie(newCookie);

        // Lấy dữ liệu sản phẩm từ cơ sở dữ liệu
        DAOProducts daoProducts = new DAOProducts();
        Vector<Products> productsVector = new Vector<>();

        DAOOrderDetails daoOrderDetails = new DAOOrderDetails();
        Vector<OrderDetails> orderDetailsVector = daoOrderDetails.addToCart(updatedCart.toString());

        for (OrderDetails orderDetails : orderDetailsVector) {
            Products product = daoProducts.getByPID(orderDetails.getProduct_id());
            productsVector.add(product);
        }

        // Tính tổng giá trị giỏ hàng
        double total = 0;
        for (OrderDetails orderDetails : orderDetailsVector) {
            total += orderDetails.getTotal();
        }
        
        // Tính tổng số lượng đơn hàng
        int totalProducts = 0;
        for (OrderDetails orderDetails : orderDetailsVector) {
            totalProducts += orderDetails.getQuantity();
        }

        // Cập nhật số lượng sản phẩm
        int totalPid = 0;
        for (OrderDetails orderDetails : orderDetailsVector) {
            if (orderDetails.getProduct_id() == productId) {
                orderDetails.setQuantity(totalPid += orderDetails.getQuantity());
                break;
            }
        }
        
        // Gửi dữ liệu đến JSP
        request.setAttribute("vector", orderDetailsVector);
        request.setAttribute("vectorP", productsVector);
        request.setAttribute("total", total);
        request.setAttribute("totalProducts", totalProducts);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
