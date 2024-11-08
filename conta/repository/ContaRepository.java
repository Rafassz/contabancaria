package conta.repository;

import conta.model.Conta;

public interface ContaRepository {

	//CRUD da Conta
	public void ProcurarPorNumero(int numero);
	public void ListarTodas();
	public void Cadastrar(Conta conta);
	public void Atualizar(Conta conta);
	public void Deletar(int numero);
	
	//Métodos Bancários
	public void sacar(int numero, float valor);
	public void depositar(int numero, float valor);
	public void transferir(int NumeroOrigem,int NumeroDestino, float valor);

}
