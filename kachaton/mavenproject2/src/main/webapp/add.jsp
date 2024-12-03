<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrar Prenda</title>
</head>
<body>
    <h1>Registrar una Nueva Prenda</h1>

    <form action="clothes" method="post">
        <label for="brand">Marca:</label>
        <input type="text" name="brand" id="brand" required><br><br>

        <label for="type">Tipo:</label>
        <input type="text" name="type" id="type" required><br><br>

        <label for="size">Tamaño:</label>
        <input type="text" name="size" id="size" required><br><br>

        <label for="gender">Género:</label>
        <input type="text" name="gender" id="gender" required><br><br>

        <input type="submit" value="Registrar">
    </form>

</body>
</html>
