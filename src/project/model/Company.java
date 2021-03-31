package project.model;

public class Company{
    private String name;
    private Adress adress;
    private String contactPerson;
    private String email;
    private int contactNumber;

    public Company() { }

    public Company(String name, Adress adress, String contactPerson, String email, int contactNumber) {
        this.name = name;
        this.adress = adress;
        this.contactPerson = contactPerson;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Adress getAdress() { return adress; }

    public void setAdress(Adress adress) { this.adress = adress; }

    public String getContactPerson() { return contactPerson; }

    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public int getContactNumber() { return contactNumber; }

    public void setContactNumber(int contactNumber) { this.contactNumber = contactNumber; }



    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", adress=" + adress +
                ", contactPerson='" + contactPerson + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber=" + contactNumber +
                '}';
    }
}
