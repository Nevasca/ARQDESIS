package dao;

import java.sql.*;

import model.Pagamento;

import model.PagamentoCredito;
import model.PagamentoDebito;

import to.PagamentoCreditoTO;
import to.PagamentoDebitoTO;

public class PagamentoDAO {
		
	public PagamentoCreditoTO pagamentoCredito(PagamentoCredito pagCredito) {

		String sql = "SELECT P.OPERADORA_CARTAO,"
				+ "          P.NM_CLIENTE,"
				+ "          P.CPF_CLIENTE,"
				+ "          P.NUM_CARTAO,"
				+ "	         P.DT_VALIDADE,"
				+ "		     P.COD_SEGURANCA, " 
				+ "		     P.CREDITO"
				+ "	    FROM TB_PAGAMENTO_CREDITO P"
				+ "    WHERE P.NUM_CARTAO = '" + pagCredito.getNumeroCartaoCredito() + "';";

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		PagamentoCreditoTO pagTO = new PagamentoCreditoTO();

		try {

			conn = ConexaoBD.conectar();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {

				PagamentoCredito pag = new PagamentoCredito();							
				pag.setOperadoraCredito(rs.getString(1));
				pag.setNomeTitular(rs.getString(2));
				pag.setCpfTitular(rs.getString(3));
				pag.setNumeroCartaoCredito(rs.getInt(4));
				pag.setValidadeCredito(rs.getString(5));
				pag.setCodigoSegurancaCredito(rs.getInt(6));
				pag.setValorPagamento(rs.getDouble(7));		
				pagTO.add(pag);

			}

		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {

			if (rs != null) {

				try {

					rs.close();

				} catch (SQLException sqe) {
					sqe.printStackTrace();
				}
			}

			if (pst != null) {

				try {

					pst.close();

				} catch (SQLException sqe) {
					sqe.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					ConexaoBD.desconectar(conn);
				}
				catch (SQLException sqe) {
					sqe.printStackTrace();
				}
			}
		}

		return pagTO;
	}
	
	public PagamentoDebitoTO pagamentoDebito(PagamentoDebito pagDebito) {

		String sql = "SELECT P.BANCO,"
				+ "          P.NM_CLIENTE,"
				+ "          P.CPF_CLIENTE,"
				+ "          P.NUM_AGENCIA,"
				+ "	         P.NUM_CONTA_CORRENTE,"
				+ "	         P.NUM_DIGITO_VERIFICADOR,"
				+ "		     P.TEL_CLIENTE, " 
				+ "		     P.SALDO"
				+ "	    FROM TB_PAGAMENTO_DEBITO P"
				+ "    WHERE P.NUM_CONTA_CORRENTE = '" + pagDebito.getNumeroContaDebito() + "';";
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		PagamentoDebitoTO pagTO = new PagamentoDebitoTO();

		try {

			conn = ConexaoBD.conectar();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {

				PagamentoDebito pag = new PagamentoDebito();				
				pag.setBancoDebito(rs.getString(1));
				pag.setNomeTitular(rs.getString(2));
				pag.setCpfTitular(rs.getString(3));
				pag.setNumeroAgenciaDebito(rs.getInt(4));
				pag.setNumeroContaDebito(rs.getInt(5));				
				pag.setNumeroDigitoVerificadorDebito(rs.getInt(6));				
				pag.setTelefone(rs.getString(7));
				pag.setValorPagamento(rs.getDouble(8));
				pagTO.add(pag);
				
			}

		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {

			if (rs != null) {

				try {

					rs.close();

				} catch (SQLException sqe) {
					sqe.printStackTrace();
				}
			}

			if (pst != null) {

				try {

					pst.close();

				} catch (SQLException sqe) {
					sqe.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					ConexaoBD.desconectar(conn);
				}
				catch (SQLException sqe) {
					sqe.printStackTrace();
				}
			}
		}

		return pagTO;
	}	

	public boolean inserirPagamento(Pagamento pagamento,int idCliente, int idLocacao) {
		
		String sql = "INSERT INTO TB_PAGAMENTO" 
				+"	 ("
		        + "	   DATA_PAGAMENTO,"
				+ "    VLR_PAGAMENTO,"
				+ "    ID_CLIENTE,"
				+ "    ID_LOCACAO"
				+"    )"
				+ "	VALUES"
				+"	 ("
				+ "	    ?," 
				+ "		?,"
				+ "		?,"
				+ "		?" 
				+ "	  )";

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			
			conn = ConexaoBD.conectar();
			pst = conn.prepareStatement(sql);
			pst.setString(1, pagamento.getDataPagamento());
			pst.setDouble(2, pagamento.getValorPagamento());
			pst.setInt(3, idCliente);
			pst.setInt(4, idLocacao);
			pst.execute();

			return true;
			
		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {

			if (rs != null) {

				try {

					rs.close();

				} catch (SQLException sqe) {
					sqe.printStackTrace();
				}
			}

			if (pst != null) {

				try {

					pst.close();

				} catch (SQLException sqe) {
					sqe.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					ConexaoBD.desconectar(conn);
				}
				catch (SQLException sqe) {
					sqe.printStackTrace();
				}
			}
		}
		
		return false;

	}

}
