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
							<a href="listar.adm">Listado</a>
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

	<section class="row container-fluid">
		<c:forEach items="${usuarios}" var="usuario">
			<c:if test="${usuario.getItinerario().size()>0}">
			<div id="titulo" class="mb-0">
				<h5 class="display-1">
					Usuario:
					<c:out value="${usuario.getNombre()}"></c:out>
					compró:
				</h5>
			</div>
			<section class="container mt-5 mb-5">
				<table class="table table-striped table-dark table-hover">
					<thead>
						<tr>
							<th scope="col">Nombre</th>
							<th scope="col">Tiempo</th>
							<th scope="col">Precio</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${usuario.getItinerario()}" var="compra">
							<tr>
								<td><c:out value="${compra.getNombre() }"></c:out></td>
								<td><c:out value="${compra.getTiempoTotal() }"></c:out></td>
								<td><c:out value="${compra.getCosto() }"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</section>
			</c:if>
		</c:forEach>
	</section>
</body>
<footer class="conteiner-md text-dark text-center mt-5 border-dark">
	ARGENTINA PROGRAMA - Yo Programo 2021 - Grupo 3 - Curso 8</footer>
</html>