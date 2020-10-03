import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * La classe "DatabaseMembre" regroupe toutes les méthodes liées aux
 * membres du Centre , ainsi que les données liées à ceux-ci.
 * @author william.
 *
 */
public class DatabaseMembre {
	
	/**
	 * L'attribut "PATH_TO_MEMBERS" est le chemin du fichier contenant toutes les données liées aux membres.
	 */
	private static final String PATH_TO_MEMBERS = "..\\Members.csv";
	/**
	 * L'attribut "membres" est une ArrayList contenant la liste de tous les membres du Centre (instances de Membre).
	 */
	private static ArrayList<Membre> membres = new ArrayList<Membre>();

	
	/**
	 * Constructeur de la classe "DatabaseMembre".
	 */
	public DatabaseMembre() {
		super();
	}

	/**
	 * Méthode permettant d'ajouter un nouveau membre au Centre de Données.
	 * @param m: instance de la classe Membre représentant le nouveau membre.
	 */
	public static void addMember(Membre m) {
		membres.add(m);
	}

	/**
	 * Méthode permettant de retrouver les données d'un membre du
	 * Centre grâce à son identifiant.
	 * @param id: identifiant du membre recherché.
	 * @return: les données du membre voulu (instance de Membre).
	 */
	public Membre findMember(String id) {
		int i = 0;
		Membre m = null;
		while (i < membres.size()) {
			Membre j = membres.get(i);			
			if (j.getID().equals(id) ) {
				m = j;
				break;
				
			}else i++;
		}		
		return m;
	}

	/**
	 * Cette méthode lit le fichier CSV 'Members.csv' pour retranscrire
	 * tous les Membres et leurs infos après une fermeture du logiciel.
	 * Les Membres lus sont stockés dans une ArrayList quand le logiciel
	 * est actif.
	 * La méthode est appelée lors du lancement de l'interface.
	 * @param path chemin vers le fichier Members.csv.
	 * @return: l'ArrayList contenant les Membres
	 */
	public static void getMembres() {
		String path = PATH_TO_MEMBERS;
		
		try {
			FileReader reader = new FileReader(path);
			
			BufferedReader csvReader = new BufferedReader(reader);
			
			String row;
			while ((row = csvReader.readLine()) != null) {
			    String[] data = row.split(",");
			    membres.add(new Membre(data[0],data[1],data[2],data[3],data[4],data[5],data[6]));
			}
			csvReader.close();
			
			
		} catch(IOException e) {
			System.out.println("Le logiciel n'a pu accéder au répertoire des Membres");
		}
		
	}

	/**
	 * Méthode s'occupant de supprimer un membre du Centre de données.
	 * @param id: identifiant du membre à supprimer.
	 */
	public static void removeMembre(String id) {
		int length = membres.size();
		for(int i=0; i<length; i++) {
			if(membres.get(i).getID().equals(id)) {
				membres.remove(i);
				return;
			}
		}		
	}

	/**
	 * Cette méthode lit l'ArrayList contenant tous les Membres
	 * et la retranscrit dans le fichier Members.csv.
	 * La méthode est appelée à chaque fois que le logiciel
	 * est fermé.
	 */
	@SuppressWarnings("resource")
	public static void updateMembersFile() {
		try {
			FileWriter csvWriter = new FileWriter(PATH_TO_MEMBERS,false);
			int i = 0;
			while(i < membres.size() && membres.get(i) != null) {
				csvWriter.append(membres.get(i).toCSV());
				csvWriter.flush();
				i++;
			}
			csvWriter.close();
			
		} catch(IOException e) {
			System.out.println("Le fichier Membres.csv n'a pu etre créé ou modifié");
		}
	}

	/**
	 * Getter pour la liste des membres.
	 * @return: la liste des membres (ArrayList).
	 */
	public ArrayList<Membre> getMembresList() {
		return this.membres;
	}
}