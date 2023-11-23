public class BinaryTreeTest {

    public static void main(String[] args) {

        BinaryTreeTest instance = new BinaryTreeTest();
        instance.testTreeOperations();
    }



    private void testTreeOperations() {
        // Test Tree operations

        // Tree 1
        Tree<Integer, String> tree1 = new Tree<>();
        tree1.put(50, "A");
        tree1.put(30, "B");
        tree1.put(70, "C");
        tree1.put(250, "D");

        // Tree 2
        Tree<Integer, String> tree2 = new Tree<>();
        tree2.put(40, "E");
        tree2.put(20, "F");
        tree2.put(60, "G");

        // Tree 3
        Tree<Integer, String> tree3 = new Tree<>();
        tree3.put(80, "H");
        tree3.put(75, "I");
        tree3.put(76, "J");
        tree3.put(90, "K");
        tree3.put(85, "L");
        tree3.put(95, "M");
        tree3.put(100, "N");

        // Tree 4 (empty tree)
        Tree<Integer, String> tree4 = new Tree<>();

        // Tree 5 (single-node tree)
        Tree<Integer, String> tree5 = new Tree<>();
        tree5.put(105, "O");

        // Test size methods for each tree
        System.out.println("Testing Size Function...");
        assertEqual(tree1.size(), 4);
        assertEqual(tree2.size(), 3);
        assertEqual(tree3.size(), 7);
        assertEqual(tree4.size(), 0);
        assertEqual(tree5.size(), 1);

        // Test height methods for each tree
        System.out.println("Testing Height Function...");
        assertEqual(tree1.height(), 2);
        assertEqual(tree2.height(), 1);
        assertEqual(tree3.height(), 3);
        assertEqual(tree4.height(), -1);
        assertEqual(tree5.height(), 0);

        // Test get method for each tree
        System.out.println("Testing get Function...");
        assertEqual(tree1.get(50), "A");
        assertEqual(tree2.get(20), "F");
        assertEqual(tree3.get(90), "K");
        assertNull(tree4.get(100)); // No key in an empty tree
        assertEqual(tree5.get(105), "O");

        // Test contains method for each tree
        System.out.println("Testing contains Function...");
        assertTrue(tree1.contains(tree1.getRoot(), 70), 70);
        assertFalse(tree2.contains(tree2.getRoot(), 80), 80);
        assertTrue(tree3.contains(tree3.getRoot(), 75), 75);
        assertFalse(tree4.contains(tree4.getRoot(), 100), 100);
        assertTrue(tree5.contains(tree5.getRoot(), 105), 105);
    }

    public void assertEqual(int actual, int expected){
        if(actual != expected){
            System.out.println("\tASSERTATION FAILED:\tExpected: " + expected + "\tActual was: " + actual);
        }
    }

    public void assertEqual(String value, String expected){
        if(value == null || expected.compareTo(value) != 0){
            System.out.println("\tASSERTATION FAILED:\tExpected: " + expected + "\tActual was: " + value);
        }
    }

    public void assertNull(String value){
        if(value != null){
            System.out.println("\tASSERTATION FAILED:\tExpected: null\tActual was: " + value);
        }
    }

    public void assertTrue(Boolean expected, int expectedInt){
        if(!expected){
            System.out.println("\tASSERTATION FAILED:\tExpected: " + expectedInt);
        }
    }

    public void assertFalse(Boolean expected, int expectedInt){
        if(expected){
            System.out.println("\tASSERTATION FAILED:\tDid not expected: " + expectedInt);
        }
    }

}
