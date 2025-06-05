# Quiz App
__Übung am 06.06.2025__

Diese Aufgabe begleitet Sie bei der Entwicklung einer einfachen Quiz-Anwendung in Java. Ziel ist es, grundlegende Konzepte wie Methoden, Bedingungen, Listen und den Umgang mit einfachen HTTP-Anfragen und JSON-ähnlichem Text (ohne externe Bibliotheken) kennenzulernen und praktisch anzuwenden. Hierfür werden Sie die [Open Trivia DB](https://opentdb.com) verwenden, eine frei zugängliche API, die Quizfragen zu verschiedenen Kategorien und Schwierigkeitsstufen im JSON-Format bereitstellt.

### Schritt 1: Aufsetzen einer Hauptklasse
Lernziel: Verständnis und Entwicklung eines strukturierten und übersichtlichen Projektes.

Aufgabenstellung:
* Erstellen Sie eine Hauptklasse `QuizApp`.
* Erstellen Sie eine `main()` Methode.
* Erstellen Sie ein geeignetes Codegerüst für die Hauptklasse, welches auf den nächsten Schritten basiert. Verwenden Sie dafür Method Stubs.

### Schritt 2: Abrufen einer Frage von der Open Trivia DB
Lernziel: Grundlagen von HTTP-Requests.

Aufgabenstellung:
* Verwenden Sie `HttpClient` und `HttpRequest`, um den folgenden Link aufzurufen: https://opentdb.com/api.php?amount=1&type=multiple
* Schreiben Sie eine Methode `getQuestion()`, die die Anfrage ausführt und den JSON-Text (als `String`) zurückgibt.
* Behandeln Sie mögliche Fehler mit einem `try-catch` Block.

### Schritt 3: Verarbeiten des JSON-Textes
Lernziel: Verarbeitung von Zeichenketten.

Aufgabenstellung:
* Schreiben Sie eine Methode `parseResponse(String response)`, welche Teilstrings aus dem JSON extrahiert.
* Extrahieren Sie damit:
  * Die Frage (`question`)
  * Die richtige Antwort (`correct_answer`)
  * Die falschen Antworten (`incorrect_answers`) als Textblock, den Sie mit `split(",")` aufteilen
* Entfernen Sie unnötige Anführungszeichen mit einer Methode `removeQuotes(...)`.

### Schritt 4: Frage anzeigen und Antwortmöglichkeiten mischen
Ziel: Arbeiten mit Listen und Zufallselementen.

Aufgabenstellung:
* Erstellen Sie eine Klasse `Question` mit folgenden Attributen, die im Konstruktor gesetzt werden:
  * `String question`
  * `String correctAnswer`
  * `String[] incorrectAnswers`
  * `String[] shuffledAnswers`
* Schreiben Sie eine Methode `shuffleAnswer(...)`, welche die Antworten mischt:
  * Fügen Sie die richtige und falschen Antworten in eine `ArrayList<String>` ein.
  * Mischen Sie die Antwortmöglichkeiten mit `Collections.shuffle(...)`.
* Erstellen Sie eine neue Instanz der Klasse `Question` nachdem Sie die Response verarbeitet haben.
* Schreiben Sie eine Methode `showQuestion()`, die die Frage und alle durchmischten Antwortmöglichkeiten nummeriert in der Konsole ausgibt.

### Schritt 5: Antwort vom Benutzer einlesen und auswerten
Ziel: Einfache Benutzereingaben und Bedingungen.

Aufgabenstellung:
* Lassen Sie den Benutzer eine Antwortoption (z.B. 1–4) auswählen.
* Vergleichen Sie die Antwort mit der richtigen Lösung.
* Geben Sie eine passende Rückmeldung aus.

Beispiel-Ausgabe:
```
In web design, what does CSS stand for?
1) Cascading Style Sheet
2) Counter Strike: Source
3) Corrective Style Sheet
4) Computer Style Sheet

Which answer is correct?
> 1
Correct!
```

### Schritt 6: Hauptlogik
Ziel: Mehrere Fragen hintereinander spielen und Steuerung des Programmflusses mit Schleifen.

Aufgabenstellung:
* Schreiben Sie eine Schleife, die dem Benutzer nach jeder Runde eine neue Frage stellt.
* Speichern Sie, wie viele Fragen gespielt und wie viele richtig beantwortet wurden.
* Erlauben Sie dem Benutzer das Spiel durch das Wort „quit“ zu beenden.
* Zeigen Sie nach Spielende die Gesamtanzahl und richtige Antworten an.


### Schritt 7: Erweiterungsideen
Ziel: Eigene Ideen umsetzen :-)

Optionale Aufgaben:
* Erlauben Sie die Auswahl von Schwierigkeitsstufen (`&difficulty=easy`, `&difficulty=medium`, `&difficulty=hard`).
* Schreiben Sie eine Methode `htmlDecode(String s)`, die Sonderzeichen wie `&quot;`, `&#039;`, `&amp;`, `&lt;`, `&gt;` in normale Zeichen umwandelt.
