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

    public int compareTo(Contestant incoming){
        if(this.score > incoming.getScore()){
            return -1;
        }
        else if(this.score < incoming.getScore()){
            return 1;
        }
        else{
            return this.name.compareTo(incoming.getName());
        }
    }

    public String toString(){
        return this.name + ": " + Integer.toString(this.score);
    }
}
