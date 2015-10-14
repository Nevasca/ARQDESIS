package dao;

import java.sql.*;

import model.Devolucao;
import to.DevolucaoTO;

public class DevolucaoDAO {
		
	public DevolucaoTO consultarLocacao(int numeroLocacao) {

		String sql = "SELECT L.ID_LOCACAO,"
				+ "          DATE_FORMAT(L.DATA_DEVOLUCAO_LOCACAO,'%d/%m/%Y') DATA_DEVOLUCAO,"
				+ "          L.LOCAL_DEVOLUCAO_LOCACAO LOCAL_DEVOLUCAO,"
				+ "          P.VLR_PAGAMENTO,"
				+ "	         A.TARIFA_KM_CONTROLADO,"
				+ "		     L.TIPO_TARIFA_LOCACAO, " 
				+ "		     A.KM_AUTOMOVEL"
				+ "	    FROM TB_LOCACAO L"
				+ "      INNER JOIN TB_PAGAMENTO P"
				+ "         ON P.ID_LOCACAO = L.ID_LOCACAO"
				+ "      INNER JOIN TB_AUTOMOVEL A"
				+ "         ON A.ID_AUTOMOVEL = L.ID_AUTOMOVEL"
				+ "   WHERE L.ID_LOCACAO = " + numeroLocacao;

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		DevolucaoTO devTO = new DevolucaoTO();

		try {

			conn = ConexaoBD.conectar();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {

				Devolucao devolucao = new Devolucao();
				devolucao.setDataDevolucaoCliente(rs.getString(1));
				devolucao.setLocalDevolucao(rs.getString(2));
				devolucao.setAgenciaDevolucao(rs.getInt(3));
				devolucao.setNumeroLocacaoAutomovel(rs.getInt(4));
				devTO.add(devolucao);

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

		return devTO;
	}

	public boolean inserirDevolucao(Devolucao devolver) {
		
		String sql = "INSERT INTO TB_DEVOLUCAO" 
				+"	 ("
		        + "	   DATA_DEVOLUCAO_LOCACAO,"
				+ "    LOCAL_DEVOLUCAO_LOCACAO,"
		        + "    AGENCIA_DEVOLUCAO,"
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
			pst.setString(1,devolver.getDataDevolucaoCliente());
			pst.setString(2, devolver.getLocalDevolucao());
			pst.setInt(3, devolver.getAgenciaDevolucao());
			pst.setInt(4, devolver.getNumeroLocacaoAutomovel());
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
