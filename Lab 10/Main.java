// Zachary S (smi00903)
// Fahia T (tabas015)
public class Main {
    public static void main(String[] args) {
        // MILESTONE 3
        try {
            // Stack test cases
            Stack<String> s = new Stack<>();
            System.out.println("STACK TEST CASES: ");
            System.out.println("Pushing a...");
            s.push("a");
            System.out.println("Pushing b...");
            s.push("b");
            System.out.println("Pushing c...");
            s.push("c");
            System.out.println("The top of the stack is " + s);
            System.out.println("Popping top of stack...");
            s.pop(); // Pops c
            System.out.println("The top of the stack is " + s);

            // Postfix test cases
            System.out.println("\nPOSTFIX TEST CASES: ");
            String[] basic = new String[]{"1", "2", "+"};
            System.out.println("1 + 2 = " + Postfix.evaluate(basic));
            basic[2] = "-";
            System.out.println("1 - 2 = " + Postfix.evaluate(basic));
            basic[2] = "*";
            System.out.println("1 * 2 = " + Postfix.evaluate(basic));
            basic[2] = "/";
            System.out.println("1 / 2 = " + Postfix.evaluate(basic));

            String[] hard = new String[]{"2", "8", "+", "1", "1", "+", "/"};
            System.out.println("\n(2+8) / (1+1) = " + Postfix.evaluate(hard));

        }
        catch (StackException e) {
            System.out.println("Stack Exception: Stack is full.");
        }
        finally {
            System.out.println("Evaluation complete.");
        }


        // MILESTONE 4
        try {
            System.out.println("\nSTACKEXCEPTION TEST CASES: ");
            String[] basic = new String[]{"1", "2", "+", "4", "5", "-", "+", "8", "7", "+", "-"};
            System.out.println("(1+2) + (4-5) - (8+7)" + Postfix.evaluate(basic));

        }
        catch (StackException e) {
            System.out.println("Stack Exception at stack size " + e.getSize() + ".");
        }
        finally {
            System.out.println("Evaluation complete.");
        }

    }
}