package project.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CSVReaderService {
    private static CSVReaderService instance = null;

    private CSVReaderService(){ }

    public static CSVReaderService getInstance(){
        if (instance == null){
            instance = new CSVReaderService();
        }
        return instance;
    }

    public ArrayList<ArrayList<String>> read(String path){
        ArrayList<ArrayList<String>> objects = new ArrayList<>();
        try {
            File input = new File(path);
            Scanner scanner = new Scanner(input);

            String line;
            line = scanner.nextLine();

            while(line != null){
                ArrayList<String> object = new ArrayList<>(Arrays.asList(line.split(",")));
                objects.add(object);

                if(scanner.hasNextLine()){
                    line = scanner.nextLine();
                }else {
                    line = null;
                }
            }
        }
        catch (Exception e) {
            //System.out.println("");
            //e.getStackTrace();
        }
        return objects;
    }

}
