// MILESTONE 3
public class Postfix {
    // Input Example = {"1", "2", "+"}
    public static Double evaluate(String[] expression) throws StackException {
        if (expression.length > 7) { // Max of 7 elements: 4 numbers and 3 operators
            throw new StackException(expression.length);
        }
		Stack<Double> s = new Stack<>(7);
		
		for (int i=0; i<expression.length; i++) {
			// If it's a number
			if (expression[i] != "+" && 
				expression[i] != "-" && 
				expression[i] != "*" && 
				expression[i] != "/") {
				s.push(Double.parseDouble(expression[i]));
			}
			else { // It must be an operator
				// The previous 2 elements from the stack must be numbers
				Double n1 = s.pop();
				Double n2 = s.pop();

				// Perform the operation on the two numbers
				if (expression[i] == "+") {
					s.push(n2+n1); 
				}
				else if (expression[i] == "-") {
					s.push(n2-n1);
				}
				else if (expression[i] == "*") {
					s.push(n2*n1);
				}
				else if (expression[i] == "/") {
					s.push(n2/n1);
				}
			}
		}

        return s.getStart(); // Return data in the top of stack
    }
} // Class