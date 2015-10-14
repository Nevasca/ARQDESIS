function cancelarDevolucao() {
	if (confirm("Deseja cancelar a devolução?")) {

	}
}

function confirmarDevolucao() {
	if (confirm("Deseja confirmar a devolução?")) {
	}
}

var houveErro;
var focoInicial;

function validarDevolucao() {

	var form = document.devolucao;
	houveErro = 0;
	focoInicial = null;
	
	
	verificaPreenchimento(form.txtNumeroLocacao, "erroNumeroLocacao","Informe o código identificador de locação do automovel.");
	verificaPreenchimento(form.txtDataDevolucao, "erroDataDevolucao","Informe a data de devolução do automovel.");
	verificaSelecao(form.cbLocalD, "erroLocalD","Informe o local de devolução do automovel.");
	verificaPreenchimento(form.txtAgencia, "erroAgencia","Informe o número da agência de devolução do automovel.");
    verificaPreenchimento(form.txtKMRodado, "erroKMRodado","Informe o KM rodado com o automovel.");

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

function verificaSelecao(campo, idSpanErro, msgErro)
{
	if(campo.value == "NaoSelecionado")
	{
		if(focoInicial == null)
		{
			focoInicial = campo;
		}
		document.getElementById(idSpanErro).innerHTML = msgErro;
		houveErro++;
		return false;
	}
	else
	{
		document.getElementById(idSpanErro).innerHTML = "";
		return true;
	}
}
