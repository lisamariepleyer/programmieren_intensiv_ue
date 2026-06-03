package QuizApp;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OpenTriviaDBHandler {
    private static final HttpClient client = HttpClient.newHttpClient();

    public static Question getQuestion(String level) {
        String response;

        while (true) {
            response = fetchQuestion(level);
            if (response == null) {
                System.out.println("Couldn't fetch new question ...");
                continue;
            }
            break;
        }

        Question question = parseResponse(response);
        return question;
    }

    private static String fetchQuestion(String level) {
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

    private static Question parseResponse(String response) {
        String question = extractKey(response, "question\":", "\",\"");
        question = decodeHTML(removeQuotes(question));

        String correctAnswer = extractKey(response, "correct_answer\":", "\",\"");
        correctAnswer = decodeHTML(removeQuotes(correctAnswer));

        String[] incorrectAnswers = extractKey(response, "incorrect_answers\":[", "]").split(",");
        for (int i = 0; i < incorrectAnswers.length; i++) {
            incorrectAnswers[i] = decodeHTML(removeQuotes(incorrectAnswers[i]));
        }

        return new Question(question, correctAnswer, incorrectAnswers);
    }

    private static String extractKey(String response, String key, String valueEnd) {
        int start = response.indexOf(key) + key.length();
        int end = response.indexOf(valueEnd, start);

        return removeQuotes(response.substring(start, end));
    }

    private static String removeQuotes(String s) {
        if (s.startsWith("\"")) {
            s = s.substring(1, s.length());
        }

        if (s.endsWith("\"")) {
            s = s.substring(0, s.length() - 1);
        }

        return s;
    }

    private static String decodeHTML(String s) {
        return s.replace("&quot;", "\"")
                .replace("&#039;", "'")
                .replace("&rsquo;", "'")
                .replace("&amp;", "&")
                .replace("&lt;", "<")
                .replace("&gt;", ">");
    }
}
