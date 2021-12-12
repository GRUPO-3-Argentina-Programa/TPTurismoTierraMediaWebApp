<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">
	<div class="mb-3">
		<label for="name" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" id="name" name="nombre"
			required value="${ atracciones.nombre}">
	</div>
	<div class="mb-3">
		<label for="cost"
			class='col-form-label ${atracciones.errors.get("costo") != null ? "is-invalid" : "" }'>Costo:</label>
		<input class="form-control" type="number" id="cost" name="costo"
			required value="${atracciones.costo}"></input>
		<div class="invalid-feedback">
			<c:out value='${atracciones.errors.get("costo")}'></c:out>
		</div>
	</div>
		<div class="mb-3">
		<label for="tipo" class="col-form-label">Tipo Atraccion:</label> <input
			type="text" class="form-control" id="tipo" name="tipo"
			required value="${ atracciones.tipo}">
	</div>
	
	<div class="mb-3">
		<label for="duration"
			class='col-form-label ${atracciones.errors.get("tiempo") != null ? "is-invalid" : "" }'>Tiempo:</label>
		<input class="form-control" type="number" id="duration" name="tiempo"
			required value="${atracciones.tiempo}"></input>
		<div class="invalid-feedback">
			<c:out value='${atracciones.errors.get("tiempo")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="capacity"
			class='col-form-label ${atracciones.errors.get("cupo") != null ? "is-invalid" : "" }'>Cupo:</label>
		<input class="form-control" type="number" id="capacity" name="cupo"
			required value="${atracciones.cupo}"></input>
		<div class="invalid-feedback">
			<c:out value='${atracciones.errors.get("cupo")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="id"
			class='col-form-label ${atracciones.errors.get("id") != null ? "is-invalid" : "" }'>ID:</label>
		<input class="form-control" type="number" id="id" name="Id"
			required value="${atracciones.cupo}"></input>
		<div class="invalid-feedback">
			<c:out value='${atracciones.errors.get("id")}'></c:out>
		</div>
	</div>
</div>
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
