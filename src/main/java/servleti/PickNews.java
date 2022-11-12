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
public class PickNews extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PickNews</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PickNews at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        ArrayList<News> news = new ArrayList();

        Connection con = null;
        Statement stmt = null;
        Statement stmt1 = null;

        String query = "select * from news as n join newstype as nt on "
                + "n.NewsTypeID=nt.NewsTypeID";

        String address = "";
        try {
            con = DB.getConnection();
            stmt = con.createStatement();
            stmt1 = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String title = rs.getString("NewsTitle");
                String content = rs.getString("Content");
                String type = rs.getString("Type");
                String date = rs.getString("CreationDate");
                int id = rs.getInt("NewsID");

                News temp = new News(id, title, content, date, type);

                String users = "select * from user as u join newseditor as e on "
                        + "u.UserID = e.UserID where e.NewsID = " + id;

                ResultSet rs2 = stmt1.executeQuery(users);

                if (rs2.next()) {
                    String username = rs2.getString("Username");
                    int userId = rs2.getInt("UserID");

                    User u = new User(userId, username);
                    temp.setUser(u);
                }
                news.add(temp);
            }

            session.setAttribute("news", news);
            address = "newsListComment.jsp";

            stmt1.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            session.invalidate();
            request.setAttribute("errormsg", ex.getMessage());
            address = "error.jsp";
        } catch (Exception ex) {
            session.invalidate();
            request.setAttribute("errormsg", ex.getMessage());
            address = "error.jsp";
        }
        request.getRequestDispatcher(address).forward(request, response);
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
