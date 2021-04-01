package project.model;

import java.util.Scanner;

public class Adress {
    private String street;
    private int number;
    private String City;
    private String Country;

    public Adress(){}

    public Adress(String street, int number, String city, String country) {
        street = street;
        this.number = number;
        City = city;
        Country = country;
    }

    public String getStreet() { return street; }

    public void setStreet(String street) { street = street; }

    public int getNumber() { return number; }

    public void setNumber(int number) { this.number = number; }

    public String getCity() { return City; }

    public void setCity(String city) { City = city; }

    public String getCountry() { return Country; }

    public void setCountry(String country) { Country = country; }

    public void readAdress(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Numele strazii: ");
        this.street = scanner.nextLine();
        System.out.println("Numarul strazii: ");
        this.number = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Orasul: ");
        this.City = scanner.nextLine();
        System.out.println("Tara: ");
        this.Country = scanner.nextLine();
    }

    @Override
    public String toString() {
        return "Adress{" +
                "Street='" + street + '\'' +
                ", number=" + number +
                ", City='" + City + '\'' +
                ", Country='" + Country + '\'' +
                '}';
    }
}
