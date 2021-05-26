package project.service;

import project.model.Category;

import java.util.ArrayList;

public class CategoriesCSVService {
    public void read(ClientService clientService){
        CSVReaderService readerService = CSVReaderService.getInstance();

        ArrayList<ArrayList<String>> categories = readerService.read("src/project/csv/categories.csv");

        for (ArrayList<String> category: categories){
            String categoryName = category.get(0);
            String categoryDescription = category.get(1);

            Category addCategory = new Category(categoryName,categoryDescription);

            //clientService.addCategory(addCategory);
        }
    }

    public void write(Category category){
        CSVWriterService writerService = CSVWriterService.getInstance();

        ArrayList<String> message = new ArrayList<>();
        message.add(category.getName());
        message.add(category.getDescription());

        writerService.write("src/project/csv/categories.csv", message);
    }
}
