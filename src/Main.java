
public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		
		Conta cc = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);

		Banco Inter = new Banco();
		Inter.setNome("Inter Banco");

		System.out.println(String.format("Este é o meu banco" + Inter.getNome() ));


		cc.depositar(100);
		cc.transferir(100, poupanca);
		cc.Imprestimo(500,1);
		cc.depositar(500);
		cc.Imprestimo(500,2);


		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}

}
