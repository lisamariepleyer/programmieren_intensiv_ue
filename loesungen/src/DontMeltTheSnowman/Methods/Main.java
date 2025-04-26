package DontMeltTheSnowman.Methods;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = frageSpielerName(scanner);
        System.out.println();

        int maxFehler = 5;

        int spieleGesamt = 0;
        int gewonneneSpiele = 0;

        boolean willSpielen = frageNachSpielen(scanner);
        while (willSpielen) {
            String wort = waehleWort();

            String wortfortschritt = spiele(maxFehler, wort, scanner);

            if (istWortErraten(wortfortschritt)) {
                gewonneneSpiele++;
            }

            spieleGesamt++;

            willSpielen = frageNachSpielen(scanner);
        }

        System.out.println(name + ", du hast " + gewonneneSpiele + " von " + spieleGesamt + " Spielen gewonnen!");
    }

    public static boolean frageNachSpielen(Scanner scanner) {
        System.out.println("Möchtest du spielen? (j/n)");
        System.out.print("> ");

        if (scanner.next().equals("j")) {
            return true;
        }

        return false;
    }

    public static boolean istWortErraten(String wortfortschritt) {
        // wenn der Wortfortschritt noch Unterstrich(e) enthält, ist das Wort noch nicht erraten.
        // wir wollen true zurückgeben, wenn der Wortforschritt keine Unterstriche enthält, daher logische Negation
        return !wortfortschritt.contains("_");
    }

    public static String spiele(int maxFehler, String wort, Scanner scanner){
        char[] gerateneBuchstaben = new char[maxFehler + wort.length()];

        String wortfortschritt = "";
        int iteration = 0;
        int fehlerAnzahl = 0;
        while (fehlerAnzahl < maxFehler) {

            zeigeGerateneBuchstaben(gerateneBuchstaben, iteration);

            char b = getBuchstabenEingabe(scanner, gerateneBuchstaben);
            gerateneBuchstaben[iteration] = b;

            wortfortschritt = getWortfortschritt(gerateneBuchstaben, wort);
            System.out.println(wortfortschritt);
            System.out.println();

            // erhöhe Iteration, unabhängig vom Wert der Variable istBuchstabeHit
            iteration++;

            if (istBuchStabeHit(wort, b)) {
                if (istWortErraten(wortfortschritt)) {
                    break;
                }
                continue;
            }

            // erhöhe fehlerAnzahl, auch wenn istBuchstabeHit falsch ist
            fehlerAnzahl++;
        }

        return wortfortschritt;
    }

    public static boolean istBuchStabeHit(String wort, char b) {
        boolean istBuchStabeHit = false;

        for (char w : wort.toLowerCase().toCharArray()) {
            if (w == b) {
                istBuchStabeHit = true;
                break;
            }
        }

        return istBuchStabeHit;
    }

    public static String getWortfortschritt(char[] gerateneBuchstaben, String wort) {
        String printMessage = "";

        for (char w : wort.toCharArray()) {
            boolean guessed = false;

            for (char g : gerateneBuchstaben) {
                if (Character.toLowerCase(w) == g) {
                    guessed = true;
                    break;
                }
            }

            printMessage += (guessed) ? Character.toString(w) : "_";
        }

        return printMessage;
    }

    public static char getBuchstabenEingabe(Scanner scanner, char[] gerateneBuchstaben) {
        System.out.print("Rate einen Buchstaben: ");
        String input = scanner.next();

        // 1. Validierung: nur maximal 1 char erlaubt
        char[] inputCharArray = input.toCharArray();
        if (inputCharArray.length > 1) {
            System.out.println("Nur einzelne Buchstaben sind erlaubt!");
            return getBuchstabenEingabe(scanner, gerateneBuchstaben);
        }

        char b = inputCharArray[0];

        // 2. Validierung: Buchstabe, keine Zahl oder Sonderzeichen
        if (!Character.isLetter(b)) {
            System.out.println(b + " ist kein gueltiger Buchstabe!");
            return getBuchstabenEingabe(scanner, gerateneBuchstaben);
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
            return getBuchstabenEingabe(scanner, gerateneBuchstaben);
        }

        return b;
    }

    public static void zeigeGerateneBuchstaben(char[] gerateneBuchstaben, int versuch){
        System.out.print("Geratene Buchstaben: ");
        for (int pi = 0; pi < versuch; pi++) {
            System.out.print(gerateneBuchstaben[pi] + " ");
        }
        System.out.println();
    }

    public static String frageSpielerName(Scanner scanner) {
        System.out.println("Bitte gib Deinen Namen ein:");
        System.out.print("> ");
        String name = scanner.next();

        return name;
    }

    public static String waehleWort() {
        String[] woerter = {"Apfel", "Birne", "Banane"};

        Random rand = new Random();
        String wort = woerter[rand.nextInt(woerter.length)];

        return wort;
    }
}
