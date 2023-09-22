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
            File myObj = new File("names.txt");
            Scanner myReader = new Scanner(myObj);
            Scanner myReader2 = new Scanner(myObj);
            String data;
            LeaderBoard myLeaderBoard;
            Contestant myContestant;
            int m = 0;
            
            m = myReader.nextInt();                                            //Size of the final array
            data = myReader.nextLine();                                        //Currently gets the white space after the "m" number

            myLeaderBoard = new LeaderBoard(m);                                //creates the leaderBoard object of size m
            
            // for(int i = 0; i < m; ++i){
            //     data = myReader.nextLine();                                    //This gets the names in the list
            //     myContestant = new Contestant(getName(data), getScore(data));  //creates the contestant objects
            //     myLeaderBoard.add(myContestant);
            // }
            //myReader.close();
            
            System.out.println(myReader.nextLine());
            
            while(myReader.hasNextLine()){
                data = myReader.nextLine();                                   //This gets the names in the list
                myContestant = new Contestant(getName(data), getScore(data));  //creates the contestant objects
                myLeaderBoard.add(myContestant);
            }

            Contestant[] finalBoard = myLeaderBoard.finalBoard();

            for(int i = 0; i < finalBoard.length; ++i){
                System.out.println(i + 1 + ": " + finalBoard[i].toString());
            }

            myReader2.close();
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
        return  Integer.parseInt(line.substring(getIndexOfComma(line) + 1, line.length()));
    }

    public static int getIndexOfComma(String line){
        return line.indexOf(",", 0);
    }
}
