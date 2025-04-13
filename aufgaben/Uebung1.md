# Taschenrechner-Applikation
__Übung am 11.04.2025__

Diese Aufgabe begleitet Sie Schritt für Schritt durch die Entwicklung eines einfachen Taschenrechners in Java. Ziel ist es, grundlegende Konzepte der Programmierung zu erlernen und systematisch anzuwenden: Benutzereingabe, Rechenoperationen, Bedingungen, Methoden, Schleifen und ein kurzer Exkurs in objektorientierte Strukturen.

### Schritt 1: Einfache Konsolen-Ein- und Ausgabe
Ziel: Vertraut werden mit der Eingabe und Ausgabe über die Konsole.

Aufgabenstellung:
Verwenden Sie `Scanner`, um Benutzereingaben einzulesen.
Fragen Sie den Benutzer nach zwei Zahlen.
Geben Sie die eingegebenen Zahlen wieder auf der Konsole aus.

Beispiel-Ausgabe:
```
Bitte geben Sie zwei Zahlen ein:
> 5
> 3
Sie haben die Zahlen 5 und 3 eingegeben.
```

### Schritt 2: Grundlegende Rechenoperationen durchführen
Ziel: Einführung in die vier Grundrechenarten.

Aufgabenstellung:
Verwenden Sie die Operatoren +, -, * und /, um die beiden Zahlen zu verrechnen.
Geben Sie die Rechenergebnisse formatiert auf der Konsole aus.

Beispiel-Ausgabe:
```
5 + 3 = 8
5 - 3 = 2
5 * 3 = 15
5 / 3 = 1.666...
```

### Schritt 3: Weitere Rechenoperationen durchführen
Ziel: Einführung in Operatoren.

Aufgabenstellung:
Verwenden Sie die Operatoren `<`, `>` und `%`, um die größte Zahl, kleinste Zahl, das Vorzeichen und die Parität (dh. ob eine Zahl gerade oder ungerade ist) der beiden Zahlen zu bestimmen.
Geben Sie die Rechenergebnisse auf der Konsole aus.

Beispiel-Ausgabe:
```
Die kleinste Zahl ist 3.
Die größte Zahl ist 5.
3 ist positiv.
5 ist positiv.
3 ist ungerade.
5 ist ungerade.
```

### Schritt 4: Auswahl der Rechenoperation durch den Benutzer
Ziel: Arbeiten mit Bedingungen (if-else oder switch).

Aufgabenstellung:
Bitten Sie den Benutzer, eine Rechenoperation auszuwählen (+, -, *, /, min, max, vorzeichen, parität).
Führen Sie je nach Eingabe die entsprechende Operation aus.
Geben Sie das Ergebnis aus.

Beispiel-Ausgabe:
```
Welche Operation möchten Sie durchführen? (+, -, *, /, min, max, vorzeichen, parität)
> *
Ergebnis: 5 * 3 = 15
```

### Schritt 5: Verwenden von Methoden zur Strukturierung
Ziel: Einführung in die Modularisierung mit Methoden.

Aufgabenstellung:
Lagern Sie die Rechenoperationen in eigene Methoden aus, z.B. `addiere(a, b)`, `subtrahiere(a, b)`, `findeMin(a, b)` usw.
Erstellen Sie weitere Methoden für:
* das Einlesen von Benutzereingaben,
* das Ausführen der Berechnung,
* das Anzeigen der Ergebnisse.

Verwenden Sie diese Methoden in Ihrer `Main` Methode.

### Schritt 6: Fehlerbehandlung und Sonderfälle
Ziel: Das Programm robuster gestalten.

Aufgabenstellung:
Verhindern Sie eine Division durch null.
Prüfen Sie, ob die Benutzereingaben gültige Zahlen und Operatoren sind.
Geben Sie bei ungültiger Eingabe eine Fehlermeldung aus.
Zusätzlich können Sie beispielsweise bei der Benutzereingabe darauf achten, dass nur Zahlen oder gewisse Operatorenwerte erlaubt sind.

Beispiel-Ausgabe:
```
Fehler: Eine Division durch null ist nicht erlaubt!
```

### Schritt 7: Wiederholte Berechnungen mit Schleifen
Ziel: Einführung in Schleifen (`while`).

Aufgabenstellung:
Ermöglichen Sie dem Benutzer, mehrere Rechnungen hintereinander durchzuführen.
Fragen Sie am Ende jeder Berechnung:
„Möchten Sie eine weitere Berechnung durchführen? (ja/nein)“
Beenden Sie das Programm, wenn der Benutzer einen anderen Wert als „ja“ eingibt.

### Schritt 8: Objektorientierte Struktur mit Klassen (Zusatz)
Ziel: Einführung in objektorientiertes Programmieren.

Aufgabenstellung:
Erstellen Sie eine eigene Taschenrechner-Klasse.
Verschieben Sie die Methoden aus Schritt 5 in diese Klasse.
Erklären Sie sich selbst (und gerne auch im Code), warum manche Methoden `public` und andere `private` sein sollten.
Verwenden Sie ein Objekt der Klasse Taschenrechner, um die Berechnungen im Hauptprogramm (`Main` Klasse in `Main.java`) auszuführen.
