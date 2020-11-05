
package iteams;

public class Adres {
    
    private String kod;
    private String miejscowosc;
    private String ulica;
    private int nrDomu;

    public Adres(String kod, String miejscowosc, String ulica, int nrDomu) {
        this.kod = kod;
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
    }
    
    public String adresToString(){
        
        
        return miejscowosc+" ul. "+ ulica+" "+nrDomu;
    }

    public String getKod() {
        return kod;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public int getNrDomu() {
        return nrDomu;
    }
       
    

    
}
