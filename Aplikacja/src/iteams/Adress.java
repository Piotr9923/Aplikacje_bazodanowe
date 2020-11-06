
package iteams;

public class Adress {
    
    private String code;
    private String town;
    private String street;
    private int number;

    public Adress(String kod, String miejscowosc, String ulica, int nrDomu) {
        this.code = kod;
        this.town = miejscowosc;
        this.street = ulica;
        this.number = nrDomu;
    }
    
    public String adressToString(){
        
        
        return town+" ul. "+ street+" "+number;
    }

    public String getKod() {
        return code;
    }

    public String getMiejscowosc() {
        return town;
    }

    public String getUlica() {
        return street;
    }

    public int getNrDomu() {
        return number;
    }
       
    

    
}
