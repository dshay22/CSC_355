package project1;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

class LeaderBoardTest {
    // Your program begins with a call to main().
    // Prints "Hello, World" to the terminal window.
    public static void main(String args[])
    {
        try {
            Contestant[] collection_of_Contestants;
            File myObj = new File("project1/names.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {  
              String data = myReader.nextLine();
              Contestant myContestant = new Contestant(getName(data), getScore(data));
              
            }

            myReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String getName(String line){
      return line.substring(0, getIndexOfComma(line));
    }

    public static int getScore(String line){
        return  Integer.parseInt(line, getIndexOfComma(line) + 1);
    }

    public static int getIndexOfComma(String line){
        return line.indexOf(",", 0);
    }

}
