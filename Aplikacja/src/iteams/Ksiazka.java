
package iteams;


public class Ksiazka {
    
    private String tytul;
    private String autor;
    private int id;
    private String gatunek;
    private boolean dostepna;

    public Ksiazka(int id,String tytul, String autor, String gatunek, boolean dostepna) {
        this.tytul = tytul;
        this.autor = autor;
        this.id = id;
        this.gatunek = gatunek;
        this.dostepna = dostepna;
    }
    
    
    
   
    

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public boolean isDostepna() {
        return dostepna;
    }

    public void setDostepna(boolean dostepna) {
        this.dostepna = dostepna;
    }
    
    public String getBook(){
        
        return ""+id+" - "+tytul;
    }
    
    
    
}
