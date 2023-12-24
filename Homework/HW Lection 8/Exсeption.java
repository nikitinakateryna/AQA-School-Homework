import java.io.File;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Exсeption {
    public static void main(String[] args)  {



        try {
            readFile();
        }
        catch (FileNotFoundException e) {
            System.out.println("Such file name or directory is invalid. Check info below.");
            e.printStackTrace();

        }

        catch (MyException i){
            System.out.println(i.getMessage());
            i.printStackTrace();
        }


    }


    public static void readFile() throws FileNotFoundException, MyException {


        String path = "/Users/nikitinak/Desktop/test.txt";
        File myFile = new File(path);
        Scanner scanner = new Scanner(myFile);

        String line = scanner.nextLine();

        if (line.matches("\\d+")) {
            throw new MyException("File shouldn't contain numbers.");
        }

        else {

            while (scanner.hasNextLine()) {
                System.out.println(line);

            }

        }


        scanner.close();
    }

}