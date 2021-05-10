package project.model;

import java.util.Scanner;

public class Adress {
    private String street;
    private int number;
    private String city;
    private String country;

    public Adress(){}

    public Adress(String street, int number, String city, String country) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.country = country;
    }

    public Adress(Adress adress) {
        this.street = adress.street;
        this.number = adress.number;
        this.city = adress.city;
        this.country = adress.country;
    }

    public String getStreet() { return street; }

    public void setStreet(String street) { this.street = street; }

    public int getNumber() { return number; }

    public void setNumber(int number) { this.number = number; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public void readAdress(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Numele strazii: ");
        this.street = scanner.nextLine();
        System.out.println("Numarul strazii: ");
        this.number = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Orasul: ");
        this.city = scanner.nextLine();
        System.out.println("Tara: ");
        this.country = scanner.nextLine();
    }

    @Override
    public String toString() {
        return "Adress{" +
                "Street='" + street + '\'' +
                ", number=" + number +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
