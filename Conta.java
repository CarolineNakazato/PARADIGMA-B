public class Conta{
	private int numero;
	private String nome;
	private double saldo;
	private double limite;
	private String senha;
	
	public Conta(){
		this.numero = 0;	
		this.nome = "";	
		this.saldo = 0.0;	
		this.limite = 0.0;	
		this.senha = "0000";	
	}
	public Conta(String nome, int numero, double limite){
		this.numero = numero;	
		this.nome = nome;	
		this.saldo = 0.0;	
		this.limite = limite;	
		this.senha = "0000";	
	}

	public void setNumero(int numero){
		this.numero = numero;		
	}
	
	public int getNumero(){
		return numero;		
	}
	public void setNome(String nome){
		this.nome = nome;		
	}
	
	public String getNome(){
		return nome;		
	}
	public void setSaldo(double saldo){
		this.saldo = saldo;		
	}

	public void setLimite(double limite){
		this.limite = limite;		
	}
	
	public double getLimite(){
		return limite;		
	}
	public void imprime(){
		System.out.printf("Numero da conta = %d\n",numero);
		System.out.printf("Nome do corentista = %s\n",nome);
		System.out.printf("Saldo = %.2f\n",saldo);
		System.out.printf("Limite = %.2f\n",limite);
	}
	
	public void sacar(double valor){
		if((saldo + limite) >= valor){
			saldo -= valor;
		}else{
			System.out.println("Nao foi possivel sacar o valor!");	
		}
	}

	public void depositar(double valor){
		saldo += valor;
	}

	public void alterarSenha(String senhaAntiga, String senhaNova){
		if(senha == senhaAntiga){
			senha = senhaNova;
		}else{
			System.out.println("Operacao nao realizada! Senha incorreta!");	
		}
	}
}