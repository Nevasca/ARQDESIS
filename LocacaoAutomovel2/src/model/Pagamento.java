package model;

import dao.PagamentoDAO;

public class Pagamento {
	
	private String nomeTitular, cpf,dataPagamento;
	private double valorPagamento;

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setCpfTitular(String cpfTitular) {
		this.cpf = cpfTitular;
	}

	public String getCpfTitular() {
		return cpf;
	}

	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getDataPagamento() {
		return dataPagamento;
	}

	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public double getValorPagamento() {
		return valorPagamento;
	}

	public void inserirPagamento(int idCliente, int idLocacao) {
		PagamentoDAO pagDAO = new PagamentoDAO();
		pagDAO.inserirPagamento(this, idCliente, idLocacao);

	}

	@Override
	public String toString() {
		return "Pagamento [nomeTitular=" + nomeTitular + ", cpf=" + cpf
				+ ", dataPagamento=" + dataPagamento + ", valorPagamento="
				+ valorPagamento + "]";
	}

}
