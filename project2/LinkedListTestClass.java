import java.util.LinkedList;

public class LinkedListTestClass {
   public static void main(String[] args) {
      runSimplyLinkedListTests(makeSimplyLinkedList());
   }

   public static void runSimplyLinkedListTests(SimplyLinkedList headObj){

      // Print linked list
      System.out.println("The Original list:");
      headObj.TraversingList(headObj);

      System.out.println("\n\nThe deleted list TEST:");
      deleteNodeTest(headObj);
      headObj.TraversingList(headObj);

      insertNodes(headObj);


      // System.out.println("\nSearching for Values");
      // SimplyLinkedList nodesearchObject;
      // nodesearchObject = headObj.searchNodes(headObj, 7);
      // nodesearchObject.printNodeData();
      // System.out.println("\n");
      // nodesearchObject = headObj.searchNodes(headObj, 7777);
      // nodesearchObject.printNodeData();
      // System.out.println("\n");

      // System.out.println("Traversing List");
      // headObj.TraversingList(headObj);
      // nodesearchObject = headObj.TraversingList(headObj, 5);
      // nodesearchObject.printNodeData();
      // System.out.println("\n");
   }

   public static SimplyLinkedList makeSimplyLinkedList(){
      SimplyLinkedList headObj;  // Create IntNode reference variables
      SimplyLinkedList nodeObj1;
      SimplyLinkedList nodeObj2;
      SimplyLinkedList nodeObj3;
      SimplyLinkedList nodeObj4;
      SimplyLinkedList nodeObj5;
      SimplyLinkedList nodeObj6;
      SimplyLinkedList nodeObj7;

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

      return headObj;
   }

   public static void deleteNodeTest(SimplyLinkedList head){
      head.deleteNode(head, 4);
   }

   public static void insertNodes(SimplyLinkedList headObj){
      System.out.println("\n\nThe inserted list:");
      SimplyLinkedList nodeObj1111 = new SimplyLinkedList(11);
      SimplyLinkedList nodeObj2222 = new SimplyLinkedList(22);
      SimplyLinkedList nodeObj4444 = new SimplyLinkedList(33);
      SimplyLinkedList nodeObj8888 = new SimplyLinkedList(44);
      SimplyLinkedList nodeObj10000 = new SimplyLinkedList(55);
      SimplyLinkedList nodeObj = new SimplyLinkedList(88);
      headObj.insertAtElementLocation(headObj, nodeObj1111, 0);
      headObj.insertAtElementLocation(headObj, nodeObj2222, 2);
      headObj.insertAtElementLocation(headObj, nodeObj4444, 4);
      headObj.insertAtElementLocation(headObj, nodeObj8888, 6);
      headObj.insertAtLast(headObj, nodeObj10000);
      nodeObj4444.insertAfterKnownNode(nodeObj8888);
      headObj.TraversingList(headObj);
   }
}
