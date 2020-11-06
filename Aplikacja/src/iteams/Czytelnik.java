
package iteams;


public class Czytelnik {
    
    private int id;
    private String imie;
    private String nazwisko;
    private Adres adres;
    private String nrTelefonu;
    private int rokUrodzenia;

    public Czytelnik(int id, String imie, String nazwisko, String nrTelefonu, int rokUrodzenia, Adres adres) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrTelefonu = nrTelefonu;
        this.rokUrodzenia = rokUrodzenia;
        this.adres = adres;
    }
    
    
    public String getReader(){
          return ""+id+" - "+imie+" "+nazwisko;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    
    
    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public int getRokUrodzenia() {
        return rokUrodzenia;
    }

    public void setRokUrodzenia(int rokUrodzenia) {
        this.rokUrodzenia = rokUrodzenia;
    }
    
    
    
}
