public class LinkedListTestClass {
    public static void main(String[] args) {
        LinkedList headObj;  // Create IntNode reference variables
        LinkedList nodeObj1;
        LinkedList nodeObj2;
        LinkedList nodeObj3;
        LinkedList nodeObj4;
        LinkedList nodeObj5;
        LinkedList currObj;
  
        // Front of nodes list
        headObj = new LinkedList(3); 
        
        // Insert more nodes
        nodeObj1 = new LinkedList(4);
        headObj.insertAfter(nodeObj1);
  
        nodeObj2 = new LinkedList(1);
        nodeObj1.insertAfter(nodeObj2);
  
        nodeObj3 = new LinkedList(0);
        nodeObj2.insertAfter(nodeObj3);

        nodeObj4 = new LinkedList(2);
        nodeObj3.insertAfter(nodeObj4);

        nodeObj5 = new LinkedList(9);
        nodeObj4.insertAfter(nodeObj5);
  
        // Print linked list
        System.out.println("The Original list:");
        currObj = headObj;
        while (currObj != null) {
           currObj.printNodeData();
           currObj = currObj.getNext();
        }

        LinkedList List1Head = new LinkedList(headObj.getDataVal());
        LinkedList List2Head = new LinkedList(-1);

        createTwoNewLists(headObj, headObj.getDataVal(), List1Head, List2Head);

        System.out.println("\n\nList 1:");
        currObj = List1Head;
        while (currObj != null) {
        currObj.printNodeData();
        currObj = currObj.getNext();
        }

        List2Head = List2Head.getNext();
        System.out.println("\n\nList 2:");
        currObj = List2Head;
        while (currObj != null) {
        currObj.printNodeData();
        currObj = currObj.getNext();
        }
    }

    public static void createTwoNewLists(LinkedList bigList, int headValue, LinkedList List1Head, LinkedList List2Head){
        LinkedList List1obj;
        LinkedList List2obj;
        LinkedList currObj;
        
        if(bigList.getNext() != null){
            if(bigList.getNext().getDataVal() <= headValue){
                List1obj = new LinkedList(bigList.getNext().getDataVal());
                List1Head.insertAfter(List1obj);
                createTwoNewLists(bigList.getNext(), headValue, List1obj, List2Head);
            }
            else{
                List2obj = new LinkedList(bigList.getNext().getDataVal());
                List2Head.insertAfter(List2obj);
                createTwoNewLists(bigList.getNext(), headValue, List1Head, List2obj);
            }
        }
    }
}
