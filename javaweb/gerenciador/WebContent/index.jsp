<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<c:if test="${empty usuarioLogado}">
		Bem vindo ao nosso gerenciador de empresas!<br/>
	</c:if>
	<c:if test="${not empty usuarioLogado}">
		Bem vindo ${usuarioLogado.email}<br/>
	</c:if>
<form action="controller" method="post">
	<input type="hidden" name="class" value="AdicionaEmpresa"/>
    Nome: <input type="text" name="nome" /><br />
    <input type="submit" value="Enviar" />
</form>

<form action="controller" method="post">
	<input type="hidden" name="class" value="Login"/>
    Email: <input type="email" name="email" /><br />
    Senha: <input type="password" name="senha" /><br />
    <input type="submit" value="Enviar" />
</form>

<form action="controller" method="post">
	<input type="hidden" name="class" value="BuscaEmpresa"/>
    Listar: <input type="submit" value="Buscar" />
</form>

<form action="controller" method="post">
	<input type="hidden" name="class" value="Logout"/>
    <input type="submit" value="Logout" />
</form>
</body>
</html>