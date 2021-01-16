package hr.java.covidportal.model;

public class Virus extends Bolest implements Zarazno{


    /**
     * konstruktor Virus
     *
     * @param naziv
     * @param simptomi
     */
    public Virus(String naziv, Simptom[] simptomi) {
        super(naziv, simptomi);
    }

    @Override
    public void prelazakZarazeNaOsobu(Osoba osoba) {

    }
}
