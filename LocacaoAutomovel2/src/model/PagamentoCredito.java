package model;

import to.PagamentoCreditoTO;
import dao.PagamentoDAO;

public class PagamentoCredito extends Pagamento{
	   
    private String validadeCredito,operadoraCredito;
    private int numeroCartaoCredito,codigoSegurancaCredito;
 	
    public String getValidadeCredito(){
       return validadeCredito;
    }
    
    public void setValidadeCredito(String validadeCredito){
       this.validadeCredito = validadeCredito;
    }
    
    public String getOperadoraCredito(){
       return operadoraCredito;
    }
    
 	 public void setOperadoraCredito(String operadoraCredito){
       this.operadoraCredito = operadoraCredito ;
    }
    
    public int getNumeroCartaoCredito(){
       return numeroCartaoCredito;
    }
    
 	 public void setNumeroCartaoCredito(int numeroCartaoCredito){
       this.numeroCartaoCredito = numeroCartaoCredito ;
    }
    
    public int getCodigoSegurancaCredito(){
       return codigoSegurancaCredito;
    }
    
     public void setCodigoSegurancaCredito(int codigoSegurançaCredito){
       this.codigoSegurancaCredito = codigoSegurançaCredito ;
    }
     
     public PagamentoCreditoTO efetuarPagamento(){
    	 
   	  PagamentoDAO pagamento = new PagamentoDAO();   	  
   	  return pagamento.pagamentoCredito(this);
   	  
     } 
     
     @Override
 	public String toString() {
 		return "PagamentoCredito [validadeCredito=" + validadeCredito + ", operadoraCredito=" + operadoraCredito
 				+ ", numeroCartaoCredito=" + numeroCartaoCredito + ", codigoSegurancaCredito=" + codigoSegurancaCredito + "]";
 	}
     
}
 