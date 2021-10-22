import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Generator {
    Scanner in;
    InputStreamReader isr;
    BufferedReader br;
    String input, output;
    InToPost inToPost;
    EvaluatePost eval;
    LinkedQueue<String> theQueue;

    public Generator() {
        in = new Scanner(System.in);
        eval = new EvaluatePost();
        theQueue = new LinkedQueue<>();
    }

    public void showMenu() {
        String choice = "";

        while (!choice.equals("Q")) {
            System.out.println("Welcome to OTP Generator!");
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

    public void generate(){
        String output;
        System.out.println(theQueue.size());
        while(!theQueue.isEmpty()){
            output = eval.doParse(theQueue.dequeue());
            System.out.println(output);

        }
    }

    public void add(){
        System.out.println("How many expressions? ");
        int expNum = in.nextInt();
        String postFix;


        for(int i = 0; i < expNum; i++){
            System.out.print("Enter infix: ");
            System.out.flush();
            input = new InToPost(getString()).doTrans();
            System.out.println(input);
            theQueue.enqueue(input);
            System.out.println(theQueue.size());
        }
        in.nextLine();
    }

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

    public void display(){
        LinkedQueue<String> theSecondQueue = theQueue;
        while(!theSecondQueue.isEmpty()){
            System.out.println(theSecondQueue.dequeue());
        }

    }

    public static void main(String[] args){
        new Generator().showMenu();
    }

}
