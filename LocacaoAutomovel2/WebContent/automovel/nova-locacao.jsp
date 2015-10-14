<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.text.DateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/LocacaoAutomovel2/bootstrap/css/bootstrap.min.css">

<script src="http://localhost:8080/LocacaoAutomovel2/scripts/jquery-1.11.3.min.js"></script>
<script src="http://localhost:8080/LocacaoAutomovel2/scripts/navegacao.js"></script>
<script src="http://localhost:8080/LocacaoAutomovel2/scripts/locacao.js"></script>
<script src="http://localhost:8080/LocacaoAutomovel2/scripts/validacao.js"></script>
<script src="http://localhost:8080/LocacaoAutomovel2/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="http://localhost:8080/LocacaoAutomovel2/css/style.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/LocacaoAutomovel2/css/sidebar.css">
<title>BEG</title>
</head>
<body>
	
	<!-- Carrega os itens de navegacao e menu em comum -->
	<div id="barraTopo"></div>
	<div id="menu"></div>
	<span id="top-link-block" class="volta-topo">
    	<a href="#topo" class="well well-sm" onclick="$('html,body').animate({scrollTop:0},'fast');return false;">
        	<span class="glyphicon glyphicon-chevron-up"></span>
    	</a>
	</span>
	<div class='cobre-pagina'></div>
	
	<script>
		setBarraTopo();
		setMenu();
		
		$(document).ready(function(){
	    	$("#menu-toggle").click(function() {
	        	$("#wrapper").toggleClass("toggled");
	        	$("body").toggleClass("pagina-coberta");
	        	$(".cobre-pagina").css("opacity", 0.6).fadeToggle("slow");	        		        	
	    	});        	
		});
	</script>
    <!-- Fim da navegacao em comum -->
    <%
    	Automovel auto = null;
    	Locacao loc = null;
    	Cliente cli = null;
    	String cidadeLocacao = "";
    	String cidadeDevolucao = "";  
    	String agenciaLocacao = "0";
    	String agenciaDevolucao = "0";
    	int modoTarifa = -1;
    	String dataLocacao = "";
    	String dataDevolucao = "";
    	
    	//Contém código em javascript para focar a linha correta de formulario.
    	//Se acabou de consultar o cliente, focar a linha de pagamento para nao ter que descer toda a página, por exemplo
    	String foco = "'#linhaLocacao'";
    	
    
	    if(request.getAttribute("automovel") != null)
		{
			auto = (Automovel) request.getAttribute("automovel");			
		}
		else
		{
			RequestDispatcher view = request.getRequestDispatcher("consulta.jsp");
			view.forward(request, response);
		}
	    
	    if(request.getAttribute("locacao") != null)
	    {
	    	loc = (Locacao) request.getAttribute("locacao");
	    	cidadeLocacao = loc.getCidadeLocacao();
	    	cidadeDevolucao = loc.getCidadeDevolucao();
	    	agenciaLocacao = loc.getAgenciaLocacao();
	    	agenciaDevolucao = loc.getAgenciaDevolucao();
	    	modoTarifa = loc.getTipoTarifa();
	    	
	    	//2014-01-02T13:42 --exemplo de formato do datetime-local input
	    	//Formata a data de locacoa e devolucao para colocar como value no input
	    	DateFormat data = new SimpleDateFormat("yyyy-MM-dd");
	        DateFormat hora = new SimpleDateFormat("hh:mm");
	        dataLocacao = data.format(loc.getDataLocacao()) + "T" + hora.format(loc.getDataLocacao());
	        dataDevolucao = data.format(loc.getDataDevolucao()) + "T" + hora.format(loc.getDataDevolucao());
	        
	        foco = "'#linhaCliente'";
	    }
	    
	    if(request.getAttribute("cliente") != null)
	    {
	    	cli = (Cliente) request.getAttribute("cliente");
	    	foco = "'#linhaPagamento'";
	    }
	%>      
	
	<script>
		//Foca a linha de forma suave
		$(document).ready(function (){          
             $('html, body').animate({scrollTop: $(<% out.print(foco); %>).offset().top}, 'fast');                
        });        
	</script>
    
    <div class="container">
    
    	<div class="col-md-12">
    		<div class="jumbotron">
    			<h1>Nova Locação</h1>
    		</div>
			<form role="form" name="formLocacao" method="post" action="locacao.do">
			<input type="hidden" name="acao">
			<div class="row well">
				<h4><span class="glyphicon glyphicon-wrench"></span> Dados do Automóvel</h4>
				<input type="hidden" name="idAutomovel" value="<% out.print(auto.getId()); %>">
				<div class="col-md-6">
					<b>Modelo: </b><br> <% out.print(auto.getModelo()); %><br>
					<b>Fabricante: </b><br> <% out.print(auto.getFabricante()); %><br>
					<b>Acessório: </b><br> <% out.print(auto.getNomeAcessorio()); %><br>
					<b>Grupo: </b><br> <% out.print(auto.getNomeGrupo()); %><br>
					<b>Placa: </b><br> <% out.print(auto.getPlaca()); %><br> 
				</div>
				<div class="col-md-6">
					<b>Cidade: </b><br> <% out.print(auto.getCidade()); %><br>
					<b>Estado: </b><br> <% out.print(auto.getUf()); %><br>
					<b>Tarifa simples:<br> </b> <% out.print(auto.getTarifa()); %><br>
					<b>Tarifa controlada:<br> </b> <% out.print(auto.getTarifaControlada()); %><br>
				</div>
			</div>
			<div class="row well" id="linhaLocacao">
				<h4><span class="glyphicon glyphicon-calendar"></span> Dados da Locação e Devolução</h4>
				<div class="col-md-6">	
					<div class="form-group">
						<label>Data e hora da locação:</label>
						<input name="dataLocacao" type="datetime-local" class="form-control" 
							onchange="atualizarTarifa(<% out.print(auto.getTarifa()); %>)" value="<% out.print(dataLocacao); %>" placeholder="MM/dd/AAAA hh:mm"> <!-- value="2014-01-02T13:42" -->
						<span class="erro-form" id="erroDataLocacao"></span>
					</div>
					<div class="form-group">
						<label>Agência de locação:</label>
						<select name="agenciaLocacao" class="form-control">
							<option id="agLoc0" value="NaoSelecionado">Selecione...</option>
							<option id="agLoc101" value="101">101</option>
							<option id="agLoc102" value="102">102</option>
							<option id="agLoc103" value="103">103</option>							
						</select>
						<span class="erro-form" id="erroAgenciaLocacao"></span>
					</div>
					<div class="form-group">
						<label>Cidade de locação:</label>
						<input name="cidadeLocacao" type="text" class="form-control" value="<% out.print(cidadeLocacao); %>">
						<span class="erro-form" id="erroCidadeLocacao"></span>
					</div>
				</div>
				
				<div class="col-md-6">
					<div class="form-group">
						<label>Data e hora da devolução:</label>
						<input name="dataDevolucao" type="datetime-local" class="form-control" 
							onchange="atualizarTarifa(<% out.print(auto.getTarifa()); %>)" value="<% out.print(dataDevolucao); %>">
							<span class="erro-form" id="erroDataDevolucao"></span>
					</div>
					<div class="form-group">
						<label>Agência de devolução:</label>
						<select name="agenciaDevolucao" class="form-control">
							<option id="agDev0" value="NaoSelecionado">Selecione...</option>
							<option id="agDev101" value="101">101</option>
							<option id="agDev102" value="102">102</option>
							<option id="agDev103" value="103">103</option>							
						</select>
						<span class="erro-form" id="erroAgenciaDevolucao"></span>
					</div>
					<div class="form-group">
						<label>Cidade de devolução:</label>
						<input name="cidadeDevolucao" type="text" class="form-control" value="<% out.print(cidadeDevolucao); %>">
						<span class="erro-form" id="erroCidadeDevolucao"></span>
					</div>
				</div>
				<div class="row">
					<!-- <h4><span class="glyphicon glyphicon-credit-card"></span> Tarifa e Pagamento</h4> -->
					<div class="col-md-6">
						<div class="container-fluid">
							<div class="col-md-2">
								<input id="radioTarifaSimples" type="radio" name="modoTarifa" value="simples" class="form-control">
							</div>
							<div class="col-md-6">
								<b>Tarifa Simples</b>
								<p>De acordo com o número de dias alugado</p>
							</div>
							<div class="col-md-4">
								<h3 id="valorTarifa">R$ <% out.print(auto.getTarifa()); %></h3>
							</div>							
						</div>
						<span class="erro-form" id="erroModoTarifa"></span>
					</div>
					
					<div class="col-md-6">
						<div class="container-fluid">
							<div class="col-md-2">
								<input id="radioTarifaControlada" type="radio" name="modoTarifa" value="controlada" class="form-control">
							</div>
							<div class="col-md-6">
								<b>Tarifa Controlada</b> 
								<p>De acordo com a quilometragem rodada</p>
							</div>
							<div class="col-md-4">
								<h3 id="valorTarifaControlada">R$ <% out.print(auto.getTarifaControlada()); %></h3>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 text-center">
						<button type="button" onclick="validarDadosLocacao()" class="btn btn-primary"><span class="glyphicon glyphicon-ok"></span> Validar Locação</button>						
					</div>
				</div>
			</div>
			
			<script>
				selecionarOptionAgencia(<% out.print(agenciaLocacao + "," + agenciaDevolucao);%>);
				selecionarModoTarifa(<% out.print(modoTarifa); %>);
			</script>
			
			<div class="row well" <% if(loc == null){ out.print("hidden"); } %> id="linhaCliente">
				<h4><span class="glyphicon glyphicon-user"></span> Dados do Cliente</h4>
				<div class="col-md-6">	
					<div class="form-group">
						<label>CPF:</label>
						<input type="text" name="cpfCliente" class="form-control">
						<span class="erro-form" id="erroCpfCliente"></span><br>
						<button type="button" onclick="validarConsultaCliente()" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span> Buscar</button>
					</div>
					
				</div>
				<%
					if(cli != null)
					{
						//Escrever no html os dados do cliente
						String cod = "<div class='row'>";
						cod+= "<div class='col-md-6'>";
						cod+= "<b>Nome: </b><br/>" + cli.cpf;
						cod+= "</div>";
						cod+= "</div>";
						
						out.print(cod);
					}
				%>				
			</div>
			
			<div class="row well" <% if(cli == null){ out.print("hidden"); } %>  id="linhaPagamento">
				<h4><span class="glyphicon glyphicon-credit-card"></span> Forma de Pagamento</h4>
				<div class="col-md-12 text-center">
					<h3 style="margin-bottom: 30px">Total: R$ 742,00</h3>
				</div>
				<div class="row">
					<div class="col-md-12 text-center">
						<button type="button" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-credit-card"></span> Débito</button>
						<button type="button" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-credit-card"></span> Crédito</button>
					</div>
				</div>
			</div>
			
			</form>
    	</div>
    </div>
</body>
</html>