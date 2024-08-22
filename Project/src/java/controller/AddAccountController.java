/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Products;
import entity.UserAccounts;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAOProducts;
import model.DAOUserAccounts;

/**
 *
 * @author Quang
 */
@WebServlet(name = "AddAccountController", urlPatterns = {"/addaccount"})
public class AddAccountController extends HttpServlet {

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
        request.getRequestDispatcher("AddAccount.jsp").forward(request, response);
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
        int txtUserID = Integer.parseInt(request.getParameter("txtUserid"));
        String txtUsername = request.getParameter("txtUsername");
        String txtPassword = request.getParameter("txtPassword");
        String txtAddress = request.getParameter("txtAddress");
        int txtPhone = Integer.parseInt(request.getParameter("txtPhone"));
        int txtUser =Integer.parseInt(request.getParameter("txtUser"));
        int txtAdmin = Integer.parseInt(request.getParameter("txtAdmin"));
        
        DAOUserAccounts dao = new DAOUserAccounts();
        UserAccounts user = dao.getByAccID(txtUserID);

        if (user == null) {
            UserAccounts us = new UserAccounts(txtUserID, txtUsername, txtPassword, txtAddress, txtPhone, txtUser, txtAdmin);
            dao.insertAccount(us);
            response.sendRedirect("account");
        } else {
            request.setAttribute("note", txtUserID + " đã tồn tại");
            request.getRequestDispatcher("AddAccount.jsp").forward(request, response);
        }
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
