<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="es">
<head>
	<jsp:include page="partials/encabezado.jsp"></jsp:include>
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
						<a href= "/TPTurismoTierraMediaWebApp/atraccionesAdmin/listar" class="col">Atracciones</a>
						<div class="col">
							<a href="/TPTurismoTierraMediaWebApp/promocionAdmin/listar">Promociones</a>
						</div>
						<div class="col">
							<a href="/TPTurismoTierraMediaWebApp/usuariosAdmin/listar">Usuarios</a>
						</div>

					</div>
				</div>
			</section>
		</div>
	</nav>

<section class="row container-fluid">

		<section class="container mt-5 mb-5">

			<table class="table table-striped table-dark table-hover">
				<thead>
					<tr>
						<th scope="col">Nombre</th>
						<th scope="col">Tiempo</th>
						<th scope="col">Precio</th>
						<th scope="col">Acción</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items= "${ atracciones }" var="atracciones"> 
					<tr>
						<td> <c:out value="${atracciones.getNombre() }"></c:out></td>
						<td><c:out value="${atracciones.getTiempoTotal() }"></c:out></td>
						<td><c:out value="${atracciones.getCosto() }"></c:out></td>
						<td>Modificar / Eliminar</td>
					</tr>
					</c:forEach>
							</tbody>
			</table>

		</section>
		</section>
		
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
					<c:forEach items= "${ promociones }" var="promocion"> 
					<tr>
						<td> <c:out value="${promocion.getNombre() }"></c:out></td>
						<td><c:out value="${promocion.getTipoAtraccion() }"></c:out></td>
						<td><c:out value="${promocion.getTiempoTotal() }"></c:out></td>
						<td><c:out value="${promocion.getCosto() }"></c:out></td>
						<td>Modificar / Eliminar</td>
					</tr>
					</c:forEach>
							</tbody>
			</table>

		</section>
		</section>

</body>
</html>