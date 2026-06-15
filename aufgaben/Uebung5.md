# Quiz App

Diese Aufgabe begleitet Sie bei der Entwicklung einer einfachen Quiz-Anwendung in Java.
Dabei lernen Sie, wie mehrere Klassen zusammenarbeiten, wie Objekte erstellt und wie Methoden genutzt werden, um die Logik eines Programms zu strukturieren.
Zusätzlich lernen Sie den Umgang mit einfachen HTTP-Anfragen und JSON-ähnlichem Text (ohne externe Bibliotheken) kennen.
Hierfür werden Sie die [Open Trivia DB](https://opentdb.com) verwenden, eine frei zugängliche API, die Quizfragen zu verschiedenen Kategorien und Schwierigkeitsstufen im JSON-Format bereitstellt.

Die Klassen `OpenTriviaDBHandler` und `UserInputHandler` werden von der Lehrveranstaltung bereitgestellt. Sie müssen deren Code nicht verändern. Kopieren Sie die Klassen aus dem bereitgestellten GitHub-Repository in Ihr Projekt.

### Schritt 1: Aufsetzen einer Hauptklasse
Lernziel: Verständnis und Entwicklung eines strukturierten und übersichtlichen Projektes.

Aufgabenstellung:
* Erstellen Sie eine Hauptklasse `QuizApp`.
* Erstellen Sie eine `main()` Methode.

### Schritt 2: Aufsetzen einer Quiz Klasse
Lernziel: Attribute und Konstruktoren verwenden.

* Erstellen Sie eine Klasse `Quiz`.
* Die Klasse soll folgende Informationen speichern:
  * Anzahl der gespielten Fragen
  * Anzahl der richtigen Antworten
  * ob das Spiel beendet wurde
  * Schwierigkeitsgrad des Quizzes
* Erstellen Sie einen Konstruktor:
  * Setzen Sie die Zähler auf `0`.
  * Lassen Sie den Benutzer mit `UserInputHandler.chooseDifficultyLevel()` einen Schwierigkeitsgrad auswählen.
* Schreiben Sie außerdem passende Getter-Methoden für die benötigten Attribute.

### Schritt 3: Die Klasse Question erstellen
Lernziel: Objekte verwenden, um zusammengehörige Daten zu speichern.

* Erstellen Sie eine Klasse `Question`.
* Diese soll folgende Attribute speichern:
  * die Frage selbst
  * die richtige Antwort
  * eine Liste von falschen Antworten
  * eine Liste an zufällig gemischten Antworten
* Legen Sie einen Konstruktor an, der alle benötigten Daten übernimmt.

### Schritt 4: Antworten mischen und anzeigen
Lernziel: Arbeiten mit Arrays, Listen und Methoden.

Aufgabenstellung:
* Implementieren Sie in der Klasse `Question` eine Methode zum Mischen der Antworten.
  * Fügen Sie die richtige Antwort und alle falschen Antworten in eine `ArrayList<String>` ein.
  * Verwenden Sie `Collections.shuffle()`, um die Reihenfolge zufällig zu verändern.
  * Speichern Sie die gemischten Antworten.
* Schreiben Sie anschließend eine Methode `showQuestion()`, welche die Frage und alle zufällig gemischten Antwortmöglichkeiten nummeriert ausgibt.

Beispiel-Ausgabe:
```
What is the capital of Austria? 
1) Graz 
2) Salzburg 
3) Vienna 
4) Linz
```

### Schritt 5: Eine Spielrunde implementieren
Lernziel: Methoden zur Strukturierung von Programmabläufen verwenden.

Aufgabenstellung:
Implementieren Sie in der Klasse `Quiz` eine Methode `playRound()`. Diese kann in weitere Methoden unterteilt werden und soll:
1. Eine neue Frage über `OpenTriviaDBHandler.getQuestion()` abrufen.
2. Die Frage anzeigen.
3. Eine Benutzereingabe über `UserInputHandler.letUserGuess()` einlesen.
4. Prüfen, ob der Benutzer das Spiel beenden möchte.
5. Überprüfen, ob die Antwort richtig ist.
6. Die Statistiken aktualisieren.
7. Das Ergebnis ausgeben.

Beispiel-Ausgabe:
```
Correct! 🤩
```
oder
```
Nope! 😶‍🌫 The correct answer was: Vienna
```

### Schritt 6: Hauptlogik
Ziel: Schleifen und Programmfluss steuern.

Aufgabenstellung:
* Verwenden Sie in der `main()`-Methode in der `QuizApp` Klasse eine Schleife, die solange läuft, bis das Spiel beendet wird. In jeder Runde soll die Methode `playRound()` aufgerufen werden.
* Wenn das Spiel beendet wird, soll eine Statistik zum Endspielstand ausgegeben werden.

Beispiel-Ausgabe:
```
You won 7 out of 10 questions!
```
