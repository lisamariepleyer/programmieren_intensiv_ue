package TicTacToe.Beispiel;

import java.util.Scanner;

public class TicTacToe {
    private static final int SPIELFELD_GROESSE = 3;
    private static char[] symbole = {'x', 'o'};
    private static char leeresSymbol = ' ';
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (pruefeNochmalSpielen()) {
            spieleSpiel();
        }

        /*
        boolean spielLaeuft = true;

        while(spielLaeuft) {
            for (symbol : {"X", "O"}) {
                zeigeSpielfeld();
                spielerZug();

                if (pruefeGewinner() | pruefeUnentschieden()) {
                    spielLaeuft = false;
                    break;
                }
            }

        }
         */
    }

    public static boolean pruefeNochmalSpielen() {
        System.out.println("Spielen? (j/n)");
        if (scanner.next().equals("j")) {
            return true;
        }
        return false;
    }

    public static void zeigeSpielfeld(char[][] spielfeld) {
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
    }

    public static void spielerZug(char symbol, char[][] spielfeld) {
        boolean hatSymbolGesetzt = false;

        while (!hatSymbolGesetzt) {
            hatSymbolGesetzt = setzeSymbol(symbol, spielfeld);
        }
    }

    public static boolean setzeSymbol(char symbol, char[][] spielfeld) {
        System.out.println("Wo möchten Sie ein '" + symbol + "' setzen?");

        System.out.print("Zeile: ");
        int zeile = scanner.nextInt();

        System.out.print("Spalte: ");
        int spalte = scanner.nextInt();

        if (spielfeld[zeile][spalte] == leeresSymbol) {
            spielfeld[zeile][spalte] = symbol;
            return true;
        } else {
            return false;
        }
    }

    public static boolean pruefeGewinner(char symbol, char[][] spielfeld) {
        for (int i = 0; i < SPIELFELD_GROESSE; i++) {
            if (
                    (spielfeld[i][0] == symbol && spielfeld[i][1] == symbol && spielfeld[i][2] == symbol)
                    || (spielfeld[0][i] == symbol && spielfeld[1][i] == symbol && spielfeld[2][i] == symbol)
            ) {
                return true;
            }
        }

        if (
                (spielfeld[0][0] == symbol && spielfeld[1][1] == symbol && spielfeld[2][2] == symbol)
                || (spielfeld[2][0] == symbol && spielfeld[1][1] == symbol && spielfeld[0][2] == symbol)
        ) {
            return true;
        }

        return false;
    }

    public static boolean pruefeUnentschieden(char[][] spielfeld) {
        for (int i = 0; i < SPIELFELD_GROESSE; i++) {
            for (int j = 0; j < SPIELFELD_GROESSE; j++) {
                if (spielfeld[i][j] == leeresSymbol) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void spieleSpiel() {
        char[][] spielfeld = initialisiereSpielfeld();
        boolean spielLaeuft = true;

        while(spielLaeuft) {
            for (char symbol : symbole) {
                zeigeSpielfeld(spielfeld);
                spielerZug(symbol, spielfeld);

                boolean gewonnen = pruefeGewinner(symbol, spielfeld);
                if (gewonnen) {
                    System.out.println(symbol + " hat gewonnen!");
                    spielLaeuft = false;
                    break;
                }

                boolean unentschieden = pruefeUnentschieden(spielfeld);
                if (unentschieden) {
                    System.out.println("unentschieden!");
                    spielLaeuft = false;
                    break;
                }
            }
        }

        zeigeSpielfeld(spielfeld);
    }

    public static char[][] initialisiereSpielfeld() {
        char[][] spielfeld = new char[SPIELFELD_GROESSE][SPIELFELD_GROESSE];

        for (int i = 0; i < SPIELFELD_GROESSE; i++) {
            for (int j = 0; j < SPIELFELD_GROESSE; j++) {
                spielfeld[i][j] = leeresSymbol;
            }
        }

        return spielfeld;
    }

}
