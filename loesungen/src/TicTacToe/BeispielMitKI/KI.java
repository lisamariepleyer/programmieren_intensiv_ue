package TicTacToe.BeispielMitKI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KI extends Spieler {
    private static final Random random = new Random();

    public KI(char symbol) {
        super(symbol);
    }

    @Override
    public void macheZug(char[][] spielfeld) {
        System.out.println("KI ist am Zug...");

        int[] zug = findeGewinnZug(spielfeld, this.symbol);
        if (zug == null) {
            zug = findeGewinnZug(spielfeld, gegnerSymbol());
        }
        if (zug == null) {
            zug = findeZufaelligenZug(spielfeld);
        }

        spielfeld[zug[0]][zug[1]] = symbol;
    }

    private char gegnerSymbol() {
        return (symbol == 'X') ? 'O' : 'X';
    }

    private int[] findeGewinnZug(char[][] spielfeld, char suchSymbol) {
        for (int i = 0; i < TicTacToe.GROESSE; i++) {
            // Zeilen prüfen
            int[] zug = pruefeReiheOderSpalte(spielfeld, i, true, suchSymbol);
            if (zug != null) return zug;

            // Spalten prüfen
            zug = pruefeReiheOderSpalte(spielfeld, i, false, suchSymbol);
            if (zug != null) return zug;
        }

        // Diagonalen prüfen
        int[] diag1 = pruefeDiagonale(spielfeld, true, suchSymbol);
        if (diag1 != null) return diag1;

        int[] diag2 = pruefeDiagonale(spielfeld, false, suchSymbol);
        if (diag2 != null) return diag2;

        return null;
    }

    private int[] pruefeReiheOderSpalte(char[][] spielfeld, int index, boolean zeile, char suchSymbol) {
        int countSymbol = 0;
        int countLeer = 0;
        int leerIndex = -1;

        for (int i = 0; i < TicTacToe.GROESSE; i++) {
            char feld = zeile ? spielfeld[index][i] : spielfeld[i][index];
            if (feld == suchSymbol) countSymbol++;
            if (feld == TicTacToe.LEER) {
                countLeer++;
                leerIndex = i;
            }
        }
        if (countSymbol == 2 && countLeer == 1) {
            if (zeile) {
                return new int[]{index, leerIndex};
            } else {
                return new int[]{leerIndex, index};
            }
        }
        return null;
    }

    private int[] pruefeDiagonale(char[][] spielfeld, boolean hauptdiagonale, char suchSymbol) {
        int countSymbol = 0;
        int countLeer = 0;
        int leerIndex = -1;

        for (int i = 0; i < TicTacToe.GROESSE; i++) {
            char feld = hauptdiagonale ? spielfeld[i][i] : spielfeld[i][TicTacToe.GROESSE - 1 - i];
            if (feld == suchSymbol) countSymbol++;
            if (feld == TicTacToe.LEER) {
                countLeer++;
                leerIndex = i;
            }
        }
        if (countSymbol == 2 && countLeer == 1) {
            if (hauptdiagonale) {
                return new int[]{leerIndex, leerIndex};
            } else {
                return new int[]{leerIndex, TicTacToe.GROESSE - 1 - leerIndex};
            }
        }
        return null;
    }

    private int[] findeZufaelligenZug(char[][] spielfeld) {
        List<int[]> freieFelder = new ArrayList<>();
        for (int i = 0; i < TicTacToe.GROESSE; i++) {
            for (int j = 0; j < TicTacToe.GROESSE; j++) {
                if (spielfeld[i][j] == TicTacToe.LEER) {
                    freieFelder.add(new int[]{i, j});
                }
            }
        }
        return freieFelder.get(random.nextInt(freieFelder.size()));
    }
}
