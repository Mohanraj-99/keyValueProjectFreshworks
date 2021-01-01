package com.mohanraj;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;


public class Main implements Serializable {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // Basic Variables
        boolean stop = true, flag = true;
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
            try {
                if ((ObjectSizeFetch.getObjectSize(hashMap) / (1024 * 1024 * 1024) > 1)) {
                    System.out.println("Your file size exceeded 1GB");
                    System.out.println("Creation operation not applicable");
                    flag = false;
                } else
                    flag = true;
            } catch (NullPointerException e) {
                //e.printStackTrace();
            }
            System.out.println("\nEnter \n1.Create \n2.Read \n3.Delete");
            num = scanner.nextInt();
            scanner.nextLine();
            if (num == 1) {
                System.out.println("\nCreate Operation");
                if (flag)
                    create(hashMap);
                else
                    System.out.println("Creation operation not applicable as your file size exceeded 1GB");
            } else if (num == 2) {
                System.out.println("\nRead Operation");
                System.out.println("Enter the Key");
                key = scanner.nextLine();
                if (authorization(hashMap, key))
                    read(hashMap, key);
            } else if (num == 3) {
                System.out.println("\nDelete Operation");
                System.out.println("Enter the Key");
                key = scanner.nextLine();
                if (authorization(hashMap, key))
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

    private static boolean authorization(HashMap<String, Details> hashMap, String key) {
        Details details = hashMap.get(key);
        if (details == null) {
            System.out.println("The Key doesn't exists");
            return false;
        } else {
            if (details.getLiveTime() != -1 && (details.getLiveTime() < (System.currentTimeMillis() / 1000))) {
                System.out.println("Live time exceeded ......");
                return false;
            } else
                return true;
        }
    }

    private static void create(HashMap<String, Details> hashMap) {
        // Getting Key and Value
        String key, name, emailID, message;
        long phoneNumber;
        int liveTime = -1;
        boolean liveStatus = false;
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
        System.out.println("Enter the Time-To-Live Status {Type:Integer} \n1 - True \n2 - False");
        if (scanner.nextInt() == 1) {
            liveStatus = true;
            scanner.nextLine();
            System.out.println("Enter the liveTime(Seconds) {Type:Integer}");
            liveTime = (int) ((System.currentTimeMillis() / 1000) + scanner.nextInt());
            scanner.nextLine();
            //System.out.println(liveTime);
        }
        // Saving....
        Details details = new Details(name, emailID, phoneNumber, message, liveTime, liveStatus);
        try {
            if ((ObjectSizeFetch.getObjectSize(details) / 1024) > 16) {
                System.out.println("Your Value size exceeded 16KB");
                System.out.println("Creation operation failed");
            } else {
                hashMap.put(key, details);
                System.out.println("Creation operation success\n");
            }
        } catch (NullPointerException e) {
            //e.printStackTrace();
        }
        hashMap.put(key, details);
        System.out.println("Creation operation success\n");
    }

    private static String vaildateKey(HashMap<String, Details> hashMap, String key) {
        String newKey = key;
        if (newKey.length() > 32) {
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
        System.out.println(details);
        System.out.println("Read operation success\n");
    }

    private static void delete(HashMap<String, Details> hashMap, String key) {
        hashMap.remove(key);
        System.out.println("Delete operation success\n");
    }
}
