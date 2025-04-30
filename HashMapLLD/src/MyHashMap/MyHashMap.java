package MyHashMap;

public class MyHashMap<K, V> {
    private static final int INITIAL_SIZE = 1 << 4; //16
    private static final int MAX_CAPACITY = 1 << 30; //2^30

    public Entry[] hashTable;

    public MyHashMap(){
        this.hashTable = new Entry[INITIAL_SIZE];
    }

    public MyHashMap(int capacity){
        int tableSize = tableSizeFor(capacity);
        this.hashTable = new Entry[tableSize];
    }


    final int tableSizeFor(int cap){
        int n = cap-1;
        n |= n >>> 1; //Unsigned Right shift by 1
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        return (n < 0) ? 1 : (n >= MAX_CAPACITY) ? MAX_CAPACITY : n + 1;
    }


    class Entry<K, V>{
        public K key;
        public V value;
        public Entry next;

        Entry(K k, V v){
            this.key = k;
            this.value = v;
        }
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        //Check if the hash table is empty
        if(node == null){
            Entry newNode = new Entry(key, value);
            hashTable[hashCode] = newNode;
        }
        //collision occurred
        else{
            Entry previousNode = node;
            while(node!= null){
                if(node.key == key){
                    node.value = value;
                    return;
                }
                previousNode = node;
                node = node.next;
            }
            Entry newNode = new Entry(key, value);
            previousNode.next = newNode;
        }
    }

    public V get(K key){
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        while(node != null){
            if(node.key.equals(key)){
                return (V)node.value;
            }
            node = node.next;
        }
        return null;
    }


}
