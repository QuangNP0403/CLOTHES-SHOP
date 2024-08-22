/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.CheckOut;
import entity.UserAccounts;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Vector;
import model.DAOCheckOut;
import model.DAOOrderDetails;

/**
 *
 * @author Quang
 */
@WebServlet(name = "StatusCart", urlPatterns = {"/statuscart"})
public class StatusCartController extends HttpServlet {

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

        DAOOrderDetails daood = new DAOOrderDetails();
        DAOCheckOut daoCheckOut = new DAOCheckOut();
        HttpSession session = request.getSession();

        UserAccounts ua = (UserAccounts) session.getAttribute("acc");
        
        if (ua != null) {
            String sqlQuery = "SELECT "
                    + "    UserAccounts.username,"
                    + "    UserAccounts.address,"
                    + "    UserAccounts.phone,"
                    + "    Products.product_name,"
                    + "    Products.product_id,"
                    + "    Products.price,"
                    + "    Products.img,"
                    + "    OrderDetails.status,"
                    + "    Orders.order_date,"
                    + "    Orders.order_id,"
                    + "    OrderDetails.quantity,"
                    + "    OrderDetails.unit_price,"
                    + "    OrderDetails.Total "
                    + "FROM "
                    + "    UserAccounts "
                    + "INNER JOIN "
                    + "    Orders ON UserAccounts.user_id = Orders.user_id "
                    + "INNER JOIN "
                    + "    OrderDetails ON Orders.order_id = OrderDetails.order_id "
                    + "INNER JOIN "
                    + "    Products ON OrderDetails.product_id = Products.product_id "
                    + "WHERE "
                    + "    Orders.order_date = (SELECT MAX(order_date) FROM Orders WHERE user_id = ?)"; // Lấy thông tin sản phẩm theo userID và thời gian mới nhất

            Vector<CheckOut> vectorCO = daoCheckOut.getAllByCheckOut(sqlQuery, ua.getUser_id());
            double totalOrderValue = 0.0;
            // Calculate total value for each order
            for (CheckOut checkout : vectorCO) {
                double totalValue = checkout.getQuantity() * checkout.getUnit_price();
                checkout.setTotal(totalValue);
                totalOrderValue += totalValue;
            }
            // Set total order value as an attribute in the request
            request.setAttribute("totalOrderValue", totalOrderValue);
            request.setAttribute("vectorCO", vectorCO);
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
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
