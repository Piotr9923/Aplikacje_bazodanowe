
package iteams;

import java.util.Date;


public class Wypozyczenie {
    
    
    private int id;
    private int idCzytelnika;
    private int idKsiazki;
    private Date dataWypozyczenia;
    private Date dataZwrotu;
    
    

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

    public Date getDataZwrotu() {
        return dataZwrotu;
    }

    public void setDataZwrotu(Date dataZwrotu) {
        this.dataZwrotu = dataZwrotu;
    }
    
    
    
    
}
