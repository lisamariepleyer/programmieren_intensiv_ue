package DontMeltTheSnowman.ObjectOriented;

public class Spieler {
    private final String name;
    private int spieleGesamt;
    private int spieleGewonnen;

    public Spieler(String name) {
        this.name = name;
        this.spieleGesamt = 0;
        this.spieleGewonnen = 0;
    }

    public void inkrementiereSpieleGesamt() {
        spieleGesamt++;
    }

    public void inkrementiereSpieleGewonnen() {
        spieleGewonnen++;
    }

    public String getName() {
        return name;
    }

    public int getSpieleGesamt() {
        return spieleGesamt;
    }

    public int getSpieleGewonnen() {
        return spieleGewonnen;
    }
}
