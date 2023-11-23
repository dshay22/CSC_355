public class BSTNode<K extends Comparable<K>, V extends Comparable<V>> {
    private K key;
    private V val;
    BSTNode<K, V> leftChild;
    BSTNode<K, V> rightChild;


    public BSTNode(K key, V val) {
	this.key = key;
	this.val = val;
    this.leftChild = null;
    this.rightChild = null;
    }

    public BSTNode(K key, V val, BSTNode<K, V> left, BSTNode<K, V> right) {
	this.key = key;
	this.val = val;
    this.leftChild = left;
    this.rightChild = right;
    }

    public K getKey() {
	return key;
    }

    public V getValue() {
	return val;
    }

    public void setValue(V val) {
	this.val = val;
    }

    public BSTNode<K, V> getLeft(){
        return this.leftChild;
    }

    public void setLeft(BSTNode<K, V>  b){
        this.leftChild = b;
    }

    public BSTNode<K, V> getRight(){
        return this.rightChild;
    }

    public void setRight(BSTNode<K, V>  b){
        this.rightChild = b;
    }

    public boolean isleaf(){
        return (leftChild == null) && (rightChild == null);
    }

    public boolean isEqual(BSTNode<K, V> p) {
	return this.key.equals(p.getKey()) && this.val.equals(p.getValue());
    }

    public int compareTo(K key) {
        return this.key.compareTo(key);
    }

    public String toString() {
	return "(key = " + key.toString() + ", value = " + val.toString() + ")";
    }
}
