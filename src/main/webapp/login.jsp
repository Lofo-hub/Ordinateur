
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/log" method="post">
    <input type="text" name="login" value="Nom" >
    <input type="password" name="password" value="Password" >
       <input type="submit" value="SE CONNECTER" %>">
    </form>
</body>
</html>