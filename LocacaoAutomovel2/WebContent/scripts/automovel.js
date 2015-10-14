//Verifica todos os preenchimentos e incrementa se houve algum erro
var houveErro;
//Usado para focar o primeiro input com erro
var focoInicial;

function validarCadastroAutomovel()
{
	
	var form = document.cadastroAuto;
	houveErro = 0;
	focoInicial = null;
	
	verificarSelecao(form.grupo, "erroGrupo", "Selecione o grupo do automóvel");
	verificarPreenchimento(form.chassi, "erroChassi", "Informe o chassi do automóvel");
	verificarPreenchimento(form.placa, "erroPlaca", "Informe a placa do automóvel");
	verificarPreenchimento(form.cidade, "erroCidade", "Informe a cidade do automóvel");
	verificarSelecao(form.uf, "erroEstado", "Selecione o estado do automóvel");
	verificarPreenchimento(form.quilometragem, "erroQuilometragem", "Informe a quilometragem do automóvel");
	verificarPreenchimento(form.modelo, "erroModelo", "Informe o modelo do automóvel");
	verificarPreenchimento(form.fabricante, "erroFabricante", "Informe o fabricante do automóvel");
	verificarPreenchimento(form.tarifa, "erroTarifa", "Informe o valor da tarifa do automóvel");
	verificarPreenchimento(form.tarifaControlada, "erroTarifaControlada", "Informe o valor da tarifa controlada do automóvel");
	
	//Se deu tudo certo, submeter o formulário
	if(houveErro == 0)
	{
		return true;
	}
	
	//Se preencheu errado
	focoInicial.focus();
	return false;
}