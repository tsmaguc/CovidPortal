package hr.java.covidportal.model;

public class Zupanija extends ImenovaniEntitet{


    private Integer brojStanovnika;

    /**
     * konstruktor Zupanija
     * @param naziv
     * @param brojStanovnika
     */
    public Zupanija(String naziv, Integer brojStanovnika) {
        super(naziv);
        this.brojStanovnika = brojStanovnika;
    }

    /**
     * get i set metode
     * @return
     */

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setBrojStanovnika(Integer brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }
}
