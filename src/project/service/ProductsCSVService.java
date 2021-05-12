package project.service;

import project.model.Category;
import project.model.Product;
import project.model.SalesPrice;

import javax.xml.catalog.CatalogException;
import java.util.ArrayList;

public class ProductsCSVService {
    public void read(ClientService clientService){
        CSVReaderService readerService = CSVReaderService.getInstance();

        ArrayList<ArrayList<String>> products = readerService.read("src/project/csv/products.csv");

        for (ArrayList<String> product: products){
            String productName = product.get(0);
            int productCode = Integer.parseInt(product.get(1));
            double salesPrice = Double.parseDouble(product.get(2));
            String productDescription = product.get(3);
            String productCategoryName = product.get(4);

            ArrayList<Category> categories = clientService.getCategories();
            Product addProduct = null;
            for (Category category: categories){
                if (category.getName().equals(productCategoryName)){
                    addProduct = new Product(productName, productCode, new SalesPrice(salesPrice),productDescription, category);
                    clientService.addProduct(addProduct);
                    break;
                }
            }
        }
    }
}
