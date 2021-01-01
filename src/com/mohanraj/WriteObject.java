package com.mohanraj;

import java.io.*;
import java.util.HashMap;

public class WriteObject{

    public static void write(String filePath,HashMap<String,Details> hashMap) throws IOException {
        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(hashMap);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(objectOutputStream!=null)
                objectOutputStream.close();
        }
    }

}
