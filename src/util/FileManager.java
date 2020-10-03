import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/***
 * FileManager handles the search and extraction of all .java files in
 * the folder to analyze.
 * @author William Bach (20127144)
 *
 */
public class FileManager {
    String path; //absolute path of the folder to analyze

    /**
     * Constructor
     * @param path attribute 
     */
    public FileManager(String path)
    {
        this.path = path;
    }

    /**
     * Sends to CodeAnalyzer every line of every .java file in the attribute 
     * folder
     * @return 2D Strings array
     * 
     * SOURCE: https://stackabuse.com/java-list-files-in-a-directory/
     */
    public String[][] getClassesArray()
    {
        //get the .java File objects 
        File[] classes = listFiles(this.path);

        //store the lines of every file found
        ArrayList<ArrayList<String>> classesArray = new ArrayList<ArrayList<String>>();
        //extract every line of every File
        for (var i=0; i<classes.length; i++) 
        {
            try {
                List<String> allLines = Files.readAllLines(
                    Paths.get(classes[i].getAbsolutePath()));
                    System.out.println(allLines);
                //convert List of lines to ArrayList for convenience
                ArrayList<String> allLinesArrayList = new ArrayList<String>(allLines);
                //add to the @return array
                classesArray.add(allLinesArrayList);
            } 
            catch (IOException e) {
                System.out.println("Something went wrong (getClassesArray)");
                System.exit(1);
            }
        }

        //convert ArrayList to a String array for the main class
        String[][] finalArray = new String[classesArray.size()][];
        for (var i=0; i<classesArray.size(); i++)
        {
            ArrayList<String> fileContent = classesArray.get(i);
            finalArray[i] = fileContent.toArray(new String[fileContent.size()]);
        }
        return finalArray;

    }

    /**
     * Sends to CodeAnalyzer the name of all the classes to be analyzed
     * @return String array of names
     */
    public String[] getClassNamesArray() 
    {
        File[] classes = listFiles(this.path);
        String[] classNames = new String[classes.length];

        for (var i=0; i<classes.length; i++)
        {
            classNames[i] = classes[i].getName();
            System.out.println(classNames[i]);
        } 

        return classNames;
        
    }

    /**
     * Searches the folder  
     * @param startDir folder
     * 
     * SOURCE: https://stackabuse.com/java-list-files-in-a-directory/
     */
    private File[] listFiles(String startDir) 
    {
        File[] files = null;

        try {
            //extracts files from up to 20 inner folders
            files = Files.walk(Paths.get(startDir), 20)
            .filter(Files::isRegularFile)
            .map(Path::toFile)
            .toArray(File[]::new);

        } catch (Exception e) {
            System.out.println("Something went wrong.");
            System.exit(1);
        }
    
        //extraction of files .java 
        File[] javaFiles = new File[files.length];
        int counter = 0;
        for (var i=0; i<files.length; i++)
        {
            if (files[i].getName().endsWith(".txt")) {
                javaFiles[counter] = files[i];
                counter++;
            }
        }
        return javaFiles;
        
    }
    
    public static void main(String[] args) 
    {
        System.out.println(args[0]);
        FileManager test = new FileManager(args[0]);
        test.getClassNamesArray();
    }
    



}
    
