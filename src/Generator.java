import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Generator {
    Scanner in;
    InToPost inToPost;
    EvaluatePost eval;
    LinkedQueue<String> queue;

    //constructror
    public Generator() {
        in = new Scanner(System.in);
        inToPost = new InToPost();
        eval = new EvaluatePost();
        queue = new LinkedQueue<>();

    }

    //shows menu to the user
    public void showMenu() {
        String choice = "";

        while (true) {
            System.out.println("\nWelcome to OTP Generator!");
            System.out.println("To continue, please select an option below:");
            System.out.println("\ta. generate OTP");
            System.out.println("\tb. add expressions to OTP Queue");
            System.out.println("\tc. display OTP Queue");

            choice = in.nextLine().toUpperCase();
            switch (choice) {
                case "A":
                    generate();
                    break;
                case "B":
                    add();
                    break;
                case "C":
                    display();
                    break;
                default:
                    System.out.println("You pressed the wrong key!");
            }
        }
    }

    //gets the string input
    public String getString(){
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = null;
        try {
            s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * prompts the user n times with
     * string input of an infix expression
     * using the stack data structure
     * and then store it in a queue
     **/
    public void add(){
        String input;
        int expNum;
        System.out.println("How many expressions? ");

        while(!in.hasNextInt()) {
            System.out.println("Enter a valid number.");
            in.next();
        }
        expNum = in.nextInt();

        for(int i = 0; i < expNum; i++){
            System.out.print("Enter infix: ");
            System.out.flush();

            input = inToPost.doTrans(getString());
            queue.enqueue(input);
        }
        in.nextLine();

    }


    /**
     * generates an OTP by dequeuing to queue storage and
     * evaluating the postfix expression
     * using stack implementation
     * if queue is empty, prints a warning
     **/
    public void generate(){
        String output;
        System.out.println("Generating OTP...");

        while(!queue.isEmpty()){
            output = eval.evaluate(queue.dequeue());
            System.out.println(fourDigitOTP(output));
        }

        //if there's nothing left to dequeue prompt the user to input infix again
        System.out.println("Queue is empty. Add expression.");

    }


    /**
     * checks the evaluation if the number of digits
     * is equal to 4. It returns the string otp
     * if the result evaluation has 4 digits return it as OTP
     * if it has less than 4 digits APPEND zeroes in front to become 4
     * if it has greater than 4 digits, return only the LAST 4
     **/
    public String fourDigitOTP(String otp){
        int len = otp.length();

        if(len == 4)
            return otp;
        else if(len < 4){
            if(len == 1)
                return "000" + otp;
            else if(len == 2)
                return "00" + otp;
            else
                return "0" + otp;
        }
        else
            return otp.substring(len - 4);
    }


    /**
     * display the postfix expressions
     * in the OTP queue
     * prints a warning if OTP queue is empty
     **/
    public void display(){
        if(queue.isEmpty()) {
            System.out.println("OTP Queue empty.");
            return;
        }
        queue.display();
    }


    //MAIN METHOD
    public static void main(String[] args){
        new Generator().showMenu();
    }

}
