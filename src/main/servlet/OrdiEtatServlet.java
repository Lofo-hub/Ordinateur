
import java.io.*;
import java.sql.Date;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import model.*;

public class OrdiEtatServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.setHeader("Access-Control-Allow-Origin", "*");

        String id = req.getParameter("id");
        String date = req.getParameter("date");
        String etat = req.getParameter("etat");
        String observation = req.getParameter("observation");

        Ordinateur ordinateur = new Ordinateur();

        try {
            if (id != null && !id.isEmpty() && date != null && !date.isEmpty() && etat != null) {

                int ordinateurId = Integer.parseInt(id);
                int etatId = Integer.parseInt(etat);

                Date dateValue = Date.valueOf(date);

                if (ordinateur.insererHistorique(ordinateurId, etatId, dateValue, observation)) {

                    res.getWriter().print(
                        "{\"success\":true,\"message\":\"Etat ajouté\"}"
                    );

                } else {

                    res.getWriter().print(
                        "{\"success\":false,\"message\":\"Erreur insertion\"}"
                    );

                }

            } else {

                res.getWriter().print(
                    "{\"success\":false,\"message\":\"Paramètres manquants\"}"
                );

            }

        } catch (Exception e) {

            e.printStackTrace();

            res.getWriter().print(
                "{\"success\":false,\"message\":\"Erreur serveur\"}"
            );
        }
    }
}