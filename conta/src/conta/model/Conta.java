package conta.model;

public class Conta {

	//ATRIBUTOS DA CLASSE
	private String titular;
	private int agencia;
	private int tipo;
	private int numero;
	private float saldo;

	//MÉTODO CONSTRUTOR
	public Conta(String titular, int agencia, int tipo, int numero, float saldo) {
		this.titular = titular;
		this.agencia = agencia;
		this.tipo = tipo;
		this.numero = numero;
		this.saldo = saldo;
	}

	//METODOS METODOS DE ACESSO E MODIFICAÇÃO
	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public boolean sacar(float valor) {
		if (this.getSaldo() < valor) {
			System.out.println("|              Saldo Insuficiente                  |\n");
			return false;

		}

		this.setSaldo(this.getSaldo() - valor);
		return true;
	}

	public void depositar(float valor) {

		this.setSaldo(this.getSaldo() + valor);

	}

	public void visualizar() {
		String tipo = "";

		switch (this.tipo) {
		case 1:
			tipo = "Conta Corrente";
			break;
		case 2:
			tipo = "Conta Poupança";
			break;
		}

		System.out.println("|*****************************************************|");
		System.out.println("|                    Dados da Conta                   |");
		System.out.println("|*****************************************************|");
		System.out.println("|    Titular:	" + this.titular);
		System.out.println("|    Tipo da conta:	" + tipo);
		System.out.println("|    Numero da Conta:	" + this.numero);
		System.out.println("|    Agencia:	" + this.agencia);
		System.out.printf("|    Saldo: %.2f R$", this.saldo);
		System.out.println("\n|*****************************************************|");

	}
}
