package conta.model;

public class ContaCorrente extends Conta {


    private float limite;

	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}

	// ADD ATRIBUTO ESPECIFICO DA CLASSE

	public float getLimite() {

		// SALDO SE NEGATIVO ATUALIZA O LIMITE
		if (this.getSaldo() < 0)
			return this.limite - Math.abs(this.getSaldo());

		return limite;

	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	@Override
	public boolean sacar(float valor) {
        if (valor > 0 && valor <= (this.getSaldo() + this.getLimite())) {
            this.setSaldo(this.getSaldo() - valor);
            if (this.getSaldo() < 0) {
                this.setLimite(this.getLimite() + this.getSaldo());
                this.setSaldo(0);
            }
            return true;
        } else {
            return false; 
        }
    }

    public void depositar(float valor) {
        if (valor > 0) {
            if (this.getSaldo() < 0) {
                this.setLimite(this.getLimite() + Math.abs(this.getSaldo()));
                this.setSaldo(0);
            }
            this.setSaldo(this.getSaldo() + valor);
        }
    }

	// METODOS ESPECIFICOS
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("|*****************************************************|");
		System.out.printf("|              Saldo Insuficiente %.2f R$ \n", this.getLimite());
		System.out.println("|*****************************************************|");
	}
}