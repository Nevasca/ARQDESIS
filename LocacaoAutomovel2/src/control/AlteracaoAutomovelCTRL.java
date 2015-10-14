package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Automovel;

/**
 * Servlet implementation class AlteracaoAutomovelCTRL
 */
@WebServlet("/automovel/alteracao.do")
public class AlteracaoAutomovelCTRL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlteracaoAutomovelCTRL() {
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
		
		//Fazer verificações de preenchimento?
		Automovel auto = new Automovel();
		auto.setId(Integer.parseInt(request.getParameter("idAutomovel")));
		auto.setGrupo(request.getParameter("grupo")); 
		auto.setAcessorio(Integer.parseInt(request.getParameter("acessorio")));
		auto.setChassi(request.getParameter("chassi"));
		auto.setPlaca(request.getParameter("placa"));
		auto.setCidade(request.getParameter("cidade"));
		auto.setUf(request.getParameter("uf"));
		auto.setQuilometragem(Double.parseDouble(request.getParameter("quilometragem")));
		auto.setModelo(request.getParameter("modelo"));
		auto.setFabricante(request.getParameter("fabricante"));
		auto.setTarifa(Double.parseDouble(request.getParameter("tarifa")));
		auto.setTarifaControlada(Double.parseDouble(request.getParameter("tarifaControlada")));
		
		//Boolean para informar usuario se alterou ou nao
		if(auto.alterar())
		{			
			request.setAttribute("alterado", true);
			request.setAttribute("automovelConsultado", auto);
		}
		else
		{
			
			request.setAttribute("alterado", false);
		}				
		
		//Volta para a mesma tela de detalhes para tratar se alterou ou nao
		RequestDispatcher view = request.getRequestDispatcher("detalhes.do?id=" + auto.getId());
		view.forward(request, response);
	}

}
