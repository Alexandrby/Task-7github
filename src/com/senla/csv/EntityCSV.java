package com.senla.csv;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class EntityCSV {

    private  File file;

    public EntityCSV(File file) {
        this.file = file;
    }

    public List<List<String>> readFile() throws IOException {
        List<List<String>> guests = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                guests.add(Arrays.asList(values));

            }
        }
        return guests;
    }

    public List<String> writeFile(List<String> listToWrite) throws IOException {

        String separator = ";";
        FileWriter writer = new FileWriter(file, true);
            for( int i = 0; i<listToWrite.size();i++){
                writer.append(listToWrite.get(i));
                if (i < (listToWrite.size() - 1)) {
                    writer.append(separator);
                }
            }
        writer.append(System.lineSeparator());
            writer.flush();
        return listToWrite;
    }


}

