package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> ListarContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void ProcurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			conta.visualizar();
		} else {
			System.out.println("\nA Conta número: " + numero + "não foi encontrada!");
		}

	}

	@Override
	public void ListarTodas() {
		for (var conta : ListarContas) {
			((Conta) conta).visualizar();
		}
	}

	@Override
	public void Cadastrar(Conta conta) {
		ListarContas.add(conta);
		System.out.println("\nA conta número: " + conta.getNumero() + " Foi criada com sucesso!!");
	}

	@Override
	public void Atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if(buscaConta != null) {
			ListarContas.set(ListarContas.indexOf(buscaConta),conta);	
			System.out.println("\nA Conta Numero: " + conta.getNumero() + " foi atualizada com sucesso!!");
		}else {
			System.out.println("\nA Conta Numero: " + conta.getNumero() + " não foi encontrada!!");
			
		}

	}

	@Override
	public void Deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(ListarContas.remove(conta) == true) {
				System.out.println("\nA Conta numero: " + numero + " foi Deletada com sucesso!!");				
			}else {
				System.out.println("\nA Conta numero: " + numero + " não foi encontrada!!");
			}
		}

	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(conta.sacar(valor)) {
				System.out.println("\nO Saque na Conta numero " + numero + " foi efetuado com sucesso!!");
			}else {
				System.out.println("\nConta numero " + numero + " não foiencontrada!!");
			}
		}

	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			conta.depositar(valor);
			System.out.println("\nO Depósito na Conta Número: " + numero + " foi efetuado com Sucesso!!");
		}else {
			System.out.println("\nA Conta Número: " + numero + " não foi encontrada ou a Conta destino não é uma CC!!");
		}

	}

	@Override
	public void transferir(int NumeroOrigem, int NumeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(NumeroOrigem);
		var contaDestino = buscarNaCollection(NumeroDestino);
		
		if(contaOrigem != null) {
			if(contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.println("\nA Transferência foi efetuada com Sucesso!!");
			}
		}else {
			System.out.println("\nA Conta Origem e ou Destino não foram encontradas!");
		}

	}

	public int gerarNumero() {
		return ++numero;
	}

	public Conta buscarNaCollection(int numero) {
		for (var conta : ListarContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}

}
