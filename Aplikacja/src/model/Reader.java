
package model;


public class Reader {
    
    private int id;
    private String firstname;
    private String lastname;
    private Adress adress;
    private String phoneNumber;
    private int bornYear;

    public Reader(int id, String firstname, String lastname, String phoneNumber, int bornYear, Adress adress) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.bornYear = bornYear;
        this.adress = adress;
    }
    
    
    public String getReader(){
          return ""+id+" - "+lastname+" "+firstname;
    }
    
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Adress getAdress() {
        return adress;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getBornYear() {
        return bornYear;
    }

    
}
