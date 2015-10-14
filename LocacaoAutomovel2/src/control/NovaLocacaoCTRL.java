package control;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

/**
 * Servlet implementation class NovaLocacaoCTRL
 */
@WebServlet("/automovel/locacao.do")
public class NovaLocacaoCTRL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovaLocacaoCTRL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		
		//Escolhe o que fazer de acordo com o input acao
		
		//Veio da tela de detalhes do automovel
		if(request.getParameter("acao") == null) 
		{
			//Pega os dados do automovel, seta como atributo na request e manda para a tela de locacao
			Automovel auto = getAutomovel(request);
			request.setAttribute("automovel", auto);
			RequestDispatcher view = request.getRequestDispatcher("/automovel/nova-locacao.jsp");
			view.forward(request, response);
		}
		else if(request.getParameter("acao").equals("validarLocacao"))
		{
			Locacao loc = getLocacao(request);
			Automovel auto = getAutomovel(request);								
			
			
			//Validar se o periodo escolhido esta disponivel!!!
			//codigo de validacao aqui, só se der certo prosseguir com a locacao, se nao, dar algum alerta na pagina para escolher outra data
			
			request.setAttribute("locacao", loc);
			request.setAttribute("automovel", auto);
			
			RequestDispatcher view = request.getRequestDispatcher("/automovel/nova-locacao.jsp");
			view.forward(request, response);			
			
			/*
			//Teste!!!!!!
			Cliente cli = new Cliente();
			cli.setId(1);
			loc.setAutomovel(auto);
			loc.setCliente(cli);						
			loc.inserirLocacao();
			*/
			
		}
		else if(request.getParameter("acao").equals("consultarCliente"))
		{
			Locacao loc = getLocacao(request);
			Automovel auto = getAutomovel(request);
			Cliente cli = getCliente(request);
			
			request.setAttribute("locacao", loc);
			request.setAttribute("automovel", auto);
			request.setAttribute("cliente", cli);
			
			RequestDispatcher view = request.getRequestDispatcher("/automovel/nova-locacao.jsp");
			view.forward(request, response);
		}
		
	}
	
	//Pega os dados do automovel e retorna um objeto da classe Automovel
	protected Automovel getAutomovel(HttpServletRequest request)
	{
		Automovel auto = new Automovel();
		auto.setId(Integer.parseInt(request.getParameter("idAutomovel")));
		return auto.consultarPorId();		
	}
	
	protected Locacao getLocacao(HttpServletRequest request)
	{
		Locacao locacao = new Locacao();

		locacao.setAgenciaLocacao(request.getParameter("agenciaLocacao"));
		locacao.setAgenciaDevolucao(request.getParameter("agenciaDevolucao"));
		locacao.setCidadeLocacao(request.getParameter("cidadeLocacao"));
		locacao.setCidadeDevolucao(request.getParameter("cidadeDevolucao"));
		String modoTarifa = request.getParameter("modoTarifa");
		if(modoTarifa.equals("simples"))
		{
			locacao.setTipoTarifa(0);
		}
		else
		{
			locacao.setTipoTarifa(1);
		}
		
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date dataLocacao = null;
        Date dataDevolucao = null;
        
        try
        {
        	//Formata a data do datetime-local input para data do java
        	dataLocacao = f.parse(request.getParameter("dataLocacao").replace("T", " "));
        	dataDevolucao = f.parse(request.getParameter("dataDevolucao").replace("T", " "));
        	
        }
        catch(Exception e)
        {
        	e.printStackTrace();        
        }
        
        locacao.setDataLocacao(dataLocacao);
        locacao.setDataDevolucao(dataDevolucao);
		
		return locacao;
	}
	
	protected Cliente getCliente(HttpServletRequest request)
	{
		Cliente cli = new Cliente();
		
		cli.setCpf(request.getParameter("cpfCliente"));
		//Fazer a consulta por cpf do cliente aqui!!!
		//Apenas teste!!!
		cli.setId(1);
		
		return cli;
	}

}
