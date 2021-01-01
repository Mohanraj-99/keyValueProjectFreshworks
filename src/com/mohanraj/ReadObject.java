package com.mohanraj;

import java.io.*;
import java.util.HashMap;

public class ReadObject {

    public static HashMap<String, Details> read(String filePath) throws IOException {
        HashMap<String, Details> readData = null;
        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            objectInputStream = new ObjectInputStream(fileInputStream);
            readData = (HashMap<String, Details>) objectInputStream.readObject();
        } catch (Exception e) {
            System.out.println(" <----- Initializing Application ----------->");
        } finally {
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            return readData;
        }
    }


}
