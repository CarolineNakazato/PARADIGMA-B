/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author PC
 */
public class ContaPoupanca extends Conta{
	private double taxaRendimento;
	public ContaPoupanca(){
		super();
		taxaRendimento = 0.0;
	}
	public ContaPoupanca(String nome, int numero, double taxaRendimento){
		super(nome, numero,0.00);
		this.taxaRendimento = taxaRendimento;
	}
	
	public void sacar(double valor){
		if((saldo) >= valor){
			saldo -= valor;
		}else{
			System.out.println("Nao foi possivel sacar o valor!");	
		}
	}
        public void imprime(){
		super.imprime();
		System.out.printf("Taxa de rendimento = %.2f\n",taxaRendimento);
	}
        public void incrementeRedimento(){
            super.depositar(saldo*taxaRendimento);
        }
}