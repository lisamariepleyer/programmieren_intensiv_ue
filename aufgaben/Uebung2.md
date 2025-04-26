# Don't Melt The Snowman
__Übung am 25.04.2025__

Lernziele: Anwendung grundlegender Java-Konzepte, Arrays, saubere Code-Strukturierung.

### Schritt 1: Spielstart und Begrüßung
Lernziel: Nutzung von Scanner für Benutzer Ein- und Ausgaben

Aufgabenstellung:
Erstellen Sie eine `Main` Klasse und eine `main()` Methode.
Fragen Sie den Namen des Spielers ab und begrüßen Sie ihn persönlich.

Beispiel-Ausgabe:
```
Bitte gib Deinen Namen ein:
> Lisa

Hi Lisa! Spiel wird gestartet …
```

### Schritt 2: Zufällige Wortauswahl
Lernziel: Einführung in Arrays und Zufallsgeneratoren

Aufgabenstellung:
Speichern Sie eine Liste von mindestens 3 möglichen Wörtern.
Wählen Sie zu Beginn eines Spiels zufällig eines dieser Wörter aus. Verwenden Sie dafür die Klasse `Random` des packages `java.util`.

### Schritt 3: Benutzereingabe und Validierung
Lernziel: Eingabevalidierung, Zeichenkettenverarbeitung, Kontrollstrukturen, Arrays, Schleifen, Entgegennahme, Prüfung und Speicherung von Eingaben

Aufgabenstellung:
Fragen Sie den Spieler 5x hintereinander nach einem Buchstaben.
Nur einzelne Buchstaben (keine Zahlen oder Sonderzeichen) sollen zugelassen werden.
Machen Sie bei einer validen Eingabe einen LowerCase Letter aus der Eingabe.
Speichern Sie den Buchstaben in einem Array.
Prüfen Sie, ob ein Buchstabe bereits geraten wurde – geben Sie ggf. eine Warnung aus.
Nach jeder Runde sollen alle bisher geratenen Buchstaben angezeigt werden.

Beispiel-Ausgabe:
```
Rate einen Buchstaben: a
Geratene Buchstaben: a

Rate einen Buchstaben: b
Geratene Buchstaben: a b

Rate einen Buchstaben: abc
Nur einzelne Buchstaben sind erlaubt!
Geratene Buchstaben: a b

Rate einen Buchstaben: a
Diesen Buchstaben hast du schon geraten!
Geratene Buchstaben: a b  Rate einen Buchstaben: -
Das ist kein gültiger Buchstabe!
Geratene Buchstaben: a b

Rate einen Buchstaben: c
Geratene Buchstaben: a b c
```

### Schritt 4: Anzeige des versteckten Wortes und ASCII-Art
Ziel: Schleife, Arrays, Anzeigemethoden

Aufgabenstellung:
Zeigen Sie für jedes noch nicht erratene Zeichen einen Unterstrich an, korrekt geratene Buchstaben sollen sichtbar werden.
Zeichnen Sie den Schneemann abhängig von der Anzahl falscher Versuche (z.B. Kopf, Arme etc.).

Beispiel-Ausgabe:
```
Geratene Buchstaben: a e t 
Rate einen Buchstaben: m
te_t
```

### Schritt 5: Spielschleife und Gewinn-/Verlust-Logik
Ziel: if/else, Schleifen, Logische Operatoren, Aufbau der Hauptspielschleife, Spielende bei Gewinn oder Verlust

Aufgabenstellung:
Beenden Sie das Spiel nach 5 falschen Buchstaben.
Gewonnen wird, wenn alle Buchstaben korrekt geraten wurden.
Geben Sie am Ende eine entsprechende Nachricht aus.

Beispiel-Ausgabe:
```
Sie haben verloren. Das Wort war: Test
```

### Schritt 6: Methoden und Strukturierung
Ziel: Methoden, Parameterübergabe, Strukturierung, Einführung in methodisches Arbeiten, besser lesbarer, modularer Code

Aufgabenstellung:
Extrahieren Sie wichtige Teile des Codes in eigene Methoden. Vorschläge für Methoden:
* begrüßeSpieler()
* zeigeWortFortschritt()
* getBuchstabenEingabe()
* printSchneemann(int fehler)
* istWortErraten()
* frageNachNeustart()

### Schritt 7: Objektorientierte Umstrukturierung (Zusatz)
Ziel: Klassen, Felder, Konstruktoren, Einführung in Klassen und Objekte, Anwendung von Kapselung und Zugriffskontrolle

Aufgabenstellung:
Erstellen Sie eine Klasse **DontMeltTheSnowmanSpiel** mit:
* private String wort
* private Set<Character> gerateneBuchstaben
* private int fehlerAnzahl

Und öffentliche Methoden wie:
* spiele()
* zeigeFortschritt()
* verarbeiteBuchstabe(char eingabe)

Zusätzlich eine Klasse **Spieler** mit:
* Name
* Punktestand
* Anzahl gespielter Spiele

### Schritt 8: Spiel-Session-Verwaltung 
Ziel: Schleifen, Sitzungsübergreifende Variablen

Aufgabenstellung:
Ermöglichen Sie dem Spieler, nach einem Spiel ein weiteres zu starten. Das Spiel sollte auf Wunsch des Spielers sauber beendet werden können.
Am Ende der Session sollen folgende Daten angezeigt werden:
* Anzahl gespielter Spiele
* Anzahl gewonnener Spiele
* Anzahl verlorener Spiele
