// MILESTONE 2
public class Stack<T extends Comparable<T>> {
    private int maxSize;
    private int currentSize;
    private Node<T> start;
    // Constructors
    public Stack() {
        maxSize = 5;
        currentSize = 0;
    }
    public Stack (int size) {
        maxSize = size;
        currentSize = 0;
    }
    // Remove and return object at top of stack
    public T pop() {
        if (start == null) { // If empty stack
            throw new RuntimeException("Tried to pop an empty stack.");
        }
        else {
            T data = start.getData();
            start = start.getNext();
            currentSize--;
            return data;
        }
    }
    // Add item to top of stack and throw exception if size is too big
    public void push (T item) throws StackException{
        if (currentSize == maxSize) {
            throw new StackException(maxSize);
        }
        
        start = new Node<T>(item, start);
        currentSize++;
    }
    public T getStart() {
        return start.getData();
    }
    public String toString() {
        return (String)start.getData();
    }
} // Class