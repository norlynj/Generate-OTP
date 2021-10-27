public class EvaluatePost {


    public String evaluate(String postfix) {
        //create a stack
        LinkedStack<Integer> stack = new LinkedStack<>();
        int x =0, y = 0;

        // Scan all characters one by one
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            // If the scanned character is an operand (number here),
            // push it to the stack.
            if (Character.isDigit(c)) {
                stack.push((int)(c - '0'));
            }

                //  If the scanned character is an operator, pop two
                // elements from stack apply the operator
            else {
                y = stack.pop();
                x = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(x + y);
                        break;

                    case '-':
                        stack.push(x - y);
                        break;

                    case '/':
                        stack.push(x / y);
                        break;

                    case '*':
                        stack.push(x * y);
                        break;
                }
            }
        }
        return String.valueOf(stack.pop());

    }
}

