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

				<div class="col">
					<div class="card h-100">
						<img src="assets/imagenes/Moria2.jpg"
							class="card-img-top contenedor-imagen2" alt="...">
						<div class="card-body">
							<h5 class="card-title">Moria</h5>
							<p class="card-text">This is a longer card with supporting
								text below as a natural lead-in to additional content. This
								content is a little bit longer.</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">Precio: 10 monedas</small>
						</div>
						<div class="card-footer">
							<small class="text-muted">Duración: 2 horas</small>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card h-100">
						<img src="assets/imagenes/La Comarca.jpg"
							class="card-img-top contenedor-imagen2" alt="...">
						<div class="card-body">
							<h5 class="card-title">La Comarca</h5>
							<p class="card-text">This is a longer card with supporting
								text below as a natural lead-in to additional content. This
								content is a little bit longer.</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">Precio: 3 monedas</small>
						</div>
						<div class="card-footer">
							<small class="text-muted">Duración: 6.5 horas</small>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card h-100">
						<img src="assets/imagenes/Lothlorien.jpg"
							class="card-img-top contenedor-imagen2" alt="...">
						<div class="card-body">
							<h5 class="card-title">Lothlorien</h5>
							<p class="card-text">This is a longer card with supporting
								text below as a natural lead-in to additional content. This
								content is a little bit longer.</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">Precio: 35 monedas</small>
						</div>
						<div class="card-footer">
							<small class="text-muted">Duración: 1 horas</small>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card h-100">
						<img src="assets/imagenes/Erebor.jpg"
							class="card-img-top contenedor-imagen2" alt="...">
						<div class="card-body">
							<h5 class="card-title">Erebor</h5>
							<p class="card-text">This is a longer card with supporting
								text below as a natural lead-in to additional content. This
								content is a little bit longer.</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">Precio: 12 monedas</small>
						</div>
						<div class="card-footer">
							<small class="text-muted">Duración: 3 horas</small>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card h-100">
						<img src="assets/imagenes/Minas_Tirith2.png"
							class="card-img-top contenedor-imagen2" alt="...">
						<div class="card-body">
							<h5 class="card-title">Minas Tirith</h5>
							<p class="card-text">This is a short card.</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">Precio: 5 monedas</small>
						</div>
						<div class="card-footer">
							<small class="text-muted">Duración: 2.5 horas</small>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card h-100">
						<img src="assets/imagenes/Mordor2.jpg"
							class="card-img-top contenedor-imagen2" alt="...">
						<div class="card-body">
							<h5 class="card-title">Mordor</h5>
							<p class="card-text">This is a longer card with supporting
								text below as a natural lead-in to additional content.</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">Precio: 25 monedas</small>
						</div>
						<div class="card-footer">
							<small class="text-muted">Duración: 3 horas</small>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card h-100">
						<img src="assets/imagenes/Abismo_Helm2.jpg"
							class="card-img-top contenedor-imagen2" alt="...">
						<div class="card-body">
							<h5 class="card-title">Abismo de Helm</h5>
							<p class="card-text">This is a longer card with supporting
								text below as a natural lead-in to additional content. This
								content is a little bit longer.</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">Precio: 5 monedas</small>
						</div>
						<div class="card-footer">
							<small class="text-muted">Duración: 2 horas</small>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card h-100">
						<img src="assets/imagenes/Bosque Negro.jpeg"
							class="card-img-top contenedor-imagen2" alt="...">
						<div class="card-body">
							<h5 class="card-title">Bosque Negro</h5>
							<p class="card-text">This is a longer card with supporting
								text below as a natural lead-in to additional content. This
								content is a little bit longer.</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">Precio: 3 monedas</small>
						</div>
						<div class="card-footer">
							<small class="text-muted">Duración: 4 horas</small>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card h-100">
						<img src="assets/imagenes/castillo-embrujado-.jpg"
							class="card-img-top contenedor-imagen2" alt="...">
						<div class="card-body">
							<h5 class="card-title">Castillo Embrujado</h5>
							<p class="card-text">This is a longer card with supporting
								text below as a natural lead-in to additional content. This
								content is a little bit longer.</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">Precio: 5 monedas</small>
						</div>
						<div class="card-footer">
							<small class="text-muted">Duración: 2 horas</small>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card h-100">
						<img src="assets/imagenes/Carreta fantasma.jpg"
							class="card-img-top contenedor-imagen2" alt="...">
						<div class="card-body">
							<h5 class="card-title">Carreta Fantasma</h5>
							<p class="card-text">This is a longer card with supporting
								text below as a natural lead-in to additional content. This
								content is a little bit longer.</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">Precio: 8 monedas</small>
						</div>
						<div class="card-footer">
							<small class="text-muted">Duración: 4 horas</small>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card h-100">
						<img src="assets/imagenes/Bosque Tenebroso.jpg"
							class="card-img-top contenedor-imagen2" alt="...">
						<div class="card-body">
							<h5 class="card-title">Bosque Tenebroso</h5>
							<p class="card-text">This is a longer card with supporting
								text below as a natural lead-in to additional content. This
								content is a little bit longer.</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">Precio: 6 monedas</small>
						</div>
						<div class="card-footer">
							<small class="text-muted">Duración: 4.5 horas</small>
						</div>
					</div>
				</div>

			</div>

		</section>
	</section>

	<!--  Modal de login -->
	<div class="modal fade" id="loginModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Sugerencia</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>

				<div class="modal-body">
					<div class="container mb-3">
						<form>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Nombre
									de usuario</label> <input type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">
								<div id="emailHelp" class="form-text">We'll never share
									your email with anyone else.</div>
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Contraseña</label>
								<input type="password" class="form-control"
									id="exampleInputPassword1">
							</div>
							<div class="mb-3 form-check">
								<input type="checkbox" class="form-check-input"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1">Check me out</label>
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Cerrar</button>
							<button type="button" class="btn btn-primary">Comprar</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--  Modal de sugerencia -->
	<div class="modal fade" id="PromoAventura" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Sugerencia</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>

				<div class="modal-body">
					<div class="container mb-3">
						<img src="assets/imagenes/Mordor.jpg"
							class="card-img-top contenedor-imagen2" alt="...">
					</div>
					<p>Descripción de la sugerencia</p>
					<p>Categoría:</p>
					<p>Cupo disponible:</p>
					<p>Duración:</p>
					<p>Costo: $</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Cerrar</button>
					<button type="button" class="btn btn-primary">Comprar</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="PromoDegustacion" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Sugerencia</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>

				<div class="modal-body">
					<div class="container mb-3">
						<img src="assets/imagenes/Lothlorien.jpg"
							class="card-img-top contenedor-imagen2" alt="...">
					</div>
					<p>Descripción de la sugerencia</p>
					<p>Categoría:</p>
					<p>Cupo disponible:</p>
					<p>Duración:</p>
					<p>Costo: $</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Cerrar</button>
					<button type="button" class="btn btn-primary">Comprar</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="PromoPaisaje" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Sugerencia</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>

				<div class="modal-body">
					<div class="container mb-3">
						<img src="../imagenes/Abismo_Helm2.jpg"
							class="card-img-top contenedor-imagen2" alt="...">
					</div>
					<p>Descripción de la sugerencia</p>
					<p>Categoría:</p>
					<p>Cupo disponible:</p>
					<p>Duración:</p>
					<p>Costo: $</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Cerrar</button>
					<button type="button" class="btn btn-primary">Comprar</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="PromoTerror" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Sugerencia</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>

				<div class="modal-body">
					<div class="container mb-3">
						<img src="../imagenes/Bosque Tenebroso.jpg"
							class="card-img-top contenedor-imagen2" alt="...">
					</div>
					<p>Descripción de la sugerencia</p>
					<p>Categoría:</p>
					<p>Cupo disponible:</p>
					<p>Duración:</p>
					<p>Costo: $</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Cerrar</button>
					<button type="button" class="btn btn-primary">Comprar</button>
				</div>
			</div>
		</div>
	</div>

	<footer class="conteiner-md text-dark text-center mt-5 border-dark">
		ARGENTINA PROGRAMA - Yo Programo 2021 - Grupo 3 </footer>
</body>
</html>
