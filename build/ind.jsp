<%@ page import="java.util.List" %>
<%@ page import="model.Modele" %>
 
 <% List<Modele> modeles = (List<Modele>) request.getAttribute("Modele"); %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Formulaire</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/ordi" method="post">
    <label for="idmodele">Modele :</label>
    <select name="idmodele" id="idmodele">
    <% for (Modele m : modeles) { %>
        <option value="<%= m.getId() %>"><%= m.getLibelle() %></option>
         <% } %>
    </select>
       ram =  <input type="text" name="ram">
       processeur =  <input type="text" name="processeur">
       disque_dur =  <input type="text" name="disque_dur">
       <input type="submit" value="Envoyer">
    </form>
</body>
</html>