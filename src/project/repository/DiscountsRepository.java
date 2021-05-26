package project.repository;

import project.config.DatabaseConfiguration;
import project.model.Category;
import project.model.Discount;

import java.sql.*;

public class DiscountsRepository {

    public void createTable(){
        String createTable = "CREATE TABLE IF NOT EXISTS discounts" +
                "(id int PRIMARY KEY AUTO_INCREMENT, discount float," +
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

    public void addDiscount(Discount discount){
        String insertProduct = "INSERT INTO discounts(discount, description) VALUES(?,?,?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertProduct);
            preparedStatement.setFloat(1, discount.getDiscount());
            preparedStatement.setString(2, discount.getDiscountDescription());

            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void updateDiscountbyDiscount(float discountfloat, Discount discount){
        String update = "UPDATE discounts SET discount=? WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setFloat(1, discountfloat);
            preparedStatement.setFloat(2, discount.getDiscount());

            preparedStatement.executeUpdate();

            String updateProducts = "UPDATE products SET category=? WHERE category=?";
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteDiscount(Discount discount){
        String delete = "DELETE FROM discounts WHERE discount=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setFloat(1, discount.getDiscount());

            preparedStatement.executeUpdate();

            String deleteProducts = "DELETE FROM products WHERE category = ?";
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void displayDiscounts(){
        String select = "SELECT * FROM discounts";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()){
                System.out.println("Id: "+ resultSet.getString(1));
                System.out.println("Discount: " + resultSet.getString(2));
                System.out.println("Description: " + resultSet.getString(3));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}
