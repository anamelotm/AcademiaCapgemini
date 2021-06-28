package entities;

public class Calculadora {
	
	private Double valorInvestido;

	public Calculadora(Double valorInvestido) {
		this.valorInvestido = valorInvestido;
	}

	public Double getValorInvestido() {
		return valorInvestido;
	}

	public void setValorInvestido(Double valorInvestido) {
		this.valorInvestido = valorInvestido;
	}
	
	public Integer totalVisualizacoes() {
		return (int) (valorInvestido * 30 * 4 * 0.72);
	}

}
