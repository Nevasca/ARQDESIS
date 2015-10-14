package model;

import java.util.Date;
import dao.*;

public class Locacao 
{
	private int id;
	private Date dataLocacao;
	private Date dataDevolucao;
	private String agenciaLocacao;
	private String agenciaDevolucao;
	private String cidadeLocacao;
	private String cidadeDevolucao;
	private int tipoTarifa;
	private Cliente cliente;
	private Automovel automovel;
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public Date getDataLocacao() 
	{
		return dataLocacao;
	}
	
	public void setDataLocacao(Date dataLocacao) 
	{
		this.dataLocacao = dataLocacao;
	}
	
	public Date getDataDevolucao() 
	{
		return dataDevolucao;
	}
	
	public void setDataDevolucao(Date dataDevolucao) 
	{
		this.dataDevolucao = dataDevolucao;
	}
	
	public String getAgenciaLocacao() 
	{
		return agenciaLocacao;
	}
	
	public void setAgenciaLocacao(String agenciaLocacao) 
	{
		this.agenciaLocacao = agenciaLocacao;
	}
	
	public String getAgenciaDevolucao() 
	{
		return agenciaDevolucao;
	}
	
	public void setAgenciaDevolucao(String agenciaDevolucao) 
	{
		this.agenciaDevolucao = agenciaDevolucao;
	}
	
	public String getCidadeLocacao() 
	{
		return cidadeLocacao;
	}

	public void setCidadeLocacao(String cidadeLocacao) 
	{
		this.cidadeLocacao = cidadeLocacao;
	}

	public String getCidadeDevolucao() 
	{
		return cidadeDevolucao;
	}

	public void setCidadeDevolucao(String cidadeDevolucao) 
	{
		this.cidadeDevolucao = cidadeDevolucao;
	}

	public int getTipoTarifa() 
	{
		return tipoTarifa;
	}
	
	public void setTipoTarifa(int tipoTarifa) 
	{
		this.tipoTarifa = tipoTarifa;
	}
	
	public Cliente getCliente() 
	{
		return cliente;
	}
	
	public void setCliente(Cliente cliente) 
	{
		this.cliente = cliente;
	}
	
	public Automovel getAutomovel() 
	{
		return automovel;
	}
	
	public void setAutomovel(Automovel automovel) 
	{
		this.automovel = automovel;
	}
	
	public boolean inserirLocacao()
	{
		LocacaoDAO locDAO = new LocacaoDAO();
		return locDAO.inserirLocacao(this);
	}
	
}
