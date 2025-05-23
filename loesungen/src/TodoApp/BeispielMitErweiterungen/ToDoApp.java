package TodoApp.BeispielMitErweiterungen;

import java.io.*;
import java.util.*;

public class ToDoApp {
    private static final String DATEINAME = "todos.txt";
    private static List<ToDo> toDoListe = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ladeToDosAusDatei();
        spieleApp();
        speichereToDosInDatei();
    }

    public static void spieleApp() {
        String eingabe = "";
        while (!eingabe.equals("0")) {
            zeigeMenue();
            eingabe = scanner.nextLine();
            verarbeiteEingabe(eingabe);
        }
    }

    public static void zeigeMenue() {
        System.out.println("\nWas möchten Sie tun?");
        System.out.println("1 - Alle ToDos anzeigen");
        System.out.println("2 - Neues ToDo hinzufügen");
        System.out.println("3 - ToDo als erledigt markieren");
        System.out.println("4 - ToDos speichern und beenden");
        System.out.println("5 - Ein ToDo löschen");
        System.out.println("0 - Beenden");
        System.out.print("Ihre Wahl: ");
    }

    public static void verarbeiteEingabe(String eingabe) {
        switch (eingabe) {
            case "1":
                alleToDosAnzeigen();
                break;
            case "2":
                neuesToDoHinzufuegen();
                break;
            case "3":
                markiereToDoAlsErledigt();
                break;
            case "4":
                speichereToDosInDatei();
                System.out.println("ToDos gespeichert. Bis bald!");
                System.exit(0);
                break;
            case "5":
                todoLoeschen();
                break;
            case "0":
                System.out.println("Auf Wiedersehen!");
                break;
            default:
                System.out.println("Ungültige Eingabe. Bitte wählen Sie eine gültige Option.");
        }
    }

    public static void alleToDosAnzeigen() {
        if (toDoListe.isEmpty()) {
            System.out.println("Es sind keine ToDos vorhanden.");
        } else {
            System.out.println("\nIhre ToDos:");
            for (int i = 0; i < toDoListe.size(); i++) {
                System.out.printf("%2d. %s%n", i + 1, toDoListe.get(i).gibAnzeigetext());
            }
        }
    }

    public static void neuesToDoHinzufuegen() {
        System.out.print("Geben Sie den Titel des neuen ToDos ein: ");
        String titel = scanner.nextLine();

        System.out.print("Priorität (hoch, mittel, niedrig): ");
        String prioritaet = scanner.nextLine().trim().toLowerCase();

        if (!prioritaet.equals("hoch") && !prioritaet.equals("mittel") && !prioritaet.equals("niedrig")) {
            System.out.println("Ungültige Priorität. Standardwert 'mittel' wird gesetzt.");
            prioritaet = "mittel";
        }

        toDoListe.add(new ToDo(titel, prioritaet));
        System.out.println("ToDo mit Priorität hinzugefügt.");
    }

    public static void markiereToDoAlsErledigt() {
        alleToDosAnzeigen();
        if (toDoListe.isEmpty()) return;

        System.out.print("Welche Nummer möchten Sie als erledigt markieren? ");
        try {
            int nummer = Integer.parseInt(scanner.nextLine());
            if (nummer >= 1 && nummer <= toDoListe.size()) {
                toDoListe.get(nummer - 1).alsErledigtMarkieren();
                System.out.println("ToDo als erledigt markiert.");
            } else {
                System.out.println("Ungültige Nummer.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Bitte eine gültige Zahl eingeben.");
        }
    }

    public static void todoLoeschen() {
        alleToDosAnzeigen();
        if (toDoListe.isEmpty()) return;

        System.out.print("Welche Nummer möchten Sie löschen? ");
        try {
            int nummer = Integer.parseInt(scanner.nextLine());
            if (nummer >= 1 && nummer <= toDoListe.size()) {
                toDoListe.remove(nummer - 1);
                System.out.println("ToDo gelöscht.");
            } else {
                System.out.println("Ungültige Nummer.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Bitte eine gültige Zahl eingeben.");
        }
    }

    public static void speichereToDosInDatei() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATEINAME))) {
            for (ToDo todo : toDoListe) {
                writer.write((todo.istErledigt() ? "1" : "0") + ";" + todo.getTitel() + ";" + todo.getPrioritaet());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern der Datei: " + e.getMessage());
        }
    }

    public static void ladeToDosAusDatei() {
        File datei = new File(DATEINAME);
        if (!datei.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(datei))) {
            String zeile;
            while ((zeile = reader.readLine()) != null) {
                String[] teile = zeile.split(";", 3);
                if (teile.length == 3) {
                    boolean erledigt = teile[0].equals("1");
                    String titel = teile[1];
                    String prioritaet = teile[2];
                    ToDo todo = new ToDo(titel, prioritaet);
                    if (erledigt) todo.alsErledigtMarkieren();
                    toDoListe.add(todo);
                }
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Laden der Datei: " + e.getMessage());
        }
    }
}
