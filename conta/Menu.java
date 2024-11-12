package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.util.Cores;
import conta.model.ContaPoupanca;
import conta.controller.ContaController;
import conta.model.ContaCorrente;

public class Menu {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		
		System.out.println("\nCriar Contas\n");
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.Cadastrar(cc1);
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 176, 1, "Maria da Silva", 2000f, 100.0f);
		contas.Cadastrar(cc2);
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 396, 2, "Mariana dos Santos", 4000f, 12);
		contas.Cadastrar(cp1);
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 442, 2, "Juliana Ramos", 8000f, 15);
		contas.Cadastrar(cp2);

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

			try {
				opcao = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				scanner.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				scanner.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");
				
				System.out.println("Digite o número da Agência: ");
				agencia = scanner.nextInt();
				
				System.out.println();
				scanner.skip("\\R?");
				titular = scanner.nextLine();
				
				do {
					System.out.println("Digite o tipo da Conta (1-CC ou 2-CP)");
					tipo = scanner.nextInt();
				}while(tipo < 1 && tipo > 2);
				
				System.out.println("Digite o Saldo da Conta: ");
				saldo = scanner.nextInt();
				
				switch(tipo) {
				case 1:
					System.out.println("Digite o Limite de Crédito (R$): ");
					limite =scanner.nextInt();
					contas.Cadastrar(new ContaCorrente(contas.gerarNumero(),agencia, tipo, titular, saldo, limite));
					break;
				
				case 2:
					System.out.println("Digite o Número de Aniversário da Conta: ");
					aniversario = scanner.nextInt();
					contas.Cadastrar(new ContaPoupanca(contas.gerarNumero(),agencia, tipo, titular, saldo, aniversario));
					break;																		
				
				}
				keyPress();
				break;
				
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");
				contas.ListarTodas();
				keyPress();
				break;
				
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();
				
				contas.ProcurarPorNumero(numero);
				
				keyPress();
				break;
				
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");
				
				System.out.println("Digite o número da Conta: ");
				numero = scanner.nextInt();
				
				var buscaConta = contas.buscarNaCollection(numero);
				
				if(buscaConta != null) {
					
					tipo = buscaConta.getTipo();
					
					System.out.println("Digite o número da Agência: ");
					agencia = scanner.nextInt();
					
					System.out.println("Digite o nome do Titular: ");
					scanner.skip("\\R?");
					titular = scanner .nextLine();
					
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = scanner.nextFloat();
					
					switch(tipo) {
					case 1:
						System.out.println("Digite o Limite de Crédito (R$): ");
						limite =scanner.nextInt();
						contas.Cadastrar(new ContaCorrente(contas.gerarNumero(),agencia, tipo, titular, saldo, limite));
						break;
					
					case 2:
						System.out.println("Digite o Número de Aniversário da Conta: ");
						aniversario = scanner.nextInt();
						contas.Cadastrar(new ContaPoupanca(contas.gerarNumero(),agencia, tipo, titular, saldo, aniversario));
						break;
						
						default :
							System.out.println("Tipo de conta Ínvalido!!");
					}	
				
				}else {
					System.out.println("A Conta não foi encontrada!!");
				}
				keyPress();
				break;
				
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");
				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();
				
				contas.Deletar(numero);
				keyPress();
				break;
				
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");
				
				System.out.println("Digite o Número da Conta: ");
				numero = scanner.nextInt();
				
				do {
					System.out.println("Digite o Valor do Saque (R$):");
					valor = scanner.nextFloat();
				}while(valor <= 0);
				
				contas.sacar(numero,valor);
				
				keyPress();
				break;
				
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");
				System.out.println("Digite o numero da Conta: ");
				numero = scanner.nextInt();
				
				do {
					System.out.println("Digite o valor de Depósito (R$):");
					valor = scanner.nextFloat();
					
				}while(valor <= 0);
				
				contas.depositar(numero, valor);
				
				keyPress();
				break;
				
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");
				System.out.println("Digite o Número da Conta Origem: ");
				numero = scanner.nextInt();
				System.out.println("Digite o Número da Conta Destino: ");
				numeroDestino =scanner.nextInt();
				
				do {
					System.out.println("Digite o valor da Transferência (R$): ");
					valor = scanner.nextFloat();
					
				}while(valor <= 0);
				
				contas.transferir(numero, numeroDestino, valor);
				keyPress();
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

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}

}
