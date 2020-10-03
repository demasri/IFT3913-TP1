import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
	
	//fichier csv sauvegardant les services même en cas de fermeture du logiciel
	private static ArrayList<Service> services = new ArrayList<Service>();
	private static ArrayList<Membre> membres = new ArrayList<Membre>();
	private static ArrayList<Proffesionnel> pros = new ArrayList<Proffesionnel>();

	public static void main(String[] args) throws IOException {
		
		// Va chercher les services, membres/pros stock�s en d�but d'ex�cution.
		DataBase.getServices();
		DataBase.getMembres();
		DataBase.getPros();
		
		// Ex�cution de la logique de l'interface
		System.out.println("Veuillez choisir une option: \n");
		
		//Pour les tests, un membre valide et un membre suspendu
		Membre membreTest = new Membre("william", "bach", "1234567");
		DataBase.addMember(membreTest);
		Membre membreSuspenduTest = new Membre("Elissa", "Holzer", "7654321");
		membreSuspenduTest.Suspendre();
		DataBase.addMember(membreSuspenduTest);
		
		//Différents services proposés par le logiciel
		System.out.println("1) Adhésion");
		System.out.println("2) Accès au local");
		System.out.println("3) Inscription à un service");
		System.out.println("4) Création d'un service");
		System.out.println("5) Consultation de l'état d'un service");
		System.out.println("6) Confirmation d'inscription");
		
		Scanner scanner = new Scanner(System.in);
		int choixClient = scanner.nextInt();
		
		switch(choixClient) {
			
			case 1:	//Adhésion (membre ou professionnel)
				
					System.out.println("\nNom de famille:");
					scanner.nextLine();
					String nomDeFamille = scanner.nextLine();
					
					System.out.println("\nPrénom:");
					String prenom = scanner.nextLine();
					
					int numeroMembre = (int) (Math.random() * 10000000);
					String numeroMembreString = Integer.toString(numeroMembre);
					
					System.out.println("\nProfessionnel ?: [y/n]");
					char reponse = scanner.nextLine().charAt(0);
					if(reponse == 'y' || reponse == 'Y') {
						Proffesionnel nouveauPro = new Proffesionnel(prenom, nomDeFamille, numeroMembreString);
						DataBase.addPro(nouveauPro);
					}
					else {
						Membre nouveauMembre = new Membre(nomDeFamille, prenom, numeroMembreString);
						DataBase.addMember(nouveauMembre);
					}
					
					System.out.println("\n"+ prenom +" "+ nomDeFamille +" ajouté au Centre de Données.");
					System.out.println("Numéro de membre: " +numeroMembre);
					
					break;
					
			case 2: //Accès au local
				
					System.out.println("\nEntrer le numéro de membre: ");
					scanner.nextLine();
					int codeMembreAValider = scanner.nextInt();
					String membreAValider = Integer.toString(codeMembreAValider);
					Membre aValider = DataBase.findMember(membreAValider);
					boolean numeroValide = (aValider != null);

					if(!numeroValide)
						System.out.println("\nNuméro non valide.");
					else {
						if (aValider.getStatus()) {
							System.out.println("\nMembre suspendu.");
						} else
							System.out.println("\nAccès au local validé. ");
					}
					
					break;
					
			case 3: //Inscription à un service
					
					//Vérification du numéro de membre
					System.out.println("\nVeuillez entrer le numéro de membre:");
					scanner.nextLine();
					String numAVerifier = scanner.nextLine();
					boolean membreExiste = false;
					Membre membreAInscrire = null;
					for(int i=0; i<membres.size(); i++) {
						if(membres.get(i).getID().equals(numAVerifier)) {
							membreAInscrire = membres.get(i);
							membreExiste = true;
							break;
						}
					}
					if(!membreExiste) {
						System.out.println("\nNuméro de membre invalide."); 
						break; 
					} else if(membreAInscrire.getStatus()) {
						System.out.println("\nMembre suspendu."); 
						break;
					}
					
					//Inscription au service voulu
					System.out.println("\nListe des services: \n");
					for(int i=0; i<services.size(); i++) {
						System.out.println(i +": "+ services.get(i).getID());
					}
					System.out.println("\nVeuillez choisir le numéro correspondant au service"
							+ " en question");
					
					int choixService = scanner.nextInt();
					services.get(choixService).inscrire(membreAInscrire);
					System.out.println("\nMembre inscrit avec succès.");
					
					break;
					
			case 4: //Création d'un service
				
					System.out.println("\nDate de début du service: (dd-MM-yyyy)");
					scanner.nextLine();
					String dateDebut = scanner.nextLine();
					
					System.out.println("\nDate de fin du service: (dd-MM-yyyy)");
					String dateFin = scanner.nextLine();
					
					System.out.println("\nHeure du service: (HH:mm:ss)");
					String heureService = scanner.nextLine();
					
					System.out.println("\nRécurrence hebdomadaire: (jour jour..)");
					String recHebdo = scanner.nextLine();
					
					System.out.println("\nCapacité maximale: ");					
					String capMax = scanner.nextLine();
					
					System.out.println("\nNuméro du professionnel: ");
					String numPro = scanner.nextLine();
					
					int newCodeServiceInt = (int) (Math.random() * 10000000);
					String newCodeServiceStr = Integer.toString(newCodeServiceInt);
					
					System.out.println("\nCommentaires? [y/n]");
					char rep = scanner.nextLine().charAt(0);
					String commentaire = null;
					if(rep == 'y') {
						commentaire = scanner.nextLine();
					}
					
					Service nouveauService = new Service(dateDebut, dateFin, heureService, 
							recHebdo, capMax, numPro, newCodeServiceStr, commentaire);
					services.add(nouveauService);
					System.out.println("\nService  créé! \n");
					System.out.println(nouveauService);
					
					break; 
				
			case 5: //Consultation de l'état d'un service
				
					System.out.println("\nVeuillez entrer le code du service:");
					int codeServiceAConsulter = scanner.nextInt();
					boolean serviceExiste = false;
					
					for(int i=0; i<services.size(); i++) {
						int codeServiceToInt = Integer.parseInt(services.get(i).getID());
						if (codeServiceToInt == codeServiceAConsulter) {
							serviceExiste = true;
							System.out.println("\n" +services.get(i));
						}
					}
					
					if(!serviceExiste) 
						System.out.println("\nPas de service correspondant.");
					
					break;
					
			case 6: //Confirmation d'inscription
				
					//Choix du service à confirmer
					System.out.println("\nListe des services: \n");
					for(int i=0; i<services.size(); i++) {
						System.out.println(i +": "+ services.get(i).getID());
					}
					System.out.println("\nVeuillez choisir le numéro correspondant au service"
							+ " en question");
					int codeService2 = scanner.nextInt();
					Service serviceChoisi = services.get(codeService2);
					
					//Vérification du numéro de membre à confirmer
					System.out.println("\nVeuillez entrer le numéro de membre:");
					scanner.nextLine();
					String numAVerifier2 = scanner.nextLine();
					boolean membreExiste2 = false;
					Membre membreAInscrire2 = null;
					for(int i=0; i<membres.size(); i++) {
						if(membres.get(i).getID().equals(numAVerifier2)) {
							membreAInscrire2 = membres.get(i);
							membreExiste2 = true;
							break;
						}
					}
					if(!membreExiste2) {
						System.out.println("\nNuméro de membre invalide."); 
						break; 
					} else if(membreAInscrire2.getStatus()) {
						System.out.println("\nMembre suspendu."); 
						break;
					} 
					//Vérification de l'inscription du membre 
					else {
						ArrayList<Membre> listeMembresInscrits = serviceChoisi.getInscrits();
						boolean membreInscrit = false;
						for(int i=0; i<listeMembresInscrits.size(); i++) {
							if(listeMembresInscrits.get(i) == membreAInscrire2) {
								System.out.println("Inscription confirmée.");
								membreInscrit = true;
							}
						}
						if(!membreInscrit) {
							System.out.println("Le membre n'est pas inscrit.");
							break;
						}
						
						break;
					}
				
			default: System.out.println("\nVeuillez réessayer.");
					 break;
		}

		scanner.close();
		
		// ex�cut� en fin d'ex�cution pour ajouter les nouveaux services, membres/pros sur les fichiers CSV.
		DataBase.updateServicesFile();
		DataBase.updateMembersFile();
		DataBase.updateProsFile();
	}

	//RESTE A SAUVEGARDER LES MEMBRES INSCRITS DANS LE CSVFILE
}

