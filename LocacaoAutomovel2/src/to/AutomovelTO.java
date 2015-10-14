package to;

import model.Automovel;
import java.util.ArrayList;

public class AutomovelTO 
{

	private ArrayList<Automovel> lista;
	
	public AutomovelTO()
	{
		lista = new ArrayList<Automovel>();
	}
	
	public void addAutomovel(Automovel automovel)
	{
		lista.add(automovel);
	}
	
	public ArrayList<Automovel> getLista()
	{
		return lista;
	}
}
