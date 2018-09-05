import java.util.Scanner;

public class JogoDaVelha{
	public static void main(String args[]){
		int tabuleiro[][] = {{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}}; //array de alunos		
		boolean ganhou = false,  velha = false, posOcupada = false;
		int posicao, qualJogador = 0;
		Scanner entrada =  new Scanner(System.in);
		
		imprimeTabuleiro(tabuleiro);
		
		while((ganhou == false)&&(velha==false)){
			System.out.printf("Escolha uma posicao jogador %d:\n", qualJogador);
			posicao = entrada.nextInt();
			
			if ((posicao>=0)&&(posicao<3)){
				if(tabuleiro[0][posicao]==-1){
					tabuleiro[0][posicao] = qualJogador;
				}else{
					System.out.println("Esta posicao ja esta ocupada! Tente novamente.");
					posOcupada = true;
				}
			}else{
				if ((posicao>=3)&&(posicao<6)){
					if(tabuleiro[1][posicao-3]==-1){
						tabuleiro[1][posicao-3] = qualJogador;
					}else{
						System.out.println("Esta posicao ja esta ocupada! Tente novamente.");
						posOcupada = true;
					}
				}else{
					if ((posicao>=6)&&(posicao<9)){
						if(tabuleiro[2][posicao-6]==-1){
							tabuleiro[2][posicao-6] = qualJogador;
						}else{
							System.out.println("Esta posicao ja esta ocupada! Tente novamente.");
							posOcupada = true;
						}
					}
				
				}
				
			}
			
			imprimeTabuleiro(tabuleiro);
			
			ganhou = ganha(qualJogador, tabuleiro);
			if(posOcupada == false){
				if(qualJogador == 0){
					qualJogador++;
				}else{
					qualJogador = 0;
				}
			}else{
				posOcupada = false;
			}
			velha = velha(tabuleiro);
		}
		
		

		
	}
	public static boolean velha(int tabuleiro[][]){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(tabuleiro[i][j] == -1){
					return false;
				}
			}
		}
		System.out.println("Deu Velha!");
		return true;
	}
	
	public static void imprimeTabuleiro(int tabuleiro[][]){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.printf(" %d ",tabuleiro[i][j]);
				if(j!=2){ //se não for ultima coluna
					System.out.printf("|");
				}else{
					System.out.printf("\n");
				}
			}
			if(i!=2){ //se não for ultima linha
					System.out.println("-------------");
				}
		}
	}
	
	public static boolean ganha(int jogador, int tabuleiro[][]){
		int soma[]={0,0,0};
		int ponto = 0;
		//linha
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(tabuleiro[i][j] == jogador){
					ponto++;	
				}
			}
			if(ponto==3){
				System.out.printf("Jogador %d Ganhou linha",jogador);
				return true;
			}
			ponto = 0;
		}
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(tabuleiro[i][j] == jogador){
					soma[i]++;	
				}
			}	
			if(soma[i]==3){
				System.out.printf("Jogador %d Ganhou coluna",jogador);
				return true;
			}
		}
		
		ponto = 0;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(i==j){
					if(tabuleiro[i][j] == jogador){
						ponto++;	
					}
				}
			}	
		}
		
		if(ponto==3){
				System.out.printf("Jogador %d Ganhou diagonal p",jogador);
				return true;
		}
		
		ponto = 0;
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(i+j==2){
					if(tabuleiro[i][j] == jogador){
						ponto++;		
					}
				}
			}	
		}
		if(ponto==3){
				System.out.printf("Jogador %d Ganhou diagonal s",jogador);
				return true;
		}
		return false;
	}
	
}
