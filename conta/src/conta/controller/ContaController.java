package conta.controller;

import java.util.ArrayList;
import java.util.Optional;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository{

	//GUARDAR OBJETOS DA CLASSE
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;
	
	@Override
	public void procurarPorNumero(int numero) {
		
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent())
			conta.get().visualizar();
		
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

		Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());

		if (buscaConta.isPresent()) {
			listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
			System.out.println("A conta número: " + conta.getNumero() + " foi Alterada com sucesso.");
		} else {
			System.out.println("A conta número: " + conta.getNumero() + " não foi encontrada.");
		}

	}

	@Override
	public void deletar(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent()) {
			if(listaContas.remove(conta.get()) == true) {
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
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent()) {
			if(conta.get().sacar(valor) == true) {
				System.out.println("\nO Saque na Conta numero: " + numero + "foi efetuado com sucesso!");
			} 
		}else {
			System.out.println("\nA Conta numero: " + numero + " não foi encontrada!");
		}
		
	}

		


	@Override 
	public void depositar(int numero, float valor) {
	Optional<Conta> conta = buscarNaCollection(numero);

	if (conta.isPresent()) {
		conta.get().depositar(valor);
		System.out.println("o deposito na conta: " + numero + " foi efetuado com sucesso!");
		System.out.println("|*****************************************************|");
		System.out.println(" Depósito na Conta número: " + numero + " feito com sucesso!");
		System.out.println("|*****************************************************|");
	}
	}
	
	

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		Optional<Conta> contaOrigem = buscarNaCollection(numeroOrigem);
		Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);

		if (contaOrigem.isPresent() && contaDestino.isPresent())
			if (contaOrigem.get().sacar(valor) == true) {
				contaDestino.get().depositar(valor);
				System.out.println("a transferir foi efetuado com sucesso!");
			}
			else

			System.out.println("|*****************************************************|");
			System.out.println("       Transferência foi efetuada com sucesso!");
			System.out.println("|*****************************************************|");}
	
			
	public int gerarNumero() {
		return ++ numero;
	}
	
	public Optional<Conta> buscarNaCollection(int numero) {
		for(var conta : listaContas) {
			if(conta.getNumero() == numero) 
				return  Optional.of(conta);
			
			return Optional.empty();
		}
		
		return null;
	}
	
}