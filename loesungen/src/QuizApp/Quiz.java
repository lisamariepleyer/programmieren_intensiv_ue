package QuizApp;

public class Quiz {
    private int numberOfQuestions;
    private int numberOfCorrectQuestions;
    private boolean isQuit;
    private String difficultyLevel;
    UserInputHandler inputHandler;

    public Quiz() {
        numberOfQuestions = 0;
        numberOfCorrectQuestions = 0;
        inputHandler = new UserInputHandler();
        difficultyLevel = inputHandler.chooseDifficultyLevel();
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public boolean isQuit() {
        return isQuit;
    }

    public void setQuit() {
        isQuit = true;
    }

    public Question getQuestion() {
        return OpenTriviaDBHandler.getQuestion(getDifficultyLevel());
    }

    public void handleUserGuess(Question q) {
        int guess = UserInputHandler.letUserGuess(q.getNumberOfAnswers());

        if (guess == -1) {
            setQuit();
            return;
        }

        boolean isCorrect = q.isGuessCorrect(guess);
        handleQuestionCounter(isCorrect);
        printQuestionResult(isCorrect, q);
    }

    private void handleQuestionCounter(boolean isAnswerCorrect) {
        numberOfQuestions++;
        if (isAnswerCorrect) {
            numberOfCorrectQuestions++;
        }
    }

    private void printQuestionResult(boolean isAnswerCorrect, Question q) {
        if (isAnswerCorrect) {
            System.out.println("Correct! 🤩");
        }
        else {
            System.out.println("Nope! 😶‍🌫 The correct answer was: " + q.getCorrectAnswer());
        }
    }

    public static void printRules() {
        System.out.println("Rules:");
        System.out.println("1️⃣ Enter the number of the correct answer.");
        System.out.println("2️⃣ Enter 'quit' to end the game.");
        System.out.println("3️⃣ Enter 'rules' to see the rules again.");
        System.out.println();
    }

    public void printStats() {
        System.out.println("You won " + numberOfCorrectQuestions + " out of " + numberOfQuestions + " questions!");
    }
}
