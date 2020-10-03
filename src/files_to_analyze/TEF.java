import java.time.LocalDate;
import java.time.LocalDateTime;


public class TEF {
	private String nomPro;
	private String proID;
	private float salaire;
	private String contenu;
	
	public TEF(Proffesionnel pro) {
		this.nomPro = pro.getNom() + ", " + pro.getPrenom();
		this.proID = pro.getID();
		this.salaire = makeSalaire(pro.getActivites());
		
		contenu = "TEF : \n\n\n" +" Numéro du professionnel : " + proID +
				"\n" + "Nome du professionnel : " + nomPro + 
				"\n" +	"Montant à payer : " + salaire;
	}

	private float makeSalaire(Service[] liste) {
		float total = 0;
		int i = 0;
		while(i < liste.length && liste[i] != null) {
			Service s =liste[i];
			LocalDate now = LocalDateTime.now().toLocalDate();
			LocalDate debut = LocalDate.parse(s.getDateDebut());
			LocalDate fin = LocalDate.parse(s.getDateFin());
			
			if (now.isAfter(debut) && now.isBefore(fin)) {			
				total += s.getFrais();
			}
			i++;
		}		
		return total;
	}
	
	public String toString() {
		return contenu;
	}
}