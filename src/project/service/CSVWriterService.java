package project.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVWriterService {
    private static CSVWriterService instance = null;
    private CSVWriterService(){}

    public static CSVWriterService getInstance(){
        if(instance == null){
            instance = new CSVWriterService();
        }
        return instance;
    }

    public void  write(String path, ArrayList<String> lista){
        File destination = new File(path);
        try{
            if (!destination.exists()){
                destination.createNewFile();
            }

            FileWriter writer = new FileWriter(destination,true);
            StringBuilder message = new StringBuilder();
            for (String atr: lista){
                message.append(atr);
                message.append(",");
            }
            message.deleteCharAt(message.length()-1);
            message.append("\n");
            writer.write(message.toString());
            writer.flush();
            writer.close();

        } catch (IOException e) {
            System.out.println("Eroare la scrierea in fisier");
        }
    }

}
