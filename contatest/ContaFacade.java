/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package contatest;
/**
 *
 * @author Caroline Nakazato
 */
import java.lang.NumberFormatException;

public class ContaFacade {
    Conta contas[] = new Conta[10];
    int qtdContas;
    private static ContaFacade uniqueInstance;
    
    public static synchronized ContaFacade getInstance(){
        if (uniqueInstance == null)
            uniqueInstance = new ContaFacade();
 
        return uniqueInstance;
    }
    private ContaFacade(){
	qtdContas=0;
    }
    public int existeConta(int numeroDaConta){
        //verifica se a conta existe
        for(int k = 0; k<qtdContas; k++){
            if(numeroDaConta==contas[k].getNumero()){
                return 1;
            }
        }
	return 0; //nao existe
    }
    public String novaContaSimples(String nomeDaConta, int numeroDaConta) throws Exception{
     	//Cria nova conta simples
        try{
        if( numeroDaConta<0)
	{
            throw new NumeroNegativoException("Numero Invalido");
	}else{
            if(existeConta(numeroDaConta)==0){
                contas[qtdContas] = new ContaSimples(nomeDaConta, numeroDaConta);
                qtdContas++;
                return "Conta simples criada com sucesso.";
            }
        }
            
        }catch(Exception e){
            return "Numero invalido.";
        }
        return "Numero da conta ja existe!";
    }
    public String novaContaPoupanca(String nomeDaConta, int numeroDaConta, double taxaDeRendimento) throws Exception{
     	//Cria nova conta Poupanca
        try{
            if(numeroDaConta < 0){
                throw new NumeroNegativoException("Numero Invalido");
            }else{
                if(existeConta(numeroDaConta)==0){
                    contas[qtdContas] = new ContaPoupanca(nomeDaConta, numeroDaConta,taxaDeRendimento);
                    qtdContas++;
                    return "Conta poupanca criada com sucesso.";
                }
            }
        }catch(Exception e){
            return "Numero invalido.";
        }
        return "Numero da conta ja existe!";
    }
    public String novaContaEspecial(String nomeDaConta, int numeroDaConta, double limite) throws Exception {
	//Cria nova conta Especial
        try{
            if(numeroDaConta < 0){
                throw new NumeroNegativoException("Numero Invalido");
            }else{
                if(existeConta(numeroDaConta)==0){
                    contas[qtdContas] = new ContaEspecial(nomeDaConta, numeroDaConta,limite);
                    qtdContas++;
                    return "Conta especial criada com sucesso.";
                }
            }  
        }catch(Exception e){
            return "Numero invalido.";
        }
        return "Numero da conta ja existe!";

    }
    public String visualizaInformacao(int numeroDaConta) throws Exception{
	//visualiza informação
        try{
            if(numeroDaConta < 0){
                throw new NumeroNegativoException("Numero Invalido");
            }else{
	if(existeConta(numeroDaConta)==1){
            for(int i = 0; i<qtdContas; i++){
                if(contas[i].getNumero() == numeroDaConta){
                    return contas[i].imprime();
		}	 
            }
	}
         }  
        }catch(Exception e){
            return "Numero invalido.";
        }
        return "Nada encontrado!";
    }
    public void incrementarRendimento() {
        //incremente rendimento
	for(Conta contaAtual : contas){
            if(contaAtual instanceof ContaPoupanca){
                ContaPoupanca conta = (ContaPoupanca) contaAtual;
                conta.incrementeRedimento();
            } 
	}                                                    
    }
    public String cobrarJuros(double valor) throws Exception{
	//realiza cobranca de juros
        try{
             if(valor < 0){
                throw new NumeroNegativoException("Numero Invalido");
            }else{
        for(Conta contaAtual : contas){                                                
            if(contaAtual instanceof ContaEspecial){
                ContaEspecial conta = (ContaEspecial) contaAtual;
                conta.cobrarJuros(valor);
            } 
        }
       }  
        }catch(Exception e){
            return "Numero invalido.";
        }
        return "Juros cobrados com sucesso.";
    }
    public String informacoes(int i){                                                       
        //imprime informacoes de todas as contas
        if((i <qtdContas)&&(i>=0)){                                                
            return contas[i].imprime();
        }
        return "Nada Encontrado";
    }           
    public int logarConta(int numeroDaConta, String senha){   
        //verifico se o numero e a senha estao corretos
	for(int i = 0; i<qtdContas; i++){
            if((contas[i].getNumero() == numeroDaConta)&&(contas[i].getSenha() == null ? senha == null : contas[i].getSenha().equals(senha))){
                return i;
            }
	}
        return -1;//nao existe essa conta com essa senha
    }
    public String saque(int numeroDaConta, String senha, double valor) throws Exception{
	//Realiza Saque
        try{
            if(valor < 0){
                throw new NumeroNegativoException("Numero Invalido");
            }else{
                int i = logarConta(numeroDaConta, senha);
                if(i!=-1){
                    return contas[i].sacar(valor);
                }
            }
        }catch(Exception e){
            return "Numero invalido.";
        }
        return "O numero ou senha incorreta!";
 
    }
    public String deposita(int numeroDaConta, double valor)throws Exception{
	//Realiza Deposito
        try{
            if(valor < 0){
                throw new NumeroNegativoException("Numero Invalido.");
            }else{
                for(int i = 0; i<qtdContas; i++){
                    if(contas[i].getNumero() == numeroDaConta){
                        return contas[i].depositar(valor);
                    }
                }
            }
        }catch(Exception e){
            return "Numero invalido.";
        }
        return "Nao existe este numero da conta!";
    }
    public String imprime(int numeroDaConta, String senha) throws Exception{
	//Visualizar informações da conta
        try{
            if(numeroDaConta < 0){
                throw new NumeroNegativoException("Numero Invalido.");
            }else{
                int i = logarConta(numeroDaConta, senha);
                if(i!=-1){
                    return contas[i].imprime();
                }else{
                    return "O numero ou senha incorreta!";
                }
            }
        }catch(Exception e){
            return "Numero invalido.";
        }
        //return "Nao existe este numero de conta!";
    }
    public String alteraSenha(int numeroDaConta, String senha, String senhaNova) throws Exception{
	//Alterar senha
        try{
            if(numeroDaConta < 0){
                throw new NumeroNegativoException("Numero Invalido.");
            }else{
                int i = logarConta(numeroDaConta, senha);
                if(i!=-1){
                    return contas[i].alterarSenha(senha, senhaNova);
                }else{
                    return "O numero ou senha incorreta!";
                }
            }
        }catch(Exception e){
            return "Numero invalido.";
        }
    }
    
}