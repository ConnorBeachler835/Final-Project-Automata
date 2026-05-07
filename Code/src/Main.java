// Connor Beachler
// Final Project
import java.util.Scanner;

// Creation of the main method
public class Main {
    public static void main(String[] args) {
        // Creates the scanner variable and the variable for the game, student manager, and the exile classes
        Scanner keyboard = new Scanner(System.in);
        StudentManager manager = new StudentManager("students.txt");
        Game game = new Game();
        Exile exile = new Exile();
        String student = "";

        // This is a welcome message for Adam Spanier
        System.out.print("Hello Adam Spanier!\nHave your students been bad? Well it's time to finally get your sweet " +
                "revenge!\nWe will allow you to either pick the student you want punished or simply make an example out" +
                " of one of them randomly! Please enter which decision you would rather do!");
        String a = "";
        // Creates a while statement to keep the program running until the user wants out
        while (!a.equalsIgnoreCase("q")) {
            // Asks the user for their input
            System.out.println("\n\t1: Randomly make an example out of a student\n\t2: Show that one irritating student" +
                    " that YOU are in charge and make him or her PAY for their transactions\n\tOr Enter 'q' to quit");
            a = keyboard.nextLine();
            // Two random responses to two possible outside the box answers to the prompt
            if (a.equals("67")) {
                System.out.println("Okay this joke is like a year old get over it");
            }
            if (a.equals("3")) {
                System.out.println("To access the third option DLC please enter your credit card number below: \n");
                String b = keyboard.nextLine();
                System.out.println("Jk, if you actually put your information however Adam it's time to retire");
            }
            // Tells the user to actually answer the question
            if (!a.equals("1") && !a.equals("2") && !a.equalsIgnoreCase("q")) {
                System.out.println("Come on Adam!! There are two options (1 or 2) not whatever you selected!");
            }
            // Asks the user for a student input and if it doesn't get it. It gets a random student instead
            if (a.equals("2")) {
                System.out.println("\nWho's it going to be????");
                student = keyboard.nextLine();

                if (!manager.containsStudent(student)) {
                    System.out.println("Student not found. Using random instead");
                    student = manager.getRandomStudent();
                }
                System.out.println("\nSelected student: " + student);

                // Makes the student play the game with the teacher
                boolean teacherWon = game.playGame();

                // Exiles the student if they lost and if not they survive
                if (teacherWon) {
                    exile.exileStudent(student);
                } else {
                    System.out.println(student + " has survived for now.");
                }
                // Same thing but totally random student this time
            } else if (a.equals("1")) {
                student = manager.getRandomStudent();
                System.out.println("\nSelected student: " + student);

                boolean won = game.playGame();

                if (!won) {
                    exile.exileStudent(student);
                } else {
                    System.out.println(student + " has survived... for now.");
                }
            }
        }
        // Exits if the user selects q
        if (a.equalsIgnoreCase("q")) {
            System.out.println("\nExiting Operation");
        }
    }
}