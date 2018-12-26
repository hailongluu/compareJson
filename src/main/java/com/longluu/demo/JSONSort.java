package com.longluu.demo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JSONSort {

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject o = (JSONObject) parser.parse(new FileReader("sample2.json"));
            JSONArray array = (JSONArray) o.get("results");
            ArrayList<JSONObject> list = new ArrayList<>();

            for (int i = 0; i < array.size(); i++) {
                list.add((JSONObject) array.get(i));
            }
            Collections.sort(list, new Comparator<JSONObject>() {
                @Override
                public int compare(JSONObject o1, JSONObject o2) {
                    Long v1 = (Long) o1.get("layerId");
                    Long v2 = (Long) o2.get("layerId");
                    return v1.compareTo(v2);
                }
            });

            for (JSONObject obj : list) {
                System.out.println(obj.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


