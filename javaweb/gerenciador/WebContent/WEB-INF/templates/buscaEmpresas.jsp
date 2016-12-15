<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Busca Empresas</title>
</head>
<body>
	Resultados da Busca:
	<ul>
	<c:forEach var="empresa" items="${empresas}">
		<li>${empresa.id} ${empresa.nome}</li>
	</c:forEach>
	</ul>
</body>
</html>