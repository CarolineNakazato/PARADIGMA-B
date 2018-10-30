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
public class ContaSimples extends Conta{

	public ContaSimples(){
		super();
	}
	public ContaSimples(String nome, int numero){
		super(nome, numero, 0.0);

	}

        @Override
	public String sacar(double valor) throws Exception{
            try{
                if((saldo - valor) < 0){
                    throw new NumeroNegativoException("Nao foi possivel sacar o valor.");
                }else{
                    if(saldo >= valor){
                    	saldo -= valor;
                        return "Valor sacado com sucesso.";
                    }
		}
            }catch(Exception e){
                return "Nao foi possivel sacar o valor.";
            }
            return "Nao foi possivel sacar o valor!";	
	}
}