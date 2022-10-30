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
public class Registration extends HttpServlet {

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
            out.println("<title>Servlet Registration</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registration at " + request.getContextPath() + "</h1>");
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
           
        User user = new User();

        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        Integer roleID =3;
        String status = "1";

        String address = "index.jsp";
        
        user.setUsername(username);
        user.setPassword(pass);
        user.setRoleID(roleID);
        user.setEmail(email);
        user.setStatus(status);

        HttpSession sesija = request.getSession();
        
        sesija.setAttribute("role", roleID);
        sesija.setAttribute("user", user);
        String upitI = "insert into user(Username, Password, Email, Status, RoleID) values('" 
                + username + "','" + pass + "','" + email + "', '" + status + "','" + roleID + "');";
        
        Connection con = null;
        Statement stmt = null;

        try {
            con = DB.getConnection();
            stmt = con.createStatement();
            String upit="Select * from user where Username='"+username+"';";
            ResultSet rsP=stmt.executeQuery(upit);
            if(rsP.next()){
                String poruka = "This username is already in use, please use another one.";
                request.setAttribute("poruka", poruka);
                address = "registration.jsp";
            }else{
            stmt.executeUpdate(upitI);
            String upit1="Select UserID from user where email='"+email+"';";
            ResultSet rs=stmt.executeQuery(upit1);
            if(rs.next()){
            user.setUserID(rs.getInt("UserID"));
            }
            request.setAttribute("poruka", "Your registration has been successful " + username + ". ");
            }
            
            stmt.close();
            con.close();
        } catch (SQLException e) {
            sesija.invalidate();
            String err = e.getMessage();
            request.setAttribute("errormsg", err);
            address = "error.jsp";
        } catch (Exception e) {
            sesija.invalidate();
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
