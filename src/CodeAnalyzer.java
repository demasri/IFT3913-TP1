import Java.util.io;
import Java.util.List;
import java.util.ArrayList;

/***
 * 
 * Cette classe calcule les metriques voulues du code Java associe
 * @author Daniel El-Masri (20096261) && William Bach (20127144)
 *
 */
public class CodeAnalyzer 
{
    String path; //chemin absolu du folder contenant les files a analyser
    String[][] classes; //2d array avec chaque ligne de chaque classe
    String[] classNames; //noms des classes associees 
    List<List<int[]>> methods; //index des méthodes de chaque classe
    List<List<int[]>> methodNames; //noms des methodes associees

    /**
     * Constructeur. Enregistre les attributs
     * @param path: chemin absolu du folder avec les files
     */
    public CodeAnalyzer(String path) 
    {
        this.path = path;
    }

    /**
     * Recupere les lignes de chaque classe grace a FileManager
     * @param path
     * @return 2d array avec les lignes de chaque classe
     */
    public String[][] getClasses(String path) 
    {
        //TODO
    }

    /**
     * Renvoie ls index (= no de 'ligne' dans classes) des methodes de chq classe.
     * On utilise une ArrayList car on ne sait pas a l'avance combien de methodes
     * une classe va avoir.
     * @return index des methodes de chaque classe
     */
    public List<List<int[][]>> getMethodes()
    {
        //TODO
    }

    /**
     * Produit les files CSV pour sauvegarder les .
     */
    public void produceCSV()
    {
        //TODO
    }


    /**
     * Calcule le nombre de lignes de code non-vides dans une classe
     * @param allLines les lignes de la classe
     * @return 
     */
    private int classe_LOC(ArrayList<String> allLines)
    {
        //TODO
    }

    /**
     * Calcule le nombre de lignes de codes non-vides dans une methode
     * @param allLines les lignes de la methode
     * @return
     */
    private int methode_LOC(ArrayList<String> allLines)
    {
        //TODO
    }

    /**
     * Calcule le nombre de lignes-commentaires dans une classe
     * @param allLines
     * @return
     */
    private int classe_CLOC(ArrayList<String> allLines)
    {
        //TODO
    }

    /**
     * Calcule le nombre de lignes-commentaires dans une methode
     * @param allLines
     * @return
     */
    private int methode_CLOC(ArrayList<String> allLines)
    {
        //TODO
    }

    /**
     * Calcule la densite de commentaires d'une classe
     * @param alLines
     * @return
     */
    private float classe_DC(ArrayList<String> alLines)
    {
        //TODO
    }

    /**
     * Calcule la densite de commentaires dans une methode
     * @param alLines
     * @return float car valeur non-entiere (pourcentage)
     */
    private float methode_DC(ArrayList<String> alLines)
    {
        //TODO
    }

    public static void main(String[] args) 
    {
        String folderToAnalyze = args[0];
        CodeAnalyzer analyzer = new CodeAnalyzer(folderToAnalyze);

        //TODO
    }

}
