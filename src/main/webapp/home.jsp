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

	<div id=dobleboton class="container px-4 mt=3">
		<div class="row gx-5">
			<div class="col">
				<div id="dobleboton1" class="p-5 shadow mb-5 bg-body rounded ">Atracciones</div>
			</div>
			<div class="col">
				<div class="p-5 shadow mb-5 bg-body rounded" id="dobleboton2">Promociones</div>
			</div>
		</div>
	</div>

	<section class="row container-fluid">


		<section class="container mt-5 mb-5">

			<!-- Promociones-->
			<h3 id="promociones" class="text-center bg-warning mt-4 mb-4">PROMOCIONES</h3>
			<div class="row row-cols-1 row-cols-md-3 g-5 responsive">
				<div class="col">
					<div class="card h-100">
						<div id="carouselExampleSlidesOnly" class="carousel slide"
							data-bs-ride="carousel">
							<div class="carousel-inner">
								<div class="carousel-item active">
									<img src="assets/imagenes/Bosque_Negro2.jpg"
										class="d-block contenedor-imagen2" alt="...">
								</div>
								<div class="carousel-item">
									<img src="assets/imagenes/Mordor2.jpg"
										class="d-block contenedor-imagen2" alt="...">
								</div>
							</div>
						</div>
						<div class="card-body">
							<h5 class="card-title">Promo Aventura</h5>
							<p class="card-text">Ésta es una promoción porcentual.</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">Precio: 22 monedas</small>
						</div>
						<div class="card-footer">
							<small class="text-muted">Duración: 7 horas</small>
						</div>
						<div class="card-footer">
							<button type="button" class="btn btn-primary"
								data-bs-toggle="modal" data-bs-target="#PromoAventura">
								Descripción</button>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card h-100">
						<div id="carouselExampleSlidesOnly" class="carousel slide"
							data-bs-ride="carousel">
							<div class="carousel-inner">
								<div class="carousel-item active">
									<img src="assets/imagenes/Lothlorien.jpg"
										class="d-block contenedor-imagen2" alt="...">
								</div>
								<div class="carousel-item">
									<img src="assets/imagenes/La Comarca.jpg"
										class="d-block contenedor-imagen2" alt="...">
								</div>
							</div>
						</div>
						<div class="card-body">
							<h5 class="card-title">Promo Degustación</h5>
							<p class="card-text">Ésta es una promoción absoluta.</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">Precio: 36 monedas</small>
						</div>
						<div class="card-footer">
							<small class="text-muted">Duración: 7.5 horas</small>
						</div>
						<div class="card-footer">
							<button type="button" class="btn btn-primary"
								data-bs-toggle="modal" data-bs-target="#PromoDegustacion">
								Descripción</button>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card h-100">
						<div id="carouselExampleSlidesOnly" class="carousel slide"
							data-bs-ride="carousel">
							<div class="carousel-inner">
								<div class="carousel-item active">
									<img src="assets/imagenes/Minas Tirith.jpeg"
										class="d-block contenedor-imagen2" alt="...">
								</div>
								<div class="carousel-item">
									<img src="assets/imagenes/Abismo_Helm2.jpg"
										class="d-block contenedor-imagen2" alt="...">
								</div>
								<div class="carousel-item">
									<img src="assets/imagenes/Erebor.jpg"
										class="d-block contenedor-imagen2" alt="...">
								</div>
							</div>
						</div>
						<div class="card-body">
							<h5 class="card-title">Promo Paisaje</h5>
							<p class="card-text">Ésta es una promoción AxB.</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">Precio: 10 monedas</small>
						</div>
						<div class="card-footer">
							<small class="text-muted">Duración: 7.5 horas</small>
						</div>
						<div class="card-footer">
							<button type="button" class="btn btn-primary"
								data-bs-toggle="modal" data-bs-target="#PromoPaisaje">
								Descripción</button>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card h-100">
						<div id="carouselExampleSlidesOnly" class="carousel slide"
							data-bs-ride="carousel">
							<div class="carousel-inner">
								<div class="carousel-item active">
									<img src="assets/imagenes/Carreta Fantasma.jpeg"
										class="d-block contenedor-imagen2" alt="...">
								</div>
								<div class="carousel-item">
									<img src="assets/imagenes/Bosque Tenebroso.jpg"
										class="d-block contenedor-imagen2" alt="...">
								</div>
							</div>
						</div>
						<div class="card-body">
							<h5 class="card-title">Promo Terror</h5>
							<p class="card-text">Ésta es una promoción absoluta.</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">Precio: 10 monedas</small>
						</div>
						<div class="card-footer">
							<small class="text-muted">Duración: 8.5 horas</small>
						</div>
						<div class="card-footer">
							<button type="button" class="btn btn-primary"
								data-bs-toggle="modal" data-bs-target="#PromoTerror">
								Descripción</button>
						</div>
					</div>
				</div>
			</div>

			<!-- Atracciones-->
			<h3 id="atracciones" class="text-center bg-warning mt-4 mb-4">ATRACCIONES</h3>
			<div class="row row-cols-1 row-cols-md-4 g-5">
				<c:forEach items="${atracciones}" var="atraccion">
					<div class="col">
						<div class="card h-100">
							<img src="assets/imagenes/${atraccion.getNombre()}.jpg"
								class="card-img-top contenedor-imagen2" alt="...">
							<div class="card-body">
								<h5 class="card-title">${atraccion.getNombre()}</h5>
								<p class="card-text">${atraccion.getDescripcion()}</p>
							</div>
							<div class="card-footer">
								<button type="button" class="btn btn-primary"
									data-bs-toggle="modal"
									data-bs-target="#${atraccion.getNombre()}">
									Descripción</button>
							</div>
							<c:if test="${!atraccion.hayCupo() }">
								<div class="card-footer">
									<div class="alert alert-danger">
										<small class="text-muted">SIN CUPO</small>
									</div>
								</div>
							</c:if>
						</div>
					</div>
				</c:forEach>
			</div>
		</section>
	</section>


	<!--  Modal ATRACCIONES -->
	<c:forEach items="${atracciones}" var="atraccion">
		<div class="modal fade" id="${atraccion.getNombre()}" tabindex="-1"
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
							<img src="assets/imagenes/${atraccion.getNombre()}.jpg"
								class="card-img-top contenedor-imagen2" alt="...">
						</div>
						<p>${atraccion.getDescripcion()}</p>
						<p>Categoría: ${atraccion.getTipoAtraccion()}</p>
						<p>Cupo disponible: ${atraccion.getCupo()}</p>
						<p>Duración: ${atraccion.getTiempo()}</p>
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

	<footer class="conteiner-md text-dark text-center mt-5 border-dark">
		ARGENTINA PROGRAMA - Yo Programo 2021 - Grupo 3 </footer>
</body>
</html><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>