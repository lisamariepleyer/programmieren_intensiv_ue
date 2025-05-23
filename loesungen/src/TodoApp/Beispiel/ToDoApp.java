package TodoApp.Beispiel;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class ToDoApp {
    private static ArrayList<ToDo> todoListe = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static String DATEINAME = "todos.txt";

    public static void main(String[] args) {
        appStarten();
    }

    public static void appStarten() {
        ladeToDosAusDatei();

        String eingabe = "";
        while (!(eingabe.equals("0") || eingabe.equals("4"))) {
            zeigeMenue();
            eingabe = scanner.next();
            verarbeiteEingabe(eingabe);
        }
    }

    public static void ladeToDosAusDatei() {
        File datei = new File(DATEINAME);
        if (!datei.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(datei))) {
            String zeile = reader.readLine();
            while (zeile != null) {
                String[] teile = zeile.split(";");

                boolean erledigt = teile[0].equals("1");
                String titel = teile[1];

                ToDo todo = new ToDo(titel);
                if (erledigt) todo.alsErledigtMarkieren();

                todoListe.add(todo);

                zeile = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Laden der Datei: " + e);
        }
    }

    public static void speichereToDosInDatei() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATEINAME))) {
            for (ToDo todo : todoListe) {
                writer.write((todo.erledigt ? "1" : "0") + ";" + todo.titel);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern der Datei: " + e);
        }
    }

    public static void zeigeMenue() {
        System.out.println("\nWas möchten Sie tun?");
        System.out.println("1 - Alle ToDos anzeigen");
        System.out.println("2 - Neues ToDo hinzufügen");
        System.out.println("3 - ToDo als erledigt markieren");
        System.out.println("4 - ToDos speichern und beenden");
        System.out.println("0 - Beenden");
        System.out.print("Ihre Wahl: ");
    }

    public static void verarbeiteEingabe(String eingabe) {
        switch(eingabe) {
            case "1":
                alleToDosAnzeigen();
                break;
            case "2":
                neuesToDoHinzufuegen();
                break;
            case "3":
                markiereTodoAlsErledigt();
                break;
            case "4":
                speichereToDosInDatei();
                System.out.println("Todos gespeichert. ciao!");
                break;
            case "0":
                System.out.println("ciao!");
                break;
            default:
                System.out.println("Ungültige Eingabe. Bitte wählen Sie eine gültige Option.");
        }
    }

    public static void neuesToDoHinzufuegen() {
        System.out.print("Geben Sie den Titel des neuen ToDos ein: ");
        String titel = scanner.next();

        todoListe.add(new ToDo(titel));
    }

    public static void alleToDosAnzeigen() {
        for (ToDo todo : todoListe) {
            System.out.println(todo.gibAnzeigetext());
        }
    }

    public static void markiereTodoAlsErledigt() {
        if (todoListe.isEmpty()) return;

        System.out.print("Welche Nummer möchten Sie als erledigt markieren? ");
        try{
            int nummer = scanner.nextInt();
            todoListe.get(nummer - 1).alsErledigtMarkieren();
        } catch (Exception e){
            System.out.println("Bitte eine gültige Zahl eingeben.");
            System.out.println(e);
        }
    }

}
