package project1;
public class LeaderBoard {
   private Contestant[] leaderBord;
   private int leaderBordSize;
   private boolean noMoreNULLVals = false;

   public LeaderBoard(int m){
        this.leaderBord = new Contestant[m];
        this.leaderBordSize = m;
   }

   public void add(Contestant c) {
     int replaceIndex = -1;
     if(!this.noMoreNULLVals){
          int index = isNULL();
          if(index >= 0){
          this.leaderBord[index] = c;
          return;
          }
          else{
               this.noMoreNULLVals = true;
          }
     }

     for(int i = 0; i < leaderBordSize; ++i){
          if(leaderBord[i].compareTo(c) > 0){
               replaceIndex = i;
               break;
          }
     }

     if(replaceIndex != -1){
          shiftArray(leaderBord, replaceIndex, leaderBordSize - 1);
          leaderBord[replaceIndex] = c;
     }
     
   }

   public Contestant[] finalBoard() {
        return this.leaderBord;
   }

   public int isNULL(){
     for(int i = 0; i < this.leaderBordSize; ++i){
          if(this.leaderBord[i] == null){
               return i;
          }
     }
     return -1;
   }

   public void shiftArray(Contestant[] myArray, int startIndex, int endIndex){
     for (int i = endIndex; i > startIndex; i--) {
          myArray[i] = myArray[i - 1];
      }
   }
}