package project1;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
class LeaderBoardTest {
    public static void main(String args[])   //the main function is used to call a runCode function for different test cases of value m
    {
        runCode(10);                                                 //all values of m are hardcoded as stated in the frequently asked questions
        System.out.println("\n\n Program Finished test Case 1 \n\n");
        runCode(20);
        System.out.println("\n\n Program Finished test Case 2\n\n");
        runCode(30);
        System.out.println("\n\n Program Finished test Case 3\n\n");
        runCode(100);
        System.out.println("\n\n Program Finished test Case 4\n\n");
        runCode(500);
        System.out.println("\n\n Program Finished test Case 5\n\n");
    }

    public static void runCode(int m){                                     //Function that runs the desired assignment code
        try {
            File myObj = new File("project1\\names.txt");                   //variables needed to exicute the program
            Scanner myReader = new Scanner(myObj);
            String data;
            LeaderBoard myLeaderBoard;
            Contestant myContestant;
            // int m = 0;
            
            // m = myReader.nextInt();                                            //Size of the final array
            // data = myReader.nextLine();                                        //Currently gets the white space after the "m" number

            myLeaderBoard = new LeaderBoard(m);                                //creates the leaderBoard object of size m
            
            while(myReader.hasNextLine()){
                data = myReader.nextLine();                                    //This gets the names in the list
                myContestant = new Contestant(getName(data), getScore(data));  //creates the contestant objects
                myLeaderBoard.add(myContestant);                               //calls the add fucntion to determine if the new contestant should be added to the leaderboard
            }

            Contestant[] finalBoard = myLeaderBoard.finalBoard();              //After the while loop this line creates the final leaderboard

            for(int i = 0; i < finalBoard.length; ++i){                        //This for loop prints the final leaderboard
                System.out.println(finalBoard[i].toString());
            }

            myReader.close();                                                //close the Scanner object
        } 
        catch (FileNotFoundException e) {                                      //All of my code is in a try catch in case of errors
            System.out.println("An error occurred.");                        //one such error could be that the input M is greater than the inputs
            e.printStackTrace();                                               //in this case the leaderboard is printed with the error message
        }
    }

    public static String getName(String line){                          //funtion to get the name portion of the line based on the index of a comma
      return line.substring(0, getIndexOfComma(line));
    }
 
    public static int getScore(String line){                           //funtion to get the score portion of the line based on the index of a comma
        return  Integer.parseInt(line.substring(getIndexOfComma(line) + 1, line.length()));
    }

    public static int getIndexOfComma(String line){                   //funtion to get the index of a comma
        return line.indexOf(",", 0);
    }
}
