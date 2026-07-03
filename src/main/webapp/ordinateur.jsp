<%@ page import="model.Ordinateur" %>
<%@ page import="java.util.List" %>

<% 
    List<Ordinateur> ordinateurList = (List<Ordinateur>) request.getAttribute("Ordinateur");
%>



<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Liste ordinateur</title>
</head>
<body>
    <h1>Liste des ordinateurs</h1>
<% 
    if (ordinateurList != null && !ordinateurList.isEmpty()) {
%>
    <table border="1">
        <tr>
            <th>ID</th> 
            <th>Modèle</th>
            <th>RAM</th>
            <th>Processeur</th>
            <th>Disque Dur</th>
        </tr>
<%

        for (Ordinateur ordinateur : ordinateurList) {
%>
        <tr>
            <td><%= ordinateur.getId() %></td>  
            <td><%= ordinateur.getModele() %></td>
            <td><%= ordinateur.getRam() %></td>
            <td><%= ordinateur.getProcesseur() %></td>
            <td><%= ordinateur.getDisqueDur() %></td>
        </tr>
<%
        }
%>
    </table>
<%
    } else {
%>
    <p>Aucun ordinateur trouvé.</p> 
  
</body>
</html>