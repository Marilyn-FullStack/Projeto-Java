package conta.model;

public class ContaPoupanca extends Conta {

	private int aniversario;

	public ContaPoupanca(String titular, int agencia, int tipo, int numero, float saldo, int aniversario) {
		super(titular, agencia, tipo, numero, saldo);
	}

	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("|*****************************************************|");
		System.out.printf("|              Aniversario da conta dia: %d \n", this.getAniversario());
		System.out.println("|*****************************************************|");
		
	}
}
