public class personne {
    private String Nom;
    private String Id;
    private String Prenom;
    
    public personne(String prenom, String nom,String id) {
    	this.Prenom = prenom;
    	this.Nom = nom;
    	this.Id = id;
    }

    public String getNom() {
        return Nom;
    }

    public String getID() {
        return Id;
    }

    public String getPrenom() {
        return Prenom;
    }
}