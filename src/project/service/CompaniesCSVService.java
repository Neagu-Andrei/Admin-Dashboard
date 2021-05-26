package project.service;

import project.model.Adress;
import project.model.Company;

import java.util.ArrayList;

public class CompaniesCSVService {
    public void read(ClientService clientService){
        CSVReaderService readerService = CSVReaderService.getInstance();

        ArrayList<ArrayList<String>> companies = readerService.read("src/project/csv/companies.csv");

        for (ArrayList<String> company:companies){
            String companyName = company.get(0);

            String companyStreet = company.get(1);
            int companyStreetNumber = Integer.parseInt(company.get(2));
            String companyCity  = company.get(3);
            String companyCountry = company.get(4);

            String companyContactPerson = company.get(5);
            String companyEmail = company.get(6);
            int companyContactNumber = Integer.parseInt(company.get(7));

            Adress adress = new Adress(companyStreet, companyStreetNumber, companyCity, companyCountry);

            Company addCompany = new Company(companyName, adress, companyContactPerson, companyEmail, companyContactNumber);

            //clientService.addCompany(addCompany);
        }
    }

    public void write(Company company) {
        CSVWriterService writerService = CSVWriterService.getInstance();

        ArrayList<String> message = new ArrayList<>();
        message.add(company.getName());

        message.add(company.getAdress().getStreet());
        message.add(String.valueOf(company.getAdress().getNumber()));
        message.add(company.getAdress().getCity());
        message.add(company.getAdress().getCountry());

        message.add(company.getContactPerson());
        message.add(company.getEmail());
        message.add(String.valueOf(company.getContactNumber()));

        writerService.write("src/project/csv/companies.csv", message);
    }
}
