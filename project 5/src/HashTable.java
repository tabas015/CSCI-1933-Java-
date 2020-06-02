
//Ladan Abdi (abdix213) & Fahia Tabassum (tabas015)

import java.lang.reflect.Array;

public class HashTable<T> {
    private final static int DEFAULT_SIZE = 101 ;
    private final NGen<T>[] buckets;
    private int size = 0;

    // constructor
    public HashTable() {

        buckets = (NGen<T>[]) Array.newInstance(NGen.class, DEFAULT_SIZE);
    }
    // add method which adds an item to hash table
    public void add(T item) {
        int bucket = hash(item);
        if (addToBucket(bucket, item)) {
            size++;//increment size
        }
    }
    //display method shows hash table
    public void display() {
        StringBuilder builder = new StringBuilder();// initializing a string object
        builder.append("Hash Table").append(System.lineSeparator());// adding Hash Table string to our builder string
        builder.append("Table length: ").append(DEFAULT_SIZE).append(System.lineSeparator());// adding Table length string to our builder string
        builder.append("Items in table: ").append(size).append(System.lineSeparator());// adding Items in table string to our builder string
        builder.append("Load factor: ").append((1.0 * size)/DEFAULT_SIZE).append(System.lineSeparator());// adding Items in table string to our builder string

        StringBuilder bucketsBuilder = new StringBuilder();
        int collisions = 0;// number of collisions tracker
        int shortest = -1;// shortest chain
        int longest = -1;//longest chain
        for (int i = 0; i<DEFAULT_SIZE; i++) {// looping through hash table
            int length = getLength(i);
            if ((shortest == -1) || (length < shortest)) {// setting shortest chain equal to length
                shortest = length;
            }
            if ((longest == -1) || (length > longest)) {// setting longest chain equal to length
                longest = length;
            }
            if (length > 0) {
                collisions += length - 1;
            }
            bucketsBuilder.append("Bucket ").append(i).append(": ").append(length).append(" item(s)").append(System.lineSeparator());
        }
        builder.append("Collisions: ").append(collisions).append(System.lineSeparator());//adding string Collisions to our builder string to display the number of collisions
        if (shortest != -1) {
            builder.append("Shortest chain: ").append(shortest).append(System.lineSeparator());//adding string Shortest chain to our builder string to display the length of shortest chain
        }
        if (longest != -1) {
            builder.append("Longest chain: ").append(longest).append(System.lineSeparator());//adding string Longest chain to our builder string to display the length of longest chain
        }
        builder.append(bucketsBuilder);
        System.out.println(builder);//displaying hash table
    }

    public T remove(T item) {
        int bucket = hash(item);
        return removeFromBucket(bucket, item);// removes an item from the hash table
    }

    private int hash(T key) {
        int hash = key.hashCode();
        if (hash < 0) {
            hash -= (hash/DEFAULT_SIZE) * (DEFAULT_SIZE + 1);
        }
        return hash % DEFAULT_SIZE;
    }

    private boolean addToBucket(int bucket, T item) {// adds item at certain bucket(index)
        if (buckets[bucket] == null) {
            buckets[bucket] = new NGen<>(item);
        }
        else {
            NGen<T> current = buckets[bucket];
            while (current.getNext() != null) {//loops through to get next index and item location until null
                if (current.getData().equals(item)) {
                    return false;
                }
                current = current.getNext();
            }
            if (current.getData().equals(item)) {
                return false;
            }
            NGen<T> newNode = new NGen<>(item);
            current.setNext(newNode);// sets the old index and item with new item at new index(bucket)
        }
        return true;
    }

    private T removeFromBucket(int bucket, T item) {//removes item at specific bucket(index)
        if (buckets[bucket] != null) {
            NGen<T> current = buckets[bucket];
            while (current != null) {//loops through until current bucket and item becomes null
                if (current.getData().equals(item)) {
                    return current.getData();
                }
                current = current.getNext();// sets that current bucket and index location with the next thing after that current location.
            }
        }
        return null;
    }

    private int getLength(int cell) {// returns an integer representing the length
        NGen<T> current = buckets[cell];
        int count = 0;
        while (current != null) {//loops through until current is null
            count++;//increment count
            current = current.getNext();
        }
        return count;
    }
    // Node class of generic type
    private static class NGen<T> {
        private final T data;
        private NGen<T> next;

        public NGen(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public NGen<T> getNext() {
            return next;
        }

        public void setNext(NGen<T> next) {
            this.next = next;
        }
    }
}
