package model;

import dao.AutomovelDAO;

public class Automovel 
{
	
	private int id;
	private String grupo;
	private int acessorio;
	private String chassi;
	private String placa;
	private String cidade;
	private String uf;
	private double quilometragem;
	private String modelo;
	private String fabricante;
	private double tarifa;
	private double tarifaControlada;
	
	public Automovel()
	{
	
	}
	
	//Getters e Setters ------------------------------------------------------------------
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getGrupo() 
	{
		return grupo;
	}

	public void setGrupo(String grupo) 
	{
		this.grupo = grupo;
	}

	public int getAcessorio() 
	{
		return acessorio;
	}

	public void setAcessorio(int acessorio) 
	{
		this.acessorio = acessorio;
	}

	public String getChassi() 
	{
		return chassi;
	}

	public void setChassi(String chassi) 
	{
		this.chassi = chassi;
	}

	public String getPlaca() 
	{
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() 
	{
		return uf;
	}

	public void setUf(String uf) 
	{
		this.uf = uf;
	}

	public double getQuilometragem() 
	{
		return quilometragem;
	}

	public void setQuilometragem(double quilometragem) 
	{
		this.quilometragem = quilometragem;
	}

	public String getModelo() 
	{
		return modelo;
	}

	public void setModelo(String modelo) 
	{
		this.modelo = modelo;
	}

	public String getFabricante() 
	{
		return fabricante;
	}

	public void setFabricante(String fabricante) 
	{
		this.fabricante = fabricante;
	}

	public double getTarifa() 
	{
		return tarifa;
	}

	public void setTarifa(double tarifa) 
	{
		this.tarifa = tarifa;
	}

	public double getTarifaControlada() 
	{
		return tarifaControlada;
	}

	public void setTarifaControlada(double tarifaControlada) 
	{
		this.tarifaControlada = tarifaControlada;
	}
	//Fim dos Getters e Setters
	
	//M�todo que retorna o nome do grupo de acordo com sua letra
	public String getNomeGrupo()
	{
		String nome = null;
		
		switch(grupo)
		{
			case "A":
				nome = grupo + " - Econ�mico";
				break;
			case "C":
				nome = grupo + " - Econ�mico com Ar";
				break;
			case "F":
				nome = grupo + " - Intermedi�rio";
				break;
			case "G":
				nome = grupo + " - Intermedi�rio Wagon Especial";
				break;
			case "H":
				nome = grupo + " - Executivo";
				break;
			case "I":
				nome = grupo + " - Utilit�rio";
				break;
			case "K":
				nome = grupo + " - Executivo Luxo";
				break;
			case "M":
				nome = grupo + " - Intermedi�rio Wagon";
				break;
			case "N":
				nome = grupo + " - Pick-up";
				break;
			case "P":
				nome = grupo + " - 4 x 4 Especial";
				break;
			case "R":
				nome = grupo + " - Minivan";
				break;
			case "U":
				nome = grupo + " - Furg�o";
				break;
			case "Y":
				nome = grupo + " - Blindado";
				break;
			default:
				nome = "Grupo desconhecido";
				break;
		}
		
		return nome;
	}
	
	//Metodo que retorna o nome do acess�rio de acordo com o cod
	public String getNomeAcessorio()
	{
		String nome = null;
			
			switch(acessorio)
			{
				case 0:
					nome = "N�o selecionado";
					break;
				case 1:
					nome = "Navegador GPS";
					break;
				case 2:
					nome = "Cadeira de Beb�";
					break;
				case 3:
					nome = "Motorista";
					break;
				default:
					nome = "Acess�rio desconhecido";
					break;
			}
			
		return nome;
	}
	//M�todo que chama a AutomovelDAO para cadastrar no banco de dados
	public boolean cadastrar()
	{
		AutomovelDAO autoDAO = new AutomovelDAO();
		
		//Tenta cadastrar e retorna se obteve sucesso ou n�o
		return autoDAO.cadastrar(this);
	}
	
	public Automovel consultarPorId()
	{
		AutomovelDAO autoDAO = new AutomovelDAO();
		
		return autoDAO.consultarPorId(this);
	}
	
	public boolean alterar()
	{
		AutomovelDAO autoDAO = new AutomovelDAO();
		
		//Tenta alterar e retorna se obteve sucesso ou n�o
		return autoDAO.alterar(this);
	}
	
	public boolean excluir()
	{
		AutomovelDAO autoDAO = new AutomovelDAO();
		
		//Tenta excluir e retorna se obteve sucesso ou n�o
		return autoDAO.excluir(this);
	}
}
