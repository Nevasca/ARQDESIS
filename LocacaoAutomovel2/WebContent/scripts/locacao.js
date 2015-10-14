function selecionarOptionAgencia(agenciaLocacao, agenciaDevolucao)
{		
	document.getElementById("agLoc" + agenciaLocacao).selected = true;
	document.getElementById("agDev" + agenciaDevolucao).selected = true;
}

function selecionarModoTarifa(modoTarifa)
{
	if(modoTarifa == 0)
	{
		document.getElementById("radioTarifaSimples").checked = true;
	}
	else if(modoTarifa == 1)
	{
		document.getElementById("radioTarifaControlada").checked = true;
	}
	
}

function atualizarTarifa(tarifaSimples)
{
	var form = document.formLocacao;
	
	if(form.dataLocacao.value != "" && form.dataDevolucao.value != "")
	{
		var dataLocacao = new Date(form.dataLocacao.value);
		//Coloca mais um dia por causa da zona de fuso horario. Se nao somar um dia, fica aparecendo como data de ontem...
		dataLocacao.setDate(dataLocacao.getDate() + 1);  
		
		var dataDevolucao = new Date(form.dataDevolucao.value);
		dataDevolucao.setDate(dataDevolucao.getDate() + 1);
		
		var diferencaDias = Math.ceil(Math.abs(dataDevolucao.getTime() - dataLocacao.getTime()) / (1000 * 3600 * 24)); //1000 * 3600 * 24 = milisegundos por dia
		
		//alert("Dias de locacao: " + diferencaDias);
			
		document.getElementById("valorTarifa").innerHTML = "R$ " + (diferencaDias * tarifaSimples);
		//document.getElementById("valorTarifaControlada").innerHTML = "R$ " + tarifaControlada;
	}
}

//Verifica todos os preenchimentos e incrementa se houve algum erro
var houveErro;
//Usado para focar o primeiro input com erro
var focoInicial;

function validarDadosLocacao()
{	
	var form = document.formLocacao;
	houveErro = 0;
	focoInicial = null;
	
	verificarPreenchimento(form.dataLocacao, "erroDataLocacao", "Informe a data de locação");
	verificarSelecao(form.agenciaLocacao, "erroAgenciaLocacao", "Selecione a agência de locação");
	verificarPreenchimento(form.cidadeLocacao, "erroCidadeLocacao", "Informe a cidade de locação");
	verificarPreenchimento(form.dataDevolucao, "erroDataDevolucao", "Informe a data de devolução");
	verificarSelecao(form.agenciaDevolucao, "erroAgenciaDevolucao", "Selecione a agência de devolução");
	verificarPreenchimento(form.cidadeDevolucao, "erroCidadeDevolucao", "Informe a cidade de devolução");
	verificarPreenchimento(form.modoTarifa, "erroModoTarifa", "Selecione o modo de cobrança");
	
	//Se deu tudo certo, submeter o formulário
	if(houveErro == 0)
	{		
		form.acao.value = "validarLocacao";		
		form.submit();
	}
	
	//Se preencheu errado
	focoInicial.focus();	
}

function validarConsultaCliente()
{
	var form = document.formLocacao;
	houveErro = 0;
	focoInicial = null;
	
	verificarPreenchimento(form.cpfCliente, "erroCpfCliente", "Informe o cpf do cliente");
	
	//Se deu tudo certo, submeter o formulário
	if(houveErro == 0)
	{		
		form.acao.value = "consultarCliente";		
		form.submit();
	}
	
	//Se preencheu errado
	focoInicial.focus();
}


