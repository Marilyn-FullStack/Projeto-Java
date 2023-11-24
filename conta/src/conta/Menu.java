package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		String titular;
		int opcao, numero, agencia, tipo, aniversario, numDestino;
		float saldo, limite, valor;
		
		
		//CONTAS TESTE
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 2201, 1, "Luara", 500f, 50.0f);
		contas.cadastrar(cc1);

		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 2202, 1, "Luciano", 1000f, 100.0f);
		contas.cadastrar(cc2);

		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 2303, 2, "Beyoncé", 2000f, 04);
		contas.cadastrar(cp1);

		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 2304, 2, "Édith Piaf", 3000f, 22);
		contas.cadastrar(cp2);

		
		while (true) {

			System.out.println( Cores.TEXT_BLUE_BOLD_BRIGHT +
					"|*****************************************************|");
			System.out.println("|                                                     |");
			System.out.println("|                       LUAR BANCO                    |");
			System.out.println("|                                                     |");
			System.out.println("|*****************************************************|");
			System.out.println("|                                                     |");
			System.out.println("|              1 - Criar Conta                        |");
			System.out.println("|              2 - Lista todas as Contas              |");
			System.out.println("|              3 - Buscar Conta por Numero            |");
			System.out.println("|              4 - Atualizar Dados da Conta           |");
			System.out.println("|              5 - Apagar Conta                       |");
			System.out.println("|              6 - Sacar                              |");
			System.out.println("|              7 - Depositar                          |");
			System.out.println("|              8 - Transferir valores                 |");
			System.out.println("|              9 - Sair                               |");
			System.out.println("|                                                     |");
			System.out.println("|*****************************************************|");
			System.out.println("|             Entre na opção desejada                 |");
			System.out.println("|*****************************************************|");

			// DECISOES DE CADA OPCAO
			try {
				opcao = sc.nextInt();
			} catch (InputMismatchException e) {

				System.out.println("|*****************************************************|");
				System.out.println("|   Digite valores inteiros!                          |");
				System.out.println("|*****************************************************|");
				sc.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println("\n|*****************************************************|");
				System.out.println("|  Luar Banco a boa fase do seu capital começa aqui!  |");
				System.out.println("|*****************************************************|");
				sobre();
				sc.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("|              Criar conta: ");
				
				System.out.println("|              Digite o numero da agencia conta: ");
				agencia = sc.nextInt();
				System.out.println("|              Digite o nome do titular: ");
				sc.skip("\\R?");
				titular = sc.nextLine();

				do {
					System.out.println("|              Digite o tipo da conta (1-CC ou 2-CP: ");
					tipo = sc.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("|              Digite o saldo da conta: ");
				saldo = sc.nextFloat();
				
				switch (tipo) {
				case 1 -> {

					System.out.println("|              Digite o limite de credito: ");
					limite = sc.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("|              Listar todas as contas: ");
					aniversario = sc.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));

					}
				}
		

				keyPress();
				break;

			case 2:
				System.out.println("|*****************************************************|");
				System.out.println("|              Listar todas as contas                 |");
				contas.listarTodas();
				keyPress();
				break;

			case 3:
				System.out.println("|*****************************************************|");
				System.out.println("|              Consultar de dados por numero          |");
				System.out.println("|*****************************************************|");
				numero = sc.nextInt();

				contas.procurarPorNumero(numero);

				keyPress();
				break;

			case 4:
				System.out.println("|*****************************************************|");
				System.out.println("|              Atualizar dados                        |");
				System.out.println("|              Digite o numero da Conta: ");
				numero = sc.nextInt();

				var buscaConta = contas.buscarNaCollection(numero);

				if (buscaConta != null) {

					tipo = buscaConta.getTipo();

					System.out.println("|*****************************************************|");
					System.out.println("|              Digite o numero da Agência: ");
					agencia = sc.nextInt();

					System.out.println("|*****************************************************|");
					System.out.println("|              Digite o nome do titular: ");
					titular = sc.nextLine();

					sc.skip("\\R");
					
					System.out.println("|*****************************************************|");
					System.out.println("|              Digite o saldo da conta:");
					saldo = sc.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.println("|*****************************************************|");
						System.out.println("|              Digite o limite de credito: ");
						limite = sc.nextFloat();
						
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("|*****************************************************|");
						System.out.println("|              Digite o dia do aniversario da conta: ");
						aniversario = sc.nextInt();
						
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("|*****************************************************|");
						System.out.println("|              Tipo invalido!                         |");
						System.out.println("|*****************************************************|");
						}
					}
				} else {
					System.out.println(Cores.ANSI_RED_BACKGROUND + 
							"|*****************************************************|");
					System.out.println("|              Conta não encontrada!                  |");
					System.out.println("|*****************************************************|" + Cores.TEXT_RESET);
				}
				keyPress();
				break;

			case 5:
				System.out.println("|*****************************************************|");
				System.out.println("|              Apagar a conta                         |");
				System.out.println("|*****************************************************|");

				System.out.println("|              Digite o numero da conta: ");
				
				numero = sc.nextInt();
				
				contas.deletar(numero);
				
				keyPress();
				break;

			case 6:
				System.out.println("|*****************************************************|");
				System.out.println("|              Saque                                  |");
				System.out.println("|*****************************************************|");
				

				System.out.println("|              Digite o numero da conta: ");
				numero = sc.nextInt();
				
				do {

					System.out.println("|              Digite o valor do Saque: ");
					valor = sc.nextFloat();
				} while(valor <=0);
				
				contas.sacar(numero, valor);
				
				keyPress();
				break;

			case 7:
				System.out.println("|*****************************************************|");
				System.out.println("|              Deposito                               |");
				System.out.println("|*****************************************************|");
				
				System.out.println("|              Digite o numero da conta: ");
				numero = sc.nextInt();
				
				do {

					System.out.println("|              Digite o valor do Deposito: ");
					valor = sc.nextFloat();
				} while(valor <= 0);
				
				contas.sacar(numero, valor);
				keyPress();
				break;

			case 8:
				System.out.println("|*****************************************************|");
				System.out.println("|              Transferencia entre contas             |");
				System.out.println("|*****************************************************|");
				
				System.out.println("|              Digite o numero da conta de origem: ");
				numero = sc.nextInt();

				
				System.out.println("|              Digite o numero da conta de Destino: ");
				numDestino = sc.nextInt();
				
				do {

					System.out.println("|              Digite o valor do Saque: ");
					valor = sc.nextFloat();
				} while(valor <=0);
				
				contas.transferir(numero, numDestino, valor);
				keyPress();
				break;

			default:
				System.out.println("|*****************************************************|");
				System.out.println("|              Opção invalida - Tente novamente       |");
				System.out.println("|*****************************************************|");
				keyPress();
				break;
			}

		}
	}

// RODAPE FECHAMENTO
	public static void sobre() {

		System.out.println("|   Desenvolvido Por Maria Leiliane                   |");
		System.out.println("|   Bootcamp T68 Generation Brasil                    |");
		System.out.println("|   https://github.com/Marilyn-FullStack              |");
		System.out.println("|   https://www.linkedin.com/in/mlls                  |");
		System.out.println("|*****************************************************|");
	}

	public static void keyPress() {
		try {

			System.out.println("|*****************************************************|");
			System.out.println("|   Pressione Enter para Continuar...                 |");
			System.out.println("|*****************************************************|");
			System.in.read();

		} catch (IOException e) {
			System.out.println("|*****************************************************|");
			System.out.println("|   Você pressionou uma tecla diferente de Enter!     |");
			System.out.println("|*****************************************************|" + Cores.TEXT_RESET);
		}

	}
}