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
        tmpPrev.next = tail;
        tail.prev = tmpPrev;
        this.size--;
    }

    // Method to delete a node with the given value
    public void delete(int data) {
        Node currentNode = head.next;
        Node prevNode = head;
    
        while (currentNode != null) {
            if (currentNode.data == data) {
                prevNode.next = currentNode.next;
    
                if (currentNode.next != null) {
                    currentNode.next.prev = prevNode;
                }
    
                currentNode.next = null;
                currentNode.prev = null;
    
                this.size--;
                return; 
            }
    
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        this.size--;
    }

    // Method to search for a certain element
    public int search(int data) {
        Node currentNode = head.next;
        Node tailNode = tail.prev;
        int index = 0;
        int tailIndex = this.size - 1;
        int mid = this.size / 2;

        while (currentNode.next != null && tailNode.prev != null && index < mid) {
            if (currentNode.data == data) {
                return index;
            }
            if (tailNode.data == data) {
                return tailIndex;
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
    
        if (tmpNext != null) {
            System.out.print(tmpNext.data);
            tmpNext = tmpNext.next;
    
            while (tmpNext != tail) {
                System.out.print(" -> " + tmpNext.data);
                tmpNext = tmpNext.next;
            }
    
            System.out.println();
        }
    }

    // Method for backward traversal
    public void backwardTraversal() {
        Node tmpPrev = tail.prev; // Start from the tail's predecessor

        System.out.print("                      Backward: ");
    
        if (tmpPrev != null) {
            System.out.print(tmpPrev.data);
    
            while (tmpPrev != head) {
                System.out.print(" -> " + tmpPrev.data);
                tmpPrev = tmpPrev.prev;
            }
    
            System.out.println();
        }
    }

    public boolean checkHead() {
        return head.next == tail && tail.prev == head;
    }
}
