package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

	//GUARDAR OBJETOS DA CLASSE
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;
	
	//ACESS CRUD DA CONTA
	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		if (conta != null)
			conta.visualizar();
		else
			System.out.println("|*****************************************************|");
			System.out.println("|     Conta n�mero: " + conta.getNumero() + " n�o encontrada!");
			System.out.println("|*****************************************************|");
	}

	@Override
	public void listarTodas() {
		for ( var conta : listaContas) {
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);

		System.out.println("|*****************************************************|");
		System.out.println("|     Conta n�mero: " + conta.getNumero() + "criada com sucesso!");
		System.out.println("|*****************************************************|");
		
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
		System.out.println("|*****************************************************|");
		System.out.println("|     Conta n�mero: " + conta.getNumero() + " Atualizada!");
		System.out.println("|*****************************************************|");
		
	}else 
			System.out.println("|*****************************************************|");
			System.out.println("|     Conta n�mero: " + conta.getNumero() + " N�o encontrada!");
			System.out.println("|*****************************************************|");
	}	


	//METODOS BANCARIOS
	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			if (listaContas.remove(conta) == true)
				System.out.println("|*****************************************************|");
			System.out.println("|     Conta n�mero: " + numero + " Deletada com sucesso!");
			System.out.println("|*****************************************************|");
			
		} else 
			System.out.println("|*****************************************************|");
			System.out.println("|     Conta n�mero: " + numero + " N�o encontrada!");
			System.out.println("|*****************************************************|");
			
		
	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
				System.out.println("|*****************************************************|");
			System.out.println("|     Saque na conta: " + numero + " Realizado com sucesso!");
			System.out.println("|*****************************************************|");
		} else 
			System.out.println("|*****************************************************|");
		System.out.println("|     Conta n�mero: " + numero + " N�o foi encontrada!");
		System.out.println("|*****************************************************|");
		}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			conta.depositar(valor);
			System.out.println("|*****************************************************|");
			System.out.println("|     Deposito na conta: " + numero + " Realizado com sucesso!");
			System.out.println("|*****************************************************|");
			
		} else 
			System.out.println("|*****************************************************|");
			System.out.println("|     Conta: " + numero + " n�o encontrada!");
			System.out.println("|*****************************************************|");
		
	}

	@Override
	public void transferir(int numeroOrigen, int numeroDestino, float valor) {
		
	}
	
	
	//METODOS AUXILIARES
	public int gerrarNumero() {
		return ++ numero;
	}
	
	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}

	public int gerarNumero() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
