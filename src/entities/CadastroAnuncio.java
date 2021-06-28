package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import exceptions.DomainException;

public class CadastroAnuncio {
	
	private String nomeDoAnuncio;
	private String cliente;
	private Date dataDeInicio;
	private Date dataDeTermino;
	private Double investimentoPorDia;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public CadastroAnuncio(String nomeDoAnuncio, String cliente, Date dataDeInicio, Date dataDeTermino,
			Double investimentoPorDia) {
		if (!dataDeTermino.after(dataDeInicio)) {
			throw new DomainException ("Erro: data de término anterior à data de início");
		}
		this.nomeDoAnuncio = nomeDoAnuncio;
		this.cliente = cliente;
		this.dataDeInicio = dataDeInicio;
		this.dataDeTermino = dataDeTermino;
		this.investimentoPorDia = investimentoPorDia;
	}

	public String getNomeDoAnuncio() {
		return nomeDoAnuncio;
	}

	public void setNomeDoAnuncio(String nomeDoAnuncio) {
		this.nomeDoAnuncio = nomeDoAnuncio;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Date getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(Date dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

	public Date getDataDeTermino() {
		return dataDeTermino;
	}

	public void setDataDeTermino(Date dataDeTermino) {
		this.dataDeTermino = dataDeTermino;
	}

	public Double getInvestimentoPorDia() {
		return investimentoPorDia;
	}

	public void setInvestimentoPorDia(Double investimentoPorDia) {
		this.investimentoPorDia = investimentoPorDia;
	}
	
	public double valorTotalInvestido() {
		long diff = dataDeTermino.getTime() - dataDeInicio.getTime();
		TimeUnit time = TimeUnit.DAYS;
		long difference = time.convert(diff, TimeUnit.MILLISECONDS);
		return investimentoPorDia*difference;
	}
	
	public int maxVisualizacoes() {
		Calculadora calc = new Calculadora(investimentoPorDia);
		return calc.totalVisualizacoes();
	}
	
	public int maxCliques() {
		return (int)(investimentoPorDia*30*4*0.12);
	}
	
	public int maxCompartilhamento() {
		return (int)(investimentoPorDia*30*4*0.12*0.15);
	}
	
	@Override
	public String toString() {
		return "Valor total investido: R$ " 
				+ String.format("%.2f", valorTotalInvestido())
				+ "\n Quantidade máxima de visualizações: "
				+ maxVisualizacoes()
				+ "\n Quantidade máxima de cliques: "
				+ maxCliques()
				+ "\n Quantidade máxima de compartilhamentos: "
				+ maxCompartilhamento();
	}
	
	

}
