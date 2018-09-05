// o nome da class tem que ser igual a do arquivo.
import java.util.Scanner; // tem que ter essa biblioteca sempre que quiser ler do teclado.
public class Soma{	
	public static void main( String args[]){	
		Scanner input = new Scanner(System.in); 
		/* 		
			tipoDaVariavel nomeDaVariavel recebe valor;
			int			numero			= 		10;
			Scanner 		input 			= new Scanner(System.in);
		*/
		int number1, number2, sum;
		
		System.out.println("Digite o primeiro numero:");
		number1 = input.nextInt();
		
		System.out.println("Digite o segundo numero:");
		number2 = input.nextInt();
		
		sum = number1 + number2;
		
		System.out.printf("Soma = %d\n", sum);
		
		}
		
}
		
		

