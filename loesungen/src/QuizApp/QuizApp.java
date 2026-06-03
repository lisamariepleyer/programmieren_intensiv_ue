package QuizApp;

import java.util.Scanner;

public class QuizApp {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        System.out.println("Quiz Game initiated successfully on level " + quiz.getDifficultyLevel() + " 🥳");
        Quiz.printRules();

        while (true) {
            Question f = quiz.getQuestion();
            f.showQuestion();
            quiz.handleUserGuess(f);

            if (quiz.isQuit()) {
                break;
            }
        }

        quiz.printStats();
    }
}
