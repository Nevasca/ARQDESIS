package control;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Automovel;
/**
 * Servlet implementation class CadastroAutomovelCTRL
 */
@WebServlet("/automovel/cadastroAutomovel.do")
public class CadastroAutomovelCTRL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroAutomovelCTRL() {
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
		
		//Para formatar o valor da tarifa
		DecimalFormat f = (DecimalFormat)DecimalFormat.getInstance(new Locale("pt", "BR"));		
		
		//Fazer verificações de preenchimento?
		Automovel auto = new Automovel();
		auto.setGrupo(request.getParameter("grupo")); 
		auto.setAcessorio(Integer.parseInt(request.getParameter("acessorio")));
		auto.setChassi(request.getParameter("chassi"));
		auto.setPlaca(request.getParameter("placa"));
		auto.setCidade(request.getParameter("cidade"));
		auto.setUf(request.getParameter("uf"));
		auto.setQuilometragem(Double.parseDouble(request.getParameter("quilometragem")));
		auto.setModelo(request.getParameter("modelo"));
		auto.setFabricante(request.getParameter("fabricante"));
		try {
			auto.setTarifa((Double)f.parse(request.getParameter("tarifa")));
			auto.setTarifaControlada((Double)f.parse(request.getParameter("tarifaControlada")));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//Validar posteriormente se cadastrou ou não
		auto.cadastrar();
		
		//request.setAttribute("automovel", auto);
		
		RequestDispatcher view = request.getRequestDispatcher("/automovel/cadastro-sucesso.html");
		view.forward(request, response);
		
	}

}
