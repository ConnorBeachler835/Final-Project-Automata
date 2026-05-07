import java.util.Random;

// Creates the exile class
class Exile {
    // Creates a string of punishments
    private String[] punishments = {
            "Life in detention",
            "Expelled!",
            "Forced to use Rust only",
            "Banished to Siberia",
    };

    // Creates a string of rewards
    private String[] paradise = {
            "A perfect 100!",
            "A million dollars in your bank account!",
            "Full paid vacation to your location of choice!",
            "You get to graduate right now!",
    };
    private Random rand = new Random();

    // Creates a function to exile a student
    public void exileStudent(String name) {

        // Makes an exception for Connor Beachler only
        if (name.equalsIgnoreCase("Connor Beachler")) {
            String reward = paradise[rand.nextInt(paradise.length)];
            System.out.println("\n" + name + " " + reward + "!");
            return;
        }

        // Makes sure to show the punishment for each student and randomly select one
        String fate = punishments[rand.nextInt(punishments.length)];
        System.out.println("\n" + name + " " + fate + "!");
    }
}
