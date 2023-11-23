public class Tree<K extends Comparable<K>, V extends Comparable<V>>{

    private BSTNode<K, V> root;
    private int nodeCount;
    private int height;


    public Tree(){
        this.root = null;
        this.nodeCount = 0;
        this.height = -1;
    }

    public void put(K key, V val){

        this.root = putRecursive(root, key, val);

        this.nodeCount++;

        updateHeight(root);
    }

    public V get(K key) {
        BSTNode<K, V> current = root;
    
        while(current != null){
            int comparison = key.compareTo(current.getKey());
    
            if(comparison < 0){
                current = current.getLeft();
            }
            else if(comparison > 0){
                current = current.getRight();
            }
            else{
                return current.getValue(); // Key found
            }
        }
    
        return null; // Key not found
    }
    

    public boolean isEmpty(){
        return (this.root == null);
    }

    public int size(){
        return this.nodeCount;
    }

    public int height(){
        return this.height;
    }

    public boolean contains(BSTNode<K, V> node, K key){
        if(node == null || node.getKey() == key){
            return node != null;
        }

        if(key.compareTo(node.getKey()) > 0){
            return contains(node.getRight(), key);
        }

        return contains(node.getLeft(), key);
    }

    public BSTNode<K, V> getRoot() {
        return this.root;
    }

    private BSTNode<K, V> putRecursive(BSTNode<K, V> node, K key, V val) {
        if(node == null){
            // Create a new node when reaching a null position
            return new BSTNode<>(key, val);
        }
    
        int comparison = key.compareTo(node.getKey());
    
        if(comparison == 0){
            // Handle the case where the key already exists (update value, if needed)
            node.setValue(val);
        }
        else if(comparison < 0){
            // Recursively insert into the left subtree
            node.setLeft(putRecursive(node.getLeft(), key, val));
        }
        else{
            // Recursively insert into the right subtree
            node.setRight(putRecursive(node.getRight(), key, val));
        }
    
        // Update height for the current node
        updateHeight(node);

        return node;
    }

    private int updateHeight(BSTNode<K, V> node) {
        if(node == null){
            return -1;
        }

        int leftHeight = updateHeight(node.getLeft());
        int rightHeight = updateHeight(node.getRight());

        this.height = Math.max(leftHeight, rightHeight) + 1;

        return this.height;
    }
}