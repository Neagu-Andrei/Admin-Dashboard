package project.service;

import project.model.*;

import java.util.ArrayList;

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
}
