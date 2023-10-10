public class DoublyLinkedList {

    // Inner node class for the doubly linked list
    private class Node {
        int  data;
        Node prev;
        Node next;

        public Node() {
            this.next = null;
            this.prev = null;
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public DoublyLinkedList() {
        this.head = new Node();
        this.tail = new Node();
        this.head.next = tail;
        this.tail.prev = head;
    }

    // Method to insert a node
    public void insert(int data) {
        Node newNode = new Node(data);
        Node prevNode = tail.prev;

        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = tail;
        tail.prev = newNode;

        this.size++;
        // Node newNode = new Node(data);

        // if(head.next == null){
        //     head.next = newNode;
        //     tail.prev = newNode;

        //     newNode.prev = head;
        //     this.size++;
        //     return;
        // }

        // Node temp = head.next;

        // while(temp.next != null){
        //     temp = temp.next;
        // }

        // temp.next = newNode;
        // newNode.prev = temp;
        // tail.prev = newNode;
        // this.size++;
    }

    // Method to delete the head
    public void deleteHead() {
        Node tmpNext = head.next;
        head = null;
        head = tmpNext;
        this.size--;
    }

    // Method to delete the tail
    public void deleteTail() {
        Node tmpPrev = tail.prev.prev;
        tail.prev = null;
        tmpPrev.next = null;
        tail.prev = tmpPrev;
        this.size--;
    }

    // Method to delete a node with the given value
    public void delete(int data) {
        Node currentNode = head.next;
        int currentIndex = 0;
        int index = search(data);
        while (currentNode != null) {
            if (currentIndex == index) {
                if (currentNode.prev != null) {
                    currentNode.prev.next = currentNode.next;
                }
                if (currentNode.next != null) {
                    currentNode.next.prev = currentNode.prev;
                }
                // Optionally, you can set the next and prev of the node to be deleted to null.
                currentNode.next = null;
                currentNode.prev = null;
                return; // Node found and deleted.
            }
    
            currentNode = currentNode.next;
            currentIndex++;
        }
        this.size--;
    }

    // Method to search for a certain element
    public int search(int data) {
        Node currentNode = head.next;
        Node tailNode = tail.prev;
        int index = 0;
        int tailIndex = this.size - 1;

        while (currentNode.next != null && tailNode.prev != null) {
            if (currentNode.data == data) {
                return index; // Return the index of the node where data was found.
            }
            if (tailNode.data == data) {
                return tailIndex; // Return the index from the tail side.
            }

            currentNode = currentNode.next;
            tailNode = tailNode.prev;
            index++;
            tailIndex--;
        }

        return -1;
    }

    // Method for forward traversal
    public void forwardTraversal() {
        Node tmpNext = head.next;

        System.out.print("For DoublyLinkedList: Forward:  ");
        System.out.print(tmpNext.data + " -> ");
        while(tmpNext.next != null){
            tmpNext = tmpNext.next;
            if(tmpNext.next == null){
                System.out.print(tmpNext.data);
            }
            else{
                System.out.print(tmpNext.data + " -> ");
            }
        }
        System.out.print("\n");
    }

    // Method for backward traversal
    public void backwardTraversal() {
        // TODO: Implement this method
    }

    public boolean checkHead(){
        if(head == null){
          return true;
        }
        return false;
      }
}
