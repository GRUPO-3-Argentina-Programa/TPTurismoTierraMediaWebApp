<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="es">

<head>
<jsp:include page="partials/encabezado.jsp"></jsp:include>
</head>

<body style="background-color: #0A0A0A">
	<jsp:include page="partials/nav.jsp"></jsp:include>

	<div class="container-fluid pb-4">
		<div id="carouselExampleControls" class="carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-inner">

				<div class="carousel-item active">
					<img src="assets/imagenes/paisaje centrada.png"
						class="d-block flex contenedor-imagen" alt="1°preferencia">
				</div>
				<div class="carousel-item contenedor-imagen">
					<img src="assets/imagenes/terror centrada.png"
						class="d-block flex contenedor-imagen" alt="2° preferencia">
				</div>

				<div class="carousel-item contenedor-imagen">
					<img src="assets\imagenes\aventura centrada.png"
						class="d-block flex contenedor-imagen" alt="3 preferencia">
				</div>

				<div class="carousel-item contenedor-imagen">
					<img src="assets\imagenes\degustación centrada.png"
						class="d-block contenedor-imagen" alt="4 preferencia">
				</div>
			</div>

			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleControls" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleControls" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
	</div>

	<div class="overflow">
		<section class="row container-fluid">
			<section class="container mt-5 mb-5">

				<!-- Promociones-->
				<h3 id="promociones" class="text-center bg-warning mt-4 mb-4">PROMOCIONES</h3>

				<div class="row row-cols-1 row-cols-md-3 g-5 responsive">
					<c:forEach items="${promociones}" var="promocion">
						<div class="col">
							<div class="card h-100 text-white bg-dark border-warning">
								<img src="assets/imagenes/${promocion.getNombre().replace(' ','')}.jpg"
									class="card-img-top contenedor-imagen2" alt="...">
								<div class="card-body">
									<h5 class="card-title">${promocion.getNombre()}</h5>
								</div>
								<div class="card-footer">
									<button type="button" class="btn btn-primary"
										data-bs-toggle="modal"
										data-bs-target="#${promocion.getNombre().replace(' ','')}">
										Descripción</button>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</section>
		</section>
	</div>

	<div class="overflow">
		<section class="row container-fluid">
			<section class="container mt-5 mb-5">
				<!-- Atracciones-->
				<h3 id="atracciones" class="text-center bg-warning mt-4 mb-4">ATRACCIONES</h3>
				<div class="row row-cols-1 row-cols-md-4 g-5">

					<c:forEach items="${atracciones}" var="atraccion">
						<div class="col">
							<div class="card h-100 text-white bg-dark border-warning">
								<img src="assets/imagenes/${atraccion.getNombre().replace(' ','')}.jpg"
									class="card-img-top contenedor-imagen2" alt="...">
								<div class="card-body">
									<h5 class="card-title">${atraccion.getNombre()}</h5>
									<%-- 								<p class="card-text">${atraccion.getDescripcion()}</p> --%>
								</div>
								<div class="card-footer">
									<button type="button" class="btn btn-primary"
										data-bs-toggle="modal"
										data-bs-target="#${atraccion.getNombre().replace(' ','')}">
										Descripción</button>
								</div>

							</div>
						</div>
					</c:forEach>
				</div>
			</section>
		</section>
	</div>


	<!--  Modal PROMOCIONES -->
	<c:forEach items="${promociones}" var="promocion">
		<div class="modal fade" id="${promocion.getNombre().replace(' ','')}" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">${promocion.getNombre()}</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<div class="container mb-3">
							<img src="assets/imagenes/${promocion.getNombre().replace(' ','')}.jpg"
								class="card-img-top contenedor-imagen2" alt="...">
						</div>
						<p>
							<c:if test="${!atraccion.hayCupo() }">
								<div class="alert alert-danger">
									<small class="text-muted">SIN CUPO</small>
								</div>
							</c:if>
						</p>
						<%-- 						<p>${atraccion.getDescripcion()}</p> --%>
						<p>Duración: ${promocion.getTiempoTotal()}</p>
						<p>Costo: ${promocion.getCosto()}</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Cerrar</button>
						<a href="buy.do?id=${recomendacion.getId()}"
							class="btn btn-success rounded" role="button">Comprar</a>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>

	<!--  Modal ATRACCIONES -->
	<c:forEach items="${atracciones}" var="atraccion">
		<div class="modal fade" id="${atraccion.getNombre().replace(' ','')}" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">${atraccion.getNombre()}</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<div class="container mb-3">
							<img src="assets/imagenes/${atraccion.getNombre().replace(' ','')}.jpg"
								class="card-img-top contenedor-imagen2" alt="...">
						</div>
						<%-- 						<p>${atraccion.getDescripcion()}</p> --%>
						<p>Categoría: ${atraccion.getTipoAtraccion()}</p>
						<p>
							<c:if test="${!atraccion.hayCupo() }">
								<div class="alert alert-danger">
									<small class="text-muted">SIN CUPO</small>
								</div>
							</c:if>
							<c:if test="${atraccion.hayCupo()}"> Cupo disponible: ${atraccion.getCupo()}</c:if>
						</p>

						<p>Duración: ${atraccion.getTiempoTotal()}</p>
						<p>Costo: ${atraccion.getCosto()}</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Cerrar</button>
						<a href="buy.do?id=${recomendacion.getId()}"
							class="btn btn-success rounded" role="button">Comprar</a>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</body>
<footer class="conteiner-md text-dark text-center mt-5 border-dark">
	ARGENTINA PROGRAMA - Yo Programo 2021 - Grupo 3 - Curso 8</footer>
</html>
