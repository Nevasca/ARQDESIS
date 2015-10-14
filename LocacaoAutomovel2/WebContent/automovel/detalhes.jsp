<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Automovel"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="http://localhost:8080/LocacaoAutomovel2/bootstrap/css/bootstrap.min.css">
	<script src="http://localhost:8080/LocacaoAutomovel2/scripts/jquery-1.11.3.min.js"></script>
	<script src="http://localhost:8080/LocacaoAutomovel2/bootstrap/js/bootstrap.min.js"></script>	
	<script src="http://localhost:8080/LocacaoAutomovel2/scripts/navegacao.js"></script>
	<script src="http://localhost:8080/LocacaoAutomovel2/scripts/validacaoAutomovel.js"></script>
	<link rel="stylesheet" type="text/css" href="http://localhost:8080/LocacaoAutomovel2/css/style.css">
	<link rel="stylesheet" type="text/css" href="http://localhost:8080/LocacaoAutomovel2/css/sidebar.css">
	<title>Detalhes Automóvel</title>
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
		//Verifica se há um automóvel consultado anteriormente
		Automovel auto = null;
		String grupo = null;
		int acessorio = 0;
		String uf = null;
	
		if(request.getAttribute("automovelConsultado") != null)
		{
			auto = (Automovel) request.getAttribute("automovelConsultado");
			grupo = auto.getGrupo();
			acessorio = auto.getAcessorio();
			uf = auto.getUf();
		}
		else
		{
			RequestDispatcher view = request.getRequestDispatcher("consulta.jsp");
			view.forward(request, response);
		}
	%>
	<div class="container">
		<%
			//Verifica se é um retorno de alteração e dá a mensagem de acordo
			if(request.getAttribute("alterado") != null)
			{
				
				boolean alterado = (Boolean)request.getAttribute("alterado");
				if(alterado)
				{
					out.print("<div class='jumbotron jumb-sucesso-sm'>Automóvel alterado com sucesso!</div>");
				}
				else
				{
					out.print("<div class='jumbotron jumb-alerta'>Não foi possível alterar o automóvel</div>");
				}
			}
		%>
		
	<form name="cadastroAuto" method="post">
	<input type="hidden" name="idAutomovel" value="<%out.print(auto.getId());%>">
	<div class="row well">
		<h4><span class="glyphicon glyphicon-wrench"></span> <%out.print(auto.getModelo());%> <i><%out.print(auto.getFabricante());%></i></h4>
		<div class="col-md-6">
		<div class="form-group">
  			<label>Grupo:</label>
            <select name="grupo" class="form-control">
            	<!-- Verifica qual o grupo do automovel e coloca como selecionado se for o mesmo do option -->
            	<option value="A" <% if(grupo.equals("A")){ out.print("selected");} %>>A – Econômico</option>
                <option value="C" <% if(grupo.equals("C")){ out.print("selected");} %>>C – Econômico com Ar</option>
                <option value="F" <% if(grupo.equals("F")){ out.print("selected");} %>>F – Intermediário</option>
                <option value="G" <% if(grupo.equals("G")){ out.print("selected");} %>>G – Intermediário Wagon Especial</option>
                <option value="H" <% if(grupo.equals("H")){ out.print("selected");} %>>H – Executivo</option>
                <option value="I" <% if(grupo.equals("I")){ out.print("selected");} %>>I – Utilitário</option>
                <option value="K" <% if(grupo.equals("K")){ out.print("selected");} %>>K – Executivo Luxo</option>
                <option value="M" <% if(grupo.equals("M")){ out.print("selected");} %>>M – Intermediário Wagon</option>
                <option value="N" <% if(grupo.equals("N")){ out.print("selected");} %>>N – Pick-up</option>
                <option value="P" <% if(grupo.equals("P")){ out.print("selected");} %>>P – 4 x 4 Especial</option>	
                <option value="R" <% if(grupo.equals("R")){ out.print("selected");} %>>R – Minivan</option>
                <option value="U" <% if(grupo.equals("U")){ out.print("selected");} %>>U – Furgão</option>
                <option value="Y" <% if(grupo.equals("Y")){ out.print("selected");} %>>Y – Blindado</option>
            </select>
            <span class="erro-form" id="erroGrupo"></span>
   		</div>
		<div class="form-group">
			<label>Modelo:</label>
			<input type="text" name="modelo" value="<%out.print(auto.getModelo());%>" class="form-control"/>
			<span class="erro-form" id="erroModelo"></span>
		</div>
		<div class="form-group">
			<label>Fabricante:</label>
			<input type="text" name="fabricante" value="<%out.print(auto.getFabricante());%>" class="form-control"/>
			<span class="erro-form" id="erroFabricante"></span>
		</div>
		<div class="form-group">
  			<label>Acessório:</label>
            <select name="acessorio" class="form-control">
            	<!-- Verifica qual o acessorioo do automovel e coloca como selecionado se for o mesmo do option -->
            	<option value="0" <% if(acessorio == 0){ out.print("selected");} %>>Sem acessório</option>
                <option value="1" <% if(acessorio == 1){ out.print("selected");} %>>Navegador GPS</option>
                <option value="2" <% if(acessorio == 2){ out.print("selected");} %>>Cadeira de Bebê</option>
                <option value="3" <% if(acessorio == 3){ out.print("selected");} %>>Motorista</option>                
            </select>
   		</div>
   		<div class="form-group">
			<label>Cidade:</label>
			<input type="text" name="cidade" value="<%out.print(auto.getCidade());%>" class="form-control"/>
			<span class="erro-form" id="erroCidade"></span>
		</div>
		<div class="form-group">
   			<label>Estado:</label>
   			<!-- Verifica qual a UF do automovel e coloca como selecionado se for o mesmo do option -->
   			<select name="uf" class="form-control">
   			<option value="AC">AC</option>
                    <option value="AL" <% if(uf.equals("AL")){ out.print("selected");} %>>AL</option>
                    <option value="AP" <% if(uf.equals("AP")){ out.print("selected");} %>>AP</option>
                    <option value="AM" <% if(uf.equals("AM")){ out.print("selected");} %>>AM</option>
                    <option value="BA" <% if(uf.equals("BA")){ out.print("selected");} %>>BA</option>
                    <option value="CE" <% if(uf.equals("CE")){ out.print("selected");} %>>CE</option>
                    <option value="DF" <% if(uf.equals("DF")){ out.print("selected");} %>>DF</option>
                    <option value="ES" <% if(uf.equals("ES")){ out.print("selected");} %>>ES</option>
                    <option value="GO" <% if(uf.equals("GO")){ out.print("selected");} %>>GO</option>
                    <option value="MA" <% if(uf.equals("MA")){ out.print("selected");} %>>MA</option>
                    <option value="MT" <% if(uf.equals("MT")){ out.print("selected");} %>>MT</option>
                    <option value="MS" <% if(uf.equals("MS")){ out.print("selected");} %>>MS</option>
                    <option value="MG" <% if(uf.equals("MG")){ out.print("selected");} %>>MG</option>
                    <option value="PR" <% if(uf.equals("PR")){ out.print("selected");} %>>PR</option>
                    <option value="PB" <% if(uf.equals("PB")){ out.print("selected");} %>>PB</option>
                    <option value="PA" <% if(uf.equals("PA")){ out.print("selected");} %>>PA</option>
                    <option value="PE" <% if(uf.equals("PE")){ out.print("selected");} %>>PE</option>
                    <option value="PI" <% if(uf.equals("PI")){ out.print("selected");} %>>PI</option>
                    <option value="RJ" <% if(uf.equals("RJ")){ out.print("selected");} %>>RJ</option>
                    <option value="RN" <% if(uf.equals("RN")){ out.print("selected");} %>>RN</option>
                    <option value="RS" <% if(uf.equals("RS")){ out.print("selected");} %>>RS</option>
                    <option value="RO" <% if(uf.equals("RO")){ out.print("selected");} %>>RO</option>
                    <option value="RR" <% if(uf.equals("RR")){ out.print("selected");} %>>RR</option>
                    <option value="SC" <% if(uf.equals("SC")){ out.print("selected");} %>>SC</option>
                    <option value="SE" <% if(uf.equals("SE")){ out.print("selected");} %>>SE</option>
                    <option value="SP" <% if(uf.equals("SP")){ out.print("selected");} %>>SP</option>
                    <option value="TO" <% if(uf.equals("TO")){ out.print("selected");} %>>TO</option>
   			</select>
   			<span class="erro-form" id="erroEstado"></span>
   		</div>
   		</div> <!-- fim coluna -->   		
   		<div class="col-md-6">
		<div class="form-group">
			<label>Número do Chassi:</label>
			<input type="text" name="chassi" value="<%out.print(auto.getChassi());%>" class="form-control"/>
			<span class="erro-form" id="erroChassi"></span>
		</div>
		<div class="form-group">
			<label>Número da Placa:</label>
			<input type="text" name="placa" value="<%out.print(auto.getPlaca());%>" class="form-control"/>
			<span class="erro-form" id="erroPlaca"></span>
		</div>
		
		<div class="form-group">
			<label>Quilometragem:</label>
			<input type="text" name="quilometragem" value="<%out.print(auto.getQuilometragem());%>" class="form-control"/>
			<span class="erro-form" id="erroQuilometragem"></span>
		</div>
		
		<div class="form-group">
			<label>Tarifa:</label>
			<input type="text" name="tarifa" value="<%out.print(auto.getTarifa());%>" class="form-control"/>
			<span class="erro-form" id="erroTarifa"></span>
		</div>
		<div class="form-group">
			<label>Tarifa Controlada:</label>
			<input type="text" name="tarifaControlada" value="<%out.print(auto.getTarifaControlada());%>" class="form-control"/>
			<span class="erro-form" id="erroTarifaControlada"></span>
  		</div>
  		</div> <!-- fim coluna -->
  		<div class="row">
  		<div class="col-md-12 text-center">
	  		<button type="button" class="btn btn-warning" onclick="alterarAutomovel()"><span class="glyphicon glyphicon-pencil"></span> Alterar</button>
	  		<button type="button" class="btn btn-danger" onclick="$('#caixaExclusao').fadeIn('fast')"><span class="glyphicon glyphicon-trash"></span> Excluir</button>
	  		<div id="caixaExclusao" class="jumbotron jumb-exclusao">
	  			O automóvel será excluído do sistema. Se houver locações, será apenas desativado. Deseja prosseguir com a exclusão? 
	  			<button class="btn btn-default" type="button" onclick="excluirAutomovel()"><b>Excluir</b></button>
	  			<button class="btn btn-default" type="button" onclick="$('#caixaExclusao').fadeOut('fast')">Cancelar</button>  			
	  		</div>
  		</div>
		</div>
  </form>
  
  </div>
  <div class="row">
  	<div class="col-md-12">
  		<div class="jumbotron" style="margin-top: 30px;">
  			<h1>Locações</h4>
  		</div>
  	</div>
  </div>
  <div class="row">
  	<div class="col-md-12">
  		Mostrar se está atualmente alocado e em qual.<br/>
  		<a href="#" onclick="locarAutomovel()">Botão para fazer uma locação/reservar</a><br/>
  		Tabela com histórico de locações para o automóvel acima
  	</div>
  </div>
  
  </div>
  <script>
  	function alterarAutomovel(){
  		//Valida o preenchimento  		
  		if(validarCadastroAutomovel())
  		{
  			document.cadastroAuto.action = "alteracao.do";
  	  		document.cadastroAuto.submit();
  		}
  		
  	}
  	function excluirAutomovel(){
  		document.cadastroAuto.action = "exclusao.do";
  		document.cadastroAuto.submit();
  	}
  	
  	function locarAutomovel(){
  		document.cadastroAuto.action = "locacao.do";
  		document.cadastroAuto.submit();
  	}
  	
  	
  </script>
</body>
</html>