package project.model;

import java.util.Scanner;

public class Company{
    private String name;
    private Adress adress;
    private String contactPerson;
    private String email;
    private int contactNumber;

    public Company() {
        this.adress = new Adress();
    }

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

    public void readCompany() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Citeste numele firmei: ");
        this.name = scanner.nextLine();
        this.adress.readAdress();
        System.out.println("Doriti sa introduceti o persoana de contact? (Y/N)");
        String choice = scanner.nextLine();
        if (choice.equals("Y")) {
            System.out.println("Citeste persoana de contact: ");
            this.contactPerson = scanner.nextLine();
        }
        System.out.println("Doriti sa introduceti un numar de contact? (Y/N)");
        choice = scanner.nextLine();
        if (choice.equals("Y")) {
            System.out.println("Citeste numarul de contact: ");
            this.contactNumber = scanner.nextInt();
        }
        scanner.nextLine();
        System.out.println("Doriti sa introduceti o adresa de email? (Y/N)");
        choice = scanner.nextLine();
        if (choice.equals("Y")) {
            System.out.println("Citeste adresa de email: ");
            this.email = scanner.nextLine();
        }
    }

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
