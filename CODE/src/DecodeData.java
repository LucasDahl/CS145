import java.io.File;
import java.util.*;

/**
 *  This class will decode a huffman
 *  code fill by accepting a .huff and
 *  .code file.
 *
 * @author Lucas D. Dahl
 * @version 11/24/20
 */
public class DecodeData {

    /**
     * THis is the main method.
     * @param args the arguments to pass in.
     */
    public static void main(String[] args) {

        // Properties
        String codeFileName = "", huffFileName = "", codeString = "", miniString = "";
        Map<String, Character> codeMap = new TreeMap<>();
        File codeFile, huffFile;
        Scanner codeScanner = null, huffScanner = null;


        // Get the code file
        codeFileName = getFile(".code");

        // Try opening the file and set the scanner.
        try {
            codeFile = new File(codeFileName);
            codeScanner = new Scanner(codeFile);
        } catch(Exception e) {
            System.out.println("The code file doesn't exist, please try again.");
            System.exit(-1);
        }

        // Create the map
        while(codeScanner.hasNext()) {

            // Get the key and code
            char charCode = (char) codeScanner.nextInt();
            String code = codeScanner.next();

            // Put them into a map
            codeMap.put(code, charCode);

        }

        // Get the huff file
        huffFileName = getFile(".huff");

        // Try opening the file and set the scanner.
        try {
            huffFile = new File(huffFileName);
            huffScanner = new Scanner(huffFile);
            codeString = huffScanner.next();
        } catch(Exception e) {
            System.out.println("The huff file doesn't exist, please try again.");
            System.exit(-1);
        }

        // Decode the string
        for(int i = 0; i < codeString.length(); i++) {

            char c = codeString.charAt(i);
            miniString = miniString + c;

            if(codeMap.containsKey(miniString)) {
                System.out.print(codeMap.get(miniString));
                miniString = "";
            }

        }

    }

    // Ask the user for a file.
    private static String getFile(String fileFormat) {

        // Properties
        String file = "", format = "";
        Scanner keyboard = new Scanner(System.in);

        do {

            // Ask the user for the filename
            System.out.println("please enter a " + fileFormat + " file.");
            System.out.print("--> ");
            file = keyboard.nextLine();

            // Find the format of the file.
            if(!file.contains(".")) {
                file = file + "." + fileFormat;
            } else {
                int dotIndex = file.indexOf(".");
                format = file.substring(dotIndex);
            }

        } while(!format.equals(fileFormat));

        return file;
    }


}
