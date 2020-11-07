
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
        return code+" "+town+" ul. "+ street+" "+number;
    }

    public String getCode() {
        return code;
    }

    public String getTown() {
        return town;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }
       
    

    
}
