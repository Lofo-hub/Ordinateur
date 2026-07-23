<%@ page import="java.util.List" %>
<%@ page import="model.Modele" %>
<%@ page import="model.Ordinateur" %>

 
 <% List<Modele> modeles = (List<Modele>) request.getAttribute("Modeles"); %>
 <% Modele modele = (Modele) request.getAttribute("Modele"); %>
   <% Ordinateur ordinateur = (Ordinateur) request.getAttribute("Ordinateur"); %>


<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Formulaire</title>
</head>
<body>
    <h1> ETU4071<h1>
    <form action="${pageContext.request.contextPath}/ordi" method="post">
    <input type="hidden" name="id" value="<%= ordinateur != null ? ordinateur.getId() : 0 %>">
    <label for="idmodele">Modele :</label>
    <% if (modeles != null) { %>
        <select name="idmodele" id="idmodele">
            <%  for (Modele m : modeles) { %>
                <% if (ordinateur != null) { %>
                    <option value="<%= m.getId() %>" <%= ordinateur.getModelid() == m.getId() ? "selected" : "" %> > <%= m.getLibelle() %> </option>
                <% } else { %>
                    <option value="<%= m.getId() %>"><%= m.getLibelle() %></option>
                <% } %>
            <% } %>
        </select>
    <% } %>


       ram =  <input type="text" name="ram"  value = "<%= ordinateur != null ? ordinateur.getRam() : "" %>">
       processeur =  <input type="text" name="processeur" value = "<%= ordinateur != null ? ordinateur.getProcesseur() : "" %>">
       disque_dur =  <input type="text" name="disque_dur" placeholder = " <%= ordinateur != null ? ordinateur.getDisque_dur() : "" %>">
       <input type="submit" value="<%= ordinateur != null ? "Modifier" : "Ajouter" %>">
    </form>
</body>
</html>