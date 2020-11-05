
package iteams;

import java.util.Date;


public class Wypozyczenie {
    
    
    private int id;
    private int idCzytelnika;
    private String imieCzytelnika;
    private String nazwiskoCzytelnika;
    private int idKsiazki;
    private String tytul;
    private Date dataWypozyczenia;

    public Wypozyczenie(int id, int idCzytelnika, String imieCzytelnika, String nazwiskoCzytelnika, int idKsiazki, String tytul, Date dataWypozyczenia) {
        this.id = id;
        this.idCzytelnika = idCzytelnika;
        this.imieCzytelnika = imieCzytelnika;
        this.nazwiskoCzytelnika = nazwiskoCzytelnika;
        this.idKsiazki = idKsiazki;
        this.tytul = tytul;
        this.dataWypozyczenia = dataWypozyczenia;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCzytelnika() {
        return idCzytelnika;
    }

    public void setIdCzytelnika(int idCzytelnika) {
        this.idCzytelnika = idCzytelnika;
    }

    public int getIdKsiazki() {
        return idKsiazki;
    }

    public void setIdKsiazki(int idKsiazki) {
        this.idKsiazki = idKsiazki;
    }

    public Date getDataWypozyczenia() {
        return dataWypozyczenia;
    }

    public void setDataWypozyczenia(Date dataWypozyczenia) {
        this.dataWypozyczenia = dataWypozyczenia;
    }

    public String getImieCzytelnika() {
        return imieCzytelnika;
    }

    public String getNazwiskoCzytelnika() {
        return nazwiskoCzytelnika;
    }

    public String getTytul() {
        return tytul;
    }

   
    
    
    
    
}
