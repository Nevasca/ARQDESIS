package to;

import java.io.Serializable;
import java.util.ArrayList;
import model.PagamentoCredito;

public class PagamentoCreditoTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<PagamentoCredito> lista;
	
	public PagamentoCreditoTO(){
		lista = new ArrayList<PagamentoCredito>();
	}
	
	public void add(PagamentoCredito pc){
		lista.add(pc);
	}
	
	public boolean remove(PagamentoCredito pc){
		return(lista.remove(pc));
	}
	
	public ArrayList<PagamentoCredito> getLista(){
		return lista;
	}
}
