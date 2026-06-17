package QuizApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Question {
    private String question;
    private String correctAnswer;
    private String[] incorrectAnswers;
    private String[] shuffledAnswers;

    public Question(String question, String correctAnswer, String[] incorrectAnswers){
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
        this.shuffledAnswers = shuffleAnswers();
    }

    private String[] shuffleAnswers(){
        ArrayList<String> shuffledAnswers = new ArrayList<>(Arrays.asList(this.incorrectAnswers));
        shuffledAnswers.add(this.correctAnswer);

        Collections.shuffle(shuffledAnswers);

        return shuffledAnswers.toArray(new String[0]);
    }

    public void showQuestion() {
        System.out.println(this.question);

        for (int i = 0; i < getNumberOfAnswers(); i++) {
            System.out.println(i + 1 + ") "+ this.shuffledAnswers[i]);
        }
    }

    public boolean isGuessCorrect(int userGuess) {
        return this.shuffledAnswers[userGuess].equals(this.correctAnswer);
    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

    public int getNumberOfAnswers() {
        return this.shuffledAnswers.length;
    }
}
