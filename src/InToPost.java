import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InToPost {

    //utility function to return precedence of a give operator
    private int prec(char ch){
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    //converts infix to postfix
    public String doTrans(String in){

        LinkedStack<Character> stack = new LinkedStack<>();
        String output = new String("");

        for (int i = 0; i< in.length(); ++i)
        {
            char c = in.charAt(i);

            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c))
                output += c;

                // If the scanned character is an '(',
                // push it to the stack.
            else if (c == '(')
                stack.push(c);

                //  If the scanned character is an ')',
                // pop and output from the stack
                // until an '(' is encountered.
            else if (c == ')')
            {
                while (!stack.isEmpty() && stack.top() != '(')
                    output += stack.pop();

                stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && prec(c) <= prec(stack.top())){

                    output += stack.pop();
                }
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty()){
            if(stack.top() == '(')
                return "Invalid expression";
            output += stack.pop();
        }
        return output;
    }

}



