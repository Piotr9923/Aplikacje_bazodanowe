
package model;

public class RankingPerson {
    
    private int id;
    private String firstname;
    private String lastname;
    private int count;

    public RankingPerson(int id, String firstname, String lastname, int count) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getCount() {
        return count;
    }
    
    
    
}
