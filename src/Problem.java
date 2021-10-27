import java.util.*;

public class Problem {
    // Main Method
    public static void main(String[] args) {

        // Attributes
        Scanner input = new Scanner(System.in);
        String userInput;
        String postfix;

        // For Infix to Postfix Conversion
        System.out.println("Please enter an Infix Expression to evaluate it's Postfix Expression: ");
        userInput = input.nextLine();
        postfix = inToPost(userInput);

        // For Postfix Evaluation
        calculatePostfix(postfix);
    }

    // Function to convert infix to postfix expression
    public static String inToPost(String userInput){
        // Variables
        String postfix = "";
        LinkedStack<Character> stack = new LinkedStack<>();

        // Loop till the end of the user input
        for (int i = 0; i < userInput.length(); i++) {
            char c = userInput.charAt(i);

            // If the character at the i(th) position is a digit then append it to postfix result
            if (c >= '0' && c <= '9') {
                postfix += c;
            }

            // If the character at the i(th) position is a + or - then
            else if (c == '+' || c == '-') {
                postfix += " ";
                // Check for the null point exception
                if (stack.top() == '0' || stack.top() == -1 || stack.top() == '(') {
                    stack.push(c);
                }
                // Also check for the precedence and then push it on to stack
                else {
                    if ((stack.top() == '*' || stack.top() == '/' || stack.top() == '+' || stack.top() == '-')){
                        postfix += ' ' + stack.pop();
                        if (stack.top() == '+'||stack.top() == '-'){
                            postfix += " " + stack.pop();
                        }
                        stack.push(c);
                    }
                }
            }

            // If the character at the i(th) position is a * or / then
            else if (c == '*' || c == '/') {
                postfix += " ";
                // Check for the null pointer exception
                if (stack.isEmpty()) {
                    stack.push('c');
                }
                // Also check for precedence and then push it on to stack
                else {
                    if (stack.top() == '/') {
                        postfix += " " + stack.pop();
                        stack.push(c);
                    } else {
                        stack.push(c);
                    }
                }
            }

            // If the character at the i(th) position is a ( then push it on to stack
            else if (c == '(') {
                postfix += " ";
                stack.push(c);
            }

            // If the character at the i(th) position is a ) then
            else if (c == ')') {
                postfix += " ";
                // Append all operators before (
                while (stack.top() != '(') {
                    postfix += " " + (char) stack.pop();
                }
                // and pop (
                stack.pop();
            }
        }

        // At the end pop everything remaining in the stack
        while (!stack.isEmpty()) {
            postfix += " " +  (char) stack.pop();
        }

        // Then print the result
        System.out.println("Here is the postfix expression: " + postfix);

        return postfix;
    }

    // Function to evaluate the postfix expression
    public static void calculatePostfix(String expression){
        // Variables
        int result = 0;
        LinkedStack resultStack = new LinkedStack();
        char[] charPostfix = expression.toCharArray();

        // Loop till the end of the expression and when an operator is encountered, use it on last two elements of the Stack
        for (int i = 0; i < expression.length(); i++){
            if (charPostfix[i] == ' '){
                continue;
            } else if (charPostfix[i] >= '0' && charPostfix[i] <= '9'){
                int j = i;
                int count = 0;
                resultStack.push((int)(charPostfix[i])-'0');
                while (charPostfix[j+1] >= '0' && charPostfix[j+1] <= '9'){
                    resultStack.push((int)(charPostfix[i] - '0') + ((int) (resultStack.pop())* 10));
                    count++;
                    j++;
                }
                i += count;
                //System.out.println(resultStack.top());
            } else if (charPostfix[i] == '+'){
                resultStack.push((int)(resultStack.pop()) + (int)(resultStack.pop()));
            } else if (charPostfix[i] == '-'){
                resultStack.push((int)(resultStack.pop()) - (int)(resultStack.pop()));
            } else if (charPostfix[i] == '*'){
                resultStack.push((int)(resultStack.pop()) * (int)(resultStack.pop()));
            } else if (charPostfix[i] == '/'){
                resultStack.push((int)(resultStack.pop()) / (int)(resultStack.pop()));
            }
        }

        // Pop the result and display it
        result = (int) resultStack.pop();
        System.out.println("The result is: " + result);
    }
}