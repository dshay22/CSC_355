package project1;
public class LeaderBoard {
     private Contestant[] leaderBord;

     public LeaderBoard(int m){  //Constructor for the leaderboard class
        this.leaderBord = new Contestant[m]; 
     }

     public void add(Contestant c) {                                   //add fucntion which determines if a new contestant should be added
          for(int i = 0; i < leaderBord.length; ++i){                  //this for loop goes through the leaderboard list

               if(this.leaderBord[i] == null){                         //if a leaderboard spot is empty then insert the new contestant automatically
                    this.leaderBord[i] = c;
                    break;
               }
               else if(leaderBord[i].compareTo(c) > 0) {               //otherwise call the compare to function to determine if a new contestant should be added
                    for (int j = leaderBord.length - 1; j > i; --j) {  //if a new contestant needs to be added this for loop shifts
                         leaderBord[j] = leaderBord[j - 1];            //all the current leaderboard down one index 
                    }                                                  //after the spot where the addition is made.
                    leaderBord[i] = c;                                 //is line replaces the old person with the new addition.
                    break;                                             //break the loop
               }
          }
     }

     public Contestant[] finalBoard() {        //function to return the final leaderboard based on this leaderboard object
        return this.leaderBord;
     }
}