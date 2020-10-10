import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * La classe "VueMS" s'occupe de l'interface pour les fonctionnalités
 * de modification, suppression et ajout d'un service.
 * @author william.
 *
 */
public class VueMS extends VueClass {
	
	/**
	 * l'attribut "DATE_FORMAT" s'occupe de formater la date pour qu'elle respecte le format imposé.
	 */
	private final Pattern DATE_FORMAT = Pattern.compile("^\\d{2}-\\d{2}-\\d{4}$");
	/**
	 * l'attribut "HOUR_FORMAT" s'occupe de formater l'heure pour qu'elle respecte le format imposé.
	 */
	private final Pattern HOUR_FORMAT = Pattern.compile("([2][0-3]|[0-1][0-9]|[1-9]):[0-5][0-9]:([0-5][0-9]|[6][0])");
	
	/**
	 * Constructeur de la classe "VueMS".
	 * @param s: scanner utilisé pour recueillir les choix du professionnel.
	 */
	public VueMS(Scanner s) {
		super(s);
	}

	/**
	 * Cette méthode correspond au cas d'utilisation "Ajout / modification / suppression
	 * d'un service.
	 * L'agent demande d'abord le numéro du service en question puis effectue
	 * la procédure interactivement avec le professionnel.
	 */
	@Override
	public void display() {
		DataBase.displayServices();
		System.out.println("\nVeuillez entrer le numéro du service en question");
		scanner.nextLine();
		String codeS = scanner.nextLine();
		Service serviceC = DataBase.findService(codeS);
		
		if(serviceC == null ) {
			System.out.println("\nLe numéro de service entré n'est pas valide.");
		}
	
		System.out.println("Veuillez choisir ce que vous voulez modifier: \n");
		System.out.println("1) Modifier la date de début du service");
		System.out.println("2) Modifier la date de fin du service");
		System.out.println("3) Modifier la récurrence hebdommadaire du service");
		System.out.println("4) Modifier l'heure de début du service");
		System.out.println("5) Modifier les frais du service");
		System.out.println("6) Modifier la capacité maximale");
		System.out.println("7) Supprimer le service");
		
		int x = scanner.nextInt();
		switch (x) {
	
			case 1 : System.out.println("\nEntrer la nouvelle date de début");
					 scanner.nextLine();
			 		 String debut = scanner.nextLine();
			 		 while(!DATE_FORMAT.matcher(debut).matches()) {
						System.out.println("\n s'il vous plaît, entrez une date respectant ce format (dd-MM-yyyy)");
						debut = scanner.nextLine();
					 }
			 		 serviceC.setDate_debut(debut);
			 		 System.out.println("\nLa date de début a bien été modifié.");
			 		 break;
	
			case 2 : System.out.println("\nEtrer la nouvelle date de fin");
					 scanner.nextLine();
					 String fin = scanner.nextLine();
			 		 while(!DATE_FORMAT.matcher(fin).matches()) {
						System.out.println("\n s'il vous plaît, entrez une date respectant ce format (dd-MM-yyyy)");
						fin = scanner.nextLine();
					 }
			 		 serviceC.setDate_fin(fin);
					 System.out.println("\nLa date de fin a bien été modifiée.");
					 break;
					 
			case 3 : System.out.println("\nEntrer la nouvelle réurrence hebdomadaire");
				     scanner.nextLine();
				     String recH = scanner.nextLine();
				     serviceC.setRecurrence_hebdo(recH);
				     System.out.println("\nLa date récurrence hebdonadaire a bien été modifiée.");
					 break;
			
			case 4 : System.out.println("\nEntrer la nouvelle heure de début du service");
				 	 scanner.nextLine();
				 	 String heure = scanner.nextLine();
					
					 while(!HOUR_FORMAT.matcher(heure).matches()) {
						System.out.println("\n s'il vous plaît, entrez une heure respectant ce format (HH:mm:ss)");
						heure = scanner.nextLine();
					 }
					 serviceC.setHeure_debut(heure);
					 System.out.println("\nL'heure du début de la scéance a bien été modifiée.");
					 break;
			
			case 5 : System.out.println("\nEntrer les nouveaux frais de service");
					 scanner.nextLine();
					 int f = scanner.nextInt();
						
					 while(f > 100) {
						System.out.println("\n s'il vous plaît, entrez un frais de service de 100");
						f = scanner.nextInt();
					 }
					 serviceC.setFrais(f);
					 System.out.println("\nLes frais de la scéance a bien été modifiée.");
					 break;
			
			case 6 : System.out.println("\nEntrer la nouvelle capacité maximale");
					 scanner.nextLine();
					 int cap = scanner.nextInt();
						
					 while(cap > 30) {
							System.out.println("\n s'il vous plaît, entrez une capacité maximale en deça de 30");
							cap = scanner.nextInt();
					 }
					 serviceC.setCap_max(cap);
					 System.out.println("\nLa capacité maximale de la scéance a bien été modifiée.");
					 break;
	
			case 7 : System.out.println("\nVoulez-vous vraiment suprimmer le service ? [y]");
					 scanner.nextLine();
			 	  	 char r = scanner.nextLine().charAt(0);
			 	  	 if (r == 'y') {
			 	  		 DataBase.findPro(serviceC.getNum_pro()).removeActivities(codeS);
			 	  		 DataBase.removeService(codeS);
			 	  		 System.out.println("\nLe Service a bien été suprimmé.");}
			 	  	 else System.out.println("\nLe service n'a pas été suprimmé.");									 
			 	  	 break;
	
			default : break;				
		}		
	}

}