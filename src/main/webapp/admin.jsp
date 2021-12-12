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

<a href="Create1.jsp" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Nueva Atracción
				</a>

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
						<td> <a href = "atraccion/borrar.adm?id=${ atracciones.getId() }">Borrar</a>
						<a href="atraccion/editar.adm?id=${atracciones.getId()}"
									class="btn btn-light rounded-0" role="button"><i
									class="bi bi-pencil-fill"></i>Editar</a>
						</td>
					
					</tr>
					
					</c:forEach>
							</tbody>
			</table>

		</section>
		</section>
		
		<button type="button" class="btn btn-secondary btn-lg">Crear Nueva Promocion</button>
		
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
						<td>Modificar </td>
						<td>Eliminar </td>
					</tr>
					</c:forEach>
							</tbody>
			</table>

		</section>
		</section>
		
				<button type="button" class="btn btn-secondary btn-lg">Crear Nuevo Usuario</button>
				
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
						<th scope="col">Acción</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items= "${ usuarios }" var="usuario"> 
					<tr>
						<td> <c:out value="${usuario.getNombre() }"></c:out></td>
						<td><c:out value="${usuario.getPassword() }"></c:out></td>
						<td><c:out value="${usuario.getTIEMPO() }"></c:out></td>
						<td><c:out value="${usuario.getPRESUPUESTO()}"></c:out></td>
						<td><c:out value="${usuario.isAdmin()}"></c:out></td>
						<td>Modificar </td>
						<td>Eliminar </td>
					</tr>
					</c:forEach>
							</tbody>
			</table>

		</section>
		</section>

</body>
</html>