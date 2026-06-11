import java.util.InputMismatchException;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Queue<String> tasks = new ArrayDeque<>();
        Scanner in = new Scanner(System.in);
        int choice;

        myLoop:
            while(true){

                printUI();

                System.out.println("Select your Choice:\t");

                try{

                    choice = in.nextInt();
                    in.nextLine();

                }catch(InputMismatchException e){ //handle invalid inputs
                    System.out.println("System Announcement: Invalid Input, Try Again.");
                    in.nextLine();
                    continue;
                }


                switch(choice){
                    case 1:
                        addTask(tasks, in);
                        break;
                    case 2:
                        System.out.println(viewNextTask(tasks));
                        break;
                    case 3:
                        System.out.println(processTask(tasks));
                        break;
                    case 4:
                        showAllTask(tasks);
                        break;
                    case 5:
                        break myLoop;
                    default:
                        System.out.println(" System Announcement: Invalid Option");
                }

            }


    }

    public static void printUI(){
        System.out.println("""
                Queue Demonstration Program
                1. Add Task
                2. View Next Task
                3. Process Task
                4. Show All Tasks
                5. Exit
                """
            );
    }


    public static void addTask(Queue<String> tasks, Scanner in){


            System.out.println("Enter Task:\t");
            String task = in.nextLine();

            if(task.isBlank()){ //handle empty inputs
                System.out.println("System Announcement: Input Cannot be Empty, Try Again.");
                return;
            }

            if(task.trim().matches("[+-]?\\d+")){
                System.out.println("System Announcement: Input is Invalid, Try Again.");
                return;
            }

            tasks.offer(task);

        System.out.println("System Announcement: Task Added..\n");

    }

    public static String viewNextTask(Queue<String> tasks){

        if(tasks.isEmpty()){
            return "System Announcement: Tasks are currently empty!";
        }
        return "Next Task: " + tasks.peek() + "\n";
    }

    public static String processTask(Queue<String> tasks){

        if(tasks.isEmpty()){
            return "System Announcement: There are no tasks to process!";
        }

        return "Processing Task: " + tasks.poll() + "\n";
    }

    public static void showAllTask(Queue<String> tasks){

        if(tasks.isEmpty()){
            System.out.println("System Announcement: Tasks are currently empty!");
            return;
        }

        int i = 0;

        System.out.println("Current Tasks:");
        for(String task: tasks){
            i+=1;
            System.out.println(i + ". " + task);

        }

        System.out.println();

    }


}
