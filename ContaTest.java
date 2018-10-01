/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package contatest;
import java.util.Scanner;
/**
 *
 * @author Caroline Nakazato
 */
public class ContaTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     		Conta contas[] = new Conta[10];
		int opcao = 0, opcaoGerente = 0, opcaoCliente = 0, tipoConta = 0, qtdContas = 0, mesmoNumero = 0, numeroDaConta, existeNumero = 0, qtdErro = 3;
		String senha, senhaNova, nomeDaConta;
		double valor, taxaDeRendimento, limite;
		Scanner entrada =  new Scanner(System.in);
		
		while(opcao!=3){
			System.out.printf("Digite:\n");
			System.out.printf("1 - Gerente;\n");
			System.out.printf("2 - Cliente;\n");
			System.out.printf("3 - Sair;\n");
			opcao = entrada.nextInt();
			
			if(opcao == 1){  //gerente
                            
                            opcaoGerente = 0;
				while((opcaoGerente!=6)&&(qtdContas<10)){
					System.out.printf("Digite:\n");
					System.out.printf("1 - Cria nova conta ;\n");
					System.out.printf("2 - Visualizar informações de uma conta;\n");
                                        System.out.printf("3 - Incremente rendimentos;\n");
					System.out.printf("4 - Realizar cobranca de juros;\n");
					System.out.printf("5 - Imprimir informacoes de todas as contas;\n");
					System.out.printf("6 - Voltar ao menu inicial;\n");
					opcaoGerente = entrada.nextInt();
				
					switch( opcaoGerente ){
						case 1: //Cria nova conta
							
							System.out.printf("Digite:\n");
							System.out.printf("1 - Conta Corrente;\n");
							System.out.printf("2 - Conta Poupanca;\n");
							System.out.printf("3 - Conta Especial;\n");
							tipoConta = entrada.nextInt();
							switch( tipoConta ){
                                                            
								case 1:
									
                                                                        System.out.printf("Digite nome da conta:\n");                                                                        
                                                                        entrada.nextLine();
                                                                        nomeDaConta = entrada.nextLine();
                                                                        System.out.printf("Digite numero da conta:\n");
                                                                        numeroDaConta = entrada.nextInt();
                                                                        mesmoNumero = 0;
                                                                        for(int k = 0; k<qtdContas; k++){
                                                                            if(numeroDaConta==contas[k].getNumero()){
                                                                                mesmoNumero++;
                                                                            }
                                                                        }
                                                                        if(mesmoNumero==0){
                                                                            contas[qtdContas] = new ContaSimples(nomeDaConta, numeroDaConta);
                                                                            qtdContas++;
                                                                        }else{
                                                                            System.out.printf("Numero da conta ja existe!\n");
                                                                        }
                                                                        break;
    
								case 2:
                                                                        entrada.nextLine();
                                                                        System.out.printf("Digite nome da conta:\n");                                                                    
                                                                        nomeDaConta = entrada.nextLine();
                                                                        
                                                                        System.out.printf("Digite numero da conta:\n");
                                                                        numeroDaConta = entrada.nextInt();
                                                                        
                                                                        System.out.printf("Digite da taxa de rendimento:\n");
                                                                        taxaDeRendimento = entrada.nextDouble();
									
                                                                        mesmoNumero = 0;
                                                                        for(int k = 0; k<qtdContas; k++){
                                                                            if(numeroDaConta==contas[k].getNumero()){
                                                                                mesmoNumero++;
                                                                            }
                                                                        }
                                                                        if(mesmoNumero==0){
                                                                            contas[qtdContas] = new ContaPoupanca(nomeDaConta, numeroDaConta,taxaDeRendimento);
                                                                            qtdContas++;
                                                                        }else{
                                                                            System.out.printf("Numero da conta ja existe!\n");
                                                                        }
                                                                        break;
    
								case 3:
									System.out.printf("Digite numero da conta:\n");
                                                                        numeroDaConta = entrada.nextInt();
                                                                        entrada.nextLine();
                                                                        System.out.printf("Digite nome da conta:\n");                                                                        
                                                                        nomeDaConta = entrada.nextLine();
                                                                        
                                                                        System.out.printf("Digite o valor do limite:\n");
                                                                        limite = entrada.nextDouble();
                                                                        
                                                                        mesmoNumero = 0;
                                                                        for(int k = 0; k<qtdContas; k++){
                                                                            if(numeroDaConta==contas[k].getNumero()){
                                                                                mesmoNumero++;
                                                                            }
                                                                        }
                                                                        if(mesmoNumero==0){
                                                                            contas[qtdContas] = new ContaEspecial(nomeDaConta, numeroDaConta,limite);
                                                                            qtdContas++;
                                                                        }else{
                                                                            System.out.printf("Numero da conta ja existe!\n");
                                                                        }
                                                                        break;
    
								default:
									System.out.printf("Opcao invalida!\n");
									break;
							}	
							break;
    
						case 2: //visualiza informação
							System.out.printf("Digite o numero da conta:\n");
							numeroDaConta = entrada.nextInt();
							for(int i = 0; i<qtdContas; i++){
								if(contas[i].getNumero() == numeroDaConta){
									contas[i].imprime();
									existeNumero++;
								} 
							}
							if(existeNumero == 0){
								System.out.printf("O numero da conta nao existe!\n");
							}
							existeNumero = 0;
							break;
    
                                                case 3: //incremente rendimento
							for(Conta contaAtual : contas){
								if(contaAtual instanceof ContaPoupanca){
                                                                    ContaPoupanca conta = (ContaPoupanca) contaAtual;
                                                                    conta.incrementeRedimento();
								} 
							}                                                    
							break;
                                                case 4: //realiza cobranca de juros
                                                    for(Conta contaAtual : contas){                                                
                                                        if(contaAtual instanceof ContaEspecial){
                                                            System.out.printf("Digite o valor do juros:\n");
                                                            valor = entrada.nextInt();
                                                            
                                                            ContaEspecial conta = (ContaEspecial) contaAtual;
                                                            conta.cobrarJuros(valor);
                                                        } 
                                                    }    
                                                    break;
                                                        
                                                case 5: //imprime informacoes de todas as contas
                                                    for(int k = 0; k <qtdContas; k++){                                                
                                                       contas[k].imprime();
                                                    }  
                                                    break;
						case 6: //volta
							break;
    
						default:
							System.out.printf("Opcao invalida!\n");
							break;
					}
				}
				
			}else{
				if(opcao == 2){  //cliente
					//while(qtdErro>0){ // pode errar no maximo 4 vezes
					System.out.printf("Digite o numero da conta:\n");
					numeroDaConta = entrada.nextInt();
					entrada.nextLine();
					System.out.printf("Digite a senha da conta:\n");
					senha = entrada.nextLine();
					System.out.println("numeroDaConta = " +numeroDaConta+ " senha = "+senha);
					//verifico se o numero e a senha estao corretos
					for(int i = 0; i<qtdContas; i++){
                                            System.out.println("contas["+i+"].getNumero() = " +contas[i].getNumero()+ " contas["+i+"].getSenha() = "+contas[i].getSenha());
						if((contas[i].getNumero() == numeroDaConta)&&(contas[i].getSenha() == null ? senha == null : contas[i].getSenha().equals(senha))){
                                                    opcaoCliente = 0;		
                                                    while(opcaoCliente!=5){
									System.out.printf("Digite:\n");
									System.out.printf("1 - Realizar Saque;\n");
									System.out.printf("2 - Realizar Deposito;\n");
									System.out.printf("3 - Visualizar informações da conta;\n");
									System.out.printf("4 - Alterar senha;\n");
									System.out.printf("5 - Voltar ao menu inicial;\n");
									opcaoCliente = entrada.nextInt();
				
									switch( opcaoCliente ){
									case 1: //Realiza Saque
										System.out.printf("Digite o valor a ser sacado:\n");
										valor = entrada.nextDouble();
										contas[i].sacar(valor);
										break;
    
									case 2: //Realiza Deposito
										System.out.printf("Digite o valor a ser depositado:\n");
										valor = entrada.nextDouble();
										contas[i].depositar(valor);
										break;
    
									case 3: //Visualizar informações da conta
										contas[i].imprime();
										break;
    
									case 4: //Alterar senha
										entrada.nextLine();
										System.out.printf("Digite a senha da conta:\n");
										senha = entrada.nextLine();
										System.out.printf("Digite a nova senha da conta:\n");
										senhaNova = entrada.nextLine();
										contas[i].alterarSenha(senha, senhaNova);
										break;
									case 5: //Voltar
										break;
									default:
										System.out.printf("Opcao invalida!\n");
										break;
									}
								}	
							//existeConta++;
							//qtdErro--;
						} 
					}
					//if(qtdErro > 0){
						//qtdErro++;
					//	System.out.printf("O numero ou a senha da conta esta incorreto!\n");
					//}
					//existeConta = 0;
					//}

				}else{ 
					if(opcao == 3){  //sair
						System.exit(0);
					}else{
						System.out.printf("Opcao invalida!\n");
					}
				}
			}
		}
    }
    
}
