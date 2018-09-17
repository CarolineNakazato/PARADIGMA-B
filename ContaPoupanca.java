public class ContaPoupanca extends Conta{
	private float taxaRendimento;
	public ContaPoupanca(){
		super();
		taxaRendimento = 0.0;
	}
	public ContaPoupanca(String nome, int numero, float taxaRendimento){
		super(nome, numero, 0.0);
		this.taxaRendimento = taxaRendimento;
	}
	
	public void sacar(double valor){
		if((saldo) >= valor){
			saldo -= valor;
		}else{
			System.out.println("Nao foi possivel sacar o valor!");	
		}
	}
}