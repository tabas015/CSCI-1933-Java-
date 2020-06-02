// MILESTONE 1
public class StackException extends Exception {
    private static final long serialVersionUID = 1L;
    private int size;
    
    public StackException (int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }

}