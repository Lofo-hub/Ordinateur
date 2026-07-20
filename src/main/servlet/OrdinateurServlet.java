
import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.google.gson.Gson;

import model.*;

public class OrdinateurServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Ordinateur o = new Ordinateur();
        try {
            List<Ordinateur> ordinateurList = o.findall();
            if (req.getServletPath().equals("/ordi/liste")) {
            Gson gson = new Gson();
            String json = gson.toJson(ordinateurList);
            res.setContentType("application/json");
            res.setCharacterEncoding("UTF-8");
            res.setHeader("Access-Control-Allow-Origin", "*");
            res.getWriter().write(json);
            return;
        }
        
        res.setContentType("text/html");
        String id = req.getParameter("id");
        if (id != null && !id.isEmpty()) {
            if (req.getSession().getAttribute("user") == null) {
                res.sendRedirect(req.getContextPath() + "/login.jsp");
                return;
            }
            int ordinateurId = Integer.parseInt(id);
            try {
                o.delete(ordinateurId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        req.setAttribute("Ordinateur", ordinateurList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/ordinateur.jsp");
        dispatcher.forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        int idmodele = Integer.parseInt(req.getParameter("idmodele"));
        String ram = req.getParameter("ram");
        String processeur = req.getParameter("processeur");
        int disque_dur = Integer.parseInt(req.getParameter("disque_dur"));
        
        try {
             if (req.getSession().getAttribute("user") == null) {
                res.sendRedirect(req.getContextPath() + "/login.jsp");
                return;
            }
            Ordinateur o = new Ordinateur();
            o.setModelid(idmodele);
            o.setRam(Integer.parseInt(ram));
            o.setProcesseur(processeur);
            o.setDisque_dur(disque_dur);
            if (id != 0) {
                o.setId(id);
                o.update(o);
            } else {
                o.insert(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        res.sendRedirect(req.getContextPath() + "/ordi");

    }

}
