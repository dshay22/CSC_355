package project1;
public class LeaderBoard {
     private Contestant[] leaderBord;
     private boolean noMoreNULLVals = false;

     public LeaderBoard(int m){
        this.leaderBord = new Contestant[m];
     }

     public void add(Contestant c) {


          // if(!this.noMoreNULLVals){
          //      int index = isNULL();
          //      if(index >= 0){
          //      this.leaderBord[index] = c;
          //      return;
          //      }
          //      else{
          //           this.noMoreNULLVals = true;
          //      }
          // }

          for(int i = 0; i < leaderBord.length; ++i){

               if(this.leaderBord[i] == null){
                    this.leaderBord[i] = c;
                    break;
               }

               if (leaderBord[i].compareTo(c) > 0) {
                    for (int j = leaderBord.length - 1; j > i; --j) {
                         leaderBord[j] = leaderBord[j - 1];
                    }
                    leaderBord[i] = c;
                    break;
               }
          }
     }

     public Contestant[] finalBoard() {
        return this.leaderBord;
     }

     // public int isNULL(){
     //      for(int i = 0; i < leaderBord.length; ++i){
     //           if(this.leaderBord[i] == null){
     //                return i;
     //           }
     //      }
     //      return -1;
     // }
}