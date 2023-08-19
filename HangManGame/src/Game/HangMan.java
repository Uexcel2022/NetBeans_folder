package Game;

import java.util.Scanner;

public class HangMan {

    Scanner sc = new Scanner(System.in);

    public void showManu() {
        System.out.println("------Menu--------");
        System.out.println("1. Play Game");
        System.out.println("2. Game Instructions");
        System.out.println("3. Exit Game");
    }

    public void playGame() {
        String userInput;
        String words = "love is the greatest of all";
        System.out.println("\nGuess a letter in the hidden words.");
        System.out.println("Status: Present (correct guess) and Not present (incorrect guess)");

        do {
            boolean found = false;
            System.out.print("\nEnter a letter or zero to exit: ");
            userInput = sc.nextLine().strip().toLowerCase();
            if (userInput.equalsIgnoreCase("0")) {
                exitGame();
            } else if (userInput.length() == 1) {
                char letter = userInput.charAt(0);
                for (int i = 0; i < words.length(); i++) {
                    if (words.charAt(i) == letter) {
                        found = true;
                        break;
                    }
                }
            } else {
                System.err.println("\nInvalid input. You entered more than one letters");
                continue;
            }

            String check = (found) ? "Present" : "Not Present";
            System.out.println("\nStatus: " + check);

        } while (true);

    }

    public void gameInstructions() {
        System.out.println("\nGame  Instructions Method invoked");
    }

    public void exitGame() {
        System.out.println("\nExit Game Method invoked");
        System.exit(0);
    }
}
