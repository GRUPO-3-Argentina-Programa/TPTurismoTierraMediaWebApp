<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">
	<div class="mb-3">
		<label for="name" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" id="name" name="nombre" required
			value="${promociones.nombre}">
	</div>
	<div class="mb-3">
		<div class="col-12">
			<label for="tipo" class="col-form-label">Tipo Promocion:</label> <select
				class="form-select" id="tipoPromocion" name="tipoPromocion">
				<option selected>Seleccione una opcion</option>
				<option value="AxB" name="tipo">AxB</option>
				<option value="Porcentual" name="tipo">Porcentual</option>
				<option value="Absoluta" name="tipo">Absoluta</option>
			</select>
		</div>
	</div>
	
	<div class="mb-3">
				<div class="col-12">
			<label for="tipo" class="col-form-label">tipo Atracción:</label> <select
				class="form-select" id="tipo" name="tipo">
				<option selected>Seleccione una opcion</option>
				<c:forEach items="${ tipos }" var="tipo">
				<c:if test="${tipo.esActivo()}">
				<option value="tipo.nonbre" name="tipo">${tipo.getNombre()}</option>
				</c:if>
				</c:forEach>
			</select>
		</div>
	</div>
	
	<div class="mb-3">
		<div class="col-12">
			<label for="tipo" class="col-form-label">Primera Atracción:</label> <select
				class="form-select" id="atracciones" name="atracciones">
				<option selected>Seleccione una opcion</option>
				<c:forEach items="${ atracciones }" var="atraccion">
				<c:if test="tipo.adm?id=${recomendacion.getId()}">
				<option value="atraccion.nonbre" name="tipo">${atraccion.getNombre()}</option>
				</c:if>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="mb-3">
		<div class="col-12">
			<label for="tipo" class="col-form-label">Segunda Atracción:</label> <select
				class="form-select" id="tipo" name="tipo">
				<option selected>Seleccione una opcion</option>
				<c:forEach items="${ atracciones }" var="atraccion">
				<option value="atraccion.nonbre" name="tipo">${atraccion.getNombre()}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="mb-3">
		<div class="col-12">
			<label for="tipo" class="col-form-label">Atracción Gratis:</label> <select
				class="form-select" id="tipo" name="tipo">
				<option selected>Seleccione una opcion</option>
				<c:forEach items="${ atracciones }" var="atraccion">
				<option value="atraccion.nonbre" name="tipo">${atraccion.getNombre()}</option>
				</c:forEach>
			</select>
		</div>
	</div>

	<div class="mb-3">
		<div class="col-12">
			<label for="tipo" class="col-form-label">Tipo Promocion:</label> <select
				class="form-select" id="tipo" name="tipo">
				<option selected>Seleccione una opcion</option>
				<option value="AxB" name="tipo">AxB</option>
				<option value="Porcentual" name="tipo">Porcentual</option>
				<option value="Absoluta" name="tipo">Absoluta</option>
			</select>
		</div>
	</div>
	<div class="mb-3">
		<div class="col-12">
			<label for="tipo" class="col-form-label">Tipo Promocion:</label> <select
				class="form-select" id="tipo" name="tipo">
				<option selected>Seleccione una opcion</option>
				<option value="AxB" name="tipo">AxB</option>
				<option value="Porcentual" name="tipo">Porcentual</option>
				<option value="Absoluta" name="tipo">Absoluta</option>
			</select>
		</div>
	</div>

	<div class="mb-3">
		<label for="duration"
			class='col-form-label ${promociones.errors.get("tiempo") != null ? "is-invalid" : "" }'>Tiempo:</label>
		<input class="form-control" type="number" id="duration" name="tiempo"
			required value="${promociones.tiempo}"></input>
		<div class="invalid-feedback">
			<c:out value='${promociones.errors.get("tiempo")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="capacity"
			class='col-form-label ${promociones.errors.get("cupo") != null ? "is-invalid" : "" }'>Cupo:</label>
		<input class="form-control" type="number" id="capacity" name="cupo"
			required value="${promociones.cupo}"></input>
		<div class="invalid-feedback">
			<c:out value='${promociones.errors.get("cupo")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="descripcion"
			class='col-form-label ${promociones.errors.get("descripcion") != null ? "is-invalid" : "" }'>Descripcion:</label>
		<input class="form-control" type="text" id="descripcion"
			name="descripcion" required value="${promociones.descripcion}"></input>
		<div class="invalid-feedback">
			<c:out value='${promociones.errors.get("descripcion")}'></c:out>
		</div>
	</div>

</div>
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
