package project.repository;

import project.config.DatabaseConfiguration;
import project.model.*;

import java.sql.*;
public class CompaniesRepository {
    public void createTable(){
        String createTable = "CREATE TABLE IF NOT EXISTS companies" +
                "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(15)," +
                "street varchar(20), number int, city varchar(15), country varchar(15),"+
                "contact_person varchar(20), email varchar(25), contact_number int)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            Statement statement = connection.createStatement();
            statement.execute(createTable);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void addCompany(Company company){
        String insert = "INSERT INTO companies (name, street, number, city, country, contact_person, email, contact_number)" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, company.getName());
            preparedStatement.setString(2, company.getAdress().getStreet());
            preparedStatement.setInt(3,company.getAdress().getNumber());
            preparedStatement.setString(4, company.getAdress().getCity());
            preparedStatement.setString(5, company.getAdress().getCountry());
            preparedStatement.setString(6, company.getContactPerson());
            preparedStatement.setString(7, company.getEmail());
            preparedStatement.setInt(8, company.getContactNumber());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateCompanyContactPerson(String contactPerson, Company company){
        String update = "UPDATE companies SET contact_person=? WHERE name=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, contactPerson);
            preparedStatement.setString(2, company.getName());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Company getCompanyByName(String name){
        String select = "SELECT * FROM companies where name=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToCompanies(resultSet);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private Company mapToCompanies(ResultSet resultSet) throws SQLException{
        if (resultSet.next()){
            return new Company(resultSet.getString(2), new Adress(resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6)), resultSet.getString(7), resultSet.getString(8), resultSet.getInt(9));
        }
        return null;
    }

    public void deleteCompany(Company company){
        String delete = "DELETE FROM companies WHERE name=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setString(1, company.getName());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void displayCompanies(){
        String select = "SELECT * FROM companies";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()){
                System.out.println("Id: " + resultSet.getString(1));
                System.out.println("Name: " + resultSet.getString(2));
                System.out.println("Adress");
                System.out.println("Street: " + resultSet.getString(3));
                System.out.println("Street Number: " + resultSet.getString(4));
                System.out.println("City: " + resultSet.getString(5));
                System.out.println("Country: " + resultSet.getString(6));
                System.out.println("Contact person: " + resultSet.getString(7));
                System.out.println("Email: " + resultSet.getString(8));
                System.out.println("Contact number" + resultSet.getString(9));
                System.out.println("");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
