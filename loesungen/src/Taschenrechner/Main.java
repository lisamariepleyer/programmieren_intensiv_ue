package Taschenrechner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Taschenrechner rechner = new Taschenrechner();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte gaben Sie zwei Zahlen ein: ");
        double a = rechner.leseZahl(scanner);
        double b = rechner.leseZahl(scanner);
        System.out.println("Sie haben die Zahlen " + a + " und " + b + " eingegeben.");

        boolean weiter = true;
        while (weiter) {
            System.out.println("Welche Operation möchten Sie durchführen? (+, -, *, /, min, max, vorzeichen, parität)");
            String operator = rechner.leseOperator(scanner);

            rechner.zeigeErgebnis(operator, a, b);

            System.out.println("Möchten Sie eine weitere Berechnung durchführen? (ja/nein):");
            String antwort = scanner.next().toLowerCase();
            weiter = antwort.equals("ja");
        }
    }
}
