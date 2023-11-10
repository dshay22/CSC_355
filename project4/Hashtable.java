import java.security.Key;

public class Hashtable<K, V> {
    private Pair[] table;
    private int n;//the number of key-value pairs in the table
    private int m;//the size of the table
    private double alphaHigh = 0.5;//resize if n/m exceeds this (1/2)
    private double alphaLow = 0.125;//resize if n/m goes below this (1/8)

    //constructor--default table size is 11
    public Hashtable() {
	n = 0;
	m = 11;
	table = new Pair[m];
    }

    //constructor
    public Hashtable(int m) {
	n = 0;
	this.m = m;
	table = new Pair[m];
    }

    //returns the value associated with key <key>
    //return null if key is not in table
    //do not forget that you will have to cast the result to (V)
    public V get(K key) {
	//TO BE IMPLEMENTED*
        int index = getHashCode(key, m);
        int home = index;
        int pos = index;

        while(table[pos] != null) {
            
            if (key.equals(table[pos].getKey())) {
                return (V)table[pos].getValue();
            }

            pos = (pos + 1) % m; // probe
        }

        return null;
    }

    //puts (key, val) into the table or updates value
    //if the key is already in the table
    //resize to getNextNum(2*m) if (double)n/m exceeds alphaHigh after the insert
    public void put(K key, V val) {
        int index = getHashCode(key, m);
        int home = index;
        int pos = index;

        for (int i = 1; (table[pos] != null); i++) {
            
            if (key.equals(table[pos].getKey())) {
                table[pos] = new Pair<K, V>(key, val);
                return;
            }

            pos = (home + linearProbe(key, i)) % m; // probe
        }

        Pair<K, V> temp = new Pair<K, V>(key, val);
        table[pos] = temp;
        // checkSize();
        ++n;
        if((double)n/(double)m > alphaHigh ){
            resize();
        }
    }

    public int linearProbe(K key, int i){
        return i;
    }

    public int getHashCode(K key, int m){
        return (((key.hashCode()) % m) + m) % m;
    }

    public void checkSize(){
        if((double)n/(double)m > alphaHigh ){
            resize();
        }
        if(m/2 >= 11 && (double)n/m < alphaLow){
            downsize();
        }
    }

    public void resize(){
        int newCapacity = getNextNum(2 * m); // Calculate the new capacity, you need to implement this method

        Pair<K, V>[] newTable = new Pair[newCapacity];
        int oldCapacity = m;
    
        for (int i = 0; i < oldCapacity; i++) {
            Pair<K, V> entry = table[i];
    
            if (entry != null) {
                int newIndex = getHashCode(entry.getKey(), newCapacity);
                int home;
                int pos = home = newIndex;
    
                for (int j = 1; newTable[pos] != null; j++) {
                    pos = (home + linearProbe(entry.getKey(), j)) % newCapacity;
                }
    
                newTable[pos] = entry;
            }
        }
    
        table = newTable;
        m = newCapacity;
    }

    public void downsize() {
        int newCapacity = getNextNum(m / 2);
    
        Pair<K, V>[] newTable = new Pair[newCapacity];
        int oldCapacity = m;
    
        for (int i = 0; i < oldCapacity; i++) {
            Pair<K, V> entry = table[i];
    
            if (entry != null) {
                int newIndex = getHashCode(entry.getKey(), newCapacity);
                int home;
                int pos = home = newIndex;
    
                for (int j = 1; newTable[pos] != null; j++) {
                    pos = (home + linearProbe(entry.getKey(), j)) % newCapacity;
                }
    
                newTable[pos] = entry;
            }
        }
    
        table = newTable;
        m = newCapacity;
    }

    //removes the (key, value) pair associated with <key>
    //returns the deleted value or null if the element was not in the table
    //resize to getNextNum(m/2) if m/2 >= 11 AND (double)n/m < alphaLow after the delete
    public V delete(K key) {
	    int index = getHashCode(key, m);

        while(table[index] != null && !(key.equals(table[index].getKey()))){
            index = (index + 1) % m;
        }

        if(table[index] != null && key.equals(table[index].getKey())) {
            V deletedValue = (V) table[index].getValue();
            table[index] = null;
            n--;

            int pos = (index + 1) % m;
            while (table[pos] != null) {
                Pair<K, V> temp = table[pos];
                table[pos] = null;
                n--;

                put(temp.getKey(), temp.getValue());
                pos = (pos + 1) % m;
            }

            if(m/2 >= 11 && (double)n/m < alphaLow){
                downsize();
            }
            return deletedValue;
        }

        return null;
    }

    //return true if table is empty
    public boolean isEmpty() {
        return n == 0;
    }

    //return the number of (key,value) pairs in the table
    public int size() {
        return n;
    }

    //This method is used for testing only. Do not use this method yourself for any reason
    //other than debugging. Do not change this method.
    public Pair[] getTable() {
	    return table;
    }

    //PRIVATE

    
    //gets the next multiple of 6 plus or minus 1,
    //which has a decent probability of being prime.
    //Use this method when resizing the table.
    private int getNextNum(int num) {
	if(num == 2 || num == 3)
	    return num;
	int rem = num % 6;
	switch(rem) {
	case 0: num++; break;
	case 2: num+=3; break;
	case 3: num+=2; break;
	case 4: num++; break;
	}
	return num;
    }

    public void printTable(){
        for(int i = 0; i < table.length; ++i){
            System.out.println(table[i]);
        }
    }
}
      

