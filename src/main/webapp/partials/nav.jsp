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
							<a href="login.jsp">Entrar</a>
						</div>
					</c:if>

					<c:if test="${user!=null}">
						<div class="col">
							<a href="itinerario.do">Mi itinerario</a>
						</div>
						<div class="col">
							<c:set var="currentUrl" value="${request.getRequestURI()}"/>
							<c:if test="${fn:endsWith(currentUrl, 'index.jsp')}">
								<a href="listar.do">Recomendaciones</a>
							</c:if>
							<c:if test="${fn:endsWith(currentUrl, 'listar.do')}">
								<a href="index.jsp">Inicio</a>
							</c:if>


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
													value="${user.getPresupuesto()}"></c:out>
										</a></li>
										<li><a class="dropdown-item disabled"
											style="color: black;"> <i title="tiempo"
												style="color: blue;" class="bi bi-clock-fill"></i> <c:out
													value="${user.getTiempo()}h"></c:out>
										</a></li>
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