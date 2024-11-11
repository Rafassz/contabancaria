package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {
	
	private ArrayList<Conta> ListarContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void ProcurarPorNumero(int numero) {
		
	}

	@Override
	public void ListarTodas() {
		for(var conta: ListarContas) {
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
		
	}

	@Override
	public void Deletar(int numero) {
		
	}

	@Override
	public void sacar(int numero, float valor) {
		
	}

	@Override
	public void depositar(int numero, float valor) {
		
	}

	@Override
	public void transferir(int NumeroOrigem, int NumeroDestino, float valor) {
		
	}
	public int gerarNumero() {
		return ++ numero;
	}

}
