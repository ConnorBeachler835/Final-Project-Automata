import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Creates a student manager class
class StudentManager {
    // Creates a array list of the students
    private ArrayList<String> students = new ArrayList<>();

    // Creates a student manager function
    public StudentManager(String filename) {
        // Tries to get the file and catch it if it's not found
        try {
            File file = new File(filename);
            Scanner keyboard = new Scanner(file);

            while (keyboard.hasNextLine()) {
                students.add(keyboard.nextLine());
            }

            keyboard.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
    // Creates a function that gets a random student
    public String getRandomStudent() {
        Random rand = new Random();

        // Checks to see if there are any students found
        if (students.isEmpty()) {
            return "No Students Found";
        }

        // Tries to get a random student
        return students.get(rand.nextInt(students.size()));
    }
    // Function that checks if a student is in the list or not
    public boolean containsStudent(String name) {
        return students.contains(name);
    }
}
