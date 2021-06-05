import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;


class Main {

    public static void main(String[] args) {
        Robot r = new Robot();
        try {

          File f = new File("testinputs/e.txt");
          Scanner sc = new Scanner(f);
          
          while (sc.hasNextLine()) {
            String c = sc.nextLine(); 
            r.Command(c); // Process command
          }
          
          sc.close();

        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }
}