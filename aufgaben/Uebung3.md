# Tic-Tac-Toe
__Übung am 09.05.2025__

Diese Aufgabe begleitet Sie bei der Entwicklung eines einfachen Tic-Tac-Toe-Spiels in Java. Ziel ist es, grundlegende Konzepte wie Arrays, Methoden, Schleifen, Bedingungen und erste Ansätze von Spiellogik kennenzulernen und praktisch anzuwenden.

### Schritt 1: Aufsetzen einer Hauptklasse
Lernziel: Verständnis und Entwicklung eines strukturierten und übersichtlichen Projektes.

Aufgabenstellung:
* Erstellen Sie eine Hauptklasse `TicTacToe`.
* Erstellen Sie eine `main()` Methode.
* Erstellen Sie ein geeignetes Codegerüst (engl. „Skeleton Code“) für die Hauptklasse, welches auf den nächsten Schritten basiert. Verwenden Sie dafür Platzhaltermethoden (engl. „Method Stubs“).

### Schritt 2: Erstellen und Anzeigen des Spielfeldes
Lernziel: Arbeiten mit 2D-Arrays und erste einfache Methoden.

Aufgabenstellung:
* Legen Sie ein 2D-Array `char[][] spielfeld` der Größe 3x3 an.
* Füllen Sie alle Felder zu Beginn mit einem Leerzeichen `' '`.
* Schreiben Sie eine Methode `zeigeSpielfeld()`, die das Spielfeld formatiert auf der Konsole ausgibt.

Beispiel-Ausgabe:
```
  0   1   2
0   |   |
 ---+---+---
1   |   |
 ---+---+---
2   |   |
```

### Schritt 3: Spielerzug einbauen
Lernziel: Benutzereingabe verarbeiten und Spielfeld aktualisieren.

Aufgabenstellung:
* Schreiben Sie eine Methode `spielerZug()`.
* Fragen Sie den Spieler, in welcher Zeile und Spalte er das Symbol setzen möchte (z.B. Zeile 1, Spalte 2).
* Setzen Sie das Symbol ('X' oder 'O') auf die gewünschte Position.
* Überprüfen Sie, ob das Feld noch frei ist. Falls nicht, muss der Benutzer eine neue Position eingeben.

### Schritt 4: Gewinnprüfung einbauen
Ziel: Bedingungen und Schleifen vertiefen.

Aufgabenstellung:
* Schreiben Sie eine Methode `pruefeGewinner()`, die prüft, ob das aktuelle Symbol gewonnen hat und entsprechend das Ergebnis ausgibt.
* Prüfen Sie: alle Zeilen, alle Spalten, beide Diagonalen

Beispiel-Ausgabe:
```
X hat gewonnen!
```

### Schritt 5: Spielfeld auf Unentschieden prüfen
Ziel: Schleifen und vollständige Spiellogik.

Aufgabenstellung:
* Schreiben Sie eine Methode `pruefeUnentschieden()`, die prüft, ob das Spiel unentschieden ist und entsprechend das Ergebnis ausgibt.
* Das Spiel endet unentschieden, wenn alle Felder belegt sind und keiner gewonnen hat.

### Schritt 6: Hauptspiellogik erstellen
Ziel: Programmfluss steuern und Methoden kombinieren.

Aufgabenstellung:
Schreiben Sie eine Hauptmethode `spieleSpiel()`, die folgendes tut:
* Abwechselnd Spieler X und Spieler O aufrufen.
* Nach jedem Zug das Spielfeld anzeigen.
* Nach jedem Zug prüfen, ob ein Spieler gewonnen hat oder ob es ein Unentschieden gibt.
* Bei Spielende eine entsprechende Meldung ausgeben.

### Schritt 7: Spielfeld-Reset
Ziel: Methoden erweitern und Wiederverwendung.

Aufgabenstellung:
* Schreiben Sie eine Methode `initialisiereSpielfeld(), um das Spielfeld zurückzusetzen.
* Fragen Sie den Benutzer am Spielende, ob er ein neues Spiel starten möchte und starten Sie gegebenenfalls ein neues Spiel.

### Schritt 8: Erweiterungsideen
Ziel: Eigene Ideen umsetzen :-)

Optionale Aufgaben:
* Erlauben Sie Eingaben wie „A1“, „B3“ statt Zeile-Spalte-Zahlen.
* Bauen Sie eine einfache KI, die (semi-)zufällig auf freie Felder setzt.
* Zählen Sie gewonnene Spiele je Spieler.
