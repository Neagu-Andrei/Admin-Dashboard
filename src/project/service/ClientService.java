package project.service;

import project.model.*;

import java.lang.reflect.Array;
import java.util.*;

public class ClientService {
    private ArrayList<Category> categories;
    private ArrayList<Company> companies;
    private ArrayList<Distribuitor> distribuitors;
    private ArrayList<Branch> branches;


    public ClientService() {
        categories = new ArrayList<>();
        distribuitors = new ArrayList<>();
        companies = new ArrayList<>();
        branches = new ArrayList<>();
    }


    //ADD
    public void addBranch(Branch branch){
        try{
            this.branches.add(branch);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void addCategory(Category category){
        Scanner scanner = new Scanner(System.in);
        try {
            for (Category cat:this.categories)
                if(category.getName().equals(cat.getName())){
                    throw new Exception("Aceasta categorie este deja inserata");
                }
            categories.add(category);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Doriti sa updatati categoria existenta? (Y/N)");
            String message = scanner.next();
            if (message.equals("Y")){
                updateCategory(category);
            }
        }
    }

    public void addCompany(Company company){
        try{
            for (Company company1:this.companies){
                if(company.getName() == company1.getName()){
                    throw new Exception("Compania pe care doriti sa o inserati exista deja.");
                }
            }
            companies.add(company);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void addDistribuitor(Distribuitor distribuitor) {
        try{
            for (Distribuitor distribuitor1:this.distribuitors){
                if (distribuitor.getName() == distribuitor1.getName()){
                    throw new Exception("Distribuitorul pe care doriti sa il inserati exista deja.");
                }
            }
            distribuitors.add(distribuitor);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    //Delete

    public void deleteCategory(String name){
        try{
            for (Category category:this.categories){
                if(category.getName().equals(name)) {
                    this.categories.remove(category);
                    throw new Exception("Categoria a fost stearsa.");
                }
            }
            throw new Exception("Nu am gasit categoria ceruta");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteCompany(String name){
        try{
            for (Company company:this.companies){
                if(company.getName() == name) {
                    this.categories.remove(company);
                    throw new Exception("Compania a fost stearsa.");
                }
            }
            throw new Exception("Nu am gasit compania ceruta");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteBranch(int number){
        try {
            for(Branch branch:this.branches){
                if (branch.getNumber() == number){
                    this.branches.remove(branch);
                    throw new Exception("Surcursala cu numarul " + number + " a fost stearsa");
                }
            }
            throw new Exception("Nu am gasit surcursala dorita");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteDistribuitor(String name){
        try{
            for (Distribuitor distribuitor:this.distribuitors){
                if(distribuitor.getName() == name) {
                    this.categories.remove(distribuitor);
                    throw new Exception("Distribuitorul a fost stears.");
                }
            }
            throw new Exception("Nu am gasit distribuitorul cerut.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //UPDATE
    public void updateCategory(Category category){
       try {
           for (Category category1:this.categories){
               if (category.getName().equals(category1.getName())){
                    category1.setDescription(category.getDescription());
                    throw new Exception("Categoria a fost modificata.");
               }
           }
           throw new Exception("Nu am gasit categoria cautata.");
       }
       catch (Exception e){
           System.out.println(e.getMessage());
       }
    }
    public void updateDistribuitor(Distribuitor distribuitor){
        try {
            for (Distribuitor distribuitor1:this.distribuitors){
                if (distribuitor.getName() == distribuitor1.getName()){
                    distribuitor1.setAdress(distribuitor.getAdress());
                    distribuitor1.setContactNumber(distribuitor.getContactNumber());
                    distribuitor1.setProducts(distribuitor.getProducts());
                    distribuitor1.setContactPerson(distribuitor.getContactPerson());
                    distribuitor1.setEmail(distribuitor.getEmail());
                    throw new Exception("Distribuitorul" + distribuitor1.getName() +"a fost modificat.");
                }
            }
            throw new Exception("Nu am gasit distribuitorul cautat.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void updateCompany(Company company){
        try {
            for (Company company1:this.companies){
                if (company.getName().equals(company1.getName())){
                    company1.setAdress(company.getAdress());
                    company1.setContactNumber(company.getContactNumber());
                    company1.setContactPerson(company.getContactPerson());
                    company1.setEmail(company.getEmail());
                    throw new Exception("Compania" + company1.getName() +"a fost modificata.");
                }
            }
            throw new Exception("Nu am gasit compania cautata.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void updateBranch(int number){
        Scanner scanner = new Scanner(System.in);
        try{
            for (Branch branch:this.branches){
                if (branch.getNumber() == number){
                    Adress adress = new Adress();
                    adress.readAdress();
                    branch.setAdress(adress);
                    throw new Exception("Am modificat branch ul");
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void showCategories(){
        for (int i=0;i<categories.size();i++)
            System.out.println((i+1) + ":\t" +categories.get(i));
    }

    public void showCompanies(){
        for (int i=0;i<companies.size();i++)
            System.out.println((i+1) + ":\t"+ companies.get(i));
    }

    public void showDistribuitors(){
        for (int i=0;i<distribuitors.size();i++)
            System.out.println((i+1)+ ": "+ distribuitors.get(i));
    }


    public void sortCategories(){
        Collections.sort(categories);
    }

    public ArrayList<Category> getCategories() { return categories; }

    public void setCategories(ArrayList<Category> categories) { this.categories = categories; }

    public ArrayList<Company> getCompanies() { return companies; }

    public void setCompanies(ArrayList<Company> companies) { this.companies = companies; }

    public ArrayList<Distribuitor> getDistribuitors() { return distribuitors; }

    public void setDistribuitors(ArrayList<Distribuitor> distribuitors) { this.distribuitors = distribuitors; }

    public ArrayList<Branch> getBranches() { return branches; }

    public void setBranches(ArrayList<Branch> branches) { this.branches = branches; }

    @Override
    public String toString() {
        return "ClientService{" +
                "categories=" + categories +
                ", companies=" + companies +
                ", distribuitors=" + distribuitors +
                ", branches=" + branches +
                '}';
    }
}
