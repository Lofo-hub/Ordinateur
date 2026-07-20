<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="asset\styles.css">
    <title>Formulaire</title>
</head>
<script>
    fetch('http://localhost:8080/Ordinateur/ordi/liste')
        .then(response => response.json())
        .then(data => {
            const select = document.createElement('select');
            select.name = 'ordinateur';
            data.forEach(ordinateur => {
                const option = document.createElement('option');
                option.value = ordinateur.id;
                option.textContent = ordinateur.nom;
                select.appendChild(option);
            });
            document.querySelector('form div').appendChild(select);
        })
        .catch(error => console.error('Erreur lors de la récupération des ordinateurs:', error));
</script>

<body>
    <form action="traitement.php" method="post">
        <div></div>
    <input type="date" name="date" placeholder="Date">
    <input type="text" name="observation" placeholder="Observation">

    </form>
</body>

</html>