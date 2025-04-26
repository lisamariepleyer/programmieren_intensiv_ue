package DontMeltTheSnowman.ObjectOriented;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Willkommen bei Don't Melt The Snowman!");
        System.out.print("Bitte geben Sie Ihren Namen ein: ");
        String name = scanner.nextLine();

        Spieler spieler = new Spieler(name);
        boolean nochmalSpielen;

        do {
            DontMeltTheSnowmanSpiel spiel = new DontMeltTheSnowmanSpiel(spieler);
            spiel.spiele();

            System.out.print("Möchten Sie noch einmal spielen? (j/n): ");
            String antwort = scanner.nextLine().toLowerCase();
            nochmalSpielen = antwort.equals("j");

        } while (nochmalSpielen);

        System.out.println("\n--- Sitzungsübersicht ---");
        System.out.println("Spieler: " + spieler.getName());
        System.out.println("Spiele gespielt: " + spieler.getSpieleGesamt());
        System.out.println("Gewonnen: " + spieler.getSpieleGewonnen());
        System.out.println("Verloren: " + (spieler.getSpieleGesamt() - spieler.getSpieleGewonnen()));
        System.out.println("Vielen Dank fürs Spielen!");
    }
}
