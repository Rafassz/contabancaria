package conta;

import java.util.Scanner;
import conta.model.Conta;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		/*
		 * Teste da Classe Conta Conta conta1 = new Conta(1, 123, 1, "Adriana",
		 * 10000.0f); conta1.visualizar(); conta1.sacar(12000.0f); conta1.visualizar();
		 * conta1.depositar(5000.0f); conta1.visualizar();
		 */
		Conta conta1 = new Conta();
		Scanner scanner = new Scanner(System.in);

		int opcao, opcaocriar;

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                    BANCO DO RAFA                    ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			opcao = scanner.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				scanner.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
						+ "*****************************************************");
				System.out.println(Cores.TEXT_WHITE + "                    CRIAR CONTA                      \n\n");
				System.out.println("            1 - Conta Corrente                       ");
				System.out.println("            2 - Conta Poupança                       ");
				opcaocriar = scanner.nextInt();

				switch (opcaocriar) {

				case 1:
					System.out.println(Cores.TEXT_WHITE + "            CONTA CORRENTE SELECIONADA               \n\n");
					System.out.println("Digite seu Nome Completo: ");
					conta1.setTitular(scanner.nextLine());
					System.out.println("\nDigite seu CPF: ");
					conta1.setCPF(scanner.nextFloat());

					break;
				case 2:
					System.out.println(Cores.TEXT_WHITE + "            CONTA POUPANÇA SELECIONADA               \n\n");

					break;
				}

				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");

				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");

				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");

				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");

				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");

				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");

				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("\n                                                                ");
		System.out.println("****************************************************************");
		System.out.println("Projeto Desenvolvido por: Rafael Aparecido Gonçalves de Macedo  ");
		System.out.println("Rafael Aparecido - rafassz.aps@gmail.com                        ");
		System.out.println("https://github.com/Rafassz                                      ");
		System.out.println("****************************************************************");
		System.out.println("                                                                " + Cores.TEXT_RESET);
	}

}
