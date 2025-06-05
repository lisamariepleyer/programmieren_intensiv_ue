package QuizApp;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class QuizApp {
    public static final Scanner scanner = new Scanner(System.in);
    private static final HttpClient client = HttpClient.newHttpClient();

    public static void main(String[] args) {
        System.out.println("Quiz Game initiated successfully 🥳");
        String level = getDifficultyLevel();
        printRules();

        int numberOfQuestions = 0;
        int numberOfCorrectQuestions = 0;

        boolean isPlaying = true;

        while (isPlaying) {
            String response = getQuestion(level);
            if (response == null) {
                System.out.println("Couldn't fetch new question ...");
                continue;
            }

            Question f = parseResponse(response);
            f.showQuestion();

            int userGuess = letUserGuess(f.getNumberOfAnswers());

            if (userGuess == -1) {
                break;
            }

            numberOfQuestions++;

            boolean isCorrect = f.isGuessCorrect(userGuess);

            if (isCorrect) {
                System.out.println("Correct! 🤩");
                numberOfCorrectQuestions++;
            }
            else {
                System.out.println("Nope! 😶‍🌫 The correct answer was: " + f.getCorrectAnswer());
            }
        }

        System.out.println("You won " + numberOfCorrectQuestions + " out of " + numberOfQuestions + " questions!");
    }

    public static void printRules() {
        System.out.println("Rules:");
        System.out.println("1️⃣ Enter the number of the correct answer.");
        System.out.println("2️⃣ Enter 'quit' to end the game.");
        System.out.println("3️⃣ Enter 'rules' to see the rules again.");
        System.out.println();
    }

    public static String getDifficultyLevel() {
        while (true) {
            System.out.println("Choose a difficulty level (easy, medium, hard):");
            System.out.print("> ");

            String input = scanner.next();

            if (input.equals("easy") || input.equals("medium") || input.equals("hard")) {
                return input;
            }
        }

    }

    public static String getQuestion(String level) {
        String url = "https://opentdb.com/api.php?amount=1&type=multiple&difficulty=" + level;
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String responseCode = extractKey(response.body(), "response_code\":", ",\"");
            if (! responseCode.equals("0")) {
                throw new IOException("");
            }

            return response.body();
        } catch (IOException | InterruptedException e) {
            return null;
        }
    }

    public static Question parseResponse(String response) {
        String question = extractKey(response, "question\":", "\",\"");
        question = decodeHTML(removeQuotes(question));

        String correctAnswer = extractKey(response, "correct_answer\":", "\",\"");
        correctAnswer = decodeHTML(removeQuotes(correctAnswer));

        String[] incorrectAnswers = extractKey(response, "incorrect_answers\":[", "]").split(",");
        for (int i = 0; i < incorrectAnswers.length; i++) {
            incorrectAnswers[i] = decodeHTML(removeQuotes(incorrectAnswers[i]));
        }

        Question f = new Question(question, correctAnswer, incorrectAnswers);

        return f;
    }

    public static String extractKey(String response, String key, String valueEnd) {
        int start = response.indexOf(key) + key.length();
        int end = response.indexOf(valueEnd, start);

        return removeQuotes(response.substring(start, end));
    }

    public static String removeQuotes(String s) {
        if (s.startsWith("\"")) {
            s = s.substring(1, s.length());
        }

        if (s.endsWith("\"")) {
            s = s.substring(0, s.length() - 1);
        }

        return s;
    }

    public static String decodeHTML(String s) {
        return s.replace("&quot;", "\"")
                .replace("&#039;", "'")
                .replace("&rsquo;", "'")
                .replace("&amp;", "&")
                .replace("&lt;", "<")
                .replace("&gt;", ">");
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

            if (input.equals("rules")){
                printRules();
                continue;
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
