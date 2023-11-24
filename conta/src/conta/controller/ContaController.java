package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository{

	//GUARDAR OBJETOS DA CLASSE
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;
	
	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null)
			conta.visualizar();
		else
			System.out.println("|*****************************************************|");
		System.out.println("|     Conta número:" + numero + " não encontrada");
		System.out.println("|*****************************************************|");

			System.out.println(" ");
		
	}

	@Override
	public void listarTodas() {
		for(var conta : listaContas) {
			conta.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("|*****************************************************|");
		System.out.println(" Conta número: " + conta.getNumero() + " criada com sucesso!");
		System.out.println("|*****************************************************|");
		
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if(buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta),  conta);
			System.out.println(" Conta numero: " + conta.getNumero() + " foi atualizada com sucesso!");
		}else {
			System.out.println(" Conta numero: " + conta.getNumero() + " não foi encontrada!");
		}
		
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(listaContas.remove(conta) == true) {
				System.out.println("|*****************************************************|");
				System.out.println(" Conta numero: " + numero + "deletada com sucesso!");
				System.out.println("|*****************************************************|");
			}else {
				System.out.println("|*****************************************************|");
				System.out.println("   Conta numero: " + numero + "não foi encontrada!");
				System.out.println("|*****************************************************|");
			}
		}
		
	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(conta.sacar(valor) == true) {
				System.out.println("|*****************************************************|");
				System.out.println(" Saque na Conta numero: " + numero + " efetuado com sucesso!");
				System.out.println("|*****************************************************|");
			} 
		}else {
			System.out.println("|*****************************************************|");
			System.out.println("   Conta numero: " + numero + " não foi encontrada!");
			System.out.println("|*****************************************************|");
		}
		
	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			conta.depositar(valor);
			System.out.println("|*****************************************************|");
			System.out.println(" Depósito na Conta número: " + numero + " feito com sucesso!");
			System.out.println("|*****************************************************|");
		}else {
			System.out.println("|*****************************************************|");
			System.out.println(" Conta numero: " + numero + " não existe ou não é uma Conta Corrente!");
			System.out.println("|*****************************************************|");
		}
		
	}
	
	

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if(contaOrigem != null && contaDestino != null) {
			
			if(contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.println("|*****************************************************|");
				System.out.println("       Transferência foi efetuada com sucesso!");
				System.out.println("|*****************************************************|");
			}
		}else {
			System.out.println("|*****************************************************|");
			System.out.println("   A Conta Origem ou Destino não foram encontrados!");
			System.out.println("|*****************************************************|");
		}
		
	}
	
	public int gerarNumero() {
		return ++ numero;
	}
	
	public Conta buscarNaCollection(int numero) {
		for(var conta : listaContas) {
			if(conta.getNumero() == numero) {
				return conta;
			}
		}
		
		return null;
	}
	
}