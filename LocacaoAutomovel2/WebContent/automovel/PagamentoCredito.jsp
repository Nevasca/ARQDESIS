<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagamento</title>

<link href="../bootstrap/css/bootstrap.css" rel="stylesheet" />
<link href="../bootstrap/css/bootstrap-theme.css" rel="stylesheet" />

</head>
<body>

	<div class="container">

		<div class="jumbotron">
			<h1>Pagamento Crédito</h1>
		</div>
		<!--  method="post" action="pagamento.do" -->
		<form name="pagamentoCredito" class="form-horizontal"
			onsubmit="return validarPagamento('C');">

			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeTitular">Nome
					Titular: </label>
				<div class="col-sm-10">
					<input name="txtNomeTitular" type="text" value=""
						class="form-control" /> <span class="erro-form" id="erroTitular"></span>

				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="cpfCliente">CPF:
				</label>
				<div class="col-sm-10">
					<input name="txtCpf" type="text" value="" class="form-control" />
					<span class="erro-form" id="erroCpf"></span>

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
				<label class="control-label col-sm-2" for="validadeCartao">Validade
					Cartão:</label>
				<div class="col-sm-10">
					<input name="txtValidadeCartao" type="text" value=""
						class="form-control" /> <span class="erro-form"
						id="erroValidadeCartao"></span>

				</div>

			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="operadoraCartao">Operadora
					Crédito:</label>
				<div class="col-sm-10">
					<input name="txtOperadoraCartao" type="text" value=""
						class="form-control" /> <span class="erro-form"
						id="erroOperadoraCartao"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="numCartao">Número
					Cartão:</label>
				<div class="col-sm-10">
					<input name="txtNumeroCartao" type="text" value=""
						class="form-control" /> <span class="erro-form"
						id="erroNumeroCartao"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="codSeguranca">Código
					Segurança:</label>
				<div class="col-sm-10">
					<input name="txtcodSeguranca" type="text" value=""
						class="form-control" /> <span class="erro-form"
						id="erroCodSeguranca"></span>
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

</body>

<script src="bootstrap/js/jquery-1.9.1.js" type="text/javascript"></script>
<script src="bootstrap/js/bootstrap.js" type="text/javascript"></script>
<script src="scripts/pagamento.js" type="text/javascript"></script>

</html>