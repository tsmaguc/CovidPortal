package hr.java.covidportal.model;

import java.util.Arrays;

public class Osoba {

    private String ime;
    private String prezime;
    private Integer starost;
    private Zupanija zupanija;
    private Bolest zarazenBolescu;
    private Osoba[] kontaktiraneOsobe;


    /**
     * konstruktor Osoba
     * @param ime
     * @param prezime
     * @param starost
     * @param zupanija
     * @param zarazenBolescu
     * @param kontaktiraneOsobe
     */
    public Osoba(String ime, String prezime, Integer starost, Zupanija zupanija, Bolest zarazenBolescu, Osoba[] kontaktiraneOsobe) {
        this.ime = ime;
        this.prezime = prezime;
        this.starost = starost;
        this.zupanija = zupanija;
        this.zarazenBolescu = zarazenBolescu;
        this.kontaktiraneOsobe = kontaktiraneOsobe;

        if(this.zarazenBolescu instanceof Virus virus){
            for (int h = 0; h < kontaktiraneOsobe.length; h++){
                kontaktiraneOsobe[h].setZarazenBolescu(this.getZarazenBolescu());
            }
        }
    }

    public Osoba(String ime, String prezime, Integer starost, Zupanija zupanija, Bolest zarazenBolescu) {
        this.ime = ime;
        this.prezime = prezime;
        this.starost = starost;
        this.zupanija = zupanija;
        this.zarazenBolescu = zarazenBolescu;
    }



    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Integer getStarost() {
        return starost;
    }

    public void setStarost(Integer starost) {
        this.starost = starost;
    }

    public Zupanija getZupanija() {
        return zupanija;
    }

    public void setZupanija(Zupanija zupanija) {
        this.zupanija = zupanija;
    }

    public Bolest getZarazenBolescu() {
        return zarazenBolescu;
    }

    public void setZarazenBolescu(Bolest zarazenBolescu) {
        this.zarazenBolescu = zarazenBolescu;
    }

    public Osoba[] getKontaktiraneOsobe() {
        return kontaktiraneOsobe;
    }

    public void setKontaktiraneOsobe(Osoba[] kontaktiraneOsobe) {
        this.kontaktiraneOsobe = kontaktiraneOsobe;
    }

    /**
     * Osoba2String
     * @return
     */
    @Override
    public String toString() {
        return "\n" +
                "ime i prezime: '" + this.getIme() + " "+this.getPrezime()+"\n" +
                "starost: "+ this.getStarost()+ "\n"+
                "Županija prebivališta: " + this.getZupanija().getNaziv() + "\n"+
                "Zaražen bolešću: " + this.getZarazenBolescu().getNaziv() + "\n"+
                ", kontaktiraneOsobe=" + Arrays.toString(kontaktiraneOsobe) +
                "";
    }
}
