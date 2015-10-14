//Funcoes para escrever na pagina os itens de navegacao em comum


//Url completa do sistema
var dominio = "http://localhost:8080/LocacaoAutomovel2/";

//Escreve na pagina o HTML para a barra do topo
function setBarraTopo()
{
    var barra = "<nav class='navbar navbar-default'>" +
		"<div class='container-fluid'>" +
			"<div class='navbar-header'>" +
				"<a class='navbar-brand' href='" + dominio + "index.html'>BEG</a>" +
			"</div>" +
			"<div>" +
				"<ul class='nav navbar-nav navbar-left'>" +
					"<li>" +
						"<a href='#' id='menu-toggle'><span class='glyphicon glyphicon-th-list'></span> Menu</a>" +
					"</li>" +
				"</ul>" +
			"</div>" +
			"<div>" +
				"<ul class='nav navbar-nav navbar-right'>" +
					"<li>" +
						"<a href='#' onclick='document.formBuscaRapida.submit()'><span class='glyphicon glyphicon-search'></span> Buscar por modelo ou fabricante</a>" +
					"</li>" +
					"<li>" +
						"<form role='form' name='formBuscaRapida' method='post' action='" + dominio + "automovel/consultaRapida.do'>" +
							"<input type='text' class='form-control' name='buscaRapida'/>" +
						"</form>" +
					"</li>" +
					"<li>" +
						"<a href='#'><span class='glyphicon glyphicon-log-out'></span> Sair</a>" +
					"</li>" +
				"</ul>" +
			"</div>" +
		"</div>" +
	"</nav>";
    
    document.getElementById("barraTopo").innerHTML = barra;
}

//Escreve na pagina o HTML para a barra de menu lateral com menus
function setMenu()
{
    var menu = "<div id='wrapper'>" +
        "<div id='sidebar-wrapper'>" +
            "<ul class='sidebar-nav'>" +
                "<li class='sidebar-brand'>" +
                        "<span class='glyphicon glyphicon-user'></span> Bruno Sanches" +              
                "</li>" +
                "<li>" +
                    "<a href='" + dominio + "automovel/cadastro.html'>Cadastrar Automóvel</a>" +
                "</li>" +
                "<li>" +
                    "<a href='" + dominio + "automovel/consulta.jsp'>Consultar Automóvel</a>" +
                "</li>" +
                "<li>" +
                    "<a href='#'>Locações</a>" +
                "</li>" +
                "<li>" +
                    "<a href='#'>Cadastrar Cliente</a>" +
                "</li>" +
                "<li>" +
                    "<a href='#'>Consultar Cliente</a>" +
                "</li>" +
                "<li>" +
                    "<a href='#'>Relatórios</a>" +
                "</li>" +
            "</ul>" +
        "</div>" +
      "</div>";
	
    document.getElementById("menu").innerHTML = menu;
}

/*
//Escreve na pagina o HTML para o botao de voltar ao topo
function setVoltaTopo()
{
    var voltaTopo = "<span id='top-link-block' class='volta-topo'>" +
    	"<a href='#topo' class='well well-sm' onclick='$(&quot;html,body&quot;).animate({scrollTop:0},'slow');return false;'>" +
        	"<span class='glyphicon glyphicon-chevron-up'></span>" +
    	"</a>" +
	   "</span>";
    
    document.getElementById("voltaTopo").innerHTML = voltaTopo;
}
*/