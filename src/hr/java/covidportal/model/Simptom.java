package hr.java.covidportal.model;

public class Simptom  extends ImenovaniEntitet{


    private String vrijednost;

    /**
     * konstruktor Simptom
     * @param naziv
     * @param vrijednost
     */
    public Simptom(String naziv, String vrijednost) {
        super(naziv);
        this.vrijednost = vrijednost;
    }


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getVrijednost() {
        return vrijednost;
    }

    public void setVrijednost(String vrijednost) {
        this.vrijednost = vrijednost;
    }
}
