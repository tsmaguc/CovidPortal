package hr.java.covidportal.main;

import hr.java.covidportal.model.*;

import java.util.Scanner;

public class Glavna {

    //konstnte
    private static final int BROJ_ZUPANIJA = 3;
    private static final int BROJ_SIMPTOMA = 3;
    private static final int BROJ_BOLESTI = 4;
    private static final int BROJ_OSOBA = 3;

    public static void main(String[] args) {

        //polja
        Zupanija[] zupanije = new Zupanija[BROJ_ZUPANIJA];
        Simptom[] simptomi = new Simptom[BROJ_SIMPTOMA];
        Bolest[] bolesti = new Bolest[BROJ_BOLESTI];
        Osoba[] osobe = new Osoba[BROJ_OSOBA];

        Scanner unos = new Scanner(System.in);
        System.out.println("Unos županija: ");
        for (int i = 1; i <= BROJ_ZUPANIJA; i++){
            zupanije[i - 1] = unosZupanije(unos, i);
        }

        System.out.println("Unos simptoma: ");
        for (int i = 1; i <= BROJ_SIMPTOMA; i++){
            simptomi[i - 1] = unosSimptoma(unos, i);
        }

        /**
         * za unos bolesti ili virusa postoje 2 različite metode
         * u main funkciji se pozivaju uvjetom u switch-case
         * case 1: unosBolesti
         * case 2: unosVirusa
         *
         */
        System.out.println("Unesite podatke o 4 bolesti: ");
        for (int i= 1; i <= BROJ_BOLESTI; i++ ){

            int bolestVirus;
            System.out.println("Unosite li bolest ili virus? ");
            System.out.println("[1] BOLEST ");
            System.out.println("[2] VIRUS ");

            do{
                bolestVirus = unos.nextInt();
                unos.nextLine();
                if(bolestVirus < 1 || bolestVirus > 2){
                    System.out.print("Odabrali ste broj " +
                            "van raspona\n ponovite unos: 1 BOLEST ili 2 VIRUS ");
                }

            }while(bolestVirus < 1 || bolestVirus > 2);
            switch (bolestVirus){
                case 1: bolesti[i - 1] = unosBolesti(unos, i, simptomi);
                break;
                case 2: bolesti[i - 1] = unosVirusa(unos, i, simptomi);
                break;
                default:
                    System.out.println("Krivi unos greška");
                    break;
            }

        }

        System.out.println("Unos  podatke o 3 osobe: ");
        for (int i = 1; i <= BROJ_OSOBA; i++){
            osobe[i - 1] = unosOsobe(unos, i, zupanije, bolesti, osobe);
        }


        /**
         * Ispis osoba
         */
        System.out.println("Popis osoba: ");

        for (int i = 0; i < osobe.length; i++){

            if(i==0){
                System.out.println("ime i prezime: " + osobe[i].getIme() + " "+ osobe[i].getPrezime());
                System.out.println("starost: " + osobe[i].getStarost());
                System.out.println("županija prebivališta: " + osobe[i].getZupanija().getNaziv());
                System.out.println("zaražen bolešću: " + osobe[i].getZarazenBolescu().getNaziv());
                System.out.println("Nema kontaktiranih osoba.");
            }
            System.out.println("ime i prezime: " + osobe[i].getIme() + " "+ osobe[i].getPrezime());
            System.out.println("starost: " + osobe[i].getStarost());
            System.out.println("županija prebivališta: " + osobe[i].getZupanija().getNaziv());
            System.out.println("zaražen bolešću: " + osobe[i].getZarazenBolescu().getNaziv());
            for (int k = 0; k < osobe[i].getKontaktiraneOsobe().length; i++){
                System.out.println(osobe[i].getKontaktiraneOsobe()[k].getIme()+
                        " "+ osobe[i].getKontaktiraneOsobe()[k].getPrezime());
            }
        }
    }

    /**
     * unosSimptoma
     * @param unos
     * @param i
     * @return
     */
    private static Simptom unosSimptoma(Scanner unos, int i){
        System.out.print("Unesite naziv " + i+ ". simptoma: ");
        String nazivSimptoma = unos.nextLine();
        System.out.print("Unesite vrijednost " + i+ ". simptoma (RIJETKO, SREDNJE ILI ČESTO, ): ");
        String vrijednostSimptoma = unos.nextLine();
        Simptom noviSimptom = new Simptom(nazivSimptoma, vrijednostSimptoma);
        return noviSimptom;
    }

    /**
     * unosZupanije
     * @param unos
     * @param i
     * @return
     */
    private static Zupanija unosZupanije(Scanner unos, int i) {
        System.out.print("Molimo Vas unesite ime "+ i +" županije: ");
        String nazivZupanije = unos.nextLine();
        System.out.print("Molimo Vas unesite broj stanovnika "+ i +" županije: ");
        Integer brojStanovnikaZupanije = unos.nextInt();
        unos.nextLine();
        return new Zupanija(nazivZupanije, brojStanovnikaZupanije);
    }

    /**
     * unosBolesti
     * @param unos
     * @param i
     * @param simptomi
     * @return
     */
    private static Bolest unosBolesti(Scanner unos, int i, Simptom[] simptomi) {

        System.out.print("Molimo Vas unesite naziv " + i + " bolesti: ");
        String nazivBolesti = unos.nextLine();
        int brojOdabranihSimptoma;
        do {
            System.out.println("Odaberite broj simptoma: ");
            brojOdabranihSimptoma = unos.nextInt();
            unos.nextLine();

            if ((brojOdabranihSimptoma < 1) || (brojOdabranihSimptoma > BROJ_SIMPTOMA)) {
                System.out.print("Odabrali ste broj " +
                            "van raspona\n ponovite unos: ");
                }

        } while ((brojOdabranihSimptoma < 1) || (brojOdabranihSimptoma > BROJ_SIMPTOMA));

        Simptom[] simptomiBolesti = new Simptom[brojOdabranihSimptoma];

        for (int g = 1; g <= brojOdabranihSimptoma; g++) {


                for (int j = 0; j < simptomi.length; j++) {
                    System.out.println("[" + (j + 1) + "]" + simptomi[j].getNaziv() + " " + simptomi[j].getVrijednost());
                }
                int tempSimptom = unos.nextInt();
                unos.nextLine();
                simptomiBolesti[g - 1] = new Simptom(simptomi[tempSimptom - 1].getNaziv(), simptomi[tempSimptom - 1].getVrijednost());
        }
        return new Bolest(nazivBolesti, simptomiBolesti);
    }

    /**
     *
     * @param unos
     * @param i
     * @param simptomi
     * @return Virus
     */
    private static Virus unosVirusa(Scanner unos, int i, Simptom[] simptomi) {

        System.out.print("Molimo Vas unesite naziv " + i + " virusa: ");
        String nazivVirusa = unos.nextLine();
        int brojOdabranihSimptoma;
        do {
            System.out.println("Odaberite broj simptoma: ");
            brojOdabranihSimptoma = unos.nextInt();
            unos.nextLine();

            if ((brojOdabranihSimptoma < 1) || (brojOdabranihSimptoma > BROJ_SIMPTOMA)) {
                System.out.print("Odabrali ste broj " +
                        "van raspona\n ponovite unos: ");
            }

        } while ((brojOdabranihSimptoma < 1) || (brojOdabranihSimptoma > BROJ_SIMPTOMA));

        Simptom[] simptomiVirusa = new Simptom[brojOdabranihSimptoma];

        for (int g = 1; g <= brojOdabranihSimptoma; g++) {


            for (int j = 0; j < simptomi.length; j++) {
                System.out.println("[" + (j + 1) + "]" + simptomi[j].getNaziv() + " " + simptomi[j].getVrijednost());
            }
            int tempSimptom = unos.nextInt();
            unos.nextLine();
            simptomiVirusa[g - 1] = new Simptom(simptomi[tempSimptom - 1].getNaziv(), simptomi[tempSimptom - 1].getVrijednost());
        }
        return new Virus(nazivVirusa, simptomiVirusa);
    }


    /**
     * unosOsobe - metoda vraća objekt Osobe
     * kod i =1 , za kontakte se postavlja prazno polje Osoba
     * @param unos
     * @param i
     * @param zupanije
     * @param bolesti
     * @param osobe
     * @return
     */
    private static Osoba unosOsobe (Scanner unos, int i, Zupanija[] zupanije, Bolest[] bolesti, Osoba[] osobe){
        System.out.print("Unesite ime " + i+ ". osobe: ");
        String imeOsobe = unos.nextLine();
        System.out.print("Unesite prezime " + i+ ". osobe: ");
        String prezimeOsobe = unos.nextLine();
        System.out.print("Unesite starost " + i+ ". osobe: ");
        Integer starostOsobe = unos.nextInt();
        unos.nextLine();
        System.out.println("Unesite županiju prebivališta " + i+ ". osobe: ");
        for (int j = 0; j < zupanije.length; j++) {
            System.out.println("[" + (j + 1) + "]" + zupanije[j].getNaziv());
        }
        Integer redBrojZupanije = unos.nextInt();
        Zupanija zupanijaOsobe = new Zupanija(zupanije[redBrojZupanije - 1].getNaziv(), zupanije[redBrojZupanije - 1].getBrojStanovnika());
        unos.nextLine();
        System.out.println("Unesite bolest " + i+ ". osobe: ");
        for (int b = 0; b < bolesti.length; b++) {
            System.out.println("[" + (b + 1) + "]" + bolesti[b].getNaziv());
        }
        Integer redBrojBolesti = unos.nextInt();
        Bolest bolestOsobe = new Bolest(bolesti[redBrojBolesti - 1].getNaziv(), bolesti[redBrojBolesti - 1].getSimptomi());
        unos.nextLine();
        if (i == 1){

            Osoba dummy = new Osoba("N","N",10,zupanijaOsobe,bolestOsobe);
            Osoba[] kontaktiraneOsobe = new Osoba[1];
            kontaktiraneOsobe[0] = dummy;
            Osoba o1 = new Osoba(imeOsobe, prezimeOsobe,starostOsobe, zupanijaOsobe, bolestOsobe);
            return o1;
        }
        System.out.println("Odaberite kontakte osobe: ");
        System.out.print("Broj kontakata: ");

            int brojKontakata = unos.nextInt();
            unos.nextLine();

        Osoba[] kontakti = new Osoba[brojKontakata];
        for (int p = 0; p < brojKontakata; p++) {


            for (int k = 0; k < osobe.length; k++) {
                System.out.println("[" + (k + 1) + "]" + osobe[k].getIme() + " " + osobe[k].getPrezime());
            }
            int redBrojOsobe = unos.nextInt();
            unos.nextLine();
            kontakti[p] = new Osoba(osobe[redBrojOsobe - 1].getIme(), osobe[redBrojOsobe -1].getPrezime(),
                    osobe[redBrojOsobe - 1].getStarost(), osobe[redBrojOsobe].getZupanija(),
                    osobe[redBrojOsobe -1].getZarazenBolescu(),osobe[redBrojOsobe - 1].getKontaktiraneOsobe());
        }
        System.out.println("");
        return new Osoba(imeOsobe, prezimeOsobe, starostOsobe, zupanijaOsobe, bolestOsobe, kontakti);
    }
}
