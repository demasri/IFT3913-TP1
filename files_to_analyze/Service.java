
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Service implements Comparable<Service> {

	private String date_debut;    //  Format dd-MM-yyyy
	private String date_fin;      //  Format dd-MM-yyyy
	private String heure_debut;   // Format HH:mm:ss
	private String recurrence_hebdo;
	private int cap_max;
	private int num_pro;
	private String id; // 7 char number
	private float frais;
	private String Commentaire;
	private int inscriptions;
	private ArrayList<Membre> MembresInscrits;
	
	// Constructeur id non existant
	public Service(String date_debut, String date_fin, String heure_debut,
			String recurrence_hebdo, String cap_max, String num_pro, int rank, String Commentaire) {
	
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.heure_debut = heure_debut;
		this.recurrence_hebdo = recurrence_hebdo;
		this.cap_max = Integer.parseInt(cap_max);
		this.num_pro = Integer.parseInt(num_pro);
		setID(rank);
		this.Commentaire = Commentaire;
		frais = 100;
		this.MembresInscrits = new ArrayList<Membre>();
		this.inscriptions = 0;
	}

	// Constructeur id existant
	public Service(String date_debut, String date_fin, String heure_debut,
			String recurrence_hebdo, String cap_max, String num_pro,
			String id, String Commentaire) {
	
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.heure_debut = heure_debut;
		this.recurrence_hebdo = recurrence_hebdo;
		this.cap_max = Integer.parseInt(cap_max);
		this.num_pro = Integer.parseInt(num_pro);
		this.id = id;
		frais = 100;
		this.Commentaire = Commentaire;
		this.MembresInscrits = new ArrayList<Membre>();
		this.inscriptions = 0;
	}

	private String formatDate(LocalDateTime now) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		return now.format(formatter);
	}
	
	public String toString() {
		return  "Date et heure actuelles : " + formatDate(LocalDateTime.now()) + "\n" +
				"Date de d�but du service : " + date_debut + "\n" +
				"Date de fin du service : " + date_fin + "\n" +
				"Heure du service : " + heure_debut + "\n" +
				"R�currence hebdomadaire : " + recurrence_hebdo + "\n" +
				"Capacit� maximale : " + cap_max + "\n" +
				"Num�ro du professionnel : " + num_pro + "\n" +
				"Code du service : " + id + "\n" +
				"Commentaires : " + Commentaire + "\n";
	}
	
	public void inscrire(Membre m) {
		if(inscriptions + 1 > cap_max) {
			System.out.println("Inscription refus�e : capacit� maximum atteinte");
		} else {
			inscriptions++; 
			MembresInscrits.add(m);
		}
	}
	
	public boolean findInscription(String id) {
		boolean estInscrit = false;
		
		for(int i = 0; i < MembresInscrits.size(); i++) {
			if (MembresInscrits.get(i).getID().contentEquals(id)) {
				estInscrit = true;
				break;
			}	
		}
		
		return estInscrit;
	}
	
	public ArrayList<Membre> getInscrits() {
		return MembresInscrits;
	}
	
	public int getInscriptions() {
		return inscriptions;
	}
	
	public void setID(int rank) {
		String s = "" + rank;		
		while(s.length() < 7) {
			s = "0" + s;
		}
		id = s;
	}

	public String getID() {
		return id;
	}
	
	public String printInscriptions() {
		return "Code du service : " + id + "\n" +
				"Nombre d'inscriptions : " + inscriptions + "\n";
	}
	
	public String toCSV() {
		return  date_debut + "," + date_fin + "," + heure_debut +
				"," + recurrence_hebdo + "," + cap_max + "," + 
				num_pro + "," + id + "," + Commentaire + "\n";
	}
	
	public float getFrais() {
		return frais;
	}
	
	public String getDateDebut() {
		return date_debut;
	}
	public String getDateFin() {
		return date_fin;
	}

	public int compareTo(Service s) {
		int id1 = Integer.parseInt(this.id);
		int id2 = Integer.parseInt(s.id);
		
		if (id1 > id2) return 1;
		else if (id1 < id2) return -1;
		else return 0;
	}

}