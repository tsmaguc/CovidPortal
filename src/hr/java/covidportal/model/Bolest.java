package hr.java.covidportal.model;

public class Bolest extends ImenovaniEntitet {



    Simptom[] simptomi;

    /**
     * konstruktor Bolest
     * @param naziv
     * @param simptomi
     */
    public Bolest(String naziv, Simptom[] simptomi) {
        super(naziv);
        this.simptomi = simptomi;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Simptom[] getSimptomi() {
        return simptomi;
    }

    public void setSimptomi(Simptom[] simptomi) {
        this.simptomi = simptomi;
    }
}
