/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dev8.earthquakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import processing.data.JSONArray;

/**
 *
 * @author Jesse
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        JSONArray json = m.getData();
        for (int i = 0; i < json.size(); i++ ){
            System.out.println(json.getJSONObject(i));
        }
    }

    public JSONArray getData() {
        JSONArray array = null;
        try {
            URL url = new URL("http://apis.is/earthquake/is");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String jsonString = br.readLine();
            
            if (jsonString != null)
                //Used to format the JSON string in order to create a JSONArray from it
                jsonString = jsonString.substring(11);
            array = JSONArray.parse(jsonString);
            
        } catch (IOException e) {
            System.err.println("IOException occured");
        }
        
        return array;

    }
}
