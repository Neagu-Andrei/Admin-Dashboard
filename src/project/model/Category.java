package project.model;

import java.util.Scanner;

public class Category implements Comparable<Category> {
    private String name;
    private String description;

    public Category() { }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public void readCategory(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Citeste numele categoriei: ");
        this.name = scanner.nextLine();
        //scanner.nextLine();
        System.out.println("Citeste o descriere a categoriei");
        this.description = scanner.nextLine();
        //scanner.nextLine();
    }

    @Override
    public int compareTo(Category o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
