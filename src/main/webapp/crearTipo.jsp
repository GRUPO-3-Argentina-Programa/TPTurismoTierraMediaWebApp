<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/encabezado.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<main class="container">

		<c:if test="${tipo != null}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al crear el tipo.</p>
			</div>
		</c:if>

		<form action="crearTipo.adm" method="post">
			<jsp:include page="TipoForm.jsp"></jsp:include>
		</form>
	</main>
</body>
</html>