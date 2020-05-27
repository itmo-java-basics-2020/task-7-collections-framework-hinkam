package ru.ifmo.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {

    private LinkedHashMap<Integer, Integer> hashMap = new LinkedHashMap<>();

    public FirstUnique(int[] numbers) {
        for (int i : numbers){
            hashMap.put(i, hashMap.getOrDefault(i, 0)+1);
        }
    }

    public int showFirstUnique() {
        for(Map.Entry<Integer, Integer> entry: hashMap.entrySet()){
            if(entry.getValue()==1)
                return entry.getKey();
        }
        return -1;
    }

    public void add(int value) {
        hashMap.put(value, hashMap.getOrDefault(value, 0)+1);
    }
}
