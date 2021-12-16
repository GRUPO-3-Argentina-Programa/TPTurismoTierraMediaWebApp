<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">
	<div class="mb-3">
		<label for="nombre" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" id="nombre" name="nombre" required
			value="${usuario.nombre}">
	</div>
	<div class="mb-3">
		<label for="password" class="col-form-label">Contraseņa:</label> <input
			type="password" class="form-control" id="password" name="password"
			required value="${usuario.password}">
	</div>
	<div class="mb-3">
		<label for="admin" class="col-form-label">Administrador:</label><select
			class="form-select" id="admin" name="admin">
			<option selected>Seleccione una opcion</option>
			<option value="true" name="admin">Si</option>
			<option value="false" name="admin">No</option>
		</select>
	</div>
	<div class="mb-3">
		<label for="presupuesto"
			class='col-form-label ${usuario.errors.get("presupuesto") != null ? "is-invalid" : "" }'>Presupuesto:</label>
		<input class="form-control" type="number" id="presupuesto"
			name="presupuesto" required value="${usuario.presupuesto}"></input>
		<div class="invalid-feedback">
			<c:out value='${usuario.errors.get("presupuesto")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="tiempo"
			class='col-form-label ${usuario.errors.get("tiempo") != null ? "is-invalid" : "" }'>Tiempo:</label>
		<input class="form-control" type="number" id="tiempo" name="tiempo"
			required value="${usuario.tiempo}"></input>
		<div class="invalid-feedback">
			<c:out value='${usuario.errors.get("tiempo")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<div class="col-12">
			<label for="preferencia" class="col-form-label">Preferencia:</label> <select
				class="form-select" id="preferencia" name="preferencia">
				<option selected>Seleccione una opcion</option>
				<c:forEach items="${ tipos }" var="tipo">
				<c:if test="${tipo.esActivo()}">
				<option value="tipo.nonbre" name="tipo">${tipo.getNombre()}</option>
				</c:if>
				</c:forEach>
				</select>
				


		</div>
	</div>
</div>
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>