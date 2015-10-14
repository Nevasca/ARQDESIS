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
 * Servlet implementation class DetalhesAutomovelCTRL
 */
@WebServlet("/automovel/detalhes.do")
public class DetalhesAutomovelCTRL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetalhesAutomovelCTRL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("UTF-8");
		int id;
		
		if(request.getParameter("id") != null || request.getParameter("id").length() != 0)
		{
			id = Integer.parseInt(request.getParameter("id"));
		}
		else
		{
			//Mandar pra tela de erro depois
			id = 0;	
		}
		
		Automovel auto = new Automovel();
		auto.setId(id);
		auto = auto.consultarPorId();
		
		//Se não existir automovel não fazer nada
		if(auto == null)
		{
			//Apenas para teste
			RequestDispatcher view = request.getRequestDispatcher("consulta.jsp");
			view.forward(request, response);
		}
		else //Se existir automovel, setar o atributo e ir para a tela de detalhes
		{
			request.setAttribute("automovelConsultado", auto);
			RequestDispatcher view = request.getRequestDispatcher("detalhes.jsp");
			view.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
