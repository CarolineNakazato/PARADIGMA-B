import java.util.Scanner;	
public class ParImpar{
	public static void main (String args[] ){
		int numero;
		Scanner entrada= new Scanner(System.in);
		
		System.out.print("Digite um numero:\n");
		numero = entrada.nextInt();// recebo o numero informado pelo usuário
		
		if(numero%2 == 0){
			System.out.println("Numero eh Par");
		}else{
			System.out.println("Numero eh Impar");
		}
	}	
}
	
