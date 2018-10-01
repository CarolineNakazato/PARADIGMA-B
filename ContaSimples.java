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
public class ContaSimples extends Conta{

	public ContaSimples(){
		super();
	}
	public ContaSimples(String nome, int numero){
		super(nome, numero, 0.0);

	}

        @Override
	public void sacar(double valor){
		if(saldo >= valor){
			saldo -= valor;
		}else{
			System.out.println("Nao foi possivel sacar o valor!");	
		}
	}
}
