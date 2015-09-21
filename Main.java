import java.util.Scanner;
public class Main {
	
	private static Scanner clavier;
	
	public static void Menu(){  // PROCEDURE AFIN D'AFFICHER LE MENU
		System.out.println("****************************************************************");
		System.out.println("*             APPRENDS LES TABLES DE MULTIPLICATION            *");
		System.out.println("* 1 - Veux tu voir la totalité des tables de multiplications ? *");
		System.out.println("*           2 - Veux tu voir une table particulière ?          *");
		System.out.println("*         3 - Veux tu réciter une table particulière ?         *");
		System.out.println("*      4 - Veux tu réaliser un test de tes connaissances ?     *");
		System.out.println("*           5 - Veux tu réaliser le meilleur score ?           *");
		System.out.println("*              6 - Veux tu quitter le programme ?              *");
		System.out.println("*                    Quel est ton choix ?                      *");
		System.out.println("****************************************************************");
		System.out.println("");
	}

	public static int Choix() {   // FONCTIONS RETOURNANT LE CHOIX DE L'UTILISATEUR
		
		int choix = clavier.nextInt();
		while(choix < 0 || choix > 6){
			System.out.println("Erreur de saisie, recommencez...");
			choix = clavier.nextInt();
		}
		return(choix);
	}
	
	public static void Total(){   //  PROCEDURE AFIN DE VOIR L'INTEGRALITE DES TABLES
		
	int i;
	int j;
	
		for( i = 1 ; i <= 10 ; i++ ){
			System.out.println("Table de " + i + " : ");	
			for( j = 1 ; j <= 10 ; j++ ){
				System.out.print(i + "x" + j + "=" + i * j + "	");	
			}
			System.out.println("");
		}
	clavier.nextLine();
	}
	
	public static void Particuliere(){  //  PROCEDURE AFIN DE PERMETTRE A L'UTILISATEUR DE VOIR UNE TABLE PARTICULIERE
		System.out.println("Quelle table voulez vous afficher ?");
		int i = clavier.nextInt();
		for( int j = 1 ; j <= 10 ; j++ ){
			System.out.print(i + "x" + j + "=" + i * j + "	");	
		}
		System.out.println("");
	}
	
	public static void Recitation(){  //  PROCEDURE AFIN DE DEMANDER A L'UTILISATEUR DE RECITER UNE TABLE VOULU
		int cptv = 0;
		System.out.println("Quelle table voulez vous reviser ? ");
		int j = clavier.nextInt();
		for( int i = 1 ; i <= 10 ; i++ ){
			System.out.print(i + " x " + j + " = ? : " );
			int k = clavier.nextInt();
			if (k == i*j){
				System.out.println("Juste");
				cptv = cptv + 1;
			}
			else{
				System.out.println("Faux!      " + i + " x " + j + " = " +(i*j));
			}
		}
		System.out.println("Tu as eu " + cptv + " sur 10");
		if( cptv == 10 ){
			System.out.println("Très bien, tu peux passer à une autre table.");
		}
		else{
			if( cptv >= 8){
				System.out.println("Assez Bien, mais il faut encore la revoir une ou deux fois.");
			}
			else{
				System.out.println("Il te faut encore apprendre cette table.");
			}
		}
	}
	
	public static void Test(){  //  PROCEDURE AFIN DE TESTER CES CONNAISSANCES
		float cptv = 0;
		System.out.println("Combien de question voulez vous ? ");
		int j = clavier.nextInt();
		for( int i = 1 ; i <= j ; i++ ){
			int k = (int) Math.round(Math.random()*10);
			int l = (int) Math.round(Math.random()*10);
			System.out.print(k + " x " + l + " = ? : " );
			int m = clavier.nextInt();
			if (m == k*l){
				System.out.println("Juste");
				cptv = cptv + 1;
			}
			else{
				System.out.println("Faux!      " + k + " x " + l + " = " +(k*l));
			}
		}
		cptv = (cptv/j);
		cptv = cptv * 10;
		int cptv1 = ( int ) cptv;
		switch(cptv1){
		case 10:{		
			System.out.println("10     : Très bien");
			break;
		}
		case 9:{		
			System.out.println("9     : Bien");
			break;
		}
		case 8:
		case 7:{
			System.out.println(cptv + "    : Assez Bien");
			break;
		}
		case 6:
		case 5:{		
			System.out.println(cptv + "    : Moyen");
			break;
		}
		case 4:
		case 3:
		case 2:
		case 1:
		case 0:{
			System.out.println(cptv + "    : A revoir");
			break;
		}
	}	
		System.out.println("Tu as eu " + cptv + " sur 10");
		
	}
	
	public static void MeilleurScore(){  //  PROCEDURE AFIN DE PERMETTRE A L'UTILISATEUR DE S'AMUSER EN TESTANT CES CONNAISSANCES ET FAIRE UN MEILLEUR SCORE
		System.out.println("C'est partie, bonne chance !");
		int compteur = 0;
		int k = (int) Math.round(Math.random()*10);
		int l = (int) Math.round(Math.random()*10);
		int m = k * l;
		System.out.println("C'est partie, bonne chance !");
		System.out.print(k + " x " + l + " = ? : " );
		m = clavier.nextInt();
		if (m == k*l){
			compteur = compteur + 1;
		}
		else{
			System.out.println("Faux finis ! ");
		}
		while(m == k*l){
			k = (int) Math.round(Math.random()*10);
			l = (int) Math.round(Math.random()*10);
			System.out.print(k + " x " + l + " = ? : " );
			m = clavier.nextInt();
			if (m == k*l){
				System.out.print(k + " x " + l + " = ? : " );
				compteur = compteur + 1;
			}
			else{
				System.out.println("Faux finis ! ");
			}
		}
		System.out.println("Voici votre score : " + compteur);
	}
	
	public static void main(String[] args) {  //  PROGRAMME PRINCIPAL
	clavier = new Scanner(System.in);

	Menu();
	
	int choix = Choix();
	
		while(choix != 6){
			switch(choix){
				case 1:{		// TOTALITE DES TABLES 
					Total();
					Menu();		
					choix = Choix();
					break;
				}
				case 2:{		// TABLE PARTICULIERE
					Particuliere();
					Menu();		
					choix = Choix();
					break;
				}
				case 3:{		// RECITATION TABLE PARTICULIERE
					Recitation();
					Menu();		
					choix = Choix();
					break;
				}
				case 4:{		// REALISER UN TEST
					Test();
					Menu();		
					choix = Choix();
					break;
				}
				case 5:{		// OBTENIR LE MEILLEUR SCORE
					MeilleurScore();
					Menu();		
					choix = Choix();
					break;
				}
				case 6:{
					break;
				}	
			}
		}
		System.out.println("****************************************************************");
		System.out.println("*                  Au revoir et à bientot !                    *");
		System.out.println("****************************************************************");
	}
}