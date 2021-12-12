<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="es">
<head>
<jsp:include page="partials/encabezado.jsp"></jsp:include>
</head>
<body class="img js-fullheight"
	style="background-image: url(assets/imagenes/bglogin.jpg);">

	<section class="ftco-section">

		<div class="container">

			<div class="row justify-content-center">

				<div class="col-md-6 col-lg-4">

					<div class="login-wrap p-0">
						<h2 class="mb-4 text-center" style="color: #fff">Ingresa a la diversion</h2>

						<c:if test="${flash != null}">
							<div class="alert alert-danger">
								<p>
									<c:out value="${flash}" />
								</p>
							</div>
						</c:if>

						<form action="login" method="post" class="signin-form">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Username"
									name="username" required>
							</div>

							<div class="form-group">
								<input id="password-field" type="password" class="form-control"
									placeholder="Password" name="password" required> <span
									toggle="#password-field"
									class="fa fa-fw fa-eye field-icon toggle-password"></span>
							</div>
							<div class="form-group">
								<button type="submit"
									class="form-control btn btn-primary submit px-3">Entrar</button>
							</div>
							<div class="form-group d-md-flex">								
								<div class="w-50 text-md-right">
									<a href="index" style="color: #fff">Volver a inicio</a>
								</div>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="../js/jquery.min.js"></script>
	<script src="../js/popper.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/main.js"></script>

</body>
</html>
