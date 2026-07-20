
import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import model.*;

public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
    
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, res);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Utilisateur utilisateur = new Utilisateur();
        try {
            Utilisateur user = utilisateur.checkLogin(login, password);
            if (user != null) {
                req.getSession().setAttribute("user", user);
                res.sendRedirect(req.getContextPath() + "/ordi");
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
                dispatcher.forward(req, res);
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect(req.getContextPath() + "/error.jsp");
        }
    }


}
