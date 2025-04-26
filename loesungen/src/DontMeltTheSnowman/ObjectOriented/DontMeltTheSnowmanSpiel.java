package DontMeltTheSnowman.ObjectOriented;

import java.util.*;

public class DontMeltTheSnowmanSpiel {
    private static final String[] WORTLISTE = Woerterliste.WOERTER;
    private static final int MAX_FEHLER = 5;

    private final Spieler spieler;
    private String wort;
    private Set<Character> gerateneBuchstaben;
    private int fehlerAnzahl;

    public DontMeltTheSnowmanSpiel(Spieler spieler) {
        this.spieler = spieler;
        this.gerateneBuchstaben = new HashSet<>();
        this.fehlerAnzahl = 0;
        this.wort = waehleZufaelligesWort();
    }

    private String waehleZufaelligesWort() {
        Random rand = new Random();
        return WORTLISTE[rand.nextInt(WORTLISTE.length)];
    }

    public void spiele() {
        spieler.inkrementiereSpieleGesamt();
        Scanner scanner = new Scanner(System.in);

        while (fehlerAnzahl < MAX_FEHLER && !istWortErraten()) {
            zeigeSchneemann();
            zeigeWortFortschritt();
            System.out.print("Geratene Buchstaben: " + gerateneBuchstaben + "\n");
            System.out.print("Bitte geben Sie einen Buchstaben ein: ");

            String input = scanner.nextLine().toLowerCase();

            if (!istGueltigeEingabe(input)) {
                System.out.println("❌ Ungültige Eingabe. Bitte nur EINEN Buchstaben eingeben.");
                continue;
            }

            char buchstabe = input.charAt(0);

            if (gerateneBuchstaben.contains(buchstabe)) {
                System.out.println("⚠️ Dieser Buchstabe wurde bereits geraten.");
                continue;
            }

            gerateneBuchstaben.add(buchstabe);

            if (!wort.toLowerCase().contains(String.valueOf(buchstabe))) {
                fehlerAnzahl++;
                System.out.println("❌ Falsch geraten!");
            } else {
                System.out.println("✅ Richtig geraten!");
            }
        }

        zeigeSchneemann();
        zeigeWortFortschritt();

        if (istWortErraten()) {
            System.out.println("🎉 Herzlichen Glückwunsch, Sie haben gewonnen!");
            spieler.inkrementiereSpieleGewonnen();
        } else {
            System.out.println("💀 Sie haben verloren. Das Wort war: " + wort);
        }
    }

    private boolean istGueltigeEingabe(String eingabe) {
        return eingabe.length() == 1 && Character.isLetter(eingabe.charAt(0));
    }

    private void zeigeWortFortschritt() {
        System.out.print("Wort: ");

        for (char c : wort.toCharArray()) {
            if (gerateneBuchstaben.contains(Character.toLowerCase(c))) {
                System.out.print(c + " ");
            } else {
                System.out.print("_ ");
            }
        }

        System.out.println("\n");
    }

    private boolean istWortErraten() {
        for (char c : wort.toLowerCase().toCharArray()) {
            if (!gerateneBuchstaben.contains(c)) {
                return false;
            }
        }

        return true;
    }

    private void zeigeSchneemann() {
        String[] ascii = {
                """
         🎩
        (•_•)
        ( : )
        ( : )
        """,
                """
         🎩
        (•_•)
        ( : )
        (   )
        """,
                """
         🎩
        (•_•)
        (   )
        (   )
        """,
                """
         🎩
        (•-•)
        (   )
        """,
                """
         🎩
        (•~•)
        """,
                """
        💧🎩
        (nur noch eine Pfütze...)
        """
        };

        System.out.println("\nFehler: " + fehlerAnzahl + " von " + MAX_FEHLER);
        System.out.println(ascii[fehlerAnzahl]);
    }
}
