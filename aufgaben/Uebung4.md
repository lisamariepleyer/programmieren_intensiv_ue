# Todo App
__Übung am 23.05.2025__

Diese Aufgabe begleitet Sie bei der Entwicklung einer einfachen ToDo-Listen-Anwendung in Java. Ziel ist es, mit eigenen Klassen, Benutzereingaben, Sammlungen wie ArrayList, sowie Datei-Ein-/Ausgabe (File I/O) zu arbeiten.

### Schritt 1: Projektstruktur und Einstieg
Lernziel: Projektstruktur anlegen, Grundlagenmethoden vorbereiten.

Aufgabenstellung:
* Erstellen Sie eine Klasse `ToDoApp` mit einer `main()`-Methode.
* Erstellen Sie eine Methode `appStarten()`, die beim Start des Programms aufgerufen wird.
* Schreiben Sie Platzhaltermethoden (Method Stubs) für:
  * `ladeToDosAusDatei()`
  * `speichereToDosInDatei()`
  * `zeigeMenue()`
  * `verarbeiteEingabe()`

### Schritt 2: Klasse für ToDos
Lernziel: Eigene Klassen und Objekte definieren und verwenden.

Aufgabenstellung:
* Erstellen Sie eine Klasse `ToDo` mit folgenden Attributen:
  * `String titel`
  * `boolean erledigt`
* Schreiben Sie:
  * Einen Konstruktor `ToDo(String titel)`
  * Die Methode `alsErledigtMarkieren()`
  * Die Methode `gibAnzeigetext()`

Beispiel-Ausgabe:
```
[ ] Hausarbeit schreiben
[ ] lernen
[X] Programmieren üben
```

### Schritt 3: Liste verwalten mit ArrayList
Lernziel: Dynamische Datenspeicherung und -verwaltung.

Aufgabenstellung:
* Erstellen Sie in ToDoApp eine `ArrayList<ToDo> toDoListe`.
* Schreiben Sie Methoden:
  * `neuesToDoHinzufuegen()`
  * `alleToDosAnzeigen()`
  * `markiereTodoAlsErledigt()`
* Diskutieren Sie: Warum ist `ArrayList<ToDo>` hier praktischer als ein `ToDo[]`?

### Schritt 4: Datei speichern und laden (File I/O)
Ziel: Grundlagen der Dateiverarbeitung mit Java.

Aufgabenstellung:
* Implementieren Sie:
  * `ladeToDosAusDatei()` – lädt ToDos beim Start aus einer Datei `todos.txt`.
  * `speichereToDosInDatei()` – speichert die Liste beim Beenden automatisch.
* Speichern Sie je ToDo eine Zeile.

Beispiel-Datei:
```
0;Hausaufgabe schreiben
0;lernen
1;Programmieren üben
```
(1 = erledigt, 0 = offen)

### Schritt 5: Menü und Steuerung
Ziel: Benutzerführung mit Schleifen und Entscheidungen.

Aufgabenstellung:
* Schreiben Sie eine Methode `zeigeMenue()` mit mehreren Auswahlmöglichkeiten.
* Implementieren Sie `verarbeiteEingabe()`, die anhand der Benutzereingabe die passende Methode aufruft.

Beispiel-Ausgabe:
```
Was möchten Sie tun?
1 - Alle ToDos anzeigen
2 - Neues ToDo hinzufügen
3 - ToDo als erledigt markieren
4 - ToDos speichern und beenden
0 - Beenden
```

### Schritt 6: Hauptlogik
Ziel: Gesamtes Programm verbinden und Programmfluss steuern.

Aufgabenstellung:
In `appStarten()` soll:
* Die ToDo-Liste aus der Datei geladen werden
* In einer Schleife das Menü angezeigt werden
* Nach jeder Aktion zur Auswahl zurückgekehrt werden

### Schritt 7: Erweiterungsideen
Ziel: Eigene Ideen umsetzen :-)

Optionale Aufgaben:
* Ermöglichen Sie das Löschen von ToDos.
* Ermöglichen Sie das Priorisieren von ToDos.
