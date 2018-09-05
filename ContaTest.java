import java.util.Scanner;
public class ContaTest{
	public static void main(String args[]){
		String senhaAntiga;
		Conta conta1 = new Conta("ANA", 1345, 40.50);
		Conta conta2 = new Conta();
		Conta conta3 = new Conta();
		Scanner entrada =  new Scanner(System.in);
		
		conta1.sacar(40.00);
		conta1.imprime();
		
		conta2.setNumero(16253);
		conta2.setNome("Paula");
		conta2.setLimite(400.00);
		conta2.depositar(100.00);
		System.out.printf("Digite o valor que voce quer sacar.\n");
		conta2.sacar(entrada.nextDouble());
		conta2.imprime();
		
		
		System.out.printf("Digite o numero da conta.\n");
		conta3.setNumero(entrada.nextInt());
		entrada.nextLine();//fiz um nextLine novamente pois se não ele pula
		System.out.printf("Digite o nome do(a) correntista.\n");
		conta3.setNome(entrada.nextLine());
		System.out.printf("Digite o valor do limite.\n");
		conta3.setLimite(entrada.nextDouble());
		System.out.printf("Digite o valor que voce quer sacar.\n");
		conta3.depositar(entrada.nextDouble());
		System.out.println("Voce esta alterando a senha.");
		System.out.printf("Digite senha antiga.\n");
		senhaAntiga = entrada.nextLine();
		entrada.nextLine();
		System.out.printf("Digite nova senha.\n");
		conta3.alterarSenha(senhaAntiga,entrada.nextLine());
		
		conta3.imprime();

		
	}
}