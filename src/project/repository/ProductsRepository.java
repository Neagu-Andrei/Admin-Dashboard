package project.repository;
import project.model.Category;
import project.model.Product;
import project.config.DatabaseConfiguration;
import project.model.SalesPrice;

import javax.swing.plaf.nimbus.State;
import javax.xml.crypto.Data;
import java.net.ConnectException;
import java.sql.*;

public class ProductsRepository {

    public void createTable(){
        String createTable = "CREATE TABLE IF NOT EXISTS products" +
                "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(15)," +
                "code int, price double(4,2), description varchar(30), category varchar(12))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            Statement statement = connection.createStatement();
            statement.execute(createTable);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void addProduct(Product p){
        String insert = "INSERT INTO products (name, code, price, description, category)" +
                "VALUES(?, ?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, p.getName());
            preparedStatement.setDouble(3, p.getPrice().getSalesPrice());
            preparedStatement.setInt(2,p.getCode());
            preparedStatement.setString(4, p.getDescription());
            preparedStatement.setString(5, p.getCategory().getName());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Product getProductByCode(int code){
        String select = "SELECT * FROM products where code=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            preparedStatement.setInt(1, code);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToProduct(resultSet);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private Product mapToProduct(ResultSet resultSet) throws SQLException{
        if (resultSet.next()){
            CategoriesRepository categoriesRepository = new CategoriesRepository();
            Category category = categoriesRepository.getCategoryByName(resultSet.getString(6));
            return new Product(resultSet.getString(2), resultSet.getInt(3), new SalesPrice(resultSet.getDouble(4)), resultSet.getString(5), category);
        }
        return null;
    }

    public void deleteProduct(Product p){
        String delete = "DELETE FROM products WHERE code=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, p.getCode());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void displayProducts(){
        String select = "SELECT * FROM products";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()){
                System.out.println("Id: " + resultSet.getString(1));
                System.out.println("Name: " + resultSet.getString(2));
                System.out.println("Code: " + resultSet.getString(3));
                System.out.println("Price: " + resultSet.getString(4));
                System.out.println("Description: " + resultSet.getString(5));
                System.out.println("Category: " + resultSet.getString(6));
                System.out.println("");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}
