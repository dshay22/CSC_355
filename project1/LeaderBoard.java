package project1;
public class LeaderBoard {
   private Contestant[] leaderBord;
   private int leaderBordSize;

   public LeaderBoard(int m){
        this.leaderBord = new Contestant[m];
        this.leaderBordSize = m;
   }

   public void add(Contestant c) {
        for(int i = 0; i < this.leaderBordSize; ++i){
            if(this.leaderBord[i] == null){
                this.leaderBord[i] = c;
            }
        } 
   }

   public Contestant[] finalBoard() {
        Contestant[] finalArray = new Contestant[this.leaderBordSize];

        

        return finalArray;
   }
}