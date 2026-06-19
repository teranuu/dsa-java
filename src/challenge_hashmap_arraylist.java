import java.util.InputMismatchException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;


public class challenge_hashmap_arraylist {

    public static void main(String[] args) {

        ArrayList<Integer> id = new ArrayList<>();
        HashMap<Integer, String> student = new HashMap<>();

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
                    addStudent(student, id, in);
                    break;
                case 2:
                    searchStudent(student, in);
                    break;
                case 3:
                    updateStudent(student, in);
                    break;
                case 4:
                    deleteStudent(student, id, in);
                    break;
                case 5:
                    printAllStudents(student, id);
                    break;
                case 6:
                    break myLoop;
                default:
                    System.out.println(" System Announcement: Invalid Option");
            }

        }


    }

    public static void printUI(){
        System.out.println("""
                ===== Student Record Search System =====
                1. Add Student
                2. Search Student
                3. Update Student
                4. Delete Student
                5. Print All Students
                6. Exit
                """
        );
    }

    public static boolean EmptyInputCheck(String rawInput){
        if(rawInput.isBlank()){ //handle empty inputs
            System.out.println("System Announcement: Input Cannot be Empty, Try Again.");
            return true;
        }
        return false;
    }

    public static boolean InvalidInputCheckDigit(String rawInput){
        if(!rawInput.trim().matches("\\d+")){
            System.out.println("System Announcement: Input is Invalid, Try Again.");
            return true;
        }

        return false;
    }

    public static boolean InvalidInputCheckString(String rawInput){
        if(rawInput.trim().matches("[+-]?\\d+")){
            System.out.println("System Announcement: Input is Invalid, Try Again.");
            return true;
        }

        return false;
    }



    public static void addStudent(HashMap<Integer, String> student, ArrayList<Integer> id, Scanner in){

        System.out.println("Enter student ID: \t");
        String rawInputStudentId = in.nextLine();


        if(EmptyInputCheck(rawInputStudentId) || InvalidInputCheckDigit(rawInputStudentId)){
            return;
        }

        int studentId = Integer.parseInt(rawInputStudentId.trim());

        if(student.containsKey(studentId)){
            System.out.println("System Announcement: Duplicate Detected! This Id Exists! Try Again.");
            return;
        }

        System.out.println("Enter student name: \t");
        String studentName = in.nextLine();

        if(EmptyInputCheck(studentName) || InvalidInputCheckString(studentName)){
            return;
        }

        id.add(studentId);
        student.put(studentId, studentName);

        if(student.containsKey(studentId)){
            System.out.println("System Announcement: Student ID: " + studentId + ", Student Name: " + studentName +" is Added Successfully!");
        }else{
            System.out.println("System Announcement: Error Adding Student Id and Student Name");
        }

    }

    public static void searchStudent(HashMap<Integer, String> student, Scanner in){

        System.out.println("Enter Student ID to search:\t");
        String rawInputStudentId = in.nextLine();

        if(EmptyInputCheck(rawInputStudentId) || InvalidInputCheckDigit(rawInputStudentId)){
            return;
        }

        int studentId = Integer.parseInt(rawInputStudentId.trim());

        if(student.containsKey(studentId)){
            System.out.println("Student Found: ");
            System.out.println("ID: " + studentId);
            System.out.println("Name: " + student.get(studentId));
            return;
        }
        System.out.println("System Announcement: Student ID not found. Try Again.");


    }

    public static void updateStudent(HashMap<Integer, String> student, Scanner in){

        System.out.println("Enter Student ID to update Student Name:\t");
        String rawInputStudentId = in.nextLine();

        if(EmptyInputCheck(rawInputStudentId) || InvalidInputCheckDigit(rawInputStudentId)){
            return;
        }

        int studentId = Integer.parseInt(rawInputStudentId.trim());

        if(student.containsKey(studentId)){
            System.out.println("Enter a new name: \t");
            String newStudentName = in.nextLine();

            if(EmptyInputCheck(newStudentName) || InvalidInputCheckString(newStudentName)){
                return;
            }

            student.put(studentId, newStudentName);

            System.out.println("System Announcement: Student updated successfully.");
            return;
        }

        System.out.println("System Announcement: Student ID not found. Try Again.");

    }

    public static void deleteStudent(HashMap<Integer, String> student, ArrayList<Integer> id, Scanner in){

        System.out.println("Enter Student ID to delete:\t");
        String rawInputStudentId = in.nextLine();

        if(EmptyInputCheck(rawInputStudentId) || InvalidInputCheckDigit(rawInputStudentId)){
            return;
        }

        int studentId = Integer.parseInt(rawInputStudentId.trim());

        if(student.containsKey(studentId)){
            student.remove(studentId);

            for(int i = 0; i < id.size(); i++){
                if(id.get(i).equals(studentId)){
                    id.remove(i);
                    break;
                }
            }

            System.out.println("System Announcement: Student removed successfully.");
            return;
        }

        System.out.println("System Announcement: Student ID not found. Try Again.");

    }

    public static void printAllStudents(HashMap<Integer, String> student, ArrayList<Integer> id){

        if(student.isEmpty()){
            System.out.println("System Announcement: Student Database is currently Empty.");
            return;
        }

        System.out.println("===== Student Records =====");

        for(Integer idCtr : id){

            if(student.containsKey(idCtr)){

                System.out.println("ID: " + idCtr + " | " + "Name: " + student.getOrDefault(idCtr, null));

            }else{
                System.out.println("System Announcement: Error");
                break;
            }
        }

    }




}
