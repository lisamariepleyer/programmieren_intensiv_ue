package TicTacToe.BeispielMitKI;

import java.util.Scanner;

public class Spieler {
    protected char symbol;
    protected static final Scanner scanner = new Scanner(System.in);

    public Spieler(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void macheZug(char[][] spielfeld) {
        boolean gueltig = false;
        while (!gueltig) {
            System.out.println("Bitte geben Sie Ihr Feld ein (z.B. A1, B3): ");
            String eingabe = scanner.next().toUpperCase();

            if (eingabe.length() == 2) {
                int zeile = eingabe.charAt(0) - 'A';
                int spalte = eingabe.charAt(1) - '1';

                if (zeile >= 0 && zeile < TicTacToe.GROESSE && spalte >= 0 && spalte < TicTacToe.GROESSE) {
                    if (spielfeld[zeile][spalte] == TicTacToe.LEER) {
                        spielfeld[zeile][spalte] = symbol;
                        gueltig = true;
                    } else {
                        System.out.println("Dieses Feld ist bereits belegt. Bitte ein anderes wählen.");
                    }
                } else {
                    System.out.println("Ungültige Eingabe. Bereich A1 bis C3!");
                }
            } else {
                System.out.println("Ungültiges Format! Bitte Buchstabe+Zahl eingeben.");
            }
        }
    }
}
