package com.senla.serial;
import com.senla.factory.intf.Guest;


import java.io.*;

public class Serialization implements Serializable {
    private static final long serialVersionUID = 1L;
//     private  File file = new File(".\\src\\com\\senla\\serial\\fileSerial.txt");
   private File file = new File("D:/Синёв/разное/Java learn/fileSerial.txt");     //work

    public void writeSerial(Object entity) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(entity);
        objectOutputStream.close();
    }

    public Object readSerial () throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object entity =  objectInputStream.readObject();
        return entity;

    }
}
