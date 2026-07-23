<%@ page import="model.Historique" %>
<%@ page import="model.Etat" %>
<%@ page import="java.util.List" %>

<% 
    List<Historique> historiqueList = (List<Historique>) request.getAttribute("Historiques");
    List<Historique> historiquetype = (List<Historique>) request.getAttribute("type");
    Etat en = new Etat();
    List<Etat> etat = en.findall();


%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Liste historique</title>
</head>
<body>
    <h1>ETU4071</h1>
    <h1>Liste des Historique</h1>

<% 
    if (historiqueList != null && !historiqueList.isEmpty()) {
%>
    <table border="1">
        <tr>
            <th>Etat</th> 
            <th>Nombre</th>
        </tr>
<% for (Historique historique : historiqueList) { %>
        <tr>
        <% if (historique.getId_etat() == 1 ) { %>
            <td> Fonctionnel </td>  
          <% } else { %>
            <td> Disfonctionnel </td>  
            <% } %>
            <td> <%= historique.getCounts() %></td>

        </tr>
<%
        }
%>
    </table>
<%
    } else {
        
    }
%>

<% 
    if (etat != null && !etat.isEmpty()) {
%>
    <table border="1">
        <tr>
<% for (Etat e : etat) { %> 
<th> <%= e.getType() %></th> 
<% } %>
        </tr>
        <tr>
            <td></td> 
            <td></td>
        </tr>
    </table>
<%
    } else {
        
    }
%>
    <p>Aucun ordinateur trouvé.</p> 
  
</body>
</html>