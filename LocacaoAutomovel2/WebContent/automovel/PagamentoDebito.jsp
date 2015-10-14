<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagamento</title>

<link href="../bootstrap/css/bootstrap.css" rel="stylesheet" />
<link href="../bootstrap/css/bootstrap-theme.css" rel="stylesheet" />

<script src="../bootstrap/js/jquery-1.9.1.js" type="text/javascript"></script>
<script src="../bootstrap/js/bootstrap.js" type="text/javascript"></script>
<script src="../scripts/pagamento.js" type="text/javascript"></script>

</head>

<div class="container">

	<div class="jumbotron">
		<h1>Pagamento Débito</h1>
	</div>

	<form name="pagamentoDebito" method="post" action="pagamento.do"
		class="form-horizontal" onsubmit="return validarPagamento('D');">

		<div class="form-group">
			<label class="control-label col-sm-2" for="nomeTitular">Nome
				Titular: </label>
			<div class="col-sm-10">
				<input name="txtNomeTitular" type="text" value=""
					class="form-control" /> <span class="erro-form" id="erroTitular"></span>

			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="cpfCliente">CPF: </label>
			<div class="col-sm-10">
				<input name="txtCpf" type="text" value="" class="form-control" /> <span
					class="erro-form" id="erroCpf"></span>

			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="valorPagamento">Valor
				Pagamento:</label>
			<div class="col-sm-10">
				<input name="txtValorPagamento" type="text" value=""
					class="form-control" /> <span class="erro-form"
					id="erroValorPagamento"></span>

			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="dataPagamento">Data
				pagamento:</label>
			<div class="col-sm-10">
				<input name="txtDataPagamento" type="text" value=""
					class="form-control" /> <span class="erro-form"
					id="erroDataPagamento"></span>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="numAgenciaDebito">Numero
				Agencia:</label>
			<div class="col-sm-10">
				<input name="txtnumAgenciaDebito" type="text" value=""
					class="form-control" /> <span class="erro-form"
					id="erroNumeroAgencia"></span>

			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-2" for="numContaDebito">Numero
				Conta:</label>
			<div class="col-sm-10">
				<input name="txtnumContaDebito" type="text" value=""
					class="form-control" /> <input name="txtNumeroDigitoVerificador"
					type="text" value="" class="form-control" /> <span
					class="erro-form" id="erroNumeroConta"></span>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="bancoDebito">Banco
				Debito:</label>
			<div class="col-sm-10">
				<input name="txtBancoDebito" type="text" value=""
					class="form-control" /> <span class="erro-form" id="erroBanco"></span>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="telefone">Telefone
				Cliente:</label>
			<div class="col-sm-10">
				<input name="txtTelefone" type="text" value="" class="form-control" />
				<span class="erro-form" id="erroTelefone"></span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input class="btn btn-danger" name="btnConfirmar" type="submit"
					value="Confirmar" onClick="confirmarPagamento();" /> <input
					class="btn btn-danger" name="btnCancelar" type="reset"
					value="Cancelar" onClick="cancelarPagamento();" />
			</div>
		</div>
	</form>
</div>

</html>