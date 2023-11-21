package conta.model;

public class ContaCorrente extends Conta {

	// ADD ATRIBUTO ESPECIFICO DA CLASSE
	private float limite;

	public ContaCorrente(String titular, int agencia, int tipo, int numero, float saldo, float limite) {
		super(titular, agencia, tipo, numero, saldo);

		this.limite = limite;
	}

	public float getLimite() {

		// SALDO NEGATIVO ATUALIZA O LIMITE
		if (this.getSaldo() < 0)
			return this.limite - Math.abs(this.getSaldo());

		return limite;

	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	@Override
	public boolean sacar(float valor) {

		if (this.getSaldo() + this.getLimite() < valor) {
			return false;
		}

		this.setSaldo(this.getSaldo() - valor);

		return true;
	}

	// METODOS ESPECIFICOS
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.printf("|              Saldo Insuficiente %.2f R$            \n", this.getLimite());
	}
}