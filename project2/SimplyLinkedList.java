import java.util.LinkedList;

public class SimplyLinkedList {

    private int dataVal;         // Node data
    private SimplyLinkedList nextNodeRef; // Reference to the next node

    public SimplyLinkedList() {
      dataVal = -9999;
      nextNodeRef = null;
    }

   // Constructor
    public SimplyLinkedList(int dataInit) {
      this.dataVal = dataInit;
      this.nextNodeRef = null;
    }

   /* Insert node after this node.
    Before: this -- next
    After:  this -- node -- next
    */
    public void insertAfter(SimplyLinkedList currLoc) {
      SimplyLinkedList tmpNext;

      tmpNext = this.nextNodeRef;
      this.nextNodeRef = currLoc;
      currLoc.nextNodeRef = tmpNext;
    }

    public void insertAfter(SimplyLinkedList head, SimplyLinkedList insertNode,int insertIndex) {
        SimplyLinkedList beforeInsertion;
        SimplyLinkedList tmpNext;

        beforeInsertion = head;
        for(int i = 0; i < insertIndex; ++i){
            beforeInsertion = beforeInsertion.getNext();
        }

        tmpNext = beforeInsertion.getNext();
        beforeInsertion.nextNodeRef = insertNode;
        insertNode.nextNodeRef = tmpNext;
    }

    public void deleteNode(SimplyLinkedList head, int nodeLocation) {
        SimplyLinkedList beforeDeletion = head;
        SimplyLinkedList afterDeletion;
        SimplyLinkedList currDeletion;

        for(int i = 0; i < nodeLocation; ++i){
            beforeDeletion = beforeDeletion.getNext();
        }

        currDeletion = beforeDeletion.getNext();
        afterDeletion = beforeDeletion.getNext().getNext();

        currDeletion = null;
        beforeDeletion.nextNodeRef = afterDeletion;
    }

    // Get location of nextNodeRef
    public SimplyLinkedList getNext() {
      return this.nextNodeRef;
    }

    public int getDataVal() {
      return this.dataVal;
    }

    public void printNodeData() {
      System.out.print(this.dataVal + " ");
    }

}