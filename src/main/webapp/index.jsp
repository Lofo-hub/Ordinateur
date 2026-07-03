

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
        <option value="1">Modele 1</option>
        <option value="2">Modele 2</option>
        <option value="3">Modele 3</option>
    </select>
       ram =  <input type="text" name="ram">
       processeur =  <input type="text" name="processeur">
       disque_dur =  <input type="text" name="disque_dur">
       <input type="submit" value="Envoyer">
    </form>
</body>
</html>