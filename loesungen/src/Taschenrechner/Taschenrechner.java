package Taschenrechner;

import java.util.Scanner;

public class Taschenrechner {
    public static void zeigeErgebnis(String operator, double a, double b){
        switch (operator){
            case ("+"):
                System.out.println(a + operator + b + " = " + addiere(a, b));
                return;
            case ("-"):
                System.out.println(a + operator + b + " = " + subtrahiere(a, b));
                return;
            case ("*"):
                System.out.println(a + operator + b + " = " + multipliziere(a, b));
                return;
            case ("/"):
                if (b == 0) {
                    System.out.println("Fehler: Eine Division durch null ist nicht erlaubt!");
                }
                System.out.println(a + operator + b + " = " + dividiere(a, b));
                return;
            case ("min"):
                System.out.println(operator + "(" + a + ", " + b +") = " + findeMin(a, b));
                return;
            case ("max"):
                System.out.println(operator + "(" + a + ", " + b +") = " + findeMax(a, b));
                return;
            case ("vorzeichen"):
                System.out.println(operator + "(" + a + ") = " + findeVorzeichen(a));
                System.out.println(operator + "(" + b + ") = " + findeVorzeichen(b));
                return;
            case ("parität"):
                System.out.println(operator + "(" + a + ") = " + findeParitaet(a));
                System.out.println(operator + "(" + b + ") = " + findeParitaet(b));
                return;
            default:
                System.out.println(operator + " ist kein valider operator.");
        }
    }

    public static void zeigeAlleErgebnisse(double a, double b){
        String[] potentielleOperatoren = {
                "+", "-", "*", "/", "min", "max", "vorzeichen", "parität"
        };

        for (String o : potentielleOperatoren) {
            zeigeErgebnis(o, a, b);
        }
    }

    public static String leseOperator(Scanner scanner){
        System.out.print("> ");
        return scanner.next();
    }

    public static double leseZahl(Scanner scanner){
        System.out.print("> ");

        while (!scanner.hasNextDouble()) {
            System.out.println("Das ist kein Double!");
            System.out.print("> ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static double addiere(double a, double b) {
        return a + b;
    }

    private static double subtrahiere(double a, double b) {
        return a - b;
    }

    private static double multipliziere(double a, double b) {
        return a * b;
    }

    private static double dividiere(double a, double b) {
        return a / b;
    }

    private static double findeMin(double a, double b) {
        return (a < b) ? a : b;
    }

    private static double findeMax(double a, double b) {
        return (a > b) ? a : b;
    }

    private static String findeVorzeichen(double z) {
        return (z > 0) ? "positiv" : "negativ";
    }

    private static String findeParitaet(double z) {
        return (z % 2 == 0) ? "gerade" : "ungerade";
    }

}
