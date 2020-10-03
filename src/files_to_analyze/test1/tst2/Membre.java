
public class Membre extends personne{
	private boolean suspendu;
	public String activite;
	
	public Membre(String surname, String firstName,  String id) {
		super(firstName, surname, id);
		this.suspendu = false;
		// TODO Auto-generated constructor stub
	}

	public void Suspendre() {
		this.suspendu = true;
	}

	public boolean getStatus() {
		return suspendu;
	}

	public void setActivity(String activite) {
		this.activite = activite;
	}
	
	public String getActivity() {
		return activite;
	}
	
	public String toCSV() {
		return getNom() + "," + getPrenom() + "," + getID() + "," +
				suspendu + "," + activite + "\n";
	}
}