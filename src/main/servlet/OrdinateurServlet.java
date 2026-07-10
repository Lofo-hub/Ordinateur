
import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import model.*;

public class OrdinateurServlet extends HttpServlet{
     protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        Ordinateur o = new Ordinateur();
        try {
            List<Ordinateur> ordinateurList = o.findall();
            req.setAttribute("Ordinateur", ordinateurList );
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/ordinateur.jsp");
        dispatcher.forward(req, res);
        }
        
        protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        int idmodele = Integer.parseInt(req.getParameter("idmodele"));
        String ram = req.getParameter("ram");
        String processeur = req.getParameter("processeur");
        int disque_dur = Integer.parseInt(req.getParameter("disque_dur"));
        
        try {
        Ordinateur o = new Ordinateur();
        o.setModelid(idmodele);
        o.setRam(Integer.parseInt(ram));
        o.setProcesseur(processeur);   
        o.setDisque_dur(disque_dur); 
        o.insert(o);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    res.sendRedirect(req.getContextPath() + "/ordi");
        
    }
}
    
    