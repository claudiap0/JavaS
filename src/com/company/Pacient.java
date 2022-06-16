package com.company;

public class Pacient {
    private long cnp;
    private String nume;
    private int cod_sectie;
    private int varsta;

    public Pacient(long cnp, String nume, int varsta, int cod_sectie) {
        this.cnp = cnp;
        this.nume = nume;
        this.varsta = varsta;
        this.cod_sectie = cod_sectie;
    }



    public long getCnp() {
        return cnp;
    }

    public void setCnp(long cnp) {
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getCod_sectie() {
        return cod_sectie;
    }

    public void setCod_sectie(int cod_sectie) {
        this.cod_sectie = cod_sectie;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    @Override
    public String toString() {
        return "Pacient{" +
                "cnp=" + cnp +
                ", nume='" + nume + '\'' +
                ", cod_sectie=" + cod_sectie +
                ", varsta=" + varsta +
                '}';
    }
}
