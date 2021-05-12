package project.service;

import project.model.Adress;
import project.model.Distribuitor;
import project.model.Product;

import javax.print.attribute.HashAttributeSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DistribuitorsCSVService {
    public void read(ClientService clientService){
        CSVReaderService readerService = CSVReaderService.getInstance();

        ArrayList<ArrayList<String>> distribuitors = readerService.read("src/project/csv/distribuitors.csv");
        
        for (ArrayList<String> distribuitor: distribuitors){
            String distribuitorName = distribuitor.get(0);
            String distribuitorStreet = distribuitor.get(1);
            int distribuitorStreetNumber = Integer.parseInt(distribuitor.get(2));
            String distribuitorCity  = distribuitor.get(3);
            String distribuitorCountry = distribuitor.get(4);

            String distribuitorContactPerson = distribuitor.get(5);
            String distribuitorEmail = distribuitor.get(6);
            int distribuitorContactNumber = Integer.parseInt(distribuitor.get(7));
            HashSet<Product> distribuitorProducts = new HashSet<>();
            int i = 8;
            while (i < distribuitor.size()){
                int distribuitorProductCode = Integer.parseInt(distribuitor.get(i));
                ArrayList<Product> products = clientService.getProducts();
                for (Product product: products){
                    if(product.getCode() == distribuitorProductCode){
                        distribuitorProducts.add(product);
                    }
                }
                i++;
            }
            Adress adress = new Adress(distribuitorStreet, distribuitorStreetNumber, distribuitorCity, distribuitorCountry);
            Distribuitor addDistribuitor = new Distribuitor(distribuitorName, adress, distribuitorContactPerson, distribuitorEmail, distribuitorContactNumber, distribuitorProducts);

            clientService.addDistribuitor(addDistribuitor);
        }
    }
    public void write(Distribuitor distribuitor){
        CSVWriterService writerService = CSVWriterService.getInstance();

        ArrayList<String> message = new ArrayList<>();
        message.add(distribuitor.getName());

        message.add(distribuitor.getAdress().getStreet());
        message.add(String.valueOf(distribuitor.getAdress().getNumber()));
        message.add(distribuitor.getAdress().getCity());
        message.add(distribuitor.getAdress().getCountry());

        message.add(distribuitor.getContactPerson());
        message.add(distribuitor.getEmail());
        message.add(String.valueOf(distribuitor.getContactNumber()));

        for(Product product: distribuitor.getProducts()){
            message.add(String.valueOf(product.getCode()));
        }
        writerService.write("src/project/csv/distribuitors.csv", message);
    }
}
