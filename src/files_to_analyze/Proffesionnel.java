
public class Proffesionnel extends personne{
	
	private Service[] activites;
	
	public Proffesionnel(String prenom ,String nom, String id) {
		super(prenom,nom, id);
		this.activites = new Service[3];
		
		// TODO Auto-generated constructor stub
	}
	
	public void addActivities(Service nouvelleActivite) {
		int length = this.activites.length;
		Service[] nouveauTab = new Service[length+1];
		for(int i = 0; i < length+1; i++) {
			nouveauTab[i] = this.activites[i];
			if(i==length) {
				nouveauTab[i] = nouvelleActivite;
			}
		}
		this.activites = nouveauTab;
	}

	public void removeActivities(Service activite){
		int length = this.activites.length;
		Service[] nouveauTab = new Service[length-1];
		for(int i = 0; i < length; i++) {
			if(this.activites[i] == activite) {
				continue;
			}
			else{
				nouveauTab[i] = this.activites[i];
			}
		}
		this.activites = nouveauTab;
	}
	
	public Service[] getActivites() {
		return activites;
	}
	
	public String toCSV() {
		return getNom() + "," + getPrenom() + "," + getID() + "\n";
	}

}