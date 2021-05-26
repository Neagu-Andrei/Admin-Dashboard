package project.repository;

import project.model.Category;
import project.config.DatabaseConfiguration;
import project.model.Product;

import javax.xml.crypto.Data;
import java.net.ConnectException;
import java.sql.*;

public class CategoriesRepository {

    public void createTable(){
        String createTable = "CREATE TABLE IF NOT EXISTS categories" +
                "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(12)," +
                "description varchar(30))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            Statement stmt = connection.createStatement();
            stmt.execute(createTable);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void addCategory(Category category){
        String insertProduct = "INSERT INTO categories(name, description) VALUES(?,?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertProduct);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getDescription());

            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Category getCategoryByName(String name){
        String select = "SELECT * FROM categories where name=?";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToCategory(resultSet);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private Category mapToCategory(ResultSet resultSet) throws SQLException{
        if (resultSet.next()){
            return new Category(resultSet.getString(2), resultSet.getString(3));
        }
        return null;
    }

    public void updateCategoryName(String description, Category category){
        String update = "UPDATE categories SET description=? WHERE name=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, description);
            preparedStatement.setString(2, category.getName());

            preparedStatement.executeUpdate();

            String updateProducts = "UPDATE products SET category=? WHERE category=?";

            try{
                PreparedStatement preparedStatement2 = connection.prepareStatement(updateProducts);
                preparedStatement2.setString(1, description);
                preparedStatement2.setString(2, category.getName());

                preparedStatement2.executeUpdate();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteCategory(Category category){
        String delete = "DELETE FROM categories WHERE name=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setString(1, category.getName());

            preparedStatement.executeUpdate();

            String deleteProducts = "DELETE FROM products WHERE category = ?";
            try {
                PreparedStatement preparedStatement2 = connection.prepareStatement(deleteProducts);
                preparedStatement2.setString(1, category.getName());
                preparedStatement2.executeUpdate();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void displayCategories(){
        String select = "SELECT * FROM categories";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()){
                System.out.println("Id: "+ resultSet.getString(1));
                System.out.println("Name: " + resultSet.getString(2));
                System.out.println("Description: " + resultSet.getString(3));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
