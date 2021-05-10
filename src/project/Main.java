package project;

import project.model.*;
import project.service.ClientService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void pressAnyKeyToContinue(Scanner scanner){
        System.out.println("Apasa enter pentru a continua");
        scanner.nextLine();
        scanner.nextLine();
    }

    public static void modifyCompanyData(Company company){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Doresti sa modifici adresa firmei? (Y/N)");
        String choices = scanner.nextLine();
        if (choices.equals("Y")){
            Adress adress = new Adress();
            adress.readAdress();
            company.setAdress(adress);
        }
        scanner.nextLine();
        System.out.println("Doresti sa modifici persoana de contact? (Y/N)");
        choices = scanner.nextLine();
        if (choices.equals("Y")){
            System.out.println("Introduce persoana de contact");
            String contact = scanner.nextLine();
            company.setContactPerson(contact);
        }

        System.out.println("Doresti sa modifici emailul? (Y/N)");
        choices = scanner.nextLine();
        if (choices.equals("Y")){
            System.out.println("Introduce emailul");
            String email = scanner.nextLine();
            company.setEmail(email);
        }

        System.out.println("Doresti sa modifici numarul de contact? (Y/N)");
        choices = scanner.nextLine();
        if (choices.equals("Y")){
            System.out.println("Introduce numarul de contact");
            int number = scanner.nextInt();
            company.setContactNumber(number);
        }
    }

    public static void main(String args[]){
        ClientService clientService = new ClientService();
        Scanner scanner = new Scanner(System.in);
        int o = 1;
        System.out.println("\nHello, admin!\n");
        while (o != 0){
            System.out.println(
                "Ce operatii doriti sa efectuati?" +
                "\n1: Adaugati o categorie" +
                "\n2: Afisati categoriile POS" +
                "\n3: Stergeti o categorie" +
                "\n4: Modificati o categorie" +
                "\n5: Afisati categoriile in ordine alfabetica"+
                "\n_______________________________" +
                "\n6: Adaugati o firma noua" +
                "\n7: Afisati toate firmele" +
                "\n8: Stergeti o firma" +
                "\n9: Modificati o firma" +
                "\n________________________________" +
                "\n10: Adaugati un distribuitor nou" +
                "\n11: Afisati toti distribuitorii" +
                "\n12: Stergeti un distribuitor"  +
                "\n13: Modificati un distribuitor" +
                "\n__________________________________" +
                "\n14: Adaugati un branch nou" +
                "\n15: Afisati toate branch urile" +
                "\n16: Stergeti un branch" +
                "\n17: Updatati un branch" +
                "\n0: EXIT"
            );

            o = scanner.nextInt();
            switch (o) {

                case 1:{
                    Category category = new Category();
                    category.readCategory();
                    clientService.addCategory(category);
                    pressAnyKeyToContinue(scanner);
                    break;
                }
                case 2: {
                    clientService.showCategories();
                    pressAnyKeyToContinue(scanner);
                    break;
                }
                case 3: {
                    clientService.showCategories();
                    System.out.println("Numele categoriei pe care doriti sa o stergeti:");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    clientService.deleteCategory(name);
                    pressAnyKeyToContinue(scanner);
                    break;
                }

                case 4: {
                    clientService.showCategories();
                    System.out.println("A cata categorie doresti sa o modifici?");
                    scanner.nextLine();
                    int i = scanner.nextInt();
                    scanner.nextLine();
                    Category newCategory = new Category();
                    String name = clientService.getCategories().get(i-1).getName();
                    newCategory.setName(name);
                    System.out.println("Citeste noua descriere a categoriei");
                    String description = scanner.nextLine();
                    newCategory.setDescription(description);
                    clientService.updateCategory(newCategory);
                    break;
                }

                case 5:{
                    clientService.sortCategories();
                    clientService.showCategories();
                    pressAnyKeyToContinue(scanner);
                    break;
                }

                case 6:{
                    Company company = new Company();
                    company.readCompany();
                    clientService.addCompany(company);
                    pressAnyKeyToContinue(scanner);
                    break;
                }

                case 7:{
                    clientService.showCompanies();
                    pressAnyKeyToContinue(scanner);
                    break;
                }

                case 8:{
                    clientService.showCompanies();
                    System.out.println("Numele companiei pe care doriti sa o stergeti:");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    clientService.deleteCompany(name);
                    pressAnyKeyToContinue(scanner);
                    break;
                }

                case 9:{
                    clientService.showCompanies();
                    System.out.println("A cata companie doresti sa o modifici?");
                    scanner.nextLine();
                    int i = scanner.nextInt();
                    scanner.nextLine();
                    Company newCompany;
                    newCompany = clientService.getCompanies().get(i-1);

                    System.out.println("Doresti sa modifici adresa firmei? (Y/N)");
                    String choices = scanner.nextLine();
                    if (choices.equals("Y")){
                        Adress adress = new Adress();
                        adress.readAdress();
                        newCompany.setAdress(adress);
                    }
                    scanner.nextLine();
                    System.out.println("Doresti sa modifici persoana de contact? (Y/N)");
                    choices = scanner.nextLine();
                    if (choices.equals("Y")){
                        System.out.println("Introduce persoana de contact");
                        String contact = scanner.nextLine();
                        newCompany.setContactPerson(contact);
                    }

                    System.out.println("Doresti sa modifici emailul? (Y/N)");
                    choices = scanner.nextLine();
                    if (choices.equals("Y")){
                        System.out.println("Introduce emailul");
                        String email = scanner.nextLine();
                        newCompany.setEmail(email);
                    }

                    System.out.println("Doresti sa modifici numarul de contact? (Y/N)");
                    choices = scanner.nextLine();
                    if (choices.equals("Y")){
                        System.out.println("Introduce numarul de contact");
                        int number = scanner.nextInt();
                        newCompany.setContactNumber(number);
                    }
                    clientService.updateCompany(newCompany);
                    pressAnyKeyToContinue(scanner);
                    break;
                }

                case 10:{
                    Distribuitor distribuitor = new Distribuitor();
                    distribuitor.readDistribuitor();
                    clientService.addDistribuitor(distribuitor);
                    pressAnyKeyToContinue(scanner);
                    break;
                }

                case 11:{
                    clientService.showDistribuitors();
                    pressAnyKeyToContinue(scanner);
                    break;
                }

                case 12:{

                    clientService.showDistribuitors();
                    System.out.println("Numele distribuitorului pe care doriti sa il stergeti: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    clientService.deleteDistribuitor(name);
                    pressAnyKeyToContinue(scanner);
                    break;
                }
                //de testat cazul in care un distribuitor nu are produse si vrem sa le adaugam
                case 13:{
                    clientService.showDistribuitors();
                    System.out.println("Al catelea distribuitor doresti sa il modifici: ");
                    scanner.nextLine();
                    int i = scanner.nextInt();
                    scanner.nextLine();
                    Distribuitor newdistribuitor;
                    newdistribuitor = clientService.getDistribuitors().get(i-1);
                    modifyCompanyData(newdistribuitor);

                    System.out.println("Doresti sa modifici vreun produs al distribuitorului?(Y/N)");
                    String choice = scanner.nextLine();
                    HashSet<Product> distributorProducts = new HashSet<Product>(newdistribuitor.getProducts());
                    while (choice.equals("Y")){
                        System.out.println(distributorProducts);
                        scanner.nextLine();
                        System.out.println("Codul produsului pe care doresti sa il modifici:");
                        int code = scanner.nextInt();
                        for (Product product:distributorProducts){
                            if (product.getCode() == code){
                                System.out.println("Doresti sa modifici pretul produsului?(Y/N)");
                                String secondChoice = scanner.nextLine();
                                if (secondChoice.equals("Y")){
                                    System.out.println("Pretul produsului: ");
                                    SalesPrice price = new SalesPrice(scanner.nextDouble());
                                    product.setPrice(price);
                                    System.out.println("Pretul a fost updatat.");
                                }
                                System.out.println("Produsul a fost modificat.");
                                break;
                            }
                        }
                        System.out.println("Doresti sa mai modifici un produs? (Y/N)");
                        choice = scanner.nextLine();
                    }
                    newdistribuitor.setProducts(distributorProducts);
                    pressAnyKeyToContinue(scanner);
                }

                case 14:{
                    Branch branch = new Branch();
                    branch.readBranch();
                    clientService.addBranch(branch);
                    pressAnyKeyToContinue(scanner);
                }
            }
        }
    }



}
