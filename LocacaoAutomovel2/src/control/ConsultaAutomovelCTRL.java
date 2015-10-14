package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;
import model.*;

/**
 * Servlet implementation class ConsultaAutomovelCTRL
 */
@WebServlet("/automovel/consultaAutomovel.do")
public class ConsultaAutomovelCTRL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaAutomovelCTRL() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		Automovel auto = new Automovel();
		
		if(!request.getParameter("grupo").equals("Não"))
		{
			auto.setGrupo(request.getParameter("grupo"));
		}
		
		auto.setAcessorio(Integer.parseInt(request.getParameter("acessorio")));
		auto.setChassi(request.getParameter("chassi"));
		auto.setPlaca(request.getParameter("placa"));
		auto.setCidade(request.getParameter("cidade"));
		
		if(!request.getParameter("uf").equals("Não"))
		{
			auto.setUf(request.getParameter("uf"));
		}
		
		auto.setModelo(request.getParameter("modelo"));
		auto.setFabricante(request.getParameter("fabricante"));
		
		//Apenas teste!!! Chamar outra classe ao inves da DAO direto
		AutomovelDAO autoDAO = new AutomovelDAO();
		
		request.setAttribute("listaAutomoveis", autoDAO.consultar(auto));
		RequestDispatcher view = request.getRequestDispatcher("/automovel/consulta.jsp");
		view.forward(request, response);
	}

}
