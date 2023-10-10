import java.util.LinkedList;
public class SimplyLinkedList {
    // Inner node class for the linked list
    private class Node {
        int  data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public SimplyLinkedList() {
        this.head = null;
    }

    // Method to insert a node
    public void insert(int data) {
      Node newNode = new Node(data);
     
      if(head == null){
        head = newNode;
        return;
      }

      Node tmpNext = head;

      while(tmpNext.next != null){
        tmpNext = tmpNext.next;
      }

      tmpNext.next = newNode;// Set the new node's next to the current head
    }

    // Method to delete the head
    public void deleteHead() {
        Node tmpNext = head.next;
        head = null;
        head = tmpNext;
    }

    // Method to delete the tail
    public void deleteTail() {
      Node tmpNext = head;
      tmpNext.next = head.next;
      while(tmpNext.next.next != null){
        tmpNext = tmpNext.next;
      }
      tmpNext.next = null;
    }

    // Method to delete a node with the given value
    public void delete(int data) {
      Node tmpNext = head;
      Node tmpNextNext;

      int elementIndex = search(data);
      for(int i = 0; i < elementIndex - 1; ++i){
        tmpNext = tmpNext.next;
      }

      tmpNextNext = tmpNext.next.next;
      tmpNext.next = null;
      tmpNext.next = tmpNextNext;
    }

    // Method to search for a certain element
    public int search(int data) {
      Node tmpNext = head;
      int count = 0;
      while(tmpNext.next != null){
        tmpNext = tmpNext.next;
        count++;
        if(tmpNext.data == data){
          return count;
        }
      }
      return -1;
    }

    // Method for traversal
    public void traverse() {
      Node tmpNext = head;

      System.out.print(tmpNext.data + " ");
      while(tmpNext.next != null){
        tmpNext = tmpNext.next;
        System.out.print(tmpNext.data + " ");
      }
    }

    public boolean checkHead(){
      if(head == null){
        return true;
      }
      return false;
    }
}
