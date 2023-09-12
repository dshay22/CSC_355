package project1;
public class Contestant {
    private String name;
    private int score;

    public Contestant(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }

    public int compareTo(Contestant obj){
        
        return -1;
    }

    public String toString(Contestant obj){
        String formattedString;
        String playerName = obj.name;
        String playerScore = int_to_String(obj.score);

        formattedString = playerName + ": " + playerScore;

        return formattedString;
    }

    public String int_to_String(int x){
       return Integer.toString(x);
    }

}
