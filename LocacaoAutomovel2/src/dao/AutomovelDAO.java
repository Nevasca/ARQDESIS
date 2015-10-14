package dao;

import model.Automovel;
import java.sql.*;
import to.AutomovelTO;

public class AutomovelDAO 
{
	public boolean cadastrar(Automovel auto)
	{
		String sql = "INSERT INTO tb_automovel (GRUPO_AUTOMOVEL, ACESSORIOS_AUTOMOVEL, NUM_CHASSI_AUTOMOVEL, "
				+ "NUM_PLACA_AUTOMOVEL, CIDADE_AUTOMOVEL, UF_AUTOMOVEL, KM_AUTOMOVEL, MODELO_AUTOMOVEL, "
				+ "FABRICANTE_AUTOMOVEL, TARIFA_AUTOMOVEL, TARIFA_KM_CONTROLADO) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement ps = null;
		boolean cadastrou = false;
		
		try
		{
			conn = ConexaoBD.conectar();
			ps = conn.prepareStatement(sql);
			ps.setString(1,auto.getGrupo());
			ps.setInt(2, auto.getAcessorio());
			ps.setString(3, auto.getChassi());
			ps.setString(4, auto.getPlaca());
			ps.setString(5, auto.getCidade());
			ps.setString(6, auto.getUf());
			ps.setDouble(7, auto.getQuilometragem());
			ps.setString(8, auto.getModelo());
			ps.setString(9, auto.getFabricante());
			ps.setDouble(10, auto.getTarifa());
			ps.setDouble(11, auto.getTarifaControlada());
			
			ps.execute();
			cadastrou = true;
			
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
			
		return cadastrou;
	}
	
	
	//Consulta mais detalhada, com opcões de filtro. Retorna mais automóveis
	public AutomovelTO consultar(Automovel auto)
	{
		//Strings auxiliares para formar a query de consulta e atribui null para as comparações
		String sqlWhere = "";
		String sqlModelo = "";
		String sqlPlaca = "", sqlAndPlaca = "";
		String sqlChassi = "", sqlAndChassi = "";
		String sqlFabricante = "", sqlAndFabricante = "";
		String sqlCidade = "", sqlAndCidade = "";
		String sqlUf = "", sqlAndUf = "";
		String sqlGrupo = "", sqlAndGrupo = "";
		String sqlAcessorio = "", sqlAndAcessorio = "";		
		
		//Vê quais campos foram preenchidos e vai criando a query com os filtros
		if(auto.getModelo().length() != 0)
		{
			sqlModelo = "MODELO_AUTOMOVEL LIKE '%" + auto.getModelo() + "%'";
			sqlWhere = " WHERE ";
		}
		
		if(auto.getPlaca().length() != 0)
		{
			sqlPlaca = "NUM_PLACA_AUTOMOVEL = '" + auto.getPlaca() + "'";
			sqlWhere = " WHERE ";
			
			//Verifica se é preciso colocar um AND antes desse filtro
			if(sqlModelo.length() != 0)
			{
				sqlAndPlaca = " AND ";
			}
		}
	
		if(auto.getChassi().length() != 0)
		{
			sqlChassi = "NUM_CHASSI_AUTOMOVEL = '" + auto.getChassi() + "'";
			sqlWhere = " WHERE ";
			
			if(sqlModelo.length() != 0 || sqlPlaca.length() != 0)
			{
				sqlAndChassi = " AND ";
			}
		}
	
		if(auto.getFabricante().length() != 0)
		{
			sqlFabricante = "FABRICANTE_AUTOMOVEL LIKE '%" + auto.getFabricante() + "%'";
			sqlWhere = " WHERE ";
			
			if(sqlModelo.length() != 0 || sqlPlaca.length() != 0 || sqlChassi.length() != 0)
			{
				sqlAndFabricante = " AND ";
			}
		}
		
		if(auto.getCidade().length() != 0)
		{
			sqlCidade = "CIDADE_AUTOMOVEL LIKE '%" + auto.getCidade() + "%'";
			sqlWhere = " WHERE ";
			
			if(sqlModelo.length() != 0 || sqlPlaca.length() != 0|| sqlChassi.length() != 0 || sqlFabricante.length() != 0)
			{
				sqlAndCidade = " AND ";
			}
		}
		
		if(auto.getUf() != null)
		{
			sqlUf = "UF_AUTOMOVEL = '" + auto.getUf() + "'";
			sqlWhere = " WHERE ";
			
			if(sqlModelo.length() != 0 || sqlPlaca.length() != 0 || sqlChassi.length() != 0 || sqlFabricante.length() != 0 || sqlCidade.length() != 0)
			{
				sqlAndUf = " AND ";
			}
		}
		
		if(auto.getGrupo() != null)
		{
			sqlGrupo = "GRUPO_AUTOMOVEL = '" + auto.getGrupo() + "'";
			sqlWhere = " WHERE ";
			
			if(sqlModelo.length() != 0 || sqlPlaca.length() != 0 || sqlChassi.length() != 0 || sqlFabricante.length() != 0 || sqlCidade.length() != 0 || 
					sqlUf.length() != 0)
			{
				sqlAndGrupo = " AND ";
			}
		}
		
		if(auto.getAcessorio() != 0)
		{
			sqlAcessorio = "ACESSORIOS_AUTOMOVEL = " + auto.getAcessorio();
			sqlWhere = " WHERE ";
			
			if(sqlModelo.length() != 0 || sqlPlaca.length() != 0 || sqlChassi.length() != 0 || sqlFabricante.length() != 0 || sqlCidade.length() != 0 || 
					sqlUf.length() != 0 || sqlGrupo.length() != 0)
			{
				sqlAndAcessorio = " AND ";
			}
		}
		
		//Where concatenado
		String whereCompleto = "" + sqlWhere + sqlModelo + sqlAndPlaca + sqlPlaca + sqlAndChassi + sqlChassi + sqlAndFabricante;
		whereCompleto += sqlFabricante + sqlAndCidade + sqlCidade + sqlAndUf + sqlUf + sqlAndGrupo + sqlGrupo;
		whereCompleto +=  sqlAndAcessorio + sqlAcessorio;		
		
		
		String sql = "SELECT ID_AUTOMOVEL, GRUPO_AUTOMOVEL, ACESSORIOS_AUTOMOVEL, NUM_CHASSI_AUTOMOVEL, "
				+ "NUM_PLACA_AUTOMOVEL, CIDADE_AUTOMOVEL, UF_AUTOMOVEL, KM_AUTOMOVEL, MODELO_AUTOMOVEL, "
				+ "FABRICANTE_AUTOMOVEL, TARIFA_AUTOMOVEL, TARIFA_KM_CONTROLADO "
				+ "FROM TB_AUTOMOVEL" + whereCompleto;
		
		//System.out.println(sql);
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		AutomovelTO autoTO = new AutomovelTO();
		

		try
		{
			conn = ConexaoBD.conectar();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Automovel autoCon = new Automovel();
				autoCon.setId(rs.getInt(1));
				autoCon.setGrupo(rs.getString(2));
				autoCon.setAcessorio(rs.getInt(3));
				autoCon.setChassi(rs.getString(4));
				autoCon.setPlaca(rs.getString(5));
				autoCon.setCidade(rs.getString(6));
				autoCon.setUf(rs.getString(7));
				autoCon.setQuilometragem(rs.getDouble(8));
				autoCon.setModelo(rs.getString(9));
				autoCon.setFabricante(rs.getString(10));
				autoCon.setTarifa(rs.getDouble(11));
				autoCon.setTarifaControlada(rs.getDouble(12));
				autoTO.addAutomovel(autoCon);
			}
			
		}
		catch(SQLException sqe)
		{
			sqe.printStackTrace();
		}
		finally 
		{	
			if(rs != null)
			{
				try{
					rs.close();
				} catch(SQLException sqe){
					sqe.printStackTrace();
				}
			}
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
		
		return autoTO;
		
	}
	
	//Consulta por ID e retorna um único automóvel
	public Automovel consultarPorId(Automovel auto)
	{
		String sql = "SELECT ID_AUTOMOVEL, GRUPO_AUTOMOVEL, ACESSORIOS_AUTOMOVEL, NUM_CHASSI_AUTOMOVEL, "
				+ "NUM_PLACA_AUTOMOVEL, CIDADE_AUTOMOVEL, UF_AUTOMOVEL, KM_AUTOMOVEL, MODELO_AUTOMOVEL, "
				+ "FABRICANTE_AUTOMOVEL, TARIFA_AUTOMOVEL, TARIFA_KM_CONTROLADO "
				+ "FROM TB_AUTOMOVEL WHERE ID_AUTOMOVEL = ?";
		
		//System.out.println(sql);
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try
		{
			conn = ConexaoBD.conectar();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, auto.getId());
			rs = ps.executeQuery();
			
			//Se existir um automovel com esse id, completar com os outros dados
			if(rs.next())
			{
				auto.setGrupo(rs.getString(2));
				auto.setAcessorio(rs.getInt(3));
				auto.setChassi(rs.getString(4));
				auto.setPlaca(rs.getString(5));
				auto.setCidade(rs.getString(6));
				auto.setUf(rs.getString(7));
				auto.setQuilometragem(rs.getDouble(8));
				auto.setModelo(rs.getString(9));
				auto.setFabricante(rs.getString(10));
				auto.setTarifa(rs.getDouble(11));
				auto.setTarifaControlada(rs.getDouble(12));
			}
			//Se não existir, retornar null
			else
			{
				auto = null;
			}
			
		}
		catch(SQLException sqe)
		{
			sqe.printStackTrace();
		}
		finally 
		{	
			if(rs != null)
			{
				try{
					rs.close();
				} catch(SQLException sqe){
					sqe.printStackTrace();
				}
			}
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

		
		return auto;
	}
	
	//Consulta rápida da barra superior usando como filtro modelo ou fabricante
	public AutomovelTO consultarModelo(Automovel auto)
	{
		//O que fazer se o usuario nao digitou nada no campo?
				
		String sqlWhere = " WHERE MODELO_AUTOMOVEL LIKE '%" + auto.getModelo() + "%' OR "
				+ " FABRICANTE_AUTOMOVEL LIKE '%" + auto.getFabricante() + "%'";		
		
		String sql = "SELECT ID_AUTOMOVEL, GRUPO_AUTOMOVEL, ACESSORIOS_AUTOMOVEL, NUM_CHASSI_AUTOMOVEL, "
				+ "NUM_PLACA_AUTOMOVEL, CIDADE_AUTOMOVEL, UF_AUTOMOVEL, KM_AUTOMOVEL, MODELO_AUTOMOVEL, "
				+ "FABRICANTE_AUTOMOVEL, TARIFA_AUTOMOVEL, TARIFA_KM_CONTROLADO "
				+ "FROM TB_AUTOMOVEL" + sqlWhere;		
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		AutomovelTO autoTO = new AutomovelTO();
		

		try
		{
			conn = ConexaoBD.conectar();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Automovel autoCon = new Automovel();
				autoCon.setId(rs.getInt(1));
				autoCon.setGrupo(rs.getString(2));
				autoCon.setAcessorio(rs.getInt(3));
				autoCon.setChassi(rs.getString(4));
				autoCon.setPlaca(rs.getString(5));
				autoCon.setCidade(rs.getString(6));
				autoCon.setUf(rs.getString(7));
				autoCon.setQuilometragem(rs.getDouble(8));
				autoCon.setModelo(rs.getString(9));
				autoCon.setFabricante(rs.getString(10));
				autoCon.setTarifa(rs.getDouble(11));
				autoCon.setTarifaControlada(rs.getDouble(12));
				autoTO.addAutomovel(autoCon);
			}
			
		}
		catch(SQLException sqe)
		{
			sqe.printStackTrace();
		}
		finally 
		{	
			if(rs != null)
			{
				try{
					rs.close();
				} catch(SQLException sqe){
					sqe.printStackTrace();
				}
			}
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
		
		return autoTO;
		
	}
	
	public boolean alterar(Automovel auto)
	{
		String sql = "UPDATE tb_automovel SET GRUPO_AUTOMOVEL = ?, ACESSORIOS_AUTOMOVEL = ?, NUM_CHASSI_AUTOMOVEL = ?, "
				+ "NUM_PLACA_AUTOMOVEL = ?, CIDADE_AUTOMOVEL = ?, UF_AUTOMOVEL = ?, KM_AUTOMOVEL = ?, MODELO_AUTOMOVEL = ?, "
				+ "FABRICANTE_AUTOMOVEL = ?, TARIFA_AUTOMOVEL = ?, TARIFA_KM_CONTROLADO = ? "
				+ "WHERE ID_AUTOMOVEL = ?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		boolean alterou = false;
		
		try
		{
			conn = ConexaoBD.conectar();
			ps = conn.prepareStatement(sql);
			ps.setString(1,auto.getGrupo());
			ps.setInt(2, auto.getAcessorio());
			ps.setString(3, auto.getChassi());
			ps.setString(4, auto.getPlaca());
			ps.setString(5, auto.getCidade());
			ps.setString(6, auto.getUf());
			ps.setDouble(7, auto.getQuilometragem());
			ps.setString(8, auto.getModelo());
			ps.setString(9, auto.getFabricante());
			ps.setDouble(10, auto.getTarifa());
			ps.setDouble(11, auto.getTarifaControlada());
			ps.setInt(12, auto.getId());
			
			ps.execute();
			alterou = true;
			
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
		return alterou;
	}
	
	
	//Fazer alterações posteriormente para tratar possibilidade do automovel estar ou esteve alocado
	public boolean excluir(Automovel auto)
	{
		String sql = "DELETE FROM tb_automovel WHERE ID_AUTOMOVEL = ?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		boolean deletou = false;
		
		try
		{
			conn = ConexaoBD.conectar();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,auto.getId());			
			
			ps.execute();
			deletou = true;
			
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
			
		return deletou;
	}
	

}
