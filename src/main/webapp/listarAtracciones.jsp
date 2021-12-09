<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Atracci&oacute;n</th>
					<th>Costo</th>
					<th>Duraci&oacute;n</th>
					<th>Cupo</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${atracciones}" var="atraccion">
					<tr>
						<td><strong><c:out value="${atraccion.nombre}"></c:out></strong></td>
						<td><c:out value="${atraccion.getCosto()}"></c:out></td>
						<td><c:out value="${atraccion.getTiempoTotal()}"></c:out></td>
						<td><c:out value="${atraccion.getCupo()}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>
