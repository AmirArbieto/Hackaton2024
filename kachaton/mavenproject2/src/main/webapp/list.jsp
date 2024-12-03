<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Prendas</title>
</head>
<body>
    <h1>Lista de Prendas</h1>
    
    <c:if test="${not empty clothes}">
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Marca</th>
                    <th>Tipo</th>
                    <th>Tamaño</th>
                    <th>Género</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="clothe" items="${clothes}">
                    <tr>
                        <td>${clothe.clotheId}</td>
                        <td>${clothe.brand}</td>
                        <td>${clothe.type}</td>
                        <td>${clothe.size}</td>
                        <td>${clothe.gender}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    
    <c:if test="${empty clothes}">
        <p>No hay prendas registradas.</p>
    </c:if>
</body>
</html>
