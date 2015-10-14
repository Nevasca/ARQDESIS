package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AutomovelDAO;
import model.Automovel;

/**
 * Servlet implementation class ConsultaRapidaAutomovelCTRL
 */
@WebServlet("/automovel/consultaRapida.do")
public class ConsultaRapidaAutomovelCTRL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaRapidaAutomovelCTRL() {
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
		
		auto.setModelo(request.getParameter("buscaRapida"));
		auto.setFabricante(request.getParameter("buscaRapida"));
		
		//Apenas teste!!! Chamar outra classe ao inves da DAO direto
		AutomovelDAO autoDAO = new AutomovelDAO();
		
		request.setAttribute("listaAutomoveis", autoDAO.consultarModelo(auto));
		RequestDispatcher view = request.getRequestDispatcher("/automovel/consulta.jsp");
		view.forward(request, response);		
	}

}
