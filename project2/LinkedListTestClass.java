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
      headObj.insertAfterKnownNode(nodeObj1);

      nodeObj2 = new SimplyLinkedList(2);
      nodeObj1.insertAfterKnownNode(nodeObj2);

      nodeObj3 = new SimplyLinkedList(3);
      nodeObj2.insertAfterKnownNode(nodeObj3);

      nodeObj4 = new SimplyLinkedList(4);
      nodeObj3.insertAfterKnownNode(nodeObj4);

      nodeObj5 = new SimplyLinkedList(5);
      nodeObj4.insertAfterKnownNode(nodeObj5);

      nodeObj6 = new SimplyLinkedList(6);
      nodeObj5.insertAfterKnownNode(nodeObj6);

      nodeObj7 = new SimplyLinkedList(7);
      nodeObj6.insertAfterKnownNode(nodeObj7);

      // Print linked list
      System.out.println("The Original list:");
      headObj.TraversingList(headObj);

      headObj.deleteNode(headObj, 2);

      System.out.println("\n\nThe deleted list:");
      headObj.TraversingList(headObj);

      System.out.println("\n\nThe inserted list:");
      SimplyLinkedList nodeObj1111 = new SimplyLinkedList(1111);
      SimplyLinkedList nodeObj2222 = new SimplyLinkedList(2222);
      SimplyLinkedList nodeObj4444 = new SimplyLinkedList(4444);
      SimplyLinkedList nodeObj8888 = new SimplyLinkedList(8888);
      SimplyLinkedList nodeObj10000 = new SimplyLinkedList(10000);
      headObj.insertAtElementLocation(headObj, nodeObj1111, 0);
      headObj.insertAtElementLocation(headObj, nodeObj2222, 4);
      headObj.insertAtElementLocation(headObj, nodeObj4444, 4);
      headObj.insertAtElementLocation(headObj, nodeObj8888, 9);
      headObj.insertAtLast(headObj, nodeObj10000);
      headObj.TraversingList(headObj);

      System.out.println("\nSearching for Values");
      SimplyLinkedList nodesearchObject;
      nodesearchObject = headObj.searchNodes(headObj, 7);
      nodesearchObject.printNodeData();
      System.out.println("\n");
      nodesearchObject = headObj.searchNodes(headObj, 7777);
      nodesearchObject.printNodeData();
      System.out.println("\n");

      System.out.println("Traversing List");
      headObj.TraversingList(headObj);
      nodesearchObject = headObj.TraversingList(headObj, 5);
      nodesearchObject.printNodeData();
      System.out.println("\n");
   }
}
