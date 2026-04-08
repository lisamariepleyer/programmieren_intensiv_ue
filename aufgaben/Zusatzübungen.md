# Zusatzübungen

## Einfache Aufgaben

### ⭐ Währungs-Umrechner
Schreibe ein Programm, das einen Geldbetrag von einer Währung in eine andere umrechnet (z. B. Euro → Dollar).

Was du übst:
* Einlesen von Benutzereingaben (Klasse `Scanner`)
* Variablen

Beispiel:
```
Gib einen Eurobetrag ein: 100
110 USD
```

Erweiterung:
* Mehrere Währungen anbieten
* Wechselkurs als Benutzereingabe definieren

### ⭐ Temperatur-Umrechner
Erstelle ein Programm, das Temperaturen zwischen Celsius und Fahrenheit umrechnet.

Was du übst:
* Einlesen von Benutzereingaben (Klasse `Scanner`)
* Variablen

Beispiel:
```
Gib eine Temperatur in °C ein: 25
77°F
```

Formel:
Fahrenheit = Celsius × 9/5 + 32

### ⭐ Summe von Zahlen
Schreibe ein Programm, das mehrere Zahlen vom Benutzer einliest und ihre Summe berechnet.

Was du übst:
* Schleifen (for oder while)
* Akkumulieren von Werten
* Benutzereingaben

Beispiel:
```
Gib eine Zahl ein: 1
Gib eine Zahl ein: 2
Gib eine Zahl ein: 3
Ergebnis: 6
```

Erweiterung:
* Unbekannte Anzahl von Zahlen (bis der Benutzer „0“ eingibt)
* Mittelwert der Zahlen berechnen und ausgeben

### ⭐ Passwort-Überprüfung
Erstelle ein Programm, das überprüft, ob ein eingegebenes Passwort bestimmten Regeln entspricht.

Was du übst:
* if-Bedingungen
* String-Verarbeitung
* Logik

Regeln könnten sein:
* Mindestens 8 Zeichen
* Enthält eine Zahl
* Enthält einen Großbuchstaben

Ausgabe:
„Passwort gültig“ oder konkrete Fehlermeldungen

### ⭐ Würfel-Simulator
Simuliere einen Würfelwurf (Zahlen von 1 bis 6) bei jedem Programmstart.

Was du übst:
* Zufallszahlen (Klasse `Random`)
* Einfache Logik

Erweiterung:
* Mehrere Würfe hintereinander (z.B. alle 20 Sekunden)
* Zwei Würfel gleichzeitig

## Mittelschwere Aufgaben

### ⭐⭐ Zahlenratespiel
Das Programm errechnet eine zufällige Zahl und der Benutzer muss sie erraten.

Was du übst:
* Schleifen
* Bedingungen (if/else)
* Zufallszahlen (Klasse `Random`)
* Spiel-Logik

Ablauf:
* Programm wählt Zahl zwischen 1 und 100
* Benutzer gibt Tipps ein
* Programm sagt: „zu hoch“ / „zu niedrig“
* Spiel endet bei richtiger Zahl

Erweiterung:
Programm endet automatisch nach 6 falschen Tipps

### ⭐⭐ Primzahl-Checker
Schreibe ein Programm, das überprüft, ob eine Zahl eine Primzahl ist.

Was du übst:
* Schleifen
* Mathematische Logik

```
Gib eine Zahl ein: 7
Primzahl

Gib eine Zahl ein: 8
keine Primzahl
```

### ⭐⭐ Palindrom-Checker
Überprüfe, ob ein Wort vorwärts und rückwärts gleich ist.

Was du übst:
* String-Methoden
* Schleifen

```
Gib ein Wort ein: Anna
Palindrom

Gib ein Wort ein: Haus
keine Palindrom
```

## Fortgeschrittene Aufgaben

### ⭐⭐⭐ Bibliotheksverwaltung
Simuliere ein einfaches System zur Verwaltung von Büchern.

Was du übst:
* Klassen und Objekte
* Listen (ArrayList)
* Grundlegende Strukturierung einer objektorientierten Applikation

Funktionen:
* Bücher hinzufügen
* Bücher anzeigen
* Bücher ausleihen

### ⭐⭐⭐ Chat-Anwendung
Baue eine einfache Chat-Anwendung, die mit einer KI-API kommuniziert.

Was du übst:
* HTTP-Requests
* JSON-Verarbeitung
* Arbeiten mit externen APIs

Idee:
* Benutzer gibt eine Nachricht ein
* Anfrage wird an eine API gesendet
* Antwort wird angezeigt

### ⭐⭐⭐ Benutzeroberflächen mit JavaFX
Erstelle grafische Benutzeroberflächen für eines deiner bisher erstellten Programme.

Was du übst:
* GUI-Entwicklung
* Event Handling
* Strukturierte Programme

Beispiele:
* GUI für den Währungsrechner
* GUI für das Zahlenratespiel
* GUI für den Taschenrechner
* GUI für die Quiz App
* GUI für TicTacToe
