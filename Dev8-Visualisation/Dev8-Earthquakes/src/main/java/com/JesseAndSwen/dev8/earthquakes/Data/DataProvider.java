/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JesseAndSwen.dev8.earthquakes.Data;

import com.JesseAndSwen.dev8.earthquakes.EarthquakeMap;
import com.JesseAndSwen.dev8.earthquakes.Models.Earthquake;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import processing.data.JSONArray;
import processing.data.JSONObject;

/**
 *
 * @author swenm_000
 */
public class DataProvider {
    
    private EarthquakeMap earthquakeMap;

    public DataProvider(EarthquakeMap earthquakeMap) {
        this.earthquakeMap = earthquakeMap;
    }
    
    public List<Earthquake> getEarthquakeData() {
        List<Earthquake> earthquakes = new ArrayList<>();

        JSONArray jArray = getData();
        for (int i = 0; i < jArray.size(); i++) {
            JSONObject jObject = jArray.getJSONObject(i);

            Earthquake earthquake = new Earthquake(earthquakeMap);
            try {
                TimeZone tz = TimeZone.getTimeZone("Europe/Amsterdam");
                Calendar cal = Calendar.getInstance(tz);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                sdf.setCalendar(cal);
                cal.setTime(sdf.parse(jObject.getString("timestamp")));
                Date date = cal.getTime();
                
                earthquake.timestamp = date;
            } catch (Exception e) {
                System.err.println("Could not convert timestamp from JSONObject to earthquake.");
                continue;
            }

            earthquake.latitude = jObject.getDouble("latitude");
            earthquake.longitude = jObject.getDouble("longitude");
            earthquake.depth = jObject.getDouble("depth");
            earthquake.size = jObject.getDouble("size");
            earthquake.quality = jObject.getDouble("quality");
            earthquake.humanReadableLocation = jObject.getString("humanReadableLocation");
            
            earthquake.MapCoordinates();

            earthquakes.add(earthquake);
        }

        return earthquakes;
    }

    private JSONArray getData() {
        JSONArray array = new JSONArray();
        try {
            URL url = new URL("http://apis.is/earthquake/is");

            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String jsonString = br.readLine();

            JSONObject jObject = JSONObject.parse(jsonString);
            array = jObject.getJSONArray("results");

        } catch (IOException e) {
            System.err.println("IOException occured");
        }

        return array;
    }
}
