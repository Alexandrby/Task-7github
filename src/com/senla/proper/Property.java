package com.senla.proper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Property {
    Properties properties = new Properties();
//    File file = new File (".\\src\\com\\senla\\proper\\path");
    File file = new File ("D:/Синёв/разное/Java learn/path");
    public String load (String entity){
        try {
            properties.load(new FileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Ошибка чтения файла");
        }
        if (entity.equalsIgnoreCase("guest")) {
            String path = properties.getProperty("fileGuest");
            return path;
        } else if(entity.equalsIgnoreCase("option")){
            String path = properties.getProperty("fileOption");
            return path;
         }else if(entity.equalsIgnoreCase("room")){
            String path = properties.getProperty("fileRoom");
            return path;
        } else
        return "Введите корректное значение (guest/option/room)";
    }
}
