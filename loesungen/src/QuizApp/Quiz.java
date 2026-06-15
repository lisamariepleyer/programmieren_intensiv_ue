package QuizApp;

public class Quiz {
    private int numberOfQuestions;
    private int numberOfCorrectAnswers;
    private boolean quit;
    private String difficultyLevel;

    public Quiz() {
        this.numberOfQuestions = 0;
        this.numberOfCorrectAnswers = 0;
        this.quit = false;
        this.difficultyLevel = UserInputHandler.chooseDifficultyLevel();
    }

    public String getDifficultyLevel() {
        return this.difficultyLevel;
    }

    public boolean isQuit() {
        return this.quit;
    }

    public void playRound() {
        Question question = OpenTriviaDBHandler.getQuestion(getDifficultyLevel());
        question.showQuestion();

        int guess = UserInputHandler.letUserGuess(question.getNumberOfAnswers());

        if (guess == -1) {
            this.quit = true;
            return;
        }

        boolean isCorrect = question.isGuessCorrect(guess);

        updateStatistics(isCorrect);
        printResult(isCorrect, question);
    }

    private void updateStatistics(boolean correct) {
        this.numberOfQuestions++;
        if (correct) {
            this.numberOfCorrectAnswers++;
        }
    }

    private void printResult(boolean correct, Question question) {
        if (correct) {
            System.out.println("Correct! 🤩");
        }
        else {
            System.out.println("Nope! 😶‍🌫 The correct answer was: " + question.getCorrectAnswer());
        }
    }

    public void printStatistics() {
        System.out.println("You won " + this.numberOfCorrectAnswers + " out of " + this.numberOfQuestions + " questions!");
    }

    public static void printRules() {
        System.out.println("Rules:");
        System.out.println("➡ Enter the number of the correct answer.");
        System.out.println("➡ Enter 'quit' to end the game.");
        System.out.println();
    }
}
