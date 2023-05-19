package org.example;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private final Map<String, String> phoneBook = new HashMap<>();

    public int add (String name, String number){
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, number);
        }
        return phoneBook.size();
    }

    public String findByNumber (String number){
        if (phoneBook.containsValue(number)){
            BiMap<String, String> biMap = HashBiMap.create(phoneBook);
            return biMap.inverse().get(number);
        }
        return null;
    }

    public String findByName (String name) {
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        }
        return null;
    }

    public void printAllNames(){
        System.out.println("");
    }
}
