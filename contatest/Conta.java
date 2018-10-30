/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contatest;

/**
 *
 * @author PC
 */
public abstract class Conta{
	protected int numero;
	protected String nome;
	protected double saldo;
	protected double limite;
	protected String senha;
	
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
	
	public String getSenha(){
		return senha;		
	}
	
	public String imprime(){
            String s;
            s = "<html>Informacoes: <br>  Numero da conta: " +numero+
                "<br>  Nome do correntista: "+nome+
                "<br>  Saldo: "+saldo+
                "<br>  Limite: "+limite+ "</html>";
            /**System.out.printf("Numero da conta = %d\n",numero);
            System.out.printf("Nome do corentista = %s\n",nome);
            System.out.printf("Saldo = %.2f\n",saldo);
            System.out.printf("Limite = %.2f\n",limite);**/
            return s;
	}
	
	public String sacar(double valor) throws Exception{
            try{
		if((saldo + limite) >= valor){
			saldo -= valor;
                        return "Valor sacado com sucesso.";
		}
            }catch(Exception e){
                return "Nao foi possivel sacar o valor!";
            }
            return "Nao foi possivel sacar o valor!";
	}

	public String depositar(double valor){
		saldo += valor;
                return "Deposito feito com sucesso.";
	}

	public String alterarSenha(String senhaAntiga, String senhaNova){
		if(senha == null ? senhaAntiga == null : senha.equals(senhaAntiga)){
			senha = senhaNova;
                        return "Senha alterada com sucesso";
		}else{
			return "Operacao nao realizada! Senha incorreta!";	
		}
	}
}