package com.mohanraj;

import java.io.IOException; 
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

public class Main implements Serializable {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // Basic Variables
        boolean stop = true;
        int num;
        String key, path = "C:\\Users\\Mohanraj G\\Desktop\\Mohanraj_Freshworks\\src\\com\\mohanraj\\customdata.dat";
        HashMap<String, Details> hashMap;

        // Data Source
        hashMap = new HashMap<>();
        if (ReadObject.read(path) != null) {
            hashMap = ReadObject.read(path);
        }

        // Source Code
        while (stop) {
            System.out.println("\nEnter \n1.Create \n2.Read \n3.Delete");
            num = scanner.nextInt();
            scanner.nextLine();
            if (num == 1) {
                System.out.println("\nCreate Operation");
                create(hashMap);
            } else if (num == 2) {
                System.out.println("\nRead Operation");
                System.out.println("Enter the Key");
                key = scanner.nextLine();
                read(hashMap, key);
            } else if (num == 3) {
                System.out.println("\nDelete Operation");
                System.out.println("Enter the Key");
                key = scanner.nextLine();
                delete(hashMap, key);
            } else
                System.out.println("Please enter the valid number\n");
            WriteObject.write(path, hashMap);
            System.out.println("\nDo you want to continue \n1.Yes \n2.No");
            num = scanner.nextInt();
            scanner.nextLine();
            if (num == 2)
                stop = false;
        }
    }

    private static void create(HashMap<String, Details> hashMap) {
        // Getting Key and Value
        String key, name, emailID, message;
        long phoneNumber;
        int liveTime;
        //Boolean status;
        System.out.println("Enter the Key {Type:String}\nNote : Key should not exceed 32 characters");
        {
            key = scanner.nextLine();
            key = vaildateKey(hashMap, key);
        }
        System.out.println("Enter the name {Type:String}");
        name = scanner.nextLine();
        System.out.println("Enter the emailID {Type:String}");
        emailID = scanner.nextLine();
        System.out.println("Enter the phoneNumber {Type:Long}");
        phoneNumber = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter the message {Type:String}");
        message = scanner.nextLine();
        System.out.println("Enter the liveTime(Seconds) {Type:Integer}");
        liveTime = scanner.nextInt();
        scanner.nextLine();

        // Saving....
        Details details = new Details(name, emailID, phoneNumber, message, liveTime);
        hashMap.put(key, details);
        System.out.println("Creation operation success\n");
    }

    private static String vaildateKey(HashMap<String, Details> hashMap, String key) {
        String newKey = key;
        if(newKey.length()>32){
            System.out.println("The Key must not exceed 32 characters");
            System.out.println("Enter a new Key for create operation \nNote : Key should not exceed 32 characters");
            newKey = scanner.nextLine();
            newKey = vaildateKey(hashMap, newKey);
        }
        if (hashMap.get(newKey) != null) {
            System.out.println("The Key already exists");
            System.out.println("Enter a new Key for create operation \nNote : Key should not exceed 32 characters");
            newKey = scanner.nextLine();
            newKey = vaildateKey(hashMap, newKey);
        }
        return newKey;
    }

    private static void read(HashMap<String, Details> hashMap, String key) {
        Details details = hashMap.get(key);
        if (details == null) {
            System.out.println("The Key doesn't exists");
        }
        else {
            System.out.println(details);
            System.out.println("Read operation success\n");
        }
    }

    private static void delete(HashMap<String, Details> hashMap, String key) {
        if (hashMap.get(key) == null) {
            System.out.println("The Key doesn't exists");
        } else {
            hashMap.remove(key);
            System.out.println("Delete operation success\n");
        }
    }
}
