import java.util.Random;
import java.util.Scanner;

// Creates a game class with a scanner keyboard and random variable
class Game {
    private Scanner keyboard = new Scanner(System.in);
    private Random rand = new Random();

    String choice = "";

    // Creates a play game function that tells the user what their game options are
    public boolean playGame() {
        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3")) {
            System.out.println("\nChoose a game:");
            System.out.println("\t1: Rock Paper Scissors");
            System.out.println("\t2: Guess the Number");
            System.out.println("\t3: Tic Tac Toe");

            // Gets the user's response
            String choice = keyboard.nextLine();

            // Checks to see the user's response and correlates it with the right game
            if (choice.equals("1")) {
                return rockPaperScissors();
            }
            else if (choice.equals("2")) {
                return guessNumber();
            }
            else if (choice.equals("3")) {
                return ticTacToe();
            }
            // In case the user enters anything else
            else {
                System.out.println("Has to be 1, 2, or 3 try the whole thing again");
                return false;
            }
        }
        return false;
    }
    // The rock paper scissors game
    private boolean rockPaperScissors() {

            // Asks the teacher and then the student for their picks
            System.out.println("Enter rock, paper, or scissors: ");
            System.out.print("Teacher choice: ");
            String teacher = keyboard.nextLine().toLowerCase();

            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nStudent choice: ");
            String student = keyboard.nextLine().toLowerCase();

            // If it's a tie it returns this
            if (teacher.equals(student)) {
                System.out.println("Tie!");
                return false;
            }

            // Covers for everytime the teacher can win
            boolean teacherWins =
                    (teacher.equals("rock") && student.equals("scissors")) ||
                    (teacher.equals("paper") && student.equals("rock")) ||
                    (teacher.equals("scissors") && student.equals("paper"));

            if (teacherWins) {
                System.out.println("Teacher wins!");
            } else {
                System.out.println("Student wins!");
            }

            return teacherWins;
    }
    // The guess number game
    private boolean guessNumber() {

        // Asks the teacher for a number and then the student to guess it
        System.out.print("Teacher chooses a number (1-10): ");
        int secret = Integer.parseInt(keyboard.nextLine());

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nStudent now try to guess");

        System.out.print("Guess: ");
        int guess = Integer.parseInt(keyboard.nextLine());

        // Checks to see if the student guessed right or not
        if (guess == secret) {
            System.out.println("Student guessed correctly!");
            return true;
        }
        else {
            System.out.println("Wrong guess!");
            return false;
        }
    }
    // Creates the tic tac toe game
    private boolean ticTacToe() {
        // Creates a board for the game
        char[] board = {
                '1','2','3',
                '4','5','6',
                '7','8','9'
        };

        // Sets up a player as X
        char currentPlayer = 'X';
        boolean teacherTurn = true;

        // Goes through the board until complete
        while (true) {
            // Shows the board
            printBoard(board);

            // Lets the teacher go first then the student
            if (teacherTurn) {
                System.out.print("Teacher choose spot: ");
            }
            else {
                System.out.print("Student choose spot: ");
            }

            int move = Integer.parseInt(keyboard.nextLine()) - 1;

            // Makes sure that all the moves are valid
            if (move < 0 || move > 8 || board[move] == 'X' || board[move] == 'O') {
                System.out.println("Invalid move.");
                continue;
            }

            board[move] = currentPlayer;

            // Checks to see if there is a winner yet and if so prints it out
            if (checkWinner(board, currentPlayer)) {
                printBoard(board);

                if (teacherTurn) {
                    System.out.println("Teacher wins Tic Tac Toe!");
                    return true;
                }
                else {
                    System.out.println("Student wins Tic Tac Toe!");
                    return false;
                }
            }
            // Checks to see if the board is full with no winner and if so then it's a tie
            if (boardFull(board)) {
                printBoard(board);
                System.out.println("Tie game!");
                return false;
            }
            // Sets up the teacher's then the student's turn
            if (teacherTurn) {
                teacherTurn = false;
                currentPlayer = 'O';
            }
            else {
                teacherTurn = true;
                currentPlayer = 'X';
            }
        }
    }
    // Prints out the board for the tic tac toe board
    private void printBoard(char[] board) {
        System.out.println();

        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("--+---+--");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("--+---+--");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);

        System.out.println();
    }
    // The function to help check the winner for the tic tac toe game
    private boolean checkWinner(char[] b, char p) {
        return
                (b[0] == p && b[1] == p && b[2] == p) || (b[3] == p && b[4] == p && b[5] == p) || (b[6] == p && b[7]
                        == p && b[8] == p) || (b[0] == p && b[3] == p && b[6] == p) || (b[1] == p && b[4] == p && b[7]
                        == p) || (b[2] == p && b[5] == p && b[8] == p) || (b[0] == p && b[4] == p && b[8] == p) ||
                        (b[2] == p && b[4] == p && b[6] == p);
    }
    // Function to check and to see if the board is full or not
    private boolean boardFull(char[] board) {
        for (char c : board) {
            if (c != 'X' && c != 'O') {
                return false;
            }
        }
        return true;
    }
}
