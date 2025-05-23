package TodoApp.BeispielMitErweiterungen;

class ToDo {
    private String titel;
    private String prioritaet;
    private boolean erledigt;

    public ToDo(String titel, String prioritaet) {
        this.titel = titel;
        this.prioritaet = prioritaet;
        this.erledigt = false;
    }

    public String getTitel() {
        return titel;
    }

    public String getPrioritaet() {
        return prioritaet;
    }

    public boolean istErledigt() {
        return erledigt;
    }

    public void alsErledigtMarkieren() {
        erledigt = true;
    }

    public String gibAnzeigetext() {
        return String.format("%s [%s] %s", erledigt ? "[X]" : "[ ]", prioritaet.toUpperCase(), titel);
    }
}
