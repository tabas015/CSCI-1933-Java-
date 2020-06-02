import java.util.Scanner;
public class RemoveString{
	String a;
	String b;

	
	public String removeDuplicates(String a, String b){
	    String result = " ";
	    String c = a + b;
		for (int i = 0; i < c.length(); i++) {
	        if(!result.contains(String.valueOf(c.charAt(i)))) {
	            result += String.valueOf(c.charAt(i));
	        }
	    }
	    return result;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the 1st string");
		String a =sc.nextLine();
		System.out.println("Enter the 2nd string");
		String b =sc.nextLine();
 
		RemoveString rm = new RemoveString();
		String o = rm.removeDuplicates(a, b);
		System.out.print("The removed one is:");
		System.out.println(o);
	}
}