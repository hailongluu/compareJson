package com.longluu.demo;

import com.google.gson.*;
import com.google.gson.JsonObject;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JSONComparator {
    public static void main(String[] args) throws FileNotFoundException {
        JsonElement root = new JsonParser().parse(new InputStreamReader(new FileInputStream(new File("sample.json"))));
        JsonObject jsonObject = root.getAsJsonObject();
//        Set<String> keyRoot = jsonObject.keySet();
//        for (String key : keyRoot) {
//            JsonObject object = jsonObject.getAsJsonObject();
//
//        }
        ArrayList<Set<String>> listKey = new ArrayList<Set<String>>();
        boolean isContainKey = true;
        while (isContainKey){
            Set<String> keyRoot = jsonObject.keySet();
            for (String s : keyRoot) {
                JsonObject sub = jsonObject.getAsJsonObject(s);
            }
            if (keyRoot==null)isContainKey =false;
            else {
                listKey.add(keyRoot);
                jsonObject = jsonObject.getAsJsonObject();
            }
        }
        for (Set<String> strings : listKey) {
            for (String string : strings) {
                System.out.println(string);
            }

        }
            System.out.println(jsonObject.toString());

    }
}

