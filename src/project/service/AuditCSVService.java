package project.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AuditCSVService {
    private static AuditCSVService instance = null;
    private String path = "src/project/csv/audit.csv";
    private CSVWriterService writerService = CSVWriterService.getInstance();

    private AuditCSVService(){}

    public static AuditCSVService getInstance(){
        if (instance == null){
            instance = new AuditCSVService();
        }
        return instance;
    }

    public void log(String action){
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        ArrayList<String> message = new ArrayList<>();
        message.add(action);
        message.add(timeStamp);
        writerService.write(path, message);
    }

}
