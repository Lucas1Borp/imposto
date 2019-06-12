package entities;

public class PessoaFisica extends Contribuinte {

	private Double saude;

	public PessoaFisica(String nome, Double rendaAtual, Double saude) {
		super(nome, rendaAtual);
		this.saude = saude;
	}

	public Double getSaude() {
		return saude;
	}

	public void setSaude(Double saude) {
		this.saude = saude;
	}

	@Override
	public double taxaImp() {
		if (getRendaAtual() <= 2000.0) {
			return getRendaAtual() * 0.15 - saude * 0.5;
		} else {
			return getRendaAtual() * 0.25 - saude * 0.5;
		}
	}

}
