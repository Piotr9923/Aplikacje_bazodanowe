
package model;

public class RankingPerson {
    
    private int id;
    private String firstname;
    private String lastname;
    private int booksCount;

    public RankingPerson(int id, String firstname, String lastname, int count) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.booksCount = count;
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
        return booksCount;
    }
    
    
    
}
