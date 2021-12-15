<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
					<c:if test="${user==null}">
						<div class="col">
							<a href="login">Entrar</a>
						</div>
					</c:if>

					<c:if test="${user!=null}">
						<div class="col">
							<a href="index">Inicio</a>
						</div>
						<div class="col">
							<a href="itinerario.do">Mi itinerario</a>
						</div>
						<div class="col">
							<a href="listar.do">Recomendaciones</a>
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
										<li><a class="dropdown-item disabled"
											style="color: black;"> <i title="monedas"
												style="color: gold;" class="bi bi-coin"></i> <c:out
													value="Presupuesto: ${user.getPresupuesto()} monedas"></c:out>
										</a></li>
										<li><a class="dropdown-item disabled"
											style="color: black;"> <i title="tiempo"
												style="color: blue;" class="bi bi-clock-fill"></i> <c:out
													value="Tiempo disponible: ${user.getTiempo()} h"></c:out>
										</a></li>
										<li><a class="dropdown-item disabled"
											style="color: black;"> <i title="preferencia"
												style="color: gold;" class="bi bi-coin"></i> <c:out
													value="Preferencia: ${user.getPreferencia()}"></c:out>
										</a></li>
										<c:if test="${user.isAdmin()}"><li><a href="listar.adm" class="dropdown-item">Admin</a>
										</li></c:if>
										<li><hr class="dropdown-divider"></li>
										<li><a href="logout" class="dropdown-item">Salir</a></li>
									</ul></li>
							</ul>
						</div>
					</c:if>
				</div>
			</div>
		</section>
	</div>
</nav>