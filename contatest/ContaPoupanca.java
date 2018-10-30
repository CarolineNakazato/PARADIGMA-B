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
        
	public String sacar(double valor) throws Exception{
            try{
                if((saldo - valor) < 0){
                    throw new NumeroNegativoException("Nao foi possivel sacar o valor.");
                }else{
                    if((saldo) >= valor){
			saldo -= valor;
                        return "Valor sacado com sucesso";
                    }
                }
            }catch(Exception e){
                return "Nao foi possivel sacar o valor.";
            }
            return "Nao foi possivel sacar o valor!";		
	}
        public String imprime(){
		String s;
                s = "<html>Informacoes: <br> Numero da conta: " +numero+
                "<br> Nome do correntista: "+nome+
                "<br> Saldo: "+saldo+
                "<br> Limite: "+limite+
                "<br> Taxa de rendimento: "+taxaRendimento+ "</html>";
                return s;
	}
        public void incrementeRedimento(){
            super.depositar(saldo*taxaRendimento);
        }
}