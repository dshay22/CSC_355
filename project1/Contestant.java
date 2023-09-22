package project1;
public class Contestant {
    private String name;
    private int score;

    public Contestant(String name, int score){  //Constructor for Contestant class
        this.name = name;
        this.score = score;
    }

    public String getName(){                   //return the name of the contestant
        return this.name;
    }

    public int getScore(){                     //return the score of the contestant
        return this.score;
    }

    public int compareTo(Contestant incoming){  //compare to contestants one from the leaderboard and a new one from the text file
        if(this.score > incoming.getScore()){   //leaderboard score is greater
            return -1;
        }
        else if(this.score < incoming.getScore()){ //leaderboard score is less
            return 1;
        }
        else{                                      //leaderboard score is a tie so the alphabet must be checked in the name
            return this.name.compareTo(incoming.getName());//compares the name for leaderboard spots
        }
    }

    public String toString(){  //returns a string of the leaderboard contestant.
        return this.name + ": " + Integer.toString(this.score);
    }
}
