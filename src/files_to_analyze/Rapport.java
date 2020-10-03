import java.util.ArrayList;

public class Rapport {
	private int totalPros;
	private int totalServices;
	private String rapport;
	
	public Rapport(ArrayList<Proffesionnel> pros, ArrayList<Service> services) {
		totalPros = pros.size();
		totalServices = services.size();
		
		StringBuilder str = new StringBuilder();
		
		/* TODO
		 * Concaténer des lignes comprenant le nom du professionnel, 
		 * le total de service qu'il a donner et les frais exigibles.
		 * 
		 * */
				
		rapport = str.toString();
	}
	
	public String toString() {
		
		return rapport;
	}
}