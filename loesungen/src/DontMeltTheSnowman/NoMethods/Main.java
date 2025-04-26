package DontMeltTheSnowman.NoMethods;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // begrüße Spieler
        System.out.println("Bitte gib Deinen Namen ein:");
        System.out.print("> ");
        String name = scanner.next();
        System.out.println("Herzlich willkommen bei Don't melt the Snowman, " + name + "!");
        System.out.println();

        // wähle zufaälliges Wort
        String[] woerter = {"Apfel", "Birne", "Banane"};

        Random rand = new Random();
        String wort = woerter[rand.nextInt(woerter.length)];

        // lasse Spiele raten, 5 Fehler sind erlaubt
        int maxFehler = 5;
        char[] gerateneBuchstaben = new char[maxFehler + wort.length()];

        int iteration = 0;
        int fehlerAnzahl = 0;
        while (fehlerAnzahl < maxFehler) {
            // zeige geratene Buchstaben
            System.out.print("Geratene Buchstaben: ");
            for (int i = 0; i < iteration; i++) {
                System.out.print(gerateneBuchstaben[i] + " ");
            }
            System.out.println();

            // lasse Spieler Buchstabe eingeben und validiere den Input
            System.out.print("Rate einen Buchstaben: ");
            String input = scanner.next();

            // 1. Validierung: nur maximal 1 char
            char[] inputCharArray = input.toCharArray();
            if (inputCharArray.length > 1) {
                System.out.println("Nur einzelne Buchstaben sind erlaubt!");
                continue;
            }

            char b = inputCharArray[0];

            // 2. Validierung: Buchstabe, keine Zahl oder Sonderzeichen
            if (!Character.isLetter(b)) {
                System.out.println(b + " ist kein gueltiger Buchstabe!");
                continue;
            }

            b = Character.toLowerCase(b);

            // 3. Validierung: Buchstabe wurde schonmal eingegeben
            boolean alreadyGuessed = false;
            for (char g : gerateneBuchstaben) {
                if (g == b) {
                    alreadyGuessed = true;
                    break;
                }
            }

            if (alreadyGuessed) {
                System.out.println("Diesen Buchstaben hast du schon geraten!");
                continue;
            }

            // Buchstabe in Array speichern
            gerateneBuchstaben[iteration] = b;

            // Wortfortschritt speichern
            String printMessage = "";
            for (char w : wort.toLowerCase().toCharArray()) {
                boolean guessed = false;

                for (char g : gerateneBuchstaben) {
                    if (w == g) {
                        guessed = true;
                        break;
                    }
                }

                printMessage += (guessed) ? Character.toString(w) : "_";
            }
            System.out.println(printMessage);

            System.out.println();

            // checke, ob Buchstabe in Wort vorkommt, um nur Iteration vs Fehlversuche zu erhöhen
            boolean istBuchstabeHit = false;
            for (char w : wort.toLowerCase().toCharArray()) {
                if (w == b) {
                    istBuchstabeHit = true;
                    break;
                }
            }

            // erhöhe Iteration, unabhängig vom Wert der Variable istBuchstabeHit
            iteration++;

            if (istBuchstabeHit) {
                if (!printMessage.contains("_")) {
                    break;
                }
                continue;
            }

            // erhöhe fehlerAnzahl, auch wenn istBuchstabeHit falsch ist
            fehlerAnzahl++;
        }
    }
}
