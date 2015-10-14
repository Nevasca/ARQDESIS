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
	
	
	verificaPreenchimento(form.txtNomeTitular, "erroTitular","Informe o nome do titular do cartão.");
	verificaPreenchimento(form.txtCpf, "erroCpf","Informe o CPF do titular do cartão.");
	verificaPreenchimento(form.txtValorPagamento, "erroValorPagamento","Informe o valor a ser pago.");
	verificaPreenchimento(form.txtDataPagamento, "erroDataPagamento","Informe a data de pagamento.");

	if (tipoPagamento == "C") {
		
		verificaPreenchimento(form.txtValidadeCartao, "erroValidadeCartao","Informe a data de validade do cartão.");
		verificaPreenchimento(form.txtOperadoraCartao, "erroOperadoraCartao","Informe a operadora do cartão.");
		verificaPreenchimento(form.txtNumeroCartao, "erroNumeroCartao","Informe o número do cartão.");
		verificaPreenchimento(form.txtcodSeguranca, "erroCodSeguranca","Informe o código de segurança do cartão.");

		
	} else if (tipoPagamento == "D") {
		
		verificaPreenchimento(form.txtnumAgenciaDebito, "erroNumeroAgencia","Informe o chassi do automÃ³vel");
		verificaPreenchimento(form.txtnumContaDebito, "erroNumeroConta","Informe o número da conta.");
		verificaPreenchimento(form.txtNumeroDigitoVerificador, "erroNumeroConta","Informe o digito verificador.");
		verificaPreenchimento(form.txtBancoDebito, "erroBanco","Informe o banco do cartão.");
		verificaPreenchimento(form.txtTelefone, "erroTelefone","Informe um telefone de referência do titular.");
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
