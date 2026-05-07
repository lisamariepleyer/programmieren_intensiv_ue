package TicTacToe.Beispiel;

import java.util.Scanner;

public class TicTacToe {
    // Klassenvariablen
    private static final int SPIELFELD_GROESSE = 3; // Konstante Variable
    private static char[] symbole = {'x', 'o'};
    private static char leeresSymbol = '.';
    private static char[][] spielfeld;
    private static Scanner scanner = new Scanner(System.in);

    // Methoden
    public static void main(String[] args) {
        while (true) {
            spieleSpiel();

            // spieleSpiel() wird ausgeführt, bis user nicht mehr mit "j" antwortet und die while Schleife abgebrochen wird
            if (!pruefeNochmalSpielen()) {
                break;
            }
        }
    }

    public static boolean pruefeNochmalSpielen() {
        System.out.println("Spielen? (j/n)");
        if (scanner.next().equals("j")) {
            return true;
        }
        return false;
    }

    public static void initialisiereSpielfeld() {
        // Initialisiere Variable Spielfeld (2D Array)
        spielfeld = new char[SPIELFELD_GROESSE][SPIELFELD_GROESSE];

        // der default Value für chars ist '\u0000'
        // setze daher das leereSymbol in jedes Feld des Spielfelds
        for (int i = 0; i < SPIELFELD_GROESSE; i++) {
            for (int j = 0; j < SPIELFELD_GROESSE; j++) {
                spielfeld[i][j] = leeresSymbol;
            }
        }
    }

    public static void zeigeSpielfeld() {
        for (int i = 0; i < SPIELFELD_GROESSE; i++) {
            for (int j = 0; j < SPIELFELD_GROESSE; j++) {
                System.out.print(spielfeld[i][j]);
            }
            System.out.println();
        }

        /*
        // laut Angabe:
        System.out.println("  0   1   2");

        for (int i = 0; i < SPIELFELD_GROESSE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SPIELFELD_GROESSE; j++) {
                System.out.print(" " + spielfeld[i][j]);
                if (j < 2) System.out.print(" |");
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  ---+---+---");
            }
        }
        */
    }

    public static void spielerZug(char symbol) {
        while (true) {
            System.out.println("Wo möchten Sie ein '" + symbol + "' setzen?");

            System.out.print("Zeile: ");
            int zeile = scanner.nextInt();

            System.out.print("Spalte: ");
            int spalte = scanner.nextInt();

            if (spielfeld[zeile][spalte] == leeresSymbol) {
                // wenn das Feld noch leer ist, darf ich mein Symbol setzen und unterbreche die while Schleife
                spielfeld[zeile][spalte] = symbol;
                return;
            } else {
                // wenn das Feld nicht leer ist, bleibe ich in der while Schleife
                System.out.println("Dieses Feld ist bereits belegt.");
            }
        }
    }

    public static boolean pruefeGewinner(char symbol) {
        for (int i = 0; i < SPIELFELD_GROESSE; i++) {
            // überprüfe Reihen
            if (spielfeld[i][0] == symbol && spielfeld[i][1] == symbol && spielfeld[i][2] == symbol) {
                return true;
            }

            // Überprüfe Spalten
            if (spielfeld[0][i] == symbol && spielfeld[1][i] == symbol && spielfeld[2][i] == symbol) {
                return true;
            }
        }

        // Überprüfe Diagonale links oben nach rechts unten
        if(spielfeld[0][0] == symbol && spielfeld[1][1] == symbol && spielfeld[2][2] == symbol) {
            return true;
        }

        // Überprüfe Diagonale links unten nach rechts oben
        if (spielfeld[2][0] == symbol && spielfeld[1][1] == symbol && spielfeld[0][2] == symbol) {
            return true;
        }

        // Symbol hat nicht gewonnen
        return false;
    }

    public static boolean pruefeUnentschieden() {
        // wenn sich noch ein leeres Feld im Spielfeld befindet, dann ist das Spiel noch nicht entschieden
        for (int i = 0; i < SPIELFELD_GROESSE; i++) {
            for (int j = 0; j < SPIELFELD_GROESSE; j++) {
                if (spielfeld[i][j] == leeresSymbol) {
                    return false;
                }
            }
        }

        // es wurde kein leeres Feld mehr gefunden, das Spiel ist unentschieden
        return true;
    }

    public static void spieleSpiel() {
        // Spiellogik
        initialisiereSpielfeld();
        boolean spielLaeuft = true;

        // die while Schleife läuft, solange spielLäuft true ist
        // sobald spielLäuft auf false gesetzt wird, wird die while Schleife unterbrochen
        while(spielLaeuft) {
            for (char symbol : symbole) {
                zeigeSpielfeld();
                spielerZug(symbol);

                // wenn das Symbol gewonnen hat, wird die for Schleife unterbrochen und spielLäuft auf false gesetzt
                if (pruefeGewinner(symbol)) {
                    System.out.println(symbol + " hat gewonnen!");
                    spielLaeuft = false;
                    break;
                }

                // wenn das Spiel unentschieden ist, wird die for Schleife unterbrochen und spielLäuft auf false gesetzt
                if (pruefeUnentschieden()) {
                    System.out.println("unentschieden!");
                    spielLaeuft = false;
                    break;
                }
            }
        }

        // zeige das Ergebnis nach Spielende
        zeigeSpielfeld();
    }
}
