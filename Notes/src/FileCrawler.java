import java.util.*;
import java.io.*;

public class FileCrawler {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String fName;

        System.out.println("What file/directory would you like to start at?");
        System.out.print(" --->");
        fName = keyboard.nextLine();

        // If this was hard coded in it could be used as malware.
        File startFile = new File(fName);
        if(startFile.exists()) {
            displayInfo(startFile);
        } else {
            System.out.println("File not found, please try again.");
            System.exit(-1);
        }



    }

    // This is a helper method so that both parameters in the the
    // private method. this one would have Java docs.
    // This is needed so other programmers can call displayInfo
    // without having to put zero which is needed.
    public static void displayInfo(File x) {
        displayInfo(x, 0);
    }

    private static void displayInfo(File x, int level) {

        for(int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        System.out.println(x.getName());

        if(x.isDirectory()) {
            for(File innerX: x.listFiles()) {
                displayInfo(innerX, level + 1);
            }
        }
        // THIS WILL DELETE EVERYTHING(spaced in case the // is removed).
        //x.d e l e t e();
    }

}
