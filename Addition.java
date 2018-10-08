// Addition.java
// Programa de adicao que utiliza JOptionPane para entrada e saida.  
import javax.swing.JOptionPane; 
// programa utiliza JOptionPane 
public class Addition 
{ 
	public static void main( String[] args ){ 
	// obtem a entrada de usuario a partir dos dialogos de entrada JOptionPane
	String firstNumber = 
	JOptionPane.showInputDialog( "Enter first integer" ); 
	String secondNumber = 
	JOptionPane.showInputDialog( "Enter second integer" ); 
	
	// converte String em valores int para utilizacdo em um calculo 
	int numberl = Integer.parseInt( firstNumber ); 
	int number2 = Integer.parseInt( secondNumber ); 
	int sum = numberl + number2; // soma os nomeros 20 

	
	// exibe o resultado em um dialog() de mensagem JOptionPane Exibe um dialogo de 
	JOptionPane.showMessageDialog( null, "The sum is " + sum, 
	"Sum of Two Integers", JOptionPane.PLAIN_MESSAGE );
	}
}
	

