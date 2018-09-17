import java.util.Scanner;
public class ContaTest{
	public static void main(String args[]){
		Conta contas[] = new Conta[10];
		int opcao = 0, opcaoGerente = 0, opcaoCliente = 0, tipoConta = 0, qtdContas = 0, numeroDaConta, existeNumero = 0, qtdErro = 3;
		String senha, senhaNova;
		double valor;
		Scanner entrada =  new Scanner(System.in);
		
		while(opcao!=3){
			System.out.printf("Digite:\n");
			System.out.printf("1 - Gerente;\n");
			System.out.printf("2 - Cliente;\n");
			System.out.printf("3 - Sair;\n");
			opcao = entrada.nextInt();
			
			if(opcao == 1){  //gerente
				while((opcaoGerente!=3)||(qtdContas<10)){
					System.out.printf("Digite:\n");
					System.out.printf("1 - Cria nova conta ;\n");
					System.out.printf("2 - Visualizar informações de uma conta;\n");
					System.out.printf("3 - Voltar ao menu inicial;\n");
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
									qtdContas++;
									contas[qtdContas] = new ContaSimples();
									break;
    
								case 2:
									qtdContas++;
									contas[qtdContas] = new ContaPoupanca();
									break;
    
								case 3:
									qtdContas++;
									contas[qtdContas] = new ContaEspecial();
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
									contas[i].imprimir();
									existeNumero++;
								} 
							}
							if(existeNumero == 0){
								System.out.printf("O numero da conta nao existe!\n");
							}
							existeNumero = 0;
							break;
    
						case 3: //volta
							break;
    
						default:
							System.out.printf("Opcao invalida!\n");
							break;
					}
				}
				
			}else{
				if(opcao == 2){  //cliente
					while(qtdErro>0){ // pode errar no maximo 4 vezes
					System.out.printf("Digite o numero da conta:\n");
					numeroDaConta = entrada.nextInt();
					entrada.nextLine();
					System.out.printf("Digite a senha da conta:\n");
					senha = entrada.nextLine();
					
					//verifico se o numero e a senha estao corretos
					for(int i = 0; i<qtdContas; i++){
						if((contas[i].getNumero() == numeroDaConta)&&(contas[i].getSenha() == senha)){
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
										contas[i].imprimir();
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
							qtdErro--;
						} 
					}
					if(qtdErro != 0){
						//qtdErro++;
						System.out.printf("O numero ou a senha da conta esta incorreto!\n");
					}
					//existeConta = 0;
					}
					qtdErro = 0;
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