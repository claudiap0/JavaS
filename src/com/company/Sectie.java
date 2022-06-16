package com.company;

public class Sectie {
    private int cod_sectie;
    private String denumire;
    private int nr_locuri;
    private Double varsta_medie;
    private long nrPacienti;

    public long getNrPacienti() {
        return nrPacienti;
    }

    public void setNrPacienti(long nrPacienti) {
        this.nrPacienti = nrPacienti;
    }

    public Double getVarsta_medie() {
        return varsta_medie;
    }

    public Sectie () {

    }
    public void setVarsta_medie(Double varsta_medie) {
        this.varsta_medie = varsta_medie;
    }

    public Sectie(int cod_sectie, String denumire, int nr_locuri) {
        this.cod_sectie = cod_sectie;
        this.denumire = denumire;
        this.nr_locuri = nr_locuri;
    }

    public int getCod_sectie() {
        return cod_sectie;
    }

    public void setCod_sectie(int cod_sectie) {
        this.cod_sectie = cod_sectie;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getNr_locuri() {
        return nr_locuri;
    }

    public void setNr_locuri(int nr_locuri) {
        this.nr_locuri = nr_locuri;
    }

    @Override
    public String toString() {
        return "Sectie{" +
                "cod_sectie=" + cod_sectie +
                ", denumire='" + denumire + '\'' +
                ", nr_locuri=" + nr_locuri +
                ", medie=" + varsta_medie +
                ", nr=" + nrPacienti +
                '}';
    }
}
