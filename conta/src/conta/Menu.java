package conta;

import java.util.Scanner;

import conta.model.Conta;
import conta.model.ContaCorrente;

public class Menu {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// TESTE MODEL CLASSE CONTA
		Conta c1 = new Conta("Beyonce", 1, 1, 1111, 8000000.0f);
		c1.visualizar();
		c1.sacar(5.50f);
		c1.visualizar();
		c1.depositar(100.0f);
		c1.visualizar();

		// TESTE MODEL CLASSE CONTA CORRENTE
		Conta cc1 = new ContaCorrente("Beyonce", 2, 2, 1111, 50.0f, 1000000.0f);
		cc1.visualizar();
		cc1.sacar(1000000.50f);
		cc1.visualizar();
		cc1.depositar(100.0f);
		cc1.visualizar();

		int opcao;

		while (true) {

			System.out.println("|*****************************************************|");
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

			// DECISÕES DE CADA OPÇÃO
			opcao = sc.nextInt();

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
				System.out.println("|              Criar Conta                         |\n");
				break;

			case 2:
				System.out.println("|              Listar todas as contas              |\n");
				break;

			case 3:
				System.out.println("|              Consultar de dados por numero       |\n");
				break;

			case 4:
				System.out.println("|              Atualizar dados                     |\n\n");
				break;

			case 5:
				System.out.println("|              Apagar a conta                      |\n\n");
				break;

			case 6:
				System.out.println("|              Saque                               |\n");
				break;

			case 7:
				System.out.println("|              Deposito                            |\n");
				break;

			case 8:
				System.out.println("|              Transferencia entre contas          |\n");
				break;

			default:
				System.out.println("\n|              Opção invalida - Tente novamente    |\n");
				break;
			}

		}
	}

	// RODAPÉ FECHAMENTO
	public static void sobre() {

		System.out.println("|   Desenvolvido Por Maria Leiliane                   |");
		System.out.println("|   Bootcamp T68 Generation Brasil                    |");
		System.out.println("|   https://github.com/Marilyn-FullStack              |");
		System.out.println("|   https://www.linkedin.com/in/mlls                  |");
		System.out.println("|*****************************************************|");

	}

}
