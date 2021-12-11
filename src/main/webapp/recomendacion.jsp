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
	<section class="container mt-5 mb-5">
		<div class="row row-cols-1 row-cols-md-3 g-4">
			<c:forEach items="${recomendaciones}" var="recomendacion">
				<div class="col">
					<div class="card h-100 text-white bg-dark border-warning">
						<img src="assets/imagenes/${recomendacion.getNombre()}.jpg"
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
							<small class="text-muted">Precio: ${recomendacion.getCosto()}
								monedas</small>
						</div>
						<div class="card-footer">
							<small class="text-muted">Duración:
								${recomendacion.getTiempoTotal()} horas</small>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>