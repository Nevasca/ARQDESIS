<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.Devolucao"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Devolução</title>

<link href="../bootstrap/css/bootstrap.css" rel="stylesheet" />
<link href="../bootstrap/css/bootstrap-theme.css" rel="stylesheet" />

<script src="../bootstrap/js/jquery-1.9.1.js" type="text/javascript"></script>
<script src="../bootstrap/js/bootstrap.js" type="text/javascript"></script>
<script src="../scripts/devolucao.js" type="text/javascript"></script>

</head>
<body>
	<%
	/*
		String ret = (String) request.getAttribute("ret");

		ret = (ret != null ? ret : "");
		if (ret.equals("devolver")) {
			Devolucao dev = (Devolucao) request.getAttribute("dev");
			out.print(dev.getNumeroLocacaoAutomovel() + "</font><br><br>");
		}
		*/
	%>
	<div class="container">

		<div class="jumbotron">
			<h1>Devolução de Automovel</h1>
		</div>

		<form method="post" name="devolucao" action="../devolver.do"
			class="form-horizontal" onsubmit="return validarDevolucao();">

			<div class="form-group">
				<label class="control-label col-sm-2" for="lblNumeroLocacao">Número
					Locação: </label>
				<div class="col-sm-10">
					<input name="txtNumeroLocacao" type="text" value=""
						class="form-control" /> <span class="erro-form"
						id="erroNumeroLocacao"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="lblDataD">Data
					Devolução: </label>
				<div class="col-sm-10">
					<input name="txtDataDevolucao" type="text" value=""
						class="form-control" placeholder="dd/mm/aaaa" /> <span
						class="erro-form" id="erroDataDevolucao"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="lblLocalD">Local
					de Devolução:</label>
				<div class="col-sm-10">
					<select name="cbLocalD" size="1" class="form-control">
						<option value="NaoSelecionado"></option>
						<option value="1">1 - LOCAL</option>
						<option value="2">2 - LOCAL</option>
						<option value="3">3 - LOCAL</option>
						<option value="4">4 - LOCAL</option>
						<option value="5">5 - LOCAL</option>
					</select> <span class="erro-form" id="erroLocalD"></span>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="lblAgencia">Agencia:
				</label>
				<div class="col-sm-10">
					<input name="txtAgencia" type="text" value="" class="form-control" />
					<span class="erro-form" id="erroAgencia"></span>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="lblKMRodado">KM
					Rodado: </label>
				<div class="col-sm-10">
					<input name=txtKMRodado type="text" value="" class="form-control" />
					<span class="erro-form" id="erroKMRodado"></span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input class="btn btn-info" name="btnConfirmar" type="submit"
						value="Confirmar" onClick="confirmarDevolucao();" /> <input
						class="btn btn-info" name="btnCancelar" type="reset"
						value="Cancelar" onClick="cancelarDevolucao();" />
				</div>
			</div>
			<div class="divFormaPagamento">
				<div id="confirmacao" class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input class="btn btn-danger" name="btnCredito" type="submit"
							value="Crédito" onClick="verificaTipoPagamento('C')" /> <input
							class="btn btn-default" name="btnDebito" type="submit"
							value="Débito" onClick="verificaTipoPagamento('D')" />
					</div>
				</div>
			</div>
		</form>
	</div>

</body>
</html>