
package model;

public class Adress {
    
    private String code;
    private String town;
    private String street;
    private int number;

    public Adress(String code, String town, String street, int number) {
        this.code = code;
        this.town = town;
        this.street = street;
        this.number = number;
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
