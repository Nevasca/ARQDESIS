package dao;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import model.*;

public class LocacaoDAO{	   	  
       
   	public boolean inserirLocacao(Locacao loc)
   	{
   	 String sql = "INSERT INTO TB_LOCACAO " +
			   "			(   "+
			   "			    DATA_LOCACAO, " +
			   "				DATA_DEVOLUCAO_LOCACAO,"+
			   "				AGENCIA_LOCACAO,"+
			   "				AGENCIA_DEVOLUCAO_LOCACAO,"+			
			   " 				LOCAL_EMPRESTIMO_LOCACAO,"+
			   "				LOCAL_DEVOLUCAO_LOCACAO, "+
			   "				TIPO_TARIFA_LOCACAO, " +
			   "				ID_CLIENTE , "+
			   "				ID_AUTOMOVEL"+
			   "			) "+
			   "		VALUES" +
			   "		    (" +
			   "			   ?,"+
			   "			   ?,"+
			   "			   ?,"+
			   "			   ?,"+
			   "			   ?,"+
			   "			   ?,"+
			   "			   ?,"+
			   "			   ?,"+
			   "			   ?"+
			   "			)";
   		
   		Connection conn = null;
   		PreparedStatement ps = null;
   		boolean inseriu = false;
   		DateFormat data = new SimpleDateFormat("yyyy-MM-dd hh:mm");
   		
   		try
   		{
   			conn = ConexaoBD.conectar();
   			ps = conn.prepareStatement(sql);
   			ps.setString(1, data.format(loc.getDataLocacao()));
   			ps.setString(2, data.format(loc.getDataDevolucao()));
   			ps.setString(3, loc.getAgenciaLocacao());
   			ps.setString(4, loc.getAgenciaDevolucao());
   			ps.setString(5, loc.getCidadeLocacao());
   			ps.setString(6, loc.getCidadeDevolucao());
   			ps.setInt(7, loc.getTipoTarifa());
   			ps.setInt(8, loc.getCliente().getId());
   			ps.setInt(9, loc.getAutomovel().getId());
   			
   			ps.execute();
   			inseriu = true;
   			
   		}
   		catch(SQLException sqe)
   		{
   			sqe.printStackTrace();
   		}
   		finally 
   		{			
   			if(ps != null)
   			{
   				try
   				{
   					ps.close();
   				} catch(SQLException sqe)
   				{
   					sqe.printStackTrace();
   				}
   			}
   			
   			if(conn != null)
   			{
   				try
   				{
   					ConexaoBD.desconectar(conn);
   				} catch(SQLException sqe)
   				{
   					sqe.printStackTrace();
   				}
   			}
   		}
   			
   		return inseriu;
   	}
   	/*
	   public void inserirLocacao(Automovel automovel, String cpf, EmprestarAutomovel locacao){
		   

		   int idCliente = 0;
		   int idAutomovel = 0;
		   
		   try{
		       
			   conex.conectar();
			   
			   String sql1 = "SELECT ID_CLIENTE " +
			   				 "  FROM TB_CLIENTE " +
			   				 " WHERE NM_CLIENTE ='" + cpf + "'";
			      
			   meuState = Conexao.conex.createStatement();
		       resultSet = meuState.executeQuery(sql1);
		      
		       while(resultSet.next())
		       {
		            idCliente= Integer.parseInt(resultSet.getString(1));
		            
		       }  
		       
		     
		       String sql2 = "SELECT ID_AUTOMOVEL " +
		   				"  FROM TB_AUTOMOVEL " +
		   				" WHERE PLACA_AUTOMOVEL ='" + automovel.getPlacaAutomovel() + "'";
			      
			   meuState = Conexao.conex.createStatement();
		       resultSet = meuState.executeQuery(sql2);
		      
		       while(resultSet.next())
		       {
		            idAutomovel = Integer.parseInt(resultSet.getString(1));
		            
		       }   
		       
		       String sql3 = "INSERT INTO TB_LOCACAO " +
		  			   "			(   "+
		  			   "			    DATA_LOCACAO, " +
		  			   "				DATA_DEVOLUCAO,"+
		  			   " 				LOCAL_EMPRESTIMO_LOCACAO,"+
		  			   "				LOCAL_DEVOLUCAO_LOCACAO "+
		  			   "				TIPO_TARIFA_LOCACAO, " +
		  			   "				ID_CLIENTE , "+
		  			   "				ID_AUTOMOVEL"+
		  			   "			) "+
		  			   "		VALUES" +
		  			   "		    (" +
		  			   "			   ?,"+
		  			   "			   ?,"+
		  			   "			   ?,"+
		  			   "			   ?,"+
		  			   "			   ?,"+
		  			   "			   ?,"+
		  			   "			   ?"+
		  			   "			)";
		      
			   preparedstatement = Conexao.conex.prepareStatement(sql3);
			   preparedstatement.setString(1,locacao.getDataEmprestimoAutomovel());
			   preparedstatement.setString(2,locacao.getDataDevolucaoAutomovel());
			   preparedstatement.setString(3,locacao.getLocalEmprestimoAutomovel());
			   preparedstatement.setString(4,locacao.getLocalDevolucaoAutomovel());
			   preparedstatement.setString(5,locacao.getTipoTaxaEmprestarAutomovel());
			   preparedstatement.setInt(6,idCliente);
			   preparedstatement.setDouble(7,idAutomovel);
			   preparedstatement.executeUpdate();
			   conex.desconectar();
				
		       
		  
		   }catch(Exception ex){
			   ex.printStackTrace();
		   }
		   
		   
	   }
	   
	   public int consultarID(){
		   
		   int idLocacao = 0;
		   
		   try{
		       
			   conex.conectar();
			   
			   String sql = "LAST_INSERT_ID";
			   				
			      
			   meuState = Conexao.conex.createStatement();
		       resultSet = meuState.executeQuery(sql);
		      
		       while(resultSet.next())
		       {
		            idLocacao = Integer.parseInt(resultSet.getString(1));
		       }
					   

		   }catch (SQLException erro) {
			  erro.printStackTrace();
		   }
		   
		   return idLocacao;
	   }
	   */
}