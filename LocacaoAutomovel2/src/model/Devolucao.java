package model;

import dao.DevolucaoDAO;
import to.DevolucaoTO;

public class Devolucao {

	private String localDevolucao,dataDevolucaoCliente;
	private int agenciaDevolucao,numeroLocacaoAutomovel;

	public String getDataDevolucaoCliente() {
		return dataDevolucaoCliente;
	}

	public void setDataDevolucaoCliente(String dataDevolucaoCliente) {
		this.dataDevolucaoCliente = dataDevolucaoCliente;
	}

	public int getNumeroLocacaoAutomovel() {
		return numeroLocacaoAutomovel;
	}

	public void setNumeroLocacaoAutomovel(int numeroLocacaoAutomovel) {
		this.numeroLocacaoAutomovel = numeroLocacaoAutomovel;
	}

	public String getLocalDevolucao() {
		return localDevolucao;
	}

	public void setLocalDevolucao(String localDevolucao) {
		this.localDevolucao = localDevolucao;
	}

	public int getAgenciaDevolucao() {
		return this.agenciaDevolucao;
	}

	public void setAgenciaDevolucao(int agenciaDevolucao) {
		this.agenciaDevolucao = agenciaDevolucao;
	}
	
	public DevolucaoTO consultarLocacao(int idLocacao){
		
		DevolucaoDAO devolverAutomovel = new DevolucaoDAO();
		return devolverAutomovel.consultarLocacao(idLocacao);
	}

	public boolean cadastrarDevolucao(Devolucao devolver){
		
		DevolucaoDAO devolverAutomovel = new DevolucaoDAO();
		return devolverAutomovel.inserirDevolucao(devolver);
	}
	
	@Override
	public String toString() {
		return "Devolucao [dataDevolucaoCliente=" + dataDevolucaoCliente
				+ ", localDevolucao=" + localDevolucao + ", agenciaDevolucao="
				+ agenciaDevolucao + ", numeroLocacaoAutomovel="
				+ numeroLocacaoAutomovel + "]";
	}

}
