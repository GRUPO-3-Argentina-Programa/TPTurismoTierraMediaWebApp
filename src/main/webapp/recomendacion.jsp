<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<jsp:include page="partials/encabezado.jsp"></jsp:include>
</head>

<body style="background-color: #0A0A0A">
	<jsp:include page="partials/nav.jsp"></jsp:include>

	<c:if test="${flash != null}">
		<div class="alert alert-danger">
			<p>
				<c:out value="${flash}" />
				<c:if test="${errors != null}">
					<ul>
						<c:forEach items="${errors}" var="entry">
							<li><c:out value="${entry.getValue()}"></c:out></li>
						</c:forEach>
					</ul>
				</c:if>
			</p>
		</div>
	</c:if>

	<section class="container mt-5 mb-5">
		<div class="row row-cols-1 row-cols-md-3 g-4">
			<c:forEach items="${recomendaciones}" var="recomendacion">
				<div class="col">
					<div class="card h-100 text-white bg-dark border-warning">
						<img src="assets/imagenes/${recomendacion.getNombre().replace(' ','')}.jpg"
							class="card-img-top contenedor-imagen2" alt="...">
						<div class="card-body">
							<h5 class="card-title">${recomendacion.getNombre()}</h5>
							<p class="card-text">This is a longer card with supporting
								text below as a natural lead-in to additional content. This
								content is a little bit longer.</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">Precio:
								${recomendacion.getCosto()} monedas</small>
						</div>
						<div class="card-footer">
							<small class="text-muted">Duración:
								${recomendacion.getTiempoTotal()} horas</small>
						</div>
						<div class="card-footer">
							<c:choose>
								<c:when
									test="${user.puedeComprar(recomendacion) && recomendacion.hayCupo() }">
									<a href="buy.do?id=${recomendacion.getId()}"
										class="btn-primary btn-success rounded" role="button">Comprar</a>
								</c:when>
								<c:otherwise>
									<a href="#" class="btn-secondary rounded disabled"
										role="button">No Disponible</a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
<footer class="conteiner-md text-dark text-center mt-5 border-dark">
	ARGENTINA PROGRAMA - Yo Programo 2021 - Grupo 3 - Curso 8</footer>
</html>