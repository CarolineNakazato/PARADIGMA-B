public class ContaSimples extends Conta{

	public ContaSimples(){
		super();
	}
	public ContaSimples(String nome, int numero){
		super(nome, numero, 0.0);

	}

	public void sacar(double valor){
		if((saldo) >= valor){
			saldo -= valor;
		}else{
			System.out.println("Nao foi possivel sacar o valor!");	
		}
	}
}