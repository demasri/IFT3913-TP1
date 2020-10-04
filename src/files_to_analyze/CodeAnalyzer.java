
import java.util.List;
import java.util.ArrayList;

/***
 * 
 * Cette classe calcule les metriques voulues du code Java associe
 * @author William Bach (20127144) && Daniel El-Masri (20096261)  
 *
 */
public class CodeAnalyzer 
{
    FileManager manager; //manager qui gere l'extraction des classes
    String path; //chemin absolu du folder contenant les files a analyser
    String[][] classes; //2d array avec chaque ligne de chaque classe
    String[] classNames; //noms des classes associees 

    /**
     * Constructeur. Enregistre les attributs
     * @param path: chemin absolu du folder avec les files
     */
    public CodeAnalyzer(String path)                                            
    {
        this.manager = new FileManager(path);
        this.path = path;
        this.classes = getClasses(path); getMethodes();                          
        this.classNames = getClassNames(path);

    }

    /**
     * Recupere les lignes de chaque classe grace a FileManager
     * @param path
     * @return 2d array avec les lignes de chaque classe
     */
    public String[][] getClasses(String path) 
    {
        return this.manager.getClassesArray();
    }

    /**
     * Recupere les noms de chaque classe grace a FileManager
     * @param path
     * @return array de Strings avec les noms de chaque classe
     */
    public String[] getClassNames(String path) 
    {
        return this.manager.getClassNamesArray();
    }

    /**
     * Renvoie ls index (= no de 'ligne' dans classes) des methodes de chq classe.
     * On utilise une ArrayList car on ne sait pas a l'avance combien de methodes
     * une classe va avoir.
     * @return index des methodes de chaque classe
     */
    public void getMethodes()
    {
        for (var i=0; i < this.classes.length; i++){
            for (var j=0; j < this.classes[i].length; j++) 
            {
                //si on trouve une déclaration de méthode dans la ligne lue
                if((this.classes[i][j].contains("void")      ||
                    this.classes[i][j].contains("public")    ||
                    this.classes[i][j].contains("protected") ||
                    this.classes[i][j].contains("private")) 
                    &&
                   (this.classes[i][j].endsWith(") {")       ||
                    this.classes[i][j].endsWith("){")        ||
                    this.classes[i][j].endsWith(")"))) 
                {
                    //on sauvegarde l'index de la declaration
                    int idx = j;

                    //on retrouve le nom de la methode
                    String[] declarationTokens = this.classes[i][j].split(" ");    
                    String name = "";
                    for (String token : declarationTokens) {
                        //le nom de la methode est colle a la parenthese gauche
                        if (token.contains("(")) name = token.substring(0, token.indexOf("("));
                    }                    
                    
                    //on ajoute dans l'array de la classe un identificateur (le nom de la methode)
                    //no javadoc
                    if (this.classes[i][j-1].isBlank()) 
                        this.classes[i][j-1] = "METHOD= " + name;
                    //w/ javadoc
                    else {
                        while (!(this.classes[i][j-1].isBlank())) 
                            j--;
                        this.classes[i][j-1] = "METHOD= " + name;
                    }

                    j = idx+1;
                }
            }
        }
    }

    /**
     * Produit les files CSV pour sauvegarder la data
     *
    public void produceCSV()
    {
        //TODO
    }*/


    /**
     * Calcule le nombre de lignes de code non-vides dans une classe
     * @param allLines les lignes de la classe
     * @return 
     */
    private int classe_LOC(String[] allLines)
    {
        int counter = 0;

        for (var i=0; i < allLines.length; i++) 
        {
            if (allLines[i].isBlank() || allLines[i].contains("METHOD=")) 
                continue;
            else ++counter;
        }

        return counter;
    }

    /**
     * Calcule le nombre de lignes de codes non-vides dans une methode
     * @param allLines les lignes de la methode
     * @return
     */
    private int methode_LOC(String[] allLines)
    {
        return classe_LOC(allLines);
    }

    /**
     * Calcule le nombre de lignes-commentaires dans une classe
     * @param allLines
     * @return
     */
    private int classe_CLOC(String[] allLines)
    {
        int counter = 0;

        for (var i=0; i < allLines.length; i++) 
        {
            System.out.println(allLines[i]);
            if (allLines[i].contains("/*")) {
                System.out.println("true (multiline)");
                while (!(allLines[i].contains("*/"))) {
                    System.out.println(allLines[i]);
                    ++counter;
                    ++i;
                }
                System.out.println("end multiline");
            } 
            else if (allLines[i].contains("//")) {
                System.out.println("true (single line)");
                ++counter;
            }
        }

        return counter;
    }

    /**
     * Calcule le nombre de lignes-commentaires dans une methode
     * @param allLines
     * @return
     */
    private int methode_CLOC(String[] allLines)
    {
        return classe_CLOC(allLines);
    }

    /**
     * Calcule la densite de commentaires d'une classe
     * @param alLines
     * @return
     */
    private float classe_DC(String[] allLines)
    {
        System.out.println(((float) (classe_CLOC(allLines) / classe_LOC(allLines))));
        return ((float) (classe_CLOC(allLines) / classe_LOC(allLines)));
    }

    /**
     * Calcule la densite de commentaires dans une methode
     * @param alLines
     * @return float car valeur non-entiere (pourcentage)
     */
    private float methode_DC(String[] allLines)
    {
        return ((float) (methode_CLOC(allLines) / methode_LOC(allLines)));
    }

    public static void main(String[] args) 
    {
        String folderToAnalyze = args[0];
        CodeAnalyzer analyzer = new CodeAnalyzer(folderToAnalyze);
        String[][] classes = analyzer.getClasses(folderToAnalyze);
        System.out.println(analyzer.getClassNames(folderToAnalyze)[7]);
        System.out.println(analyzer.classe_CLOC(classes[7]));
    }

}
