
    import java.io.*;
    import java.util.List;

    import javax.servlet.*;
    import javax.servlet.http.*;
    import model.*;

    public class ShowFormOrdiServlet extends HttpServlet{
        protected void doGet(HttpServletRequest req, HttpServletResponse res)
                throws ServletException, IOException {
            res.setContentType("text/html");
            Ordinateur o = new Ordinateur();
            Modele modele = new Modele();

            try {
                List<Modele> modeleList = modele.getAll();
                req.setAttribute("Modeles", modeleList);    
                if (req.getParameter("id") != null) {
                    int id = Integer.parseInt(req.getParameter("id"));
                    req.setAttribute("id", id);
                    Ordinateur ordi = o.findById(id);
                    req.setAttribute("Ordinateur", ordi);
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/ind.jsp");
                dispatcher.forward(req, res);
                } else {
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/ind.jsp");
                    dispatcher.forward(req, res);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            }
        }
