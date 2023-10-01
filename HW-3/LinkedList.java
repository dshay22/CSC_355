public class LinkedList {
  private int dataVal;         // Node data
   private LinkedList nextNodeRef; // Reference to the next node

   public LinkedList() {
      dataVal = 0;
      nextNodeRef = null;
   }

   // Constructor
   public LinkedList(int dataInit) {
      this.dataVal = dataInit;
      this.nextNodeRef = null;
   }

   /* Insert node after this node.
    Before: this -- next
    After:  this -- node -- next
    */
   public void insertAfter(LinkedList currLoc) {
      LinkedList tmpNext;

      tmpNext = this.nextNodeRef;
      this.nextNodeRef = currLoc;
      currLoc.nextNodeRef = tmpNext;
   }

   // Get location of nextNodeRef
   public LinkedList getNext() {
      return this.nextNodeRef;
   }

   public int getDataVal() {
      return this.dataVal;
   }

   public void printNodeData() {
      System.out.print(this.dataVal + " ");
   }
}
