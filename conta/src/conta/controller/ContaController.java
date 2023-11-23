package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;
import conta.util.Cores;

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
			System.out.println("|     Conta número: " + conta.getNumero() + " não encontrada!");
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
		System.out.println("|     Conta número: " + conta.getNumero() + "criada com sucesso!");
		System.out.println("|*****************************************************|");
		
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
		System.out.println("|     Atualozação da conta: " + conta.getNumero());
		System.out.println("|*****************************************************|");
		
	}else 
			System.out.println("|     Não existe a conta número: " + conta.getNumero());
			System.out.println("|*****************************************************|");
	}	


	//METODOS BANCARIOS
	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			if (listaContas.remove(conta) == true)
			System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT +
					"|     Conta número: " + numero + " Deletada com sucesso!");
			System.out.println("|*****************************************************|");
			
		} else 
			System.out.println(Cores.TEXT_RED_BRIGHT +
					"|*****************************************************|");
			System.out.println("|     Conta número: " + numero + " Não encontrada!");
			System.out.println("|*****************************************************|" + Cores.TEXT_RESET);
			
		
	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			
			if (conta.sacar(valor) == true);
				System.out.println("|*****************************************************|");
			System.out.println("|     Saque na conta: " + numero + " Realizado com sucesso!");
			System.out.println("|*****************************************************|");
		} else 
			System.out.println("|*****************************************************|");
		System.out.println("|     Conta número: " + numero + " Não foi encontrada!");
		System.out.println("|*****************************************************|");
		}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			conta.depositar(valor);
			System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT +
					"|*****************************************************|");
			System.out.println("|     Deposito na conta: " + numero + " Realizado com sucesso!");
			System.out.println("|*****************************************************|" + Cores.TEXT_RESET);
			
		} else 
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + 
					"|*****************************************************|");
			System.out.println("|     Conta: " + numero + " não encontrada ou não existe!");
			System.out.println("|*****************************************************|" + Cores.TEXT_RESET);
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if (contaOrigem != null && contaDestino != null) {
			
			if (contaOrigem.sacar(valor) == true) {
				
			contaDestino.depositar(valor);
			
			System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT +
					"|*****************************************************|");
			System.out.println("|     Tranferencia realizada com ucesso!              |");
			System.out.println("|*****************************************************|");
			}
			
		} else 
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT +
					"|*****************************************************|");
			System.out.println("|     Conta destino não encontrada!                   |");
			System.out.println("|*****************************************************|" + Cores.TEXT_RESET);
			
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
		return numero;
	}

}
