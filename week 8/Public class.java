public class Delete{
// to return the list with the n-th node deleted. 
// Indices will start with 0; if n exceeds the length of the list or 
// n is negative, nothing will be deleted.
	public static IntNode delete(IntNode ls, int n){
		IntNode head = null;
        IntNode ptr, trailer;
        System.out.println(" Remove " + n);

        ptr = ls.getNext();
        trailer = ls;

       	if(head ==null){
			System.out.println("List is Empty");
		}
		if(head.val == n){
			head = head.next;
		}
		if(head == null){ // Check if there was only one element in Original list
			return;
		}
		Node curr = head;
		while (curr.next != null) {
			if (curr.next.val == n) {
				curr.next= curr.next.next;	
			} 
			else {
				curr = curr.next;
			}
		}
	}

	
	public static void main(String[] args) {
        IntNode start = null;
        IntNode ptr, trailer;
        
        Scanner s = new Scanner(System.in);
        System.out.print("Enter an integer (enter a non-int to quit): ");
        if (s.hasNextInt()) { 
          start = new IntNode(s.nextInt(), null);
        }  
        
        System.out.print("Enter next integer (enter a non-int to quit): ");
        while (s.hasNextInt()) {
            int temp = s.nextInt();
            if (start.getData() > temp)  
              start = new IntNode(temp, start);
            else {  // general case
              ptr = start.getNext();
              trailer = start;
              while (ptr != null && ptr.getData() < temp) {
                  trailer = ptr;
                  ptr = ptr.getNext();
              }  
              trailer.setNext(new IntNode(temp, ptr));
            }  
            System.out.print("Next integer (non-int to quit): ");
        }  

        System.out.println("\nThe sorted list of ints ...");
        ptr = start;
        while (ptr != null) {
            System.out.println(ptr.toString());
            ptr = ptr.getNext();
        }

    }  // main

}