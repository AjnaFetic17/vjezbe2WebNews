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
public class AddNews extends HttpServlet {

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
            out.println("<title>Servlet AddNews</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddNews at " + request.getContextPath() + "</h1>");
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
        String address = "";

        String title = request.getParameter("title");
        int type = Integer.parseInt(request.getParameter("typeID"));
        String content = request.getParameter("content");

        User user = (User) session.getAttribute("user");

        News news = new News(title, content);

        Connection con = null;
        Statement stmt = null;

        try {
            con = DB.getConnection();
            stmt = con.createStatement();
            
            String querryIn="insert into news (NewsTitle, NewsTypeID,"
                    + "Content) values ('"+title+"','"+type+"','"+content+"');";
            stmt.execute(querryIn);
            
            String querryNewsId="Select NewsID from "
                    + "news where NewsTitle = '"+title+"';";
            
            ResultSet rsNewsId= stmt.executeQuery(querryNewsId);
            Integer newsID=null;
            
            if(rsNewsId.next()){
               newsID = rsNewsId.getInt("NewsID");
            }
            
            String querryJoin = "insert into newseditor (UserID, NewsID)"
                    + "values ('"+user.getUserID()+"','"+ newsID+"');";
            
            stmt.execute(querryJoin);
            
            
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
