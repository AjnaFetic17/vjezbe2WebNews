/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servleti;

import beans.News;
import beans.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.DB;

/**
 *
 * @author Blandus
 */
public class ShowNewsList extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowNewsList</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShowNewsList at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        doPost(request, response);
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

               HttpSession session = request.getSession();

        ArrayList<News> news = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        Statement stmt2 = null;

        String address = "";
        String upit = "SELECT n.NewsID, n.NewsTitle, n.Content, n.PublicationDate, "
                + "t.Type FROM news as n join newstype as t on n.NewsTypeID=t.NewsTypeID  where Deleted='0';";
        ResultSet rs = null;
        try {
            con = DB.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery(upit);
            while (rs.next()) {
                News temp = new News();
                ArrayList<User> users = new ArrayList<>();
                int id = rs.getInt("NewsID");
                temp.setNewsID(rs.getInt("NewsID"));
                temp.setNewsTitle(rs.getString("NewsTitle"));
                temp.setContent(rs.getString("Content"));
                temp.setPublicationDate(rs.getString("PublicationDate"));
                temp.setNewsType(rs.getString("Type"));

               
                news.add(temp);

            }
            session.setAttribute("news", news);

            address = "showNewsList.jsp";
            stmt.close();
            con.close();
        } catch (SQLException e) {
            session.invalidate();
            String err = e.getMessage();
            request.setAttribute("errormsg", err);
            address = "error.jsp";

        }

        RequestDispatcher rd = request.getRequestDispatcher(address);
        rd.forward(request, response);
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
