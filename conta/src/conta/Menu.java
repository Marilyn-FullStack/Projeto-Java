package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {

	ContaController contas = new ContaController();

	String titular;
	int opcao, numero, agencia, tipo, aniversario;
	float saldo, limite;

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
		System.out.println("\n|              Digite o número da Agencia ");
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

			System.out.println("|              Digite o limite de credito: -R$");
			limite = sc.nextFloat();
			contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
		}
		case 2 -> {
			System.out.println("|              Escolha o dia para o aniversario conta: ");
			aniversario = sc.nextInt();
			contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
		}
	}
		
		keyPress();
		break;

	case 2:
		System.out.println("|*****************************************************|");
		System.out.println("|              Listar todas as contas                 |");
		System.out.println("|*****************************************************|");
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
