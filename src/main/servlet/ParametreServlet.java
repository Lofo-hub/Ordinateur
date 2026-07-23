
import java.io.*;
import java.sql.Date;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import model.*;

public class ParametreServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        Historique o = new Historique();
        String date = req.getParameter("date");
         if (req.getSession().getAttribute("user") == null) {
                res.sendRedirect(req.getContextPath() + "/login.jsp");
                return;
            }

    
        try {
            if (date != null && !date.isEmpty()) {
                List<Historique> HistoriqueList = o.getCount(date);
                List<Historique> Historiquetype = o.getTypecount(date);

                req.setAttribute("Historiques", HistoriqueList);
                req.setAttribute("type", Historiquetype);

                RequestDispatcher dispatcher = req.getRequestDispatcher("/nombre.jsp");
                dispatcher.forward(req, res);
                } else {
                     res.getWriter().print(
                        "{\"success\":false,\"message\":\"Erreur date\"}"
                    );
                }
             
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
