public class EvaluatePost {


    public String evaluate(String postfix) {
        //create a stack
        LinkedStack<Integer> stack = new LinkedStack<>();


        // Scan all characters one by one
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            // If the scanned character is an operand (number here),
            // push it to the stack.
            if (Character.isDigit(c))
                stack.push(c - '0');

                //  If the scanned character is an operator, pop two
                // elements from stack apply the operator
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;

                    case '-':
                        stack.push(val2 - val1);
                        break;

                    case '/':
                        stack.push(val2 / val1);
                        break;

                    case '*':
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        return String.valueOf(stack.pop());

    }
}

