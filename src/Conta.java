
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;


	protected int agencia;
	protected int acaoImprestimo;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	protected double valorImprestimos;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	public void Imprestimo(double valor, int acaoImprestimo){
		saldo += valor;
		valorImprestimos += valor;

		if(acaoImprestimo == 1){
			saldo += valor;
			System.out.println(String.format("Você tem 2 meses para pagar o imprestimo de " +  valor));
		}else if(acaoImprestimo == 2){
			saldo -= valor;
			valorImprestimos -= valor;
			System.out.println(String.format("Obrigado por pagar o imprestimo de " +  valor));
		}

	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Valor de Emprestimos: %.2f", this.valorImprestimos));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
