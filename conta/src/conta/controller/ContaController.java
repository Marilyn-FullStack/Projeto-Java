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

		System.out.println("|*****************************************************|");
		System.out.println("|     Conta número: " + conta.getNumero() + "criada com sucesso!");
		System.out.println("|*****************************************************|");
		
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
		System.out.println("|*****************************************************|");
		System.out.println("|     Conta número: " + conta.getNumero() + "atualizada!");
		System.out.println("|*****************************************************|");
		
	}else 
			System.out.println("|*****************************************************|");
			System.out.println("|     Conta número: " + conta.getNumero() + " não encontrada!");
			System.out.println("|*****************************************************|");
	}	


	//METODOS BANCARIOS
	@Override
	public void deletar(int numero) {
		
	}

	@Override
	public void sacar(int numero, float valor) {
		
	}

	@Override
	public void depositar(int numero, float valor) {
		
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
