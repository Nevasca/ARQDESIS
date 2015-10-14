package to;

import java.io.Serializable;
import java.util.ArrayList;
import model.PagamentoDebito;

public class PagamentoDebitoTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<PagamentoDebito> lista;
	
	public PagamentoDebitoTO(){
		lista = new ArrayList<PagamentoDebito>();
	}
	
	public void add(PagamentoDebito pd){
		lista.add(pd);
	}
	
	public boolean remove(PagamentoDebito pd){
		return(lista.remove(pd));
	}
	
	public ArrayList<PagamentoDebito> getLista(){
		return lista;
	}
}
