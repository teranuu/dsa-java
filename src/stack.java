import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class stack {

    public static void main(String[] args) {

        Deque<String> history = new ArrayDeque<>();
        Scanner in = new Scanner(System.in);

        myLoop:
        while(true){

            printUI();

            System.out.println("Select your Choice:\t");
            int choice = in.nextInt();
            in.nextLine();

            switch(choice){
                case 1:
                    visitPages(history,in);
                    break;
                case 2:
                    System.out.println(showCurrentPage(history));
                    break;
                case 3:
                    System.out.println(backPressed(history));
                    break;
                case 4:
                    break myLoop;
                default:
                    System.out.println("invalid option");
            }

        }


    }

    public static void printUI(){
        System.out.println("""
                1. Visit Pages
                2. Show Current Page
                3. Back
                4. End Program
                """
        );
    }


    public static void visitPages(Deque<String> history, Scanner in){
        System.out.println("""
                Pages you can visit:
                    1. github.com
                    2. youtube.com
                    3. google.com
                    4. stackoverflow.com
                """);

        System.out.println("Select your Choice: ");

        int choice = in.nextInt();
        in.nextLine();

        switch(choice) {
            case 1:
                history.push("github.com");
                break;
            case 2:
                history.push("youtube.com");
                break;
            case 3:
                history.push("google.com");
                break;
            case 4:
                history.push("stackoverflow.com");
                break;
            default:
                System.out.println("invalid option");
                return;
        }

        System.out.println("Current page visited: " + history.peek());

    }

    public static String showCurrentPage(Deque<String> history){

        if(history.isEmpty()) {
            return "Stack is currently empty";
        }
        return "Current page visited: " + history.peek();

    }

    public static String backPressed(Deque<String> history){

        if(history.isEmpty()){
            return "The Stack is currently Empty!";
        }

        String removedPage = history.pop();

        if(history.isEmpty()){
            return "Pressed back! removed: " + removedPage + "\nNo Pages Left!";
        }

        return "Pressed back! removed: " + removedPage + "\nCurrent Page visited: " + history.peek();

    }



}
