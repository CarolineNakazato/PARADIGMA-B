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
public class ContaEspecial extends Conta{

    public ContaEspecial(){
	super();
    }
    public ContaEspecial(String nome, int numero, double limite){
	super(nome, numero, limite);
    }
    public void cobrarJuros(double juros){
        saldo -= limite*juros;
    }    
}