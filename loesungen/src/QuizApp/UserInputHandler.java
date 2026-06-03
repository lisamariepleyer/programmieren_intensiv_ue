package QuizApp;

import java.util.Scanner;

public class UserInputHandler {
    public static final Scanner scanner = new Scanner(System.in);

    public static String chooseDifficultyLevel() {
        while (true) {
            System.out.println("Choose a difficulty level (easy, medium, hard):");
            System.out.print("> ");

            String input = scanner.next();

            if (input.equals("easy") || input.equals("medium") || input.equals("hard")) {
                return input;
            }
        }
    }

    public static int letUserGuess(int maxAnswerIndex) {
        int answer;

        while (true) {
            System.out.println("Which answer is correct?");
            System.out.print("> ");

            String input = scanner.next();

            if (input.equals("quit")){
                return -1;
            }

            try {
                answer = Integer.parseInt(input);

                if (answer < 1 || answer > maxAnswerIndex) {
                    throw new IllegalArgumentException();
                }

                return answer - 1;
            } catch (IllegalArgumentException e) {
                System.out.println("That's not a valid number. Please try again.\n");
            }
        }
    }
}
