package TodoApp.Beispiel;

public class ToDo {
    public String titel;
    public boolean erledigt;

    public ToDo(String titel) {
        this.titel = titel;
        this.erledigt = false;
    }

    public void alsErledigtMarkieren() {
        this.erledigt = true;
    }

    public String gibAnzeigetext() {
        String checkboxContent = erledigt ? "X" : " ";
        return "[" + checkboxContent + "] " + titel;
    }
}
