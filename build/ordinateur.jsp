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
            <th>Action</th>

        </tr>
<%

        for (Ordinateur ordinateur : ordinateurList) {
%>
        <tr>
            <td><%= ordinateur.getId() %></td>  
            <td><%= ordinateur.getModelid() %></td>
            <td><%= ordinateur.getRam() %></td>
            <td><%= ordinateur.getProcesseur() %></td>
            <td><%= ordinateur.getDisque_dur() %></td>
            <td>
                <a href="${pageContext.request.contextPath}/?id=<%= ordinateur.getId() %>">Modifier</a>
                <a href="${pageContext.request.contextPath}/ordi?id=<%= ordinateur.getId() %>">Supprimer</a>

            </td>
        </tr>
<%
        }
%>
    </table>
<%
    } else {
        
    }
%>
    <p>Aucun ordinateur trouvé.</p> 
  
</body>
</html>