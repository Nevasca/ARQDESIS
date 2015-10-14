package model;

import to.PagamentoDebitoTO;
import dao.PagamentoDAO;

public class PagamentoDebito extends Pagamento {

	private String bancoDebito,telefone;
	private int numeroAgenciaDebito,numeroDigitoVerificadorDebito, numeroContaDebito;

	public int getNumeroAgenciaDebito() {
		return numeroAgenciaDebito;
	}

	public void setNumeroAgenciaDebito(int numeroAgenciaDebito) {
		this.numeroAgenciaDebito = numeroAgenciaDebito;
	}

	public int getNumeroContaDebito() {
		return numeroContaDebito;
	}

	public void setNumeroContaDebito(int numeroContaDebito) {
		this.numeroContaDebito = numeroContaDebito;
	}
	
	public int getNumeroDigitoVerificadorDebito() {
		return numeroDigitoVerificadorDebito;
	}

	public void setNumeroDigitoVerificadorDebito(int numeroDigitoVerificadorDebito) {
		this.numeroDigitoVerificadorDebito = numeroDigitoVerificadorDebito;
	}

	public String getBancoDebito() {
		return bancoDebito;
	}

	public void setBancoDebito(String bancoDebito) {
		this.bancoDebito = bancoDebito;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefone() {
		return telefone;
	}
		
	public PagamentoDebitoTO efetuarPagamento(){
		
      PagamentoDAO pagamento = new PagamentoDAO();
  	  return pagamento.pagamentoDebito(this);
    }

	@Override
	public String toString() {
		return "PagamentoDebito [numeroAgenciaDebito=" + numeroAgenciaDebito
				+ ", numeroContaDebito=" + numeroContaDebito + ", numeroDigitoVerificadorDebito=" + numeroDigitoVerificadorDebito
				+ ", bancoDebito=" + bancoDebito + ", telefone=" + telefone + "]";
	}

}
