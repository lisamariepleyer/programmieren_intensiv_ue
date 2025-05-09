package TicTacToe.BeispielMitKI;

import java.util.Scanner;

public class TicTacToe {
    public static final int GROESSE = 3;
    public static final char LEER = ' ';
    private static final Scanner scanner = new Scanner(System.in);

    private char[][] spielfeld;
    private Spieler mensch;
    private KI ki;

    public static void main(String[] args) {
        TicTacToe spiel = new TicTacToe();
        spiel.spieleSpiel();
    }

    public TicTacToe() {
        spielfeld = new char[GROESSE][GROESSE];
        initialisiereSpielfeld();
        mensch = new Spieler('X');
        ki = new KI('O');
    }

    public void spieleSpiel() {
        boolean weiterspielen = true;
        int anzahlSpiele = 0;
        int anzahlGewonneneSpiele = 0;
        int anzahlVerloreneSpiele = 0;

        while(weiterspielen) {
            initialisiereSpielfeld();
            zeigeSpielfeld();

            anzahlSpiele++;
            boolean spielLaeuft = true;

            while (spielLaeuft) {
                // Mensch
                mensch.macheZug(spielfeld);
                zeigeSpielfeld();
                if (pruefeGewinner(mensch.getSymbol())) {
                    System.out.println("Herzlichen Glückwunsch! Sie haben gewonnen!");
                    anzahlGewonneneSpiele++;
                    break;
                }
                if (pruefeUnentschieden()) {
                    System.out.println("Unentschieden!");
                    break;
                }

                // KI
                ki.macheZug(spielfeld);
                zeigeSpielfeld();
                if (pruefeGewinner(ki.getSymbol())) {
                    System.out.println("Die KI hat gewonnen!");
                    anzahlVerloreneSpiele++;
                    break;
                }
                if (pruefeUnentschieden()) {
                    System.out.println("Unentschieden!");
                    break;
                }
            }

            System.out.println("Möchten Sie ein neues Spiel starten? (j/n)");
            String antwort = scanner.nextLine().trim().toLowerCase();
            if (!antwort.equals("j")) {
                weiterspielen = false;
            }
        }

        System.out.println("\n--- Sitzungsübersicht ---");
        System.out.println("Spiele gespielt: " + anzahlSpiele);
        System.out.println("Gewonnen: " + anzahlGewonneneSpiele);
        System.out.println("Verloren: " + anzahlVerloreneSpiele);
        System.out.println("Unentschieden: " + (anzahlSpiele - anzahlGewonneneSpiele - anzahlVerloreneSpiele));
        System.out.println("Vielen Dank fürs Spielen!");
    }

    private void initialisiereSpielfeld() {
        for (int i = 0; i < GROESSE; i++) {
            for (int j = 0; j < GROESSE; j++) {
                spielfeld[i][j] = LEER;
            }
        }
    }

    private void zeigeSpielfeld() {
        System.out.println("   1 2 3");
        char zeilenBuchstabe = 'A';
        for (int i = 0; i < GROESSE; i++) {
            System.out.print(zeilenBuchstabe++ + " ");
            for (int j = 0; j < GROESSE; j++) {
                System.out.print(" " + spielfeld[i][j]);
            }
            System.out.println();
        }
    }

    private boolean pruefeGewinner(char symbol) {
        for (int i = 0; i < GROESSE; i++) {
            if ((spielfeld[i][0] == symbol && spielfeld[i][1] == symbol && spielfeld[i][2] == symbol) ||
                    (spielfeld[0][i] == symbol && spielfeld[1][i] == symbol && spielfeld[2][i] == symbol)) {
                return true;
            }
        }
        if ((spielfeld[0][0] == symbol && spielfeld[1][1] == symbol && spielfeld[2][2] == symbol) ||
                (spielfeld[0][2] == symbol && spielfeld[1][1] == symbol && spielfeld[2][0] == symbol)) {
            return true;
        }
        return false;
    }

    private boolean pruefeUnentschieden() {
        for (int i = 0; i < GROESSE; i++) {
            for (int j = 0; j < GROESSE; j++) {
                if (spielfeld[i][j] == LEER) {
                    return false;
                }
            }
        }
        return true;
    }
}
