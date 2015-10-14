function cancelarPagamento() {
	if (confirm("Deseja cancelar o pagamento?")) {

	}
}

function confirmarPagamento() {
	if (confirm("Deseja efetuar o pagamento?")) {
	}
}

var houveErro;
var focoInicial;

function validarPagamento(tipoPagamento) {

	var form = null;

	if (tipoPagamento == "C") {
		form = document.pagamentoCredito;
	} else if (tipoPagamento == "D") {
		form = document.pagamentoDebito;
	}

	houveErro = 0;
	focoInicial = null;
	
	
	verificaPreenchimento(form.txtNomeTitular, "erroTitular","Informe o nome do titular do cart�o.");
	verificaPreenchimento(form.txtCpf, "erroCpf","Informe o CPF do titular do cart�o.");
	verificaPreenchimento(form.txtValorPagamento, "erroValorPagamento","Informe o valor a ser pago.");
	verificaPreenchimento(form.txtDataPagamento, "erroDataPagamento","Informe a data de pagamento.");

	if (tipoPagamento == "C") {
		
		verificaPreenchimento(form.txtValidadeCartao, "erroValidadeCartao","Informe a data de validade do cart�o.");
		verificaPreenchimento(form.txtOperadoraCartao, "erroOperadoraCartao","Informe a operadora do cart�o.");
		verificaPreenchimento(form.txtNumeroCartao, "erroNumeroCartao","Informe o n�mero do cart�o.");
		verificaPreenchimento(form.txtcodSeguranca, "erroCodSeguranca","Informe o c�digo de seguran�a do cart�o.");

		
	} else if (tipoPagamento == "D") {
		
		verificaPreenchimento(form.txtnumAgenciaDebito, "erroNumeroAgencia","Informe o chassi do automóvel");
		verificaPreenchimento(form.txtnumContaDebito, "erroNumeroConta","Informe o n�mero da conta.");
		verificaPreenchimento(form.txtNumeroDigitoVerificador, "erroNumeroConta","Informe o digito verificador.");
		verificaPreenchimento(form.txtBancoDebito, "erroBanco","Informe o banco do cart�o.");
		verificaPreenchimento(form.txtTelefone, "erroTelefone","Informe um telefone de refer�ncia do titular.");
	}

	if (houveErro == 0) {
		return true;
	}

	focoInicial.focus();
	return false;
}

function verificaPreenchimento(campo, idSpanErro, msgErro) {
	if (campo.value == "") {

		if (focoInicial == null) {
			focoInicial = campo;
		}

		document.getElementById(idSpanErro).innerHTML = msgErro;
		houveErro++;
		return false;

	} else {
		document.getElementById(idSpanErro).innerHTML = "";
		return true;
	}
}
