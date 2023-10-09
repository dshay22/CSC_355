import java.util.LinkedList;

public class SimplyLinkedList {

    private int dataVal;         // Node data
    private SimplyLinkedList nextNodeRef; // Reference to the next node
    private boolean isHead;

    public SimplyLinkedList() {
      this.nextNodeRef = null;
      this.isHead = true;
    }

   // Constructor
    public SimplyLinkedList(int dataInit) {
      this.dataVal = dataInit;
      this.nextNodeRef = null;
      this.isHead = true;
    }

    public void insertAfterKnownNode(SimplyLinkedList currLoc) {
      SimplyLinkedList tmpNext;

      tmpNext = this.nextNodeRef;
      this.nextNodeRef = currLoc;
      currLoc.nextNodeRef = tmpNext;
      currLoc.isHead = false;
    }

    public void insertAtElementLocation(SimplyLinkedList head, SimplyLinkedList insertNode,int insertIndex) {
        SimplyLinkedList beforeInsertion = TraversingList(head, insertIndex);
        SimplyLinkedList tmpNext;

        tmpNext = beforeInsertion.getNext();
        beforeInsertion.nextNodeRef = insertNode;
        insertNode.nextNodeRef = tmpNext;
        insertNode.isHead = false;
    }

    public void insertAtLast(SimplyLinkedList head, SimplyLinkedList insertNode) {
        SimplyLinkedList beforeInsertion;

        beforeInsertion = head;
        while(beforeInsertion.nextNodeRef != null){
          beforeInsertion = beforeInsertion.getNext();
        }

        beforeInsertion.nextNodeRef = insertNode;
        insertNode.isHead = false;
    }

    public void deleteNode(SimplyLinkedList head, int index) {
      SimplyLinkedList beforeDeletion = TraversingList(head, index);
      SimplyLinkedList afterDeletion;

      afterDeletion = beforeDeletion.getNext().getNext();
      beforeDeletion.nextNodeRef = afterDeletion;
    }

    public SimplyLinkedList searchNodes(SimplyLinkedList head, int target){
        SimplyLinkedList searchNode;

        searchNode = head;
        while((searchNode.getDataVal() != target)){
          if(searchNode.nextNodeRef == null){
            System.out.println("Node not found \nReturning Last node in the list:");
            break;
          }
          searchNode = searchNode.getNext();
        }

        return searchNode;
    }

    public void TraversingList(SimplyLinkedList head){
      SimplyLinkedList traverseNode;

      traverseNode = head;
      while((traverseNode.nextNodeRef != null)){
        if(!traverseNode.isHead){
          traverseNode.printNodeData();
        }
        traverseNode = traverseNode.getNext();
      }

      System.out.println();
    }

    public SimplyLinkedList TraversingList(SimplyLinkedList head, int index){
      SimplyLinkedList traverseNode;

      traverseNode = head;
      for(int i = 0; i < index; ++i){
        if(!traverseNode.isHead){
          traverseNode.printNodeData();
        }
        traverseNode = traverseNode.getNext();
      }

      return traverseNode;
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