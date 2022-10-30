/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servleti;

import beans.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class Login extends HttpServlet {

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
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        String forw = "";
        HttpSession sesija = request.getSession();
        User u = new User();
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        String poruka;
        if (email.isEmpty() || pass.isEmpty()) {
            poruka = "Niste popunili sva polja";
            request.setAttribute("poruka", poruka);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }

        Connection con = null;
        Statement stmt = null;
        String address = "";
        String upit = "SELECT * FROM user WHERE Email = '" + email
                + "' AND password = '" + pass + "' AND Status = '1';";

        try {
            con = DB.getConnection();
            stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(upit);

            if (resultSet.next()) {
                String username = resultSet.getString("Username");
                int userid = resultSet.getInt("UserID");
                int role = resultSet.getInt("RoleID");
                String status = resultSet.getString("Status");

                u.setEmail(email);
                u.setPassword(pass);
                u.setRoleID(role);
                u.setUserID(userid);
                u.setStatus(status);
                u.setUsername(username);

                stmt.close();

                sesija.setAttribute("user", u);

                // sesija.setAttribute("user", u);
                switch (u.getRoleID()) {
                    case 3:
                        forw = "user.jsp";
                        break;
                    case 2:
                        forw = "editor.jsp";
                        break;
                    case 1:
                        forw = "admin.jsp";
                        break;
                    default:
                        break;
                }
            } else {
                poruka = "This profile does not exist, or you entered the wrong data";
                request.setAttribute("poruka", poruka);
                forw = "index.jsp";
                stmt.close();
            }

            stmt.close();
            con.close();
        } catch (SQLException e) {
            sesija.invalidate();
            String err = e.getMessage();
            request.setAttribute("errormsg", err);
            address = "error";
        } catch (Exception e) {
            sesija.invalidate();
            String err = e.getMessage();
            request.setAttribute("errormsg", err);
            address = "error";
        }
        RequestDispatcher rd = request.getRequestDispatcher(forw);
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
