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
      if(tmpNext.next != null){
        tmpNext.next = head.next;
      }
      else{
        head = null;
        return;
      }
      while(tmpNext.next.next != null){
        tmpNext = tmpNext.next;
      }
      tmpNext.next = null;
    }

    // Method to delete a node with the given value
    public void delete(int data) {
      Node tmpNext = head;
      Node prevTemNode = head;

      if(tmpNext.data == data){
        head = tmpNext.next;
      }

      while(tmpNext.data != data){
        if(tmpNext.next != null){
          prevTemNode = tmpNext;
          tmpNext = tmpNext.next;
        }
      }

      prevTemNode.next = tmpNext.next;
      tmpNext = null;
    }

    // Method to search for a certain element
    public int search(int data) {
      Node tmpNext = head;
      int count = 0;
      while(tmpNext.data != data){
        tmpNext = tmpNext.next;
        count++;
      }

      if(tmpNext.data == data){
          return count;
      }
      
      return -1;
    }

    // Method for traversal
    public void traverse() {
      Node tmpNext = head;

      System.out.print("\nFor SimplyLinkedList: Forward:  ");
      if (tmpNext != null) {
        System.out.print(tmpNext.data);
        tmpNext = tmpNext.next;

        while (tmpNext != null) {
            System.out.print(" -> " + tmpNext.data);
            tmpNext = tmpNext.next;
        }

        System.out.println();
    }

      System.out.print("\n");
    }

    public boolean checkHead() {
      return head == null;
    }
}
