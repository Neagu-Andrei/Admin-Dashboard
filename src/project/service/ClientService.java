package project.service;

import com.mysql.cj.xdevapi.Collection;
import project.model.*;
import project.repository.CategoriesRepository;
import project.repository.CompaniesRepository;
import project.repository.ProductsRepository;

import java.lang.reflect.Array;
import java.util.*;

public class ClientService {
    private ArrayList<Category> categories;
    private ArrayList<Company> companies;
    private ArrayList<Distribuitor> distribuitors;
    private ArrayList<Branch> branches;
    private ArrayList<Product> products;

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ClientService() {
        categories = new ArrayList<>();
        distribuitors = new ArrayList<>();
        companies = new ArrayList<>();
        branches = new ArrayList<>();
        products = new ArrayList<>();
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

    public void addCategory(Category category, CategoriesRepository categoriesRepository){
        Scanner scanner = new Scanner(System.in);
        try {
            for (Category cat:this.categories)
                if(category.getName().equals(cat.getName())){
                    throw new Exception("Aceasta categorie este deja inserata");
                }
            categoriesRepository.addCategory(category);
            this.categories.add(category);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Doriti sa updatati categoria existenta? (Y/N)");
            String message = scanner.next();
            if (message.equals("Y")){
                updateCategory(category, categoriesRepository);
            }
        }
    }

    public void addCompany(Company company, CompaniesRepository companiesRepository){
        try{
            for (Company company1:this.companies){
                if(company.getName().equals(company1.getName())){
                    throw new Exception("Compania pe care doriti sa o inserati exista deja.");
                }
            }
            companiesRepository.addCompany(company);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void addDistribuitor(Distribuitor distribuitor) {
        try{
            for (Distribuitor distribuitor1:this.distribuitors){
                if (distribuitor.getName().equals(distribuitor1.getName())){
                    throw new Exception("Distribuitorul pe care doriti sa il inserati exista deja.");
                }
            }
            distribuitors.add(distribuitor);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void addProduct(Product product, ProductsRepository productsRepository){
        Scanner scanner = new Scanner(System.in);
        try{
            for (Product prod:products)
                if (product.getCode() == prod.getCode())
                    throw new Exception("Acest produs este deja inserat");
            productsRepository.addProduct(product);
            this.products.add(product);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Doriti sa updatati produsul?");
            String message = scanner.next();
            if (message.equals("Y")){
                updateProduct(product);
            }
        }
    }


    //Delete

    public void deleteCategory(String name, CategoriesRepository categoriesRepository){
        try{
            for (Category category:this.categories){
                if(category.getName().equals(name)) {
                    categoriesRepository.deleteCategory(category);
                    throw new Exception("Categoria a fost stearsa.");
                }
            }
            throw new Exception("Nu am gasit categoria ceruta");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteCompany(String name, CompaniesRepository companiesRepository){
        try{
            for (Company company:this.companies){
                if(company.getName().equals(name)) {
                    companiesRepository.deleteCompany(company);
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
                if(distribuitor.getName().equals(name)) {
                    this.distribuitors.remove(distribuitor);
                    throw new Exception("Distribuitorul a fost stears.");
                }
            }
            throw new Exception("Nu am gasit distribuitorul cerut.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteProduct(int code, ProductsRepository productsRepository){
        try{
            for (Product prod:this.products){
                if (prod.getCode() == code){
                    productsRepository.deleteProduct(prod);
                    throw new Exception("Produsul a fost sters. ");
                }
            }
            throw new Exception("Nu am gasit produsul cerut");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //UPDATE
    public void updateCategory(Category category, CategoriesRepository categoriesRepository){
       try {
           for (Category category1:this.categories){
               if (category.getName().equals(category1.getName())){
                    categoriesRepository.updateCategoryName(category.getDescription(), category1);
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
                if (distribuitor.getName().equals(distribuitor1.getName())){
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
    public void updateCompany(Company company, CompaniesRepository companiesRepository){
        try {
            for (Company company1:this.companies){
                if (company.getName().equals(company1.getName())){
                    companiesRepository.updateCompanyContactPerson(company.getContactPerson(), company1);
                    throw new Exception("Compania" + company1.getName() +"a fost modificata.");
                }
            }
            throw new Exception("Nu am gasit compania cautata.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
/*
    public void updateBranch(Branch updatedBranch){
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
*/
    private void updateProduct(Product product) {
        try{
            for (Product prod:this.products){
                if (prod.getCode() == product.getCode()){
                    prod.setPrice(product.getPrice());
                    prod.setName(product.getName());
                    prod.setDescription(product.getDescription());
                    prod.setCategory(product.getCategory());
                    throw new Exception("Produsul a fost modificat");
                }
            }
            throw new Exception("Nu am gasit produsul cautat");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void showCategories(CategoriesRepository categoriesRepository){
        categoriesRepository.displayCategories();
    }

    public void showCompanies(CompaniesRepository companiesRepository){
        companiesRepository.displayCompanies();
    }

    public void showDistribuitors(){
        for (int i=0;i<distribuitors.size();i++)
            System.out.println((i+1)+ ": "+ distribuitors.get(i));
    }

    public void showProducts(ProductsRepository productsRepository) {
        productsRepository.displayProducts();
    }

    public void searchCategories(String name,CategoriesRepository categoriesRepository){
        categoriesRepository.getCategoryByName(name).readCategory();
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
