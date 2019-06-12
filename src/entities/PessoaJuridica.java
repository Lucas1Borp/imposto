package entities;

public class PessoaJuridica extends Contribuinte {

	private Integer numFunc;

	public PessoaJuridica(String nome, Double rendaAtual, Integer numFunc) {
		super(nome, rendaAtual);
		this.numFunc = numFunc;
	}

	public Integer getNumFunc() {
		return numFunc;
	}

	public void setNumFunc(Integer numFunc) {
		this.numFunc = numFunc;
	}

	@Override
	public double taxaImp() {
		if (numFunc > 10) {
			return getRendaAtual() * 0.14;
		} else {
			return getRendaAtual() * 0.16;
		}
	
	}

}
