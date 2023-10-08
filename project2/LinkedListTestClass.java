import java.util.LinkedList;

public class LinkedListTestClass {
    public static void main(String[] args) {
        SimplyLinkedList headObj;  // Create IntNode reference variables
        SimplyLinkedList nodeObj1;
        SimplyLinkedList nodeObj2;
        SimplyLinkedList nodeObj3;
        SimplyLinkedList nodeObj4;
        SimplyLinkedList nodeObj5;
        SimplyLinkedList nodeObj6;
        SimplyLinkedList nodeObj7;
        SimplyLinkedList currObj;
  
        // Front of nodes list
        headObj = new SimplyLinkedList(); 
        
        // Insert more nodes
        nodeObj1 = new SimplyLinkedList(1);
        headObj.insertAfter(nodeObj1);
  
        nodeObj2 = new SimplyLinkedList(2);
        nodeObj1.insertAfter(nodeObj2);
  
        nodeObj3 = new SimplyLinkedList(3);
        nodeObj2.insertAfter(nodeObj3);

        nodeObj4 = new SimplyLinkedList(4);
        nodeObj3.insertAfter(nodeObj4);

        nodeObj5 = new SimplyLinkedList(5);
        nodeObj4.insertAfter(nodeObj5);

        nodeObj6 = new SimplyLinkedList(6);
        nodeObj5.insertAfter(nodeObj6);

        nodeObj7 = new SimplyLinkedList(7);
        nodeObj6.insertAfter(nodeObj7);
  
        // Print linked list
        System.out.println("The Original list:");
        currObj = headObj;
        while (currObj != null) {
           currObj.printNodeData();
           currObj = currObj.getNext();
        }

        headObj.deleteNode(headObj, 2);

        System.out.println("\n\nThe deleted list:");
        currObj = headObj;
        while (currObj != null) {
           currObj.printNodeData();
           currObj = currObj.getNext();
        }

        System.out.println("\n\nThe inserted list:");
        SimplyLinkedList nodeObj1111 = new SimplyLinkedList(1111);
        SimplyLinkedList nodeObj2222 = new SimplyLinkedList(2222);
        headObj.insertAfter(headObj, nodeObj1111, 0);
        headObj.insertAfter(headObj, nodeObj2222, 4);
        currObj = headObj;
        while (currObj != null) {
           currObj.printNodeData();
           currObj = currObj.getNext();
        }
    }
}
