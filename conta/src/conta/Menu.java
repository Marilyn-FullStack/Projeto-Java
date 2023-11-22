package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

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

		// TESTE MODEL CLASSE CONTAPOUPANÇA
		Conta cp1 = new ContaPoupanca("Beyonce", 1, 5, 1111, 8000000.0f, 4);
		cp1.visualizar();
		cp1.sacar(15.50f);
		cp1.visualizar();
		cp1.depositar(100.0f);
		cp1.visualizar();
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
				System.out.println("|*****************************************************|");
				System.out.println("|  Luar Banco a boa fase do seu capital começa aqui!  |");
				System.out.println("|*****************************************************|");
				sobre();
				sc.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("|*****************************************************|");
				System.out.println("|              Criar Conta                            |");
				System.out.println("|*****************************************************|");
				keyPress();
				break;

			case 2:
				System.out.println("|*****************************************************|");
				System.out.println("|              Listar todas as contas                 |");
				System.out.println("|*****************************************************|");
				keyPress();
				break;

			case 3:
				System.out.println("|*****************************************************|");
				System.out.println("|              Consultar de dados por numero          |");
				System.out.println("|*****************************************************|");
				keyPress();
				break;

			case 4:
				System.out.println("|*****************************************************|");
				System.out.println("|              Atualizar dados                        |");
				System.out.println("|*****************************************************|");
				keyPress();
				break;

			case 5:
				System.out.println("|*****************************************************|");
				System.out.println("|              Apagar a conta                         |");
				System.out.println("|*****************************************************|");
				keyPress();
				break;

			case 6:
				System.out.println("|*****************************************************|");
				System.out.println("|              Saque                                  |");
				System.out.println("|*****************************************************|");
				keyPress();
				break;

			case 7:
				System.out.println("|*****************************************************|");
				System.out.println("|              Deposito                               |");
				System.out.println("|*****************************************************|");
				keyPress();
				break;

			case 8:
				System.out.println("|*****************************************************|");
				System.out.println("|              Transferencia entre contas             |");
				System.out.println("|*****************************************************|");
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

	// RODAPÉ FECHAMENTO
	public static void sobre() {

		System.out.println("|   Desenvolvido Por Maria Leiliane                   |");
		System.out.println("|   Bootcamp T68 Generation Brasil                    |");
		System.out.println("|   https://github.com/Marilyn-FullStack              |");
		System.out.println("|   https://www.linkedin.com/in/mlls                  |");
		System.out.println("|*****************************************************|");
	}

	public static void keyPress() {
		try {
			System.out.println("|   Pressione Enter para Continuar...                 |");
			System.out.println("|*****************************************************|");
			System.in.read();

		} catch (IOException e) {
			System.out.println("|*****************************************************|");
			System.out.println("|   Você pressionou uma tecla diferente de Enter!     |");
			System.out.println("|*****************************************************|");
		}

	}
}
