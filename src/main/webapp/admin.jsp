<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="es">
<head>
<jsp:include page="/partials/encabezado.jsp"></jsp:include>
</head>

<body>
	<nav class="navbar navbar-expand-lg p-3 mb-2">
		<div class="container-fluid">

			<section class="container-fluid text-center ">
				<div id="titulo" class="mb-0">
					<h1 class="display-1">Turismo en la tierra media</h1>
					<p class="lead  mb-0">Bienvenidos al primer Parque Tematico
						sobre la Tierra Media de la Argentina, inspirado en el gran J.R.R
						Tolkien</p>
				</div>
				<div class="container-fluid" id="nav2">
					<div class="row">
						<div class="col">
							<a href="index">Inicio</a>
						</div>
						<div class="col">
							<a href="compras.adm">Compras</a>
						</div>
						<div class="col">
							<ul class="navbar-nav">
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
									role="button" data-bs-toggle="dropdown" aria-expanded="false">
										<c:out value="${user.getNombre()}"></c:out>
								</a>
									<ul class="dropdown-menu dropdown-menu-end"
										aria-labelledby="navbarDropdown">
										<li><hr class="dropdown-divider"></li>
										<li><a href="logout" class="dropdown-item">Salir</a></li>
									</ul></li>
							</ul>
						</div>

					</div>
				</div>
			</section>
		</div>
	</nav>

	<a href="crear.adm" class="btn btn-secondary btn-lg" role="button">
		<i class="bi bi-plus-lg"></i> Nueva Atracción
	</a>

	<section class="row container-fluid">

		<section class="container mt-5 mb-5">

			<table class="table table-striped table-dark table-hover">
				<thead>
					<tr>
						<th scope="col">Nombre</th>
						<th scope="col">Tiempo</th>
						<th scope="col">Precio</th>
						<th scope="col">Activo</th>
						<th scope="col">Acción</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ atracciones }" var="atracciones">
						<tr>
							<td><c:out value="${atracciones.getNombre() }"></c:out></td>
							<td><c:out value="${atracciones.getTiempoTotal() }"></c:out></td>
							<td><c:out value="${atracciones.getCosto() }"></c:out></td>
							<td><c:out value="${atracciones.esActivo() }"></c:out></td>
							<td><a
								href="atraccion/borrar.adm?id=${ atracciones.getId() }">Borrar</a>
								/ <a href="atraccionEditar.adm?id=${atracciones.getId()}">Editar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</section>
	</section>

	<button type="button" class="btn btn-secondary btn-lg">Nueva
		Promocion</button>

	<section class="row container-fluid">

		<section class="container mt-5 mb-5">

			<table class="table table-striped table-dark table-hover">
				<thead>
					<tr>
						<th scope="col">promo_id</th>
						<th scope="col">Tipo Atracciones</th>
						<th scope="col">Tiempo</th>
						<th scope="col">Precio</th>
						<th scope="col">Acción</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ promociones }" var="promocion">
						<c:if test="${promocion.esActivo()}">
							<tr>
								<td><c:out value="${promocion.getNombre() }"></c:out></td>
								<td><c:out value="${promocion.getTipoAtraccion() }"></c:out></td>
								<td><c:out value="${promocion.getTiempoTotal() }"></c:out></td>
								<td><c:out value="${promocion.getCosto() }"></c:out></td>
								<td><a href="borrarPromocion.adm?id=${ promocion.getId() }">Borrar</a>
									/ <a href="">Editar</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>

		</section>
	</section>

	<a href="crearUsuario.adm" class="btn btn-secondary btn-lg"
		role="button"> <i class="bi bi-plus-lg"></i> Nuevo Usuario
	</a>

	<section class="row container-fluid">

		<section class="container mt-5 mb-5">

			<table class="table table-striped table-dark table-hover">
				<thead>
					<tr>
						<th scope="col">Nombre</th>
						<th scope="col">Password</th>
						<th scope="col">Tiempo</th>
						<th scope="col">Presupuesto</th>
						<th scope="col">Administrador</th>
						<th scope="col">Activo</th>
						<th scope="col">Acción</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ usuarios }" var="usuario">
						<tr>
							<td><c:out value="${usuario.getNombre() }"></c:out></td>
							<td><c:out value="${usuario.getPassword() }"></c:out></td>
							<td><c:out value="${usuario.getTiempo() }"></c:out></td>
							<td><c:out value="${usuario.getPresupuesto()}"></c:out></td>
							<td><c:out value="${usuario.isAdmin()}"></c:out></td>
							<td><c:out value="${usuario.esActivo()}"></c:out></td>
							<td><a href="borrarUsuario.adm?id=${usuario.getId()}">Borrar</a>
								/ <a href="editarUsuario.adm?id=${usuario.getId()}">Editar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
	</section>

	<a href="crearTipo.adm" class="btn btn-secondary btn-lg" role="button">
		<i class="bi bi-plus-lg"></i> Nuevo Tipo
	</a>

	<section class="row container-fluid">

		<section class="container mt-5 mb-5">

			<table class="table table-striped table-dark table-hover">
				<thead>
					<tr>
						<th scope="col">Nombre</th>
						<th scope="col">Activo</th>
						<th scope="col">Acción</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${tipos}" var="tipo">
						<tr>
							<td><c:out value="${tipo.getNombre()}"></c:out></td>
							<td><c:out value="${tipo.esActivo()}"></c:out></td>
							<td><a href="borrarTipo.adm?tipo=${tipo.getNombre()}">Borrar</a>
								/ <a href="">Editar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
	</section>
</body>
<footer class="conteiner-md text-dark text-center mt-5 border-dark">
	ARGENTINA PROGRAMA - Yo Programo 2021 - Grupo 3 - Curso 8</footer>
</html>