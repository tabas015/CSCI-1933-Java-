import java.util.Scanner;
import java.util.*; 

public class Delete{
	
	public Delete(){}
	public static IntNode delete(IntNode ls, int n){
		int m = ls.getLength();

		if (ls == null) {
			return null;
		}
	
		IntNode ptr = ls.getNext();
		IntNode trailer = ptr.getNext();
		
		for (int i = 0 ; i <= m; i ++){
			while (ptr != null && ptr.getData() == n) {
				ptr = trailer;
			}
		}
		return ls;
	}

	
	public static void main(String[] args) {
		Delete del = new Delete ();
		IntNode f = del.delete(null,2);
		System.out.println(f);
	}
}

