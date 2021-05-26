package project;

import project.model.*;
import project.repository.CategoriesRepository;
import project.repository.CompaniesRepository;
import project.repository.DiscountsRepository;
import project.repository.ProductsRepository;
import project.service.*;

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


    public static void case1(ClientService clientService,CategoriesRepository categoriesRepository, AuditCSVService auditService, Scanner scanner){
        Category category = new Category();
        category.readCategory();

        clientService.addCategory(category, categoriesRepository);

        auditService.log("Adaugare categorie");

        pressAnyKeyToContinue(scanner);
    }

    public static void case4(ClientService clientService, AuditCSVService auditService,CategoriesRepository categoriesRepository, Scanner scanner){
        clientService.showCategories(categoriesRepository);
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
        clientService.updateCategory(newCategory, categoriesRepository);
        auditService.log("categorie modificata");
    }

    public static void case9(ClientService clientService, AuditCSVService auditService,CompaniesRepository companiesRepository ,Scanner scanner){
        clientService.showCompanies(companiesRepository);
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
        modifyCompanyData(newCompany);
        clientService.updateCompany(newCompany, companiesRepository);
        auditService.log("Modificare companie");
        pressAnyKeyToContinue(scanner);
    }

    public static void case13(ClientService clientService, AuditCSVService auditService, Scanner scanner){
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
        HashSet<Product> distributorProducts = new HashSet<>(newdistribuitor.getProducts());
        while (choice.equals("Y")){
            System.out.println(distributorProducts);
            scanner.nextLine();
            System.out.println("Codul produsului pe care doresti sa il modifici:");
            int code = scanner.nextInt();
            scanner.nextLine();
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

        auditService.log("Modificare distribuitor");

        pressAnyKeyToContinue(scanner);
    }

    public static void main(String[] args){
        ClientService clientService = new ClientService();

        CategoriesRepository categoriesRepository = new CategoriesRepository();
        ProductsRepository productsRepository = new ProductsRepository();
        CompaniesRepository companiesRepository = new CompaniesRepository();
        DiscountsRepository discountsRepository = new DiscountsRepository();

        categoriesRepository.createTable();
        productsRepository.createTable();
        companiesRepository.createTable();
        discountsRepository.createTable();

        AuditCSVService auditService = AuditCSVService.getInstance();
        DistribuitorsCSVService distribuitorsService = new DistribuitorsCSVService();

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
                "\n22: Cautati o categorie dupa nume" +
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
                "\n__________________________________" +
                "\n18: Adaugati un produs nou" +
                "\n19: Afisati toate produsele" +
                "\n20: Stergeti un produs" +
                "\n21: Updatati un produs" +
                "\n0: EXIT"
            );

            o = scanner.nextInt();
            switch (o) {

                case 1:{
                    case1(clientService, categoriesRepository, auditService, scanner);
                    break;
                }
                case 2: {
                    clientService.showCategories(categoriesRepository);

                    auditService.log("Afisare categorii");

                    pressAnyKeyToContinue(scanner);
                    break;
                }
                case 3: {
                    clientService.showCategories(categoriesRepository);
                    System.out.println("Numele categoriei pe care doriti sa o stergeti:");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    clientService.deleteCategory(name, categoriesRepository);

                    auditService.log("Stergere categorie");

                    pressAnyKeyToContinue(scanner);
                    break;
                }


                /*
                *
                * de implementat modificari in csv
                *
                * */
                case 4: {
                    case4(clientService, auditService, categoriesRepository ,scanner);
                    break;
                }

                case 22:{
                    System.out.println("Numele categoriei pe care doriti sa o cautati: ");
                    String name = scanner.nextLine();
                    clientService.searchCategories(name,categoriesRepository);
                    clientService.showCategories(categoriesRepository);
                    pressAnyKeyToContinue(scanner);
                    auditService.log("cautare categorie dupa nume");
                    break;
                }
                /*
                case 5:{
                    clientService.sortCategories();
                    pressAnyKeyToContinue(scanner);
                    auditService.log("sortare categorie dupa nume");
                    break;
                }*/

                case 6:{
                    Company company = new Company();
                    company.readCompany();
                    clientService.addCompany(company, companiesRepository);
                    pressAnyKeyToContinue(scanner);
                    auditService.log("adaugare companie");
                    break;
                }

                case 7:{
                    clientService.showCompanies(companiesRepository);
                    pressAnyKeyToContinue(scanner);
                    auditService.log("Afisare companii");
                    break;
                }

                case 8:{
                    clientService.showCompanies(companiesRepository);
                    System.out.println("Numele companiei pe care doriti sa o stergeti:");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    clientService.deleteCompany(name, companiesRepository);
                    auditService.log("Stergere companie");
                    pressAnyKeyToContinue(scanner);
                    break;
                }

                case 9:{
                    case9(clientService, auditService, companiesRepository, scanner);
                    break;
                }

                case 10:{
                    Distribuitor distribuitor = new Distribuitor();
                    distribuitor.readDistribuitor();

                    clientService.addDistribuitor(distribuitor);
                    distribuitorsService.write(distribuitor);

                    auditService.log("Adaugare distribuitor");
                    pressAnyKeyToContinue(scanner);
                    break;
                }

                case 11:{
                    clientService.showDistribuitors();

                    auditService.log("Afisare distribuitor");

                    pressAnyKeyToContinue(scanner);
                    break;
                }

                case 12:{

                    clientService.showDistribuitors();
                    System.out.println("Numele distribuitorului pe care doriti sa il stergeti: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    clientService.deleteDistribuitor(name);

                    auditService.log("Stergere distribuitor");

                    pressAnyKeyToContinue(scanner);
                    break;
                }
                //de testat cazul in care un distribuitor nu are produse si vrem sa le adaugam
                case 13:{
                    case13(clientService, auditService, scanner);
                    break;
                }

                case 14:{
                    Branch branch = new Branch();
                    branch.readBranch();

                    clientService.addBranch(branch);
                    auditService.log("Adaugare branch");

                    pressAnyKeyToContinue(scanner);
                }

                case 18:{
                    Product product = new Product();
                    product.readProduct();

                    clientService.addProduct(product, productsRepository);
                    auditService.log("Adaugare produs");
                    pressAnyKeyToContinue(scanner);
                    break;
                }

                case 19:{
                    clientService.showProducts(productsRepository);
                    auditService.log("Afisare produse");
                    pressAnyKeyToContinue(scanner);
                    break;
                }

                case 20:{
                    System.out.println("Codul produsului pe care doriti sa il stergeti: ");
                    int code = scanner.nextInt();
                    clientService.deleteProduct(code, productsRepository);
                }
            }
        }
    }



}
