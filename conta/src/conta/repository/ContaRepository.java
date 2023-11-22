package conta.repository;

import conta.model.Conta;

public interface ContaRepository {

	
	// CRUD DA CONTA
	public void procurarPorNumero(int numero);

	public void listarTodas();

	public void cadastrar(Conta conta);

	public void atualizar(Conta conta);

	public void deletar(int numero);
	

	// M�TODOS BANCARIOS
	public void sacar(int numero, float valor);

	public void depositar(int numero, float valor);

	public void transferir(int numeroOrigen, int numeroDestino, float valor);

}
