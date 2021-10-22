import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Generator {
    Scanner in;
    InputStreamReader isr;
    BufferedReader br;


    public Generator() {
        in = new Scanner(System.in);
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

    String input, output;
    InToPost inToPost;
    EvaluatePost eval = new EvaluatePost();
    Queue theQueue = new Queue();

    int expNum;

    public void generate(){
        int size = theQueue.getSize();
        int output;
        while(size>0){
            output = new EvaluatePost().doParse((String) theQueue.dequeue());
            size--;
            theQueue.enqueue(output);

        }
    }

    public void add(){


        System.out.println("How many expressions? ");
        expNum = in.nextInt();


        for(int i = 0; i < expNum; i++){
            System.out.print("Enter infix: ");
            System.out.flush();
            input = new InToPost(getString()).doTrans();
            theQueue.enqueue(input);
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
        while(!theQueue.isEmpty()){
            System.out.println(theQueue.dequeue());
        }

    }

    public static void main(String[] args){
        new Generator().showMenu();
    }

}
