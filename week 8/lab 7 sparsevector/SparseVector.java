Zachery Smith

import java.util.Scanner;
public class SparseVector {
	// Instance variables
	private Node head;
	private int length;
	//Constructor
	public SparseVector(int len){
		head = null;
		length = len;
	}
	//Getters 
	public int getLength() {
      return length;
   }
   public Node getHead(){
   	return head;
   }


	// Prints out a sparse vector (including zeros)
	public String toString(){

		String result = "";
		Node currNode = head;
		int currIndex = 0;
		while( currNode != null ){
			int idx = currNode.getIndex();

			// Pad the space between nodes with zero
			while( currIndex < idx ){
				result += "0, ";
				currIndex++;
			}
			result += currNode;
			currNode = currNode.getNext();
			currIndex++;

			// Only add a comma if this isn't the last element
			if( currNode != null ){ result += ", "; }
		}
		return result;
	}

	// milestone 1
	public void addElement(int index, double value){
		Node nodes = new Node(index,value);
	
		if (head == null){
			head = nodes;
		}
	   	else{
	   		Node front = head;
	   		while(front.getNext() != null){
	   			front = front.getNext();
	   		}
	   		front.setNext(nodes);
	   	}
	}
	     

	//  milestone 3
	public static double dot( SparseVector x, SparseVector y ){
		int result = 0;
		Node xNode = x.getHead(); // Get an init Node for x
		Node yNode = y.getHead(); // Get an init node for y


		if (x.getLength() == y.getLength()){
			while (xNode != null && yNode != null) { // Check for nulls
				if (xNode.getIndex() == yNode.getIndex()) {
					result += xNode.getValue() * yNode.getValue();
					xNode = xNode.getNext();
					yNode = yNode.getNext();
				}
				else if (xNode.getIndex() < yNode.getIndex()) { 
					xNode = xNode.getNext(); 
				}
				else { 
					yNode = yNode.getNext(); 
				}
				
			}
		}
		return result;
	} // dot
		
	// TODO: Test out your code here!
	public static void main(String[] args) {
		SparseVector vec = new SparseVector(6); 
		vec.addElement(0, 10.0); 
		vec.addElement(3, -1.1); 
		vec.addElement(5, 32.0); 
		System.out.println(vec);

		SparseVector x = new SparseVector(100000000); 
		x.addElement(0, 1.0);
		x.addElement(10000000, 3.0); 
		x.addElement(10000001, -2.0);

		SparseVector y = new SparseVector(100000000); 
		y.addElement(0, 2.0);
		y.addElement(10000001, -4.0);
		double result = dot(x, y);
		System.out.println("\n" + result);



	}
}


