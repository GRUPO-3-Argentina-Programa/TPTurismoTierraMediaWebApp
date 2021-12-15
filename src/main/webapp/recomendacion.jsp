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
						<img
							src="assets/imagenes/${recomendacion.getNombre().replace(' ','')}.jpg"
							class="card-img-top contenedor-imagen2" alt="...">
						<div class="card-body">
							<h5 class="card-title">${recomendacion.getNombre()}</h5>
						</div>
						<div class="card-footer">
							<button type="button" class="btn btn-primary"
								data-bs-toggle="modal"
								data-bs-target="#${recomendacion.getNombre().replace(' ','')}">
								Descripción</button>
						</div>
					</div>
				</div>

				<div class="modal fade"
					id="${recomendacion.getNombre().replace(' ','')}" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered">
						<div class="modal-content text-white bg-dark">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">${recomendacion.getNombre()}</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<div class="container mb-3">
									<img
										src="assets/imagenes/${recomendacion.getNombre().replace(' ','')}.jpg"
										class="card-img-top contenedor-imagen2" alt="...">
								</div>
								<p>
									<c:if test="${!recomendacion.hayCupo() }">
										<div class="alert alert-danger">
											<small class="text-muted">SIN CUPO</small>
										</div>
									</c:if>
								</p>
								<p>${recomendacion.getDescripcion()}</p>
								<p>Duración: ${recomendacion.getTiempoTotal()}</p>
								<p>Costo: ${recomendacion.getCosto()}</p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Cerrar</button>
								<c:choose>
									<c:when test="${recomendacion.esPromo()}">
										<a href="comprarPromo.do?id=${recomendacion.getId()}"
											class="btn btn-success rounded" role="button">Comprar</a>
									</c:when>
									<c:otherwise>
										<a href="buy.do?id=${recomendacion.getId()}"
											class="btn btn-success rounded" role="button">Comprar</a>
									</c:otherwise>
								</c:choose>

							</div>
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