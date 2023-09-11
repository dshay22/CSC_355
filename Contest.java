public class Contest {
    private String name;
    private int score;

    public Contest(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }

    public int compareTo(Contest obj){
        
        return -1;
    }

    public String toString(Contest obj){
        String formattedString;
        String playerName = obj.name;
        String playerScore = string_to_int(obj.score);

        formattedString = playerName + ": " + playerScore;

        return formattedString;
    }

    public String string_to_int(int x){
       return Integer.toString(x);
    }

}
