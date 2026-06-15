package QuizApp;

import java.util.Scanner;

public class QuizApp {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        System.out.println("Quiz Game initiated successfully on level " + quiz.getDifficultyLevel() + " 🥳");
        Quiz.printRules();

        while (!quiz.isQuit()) {
            quiz.playRound();
        }

        quiz.printStatistics();
    }
}
