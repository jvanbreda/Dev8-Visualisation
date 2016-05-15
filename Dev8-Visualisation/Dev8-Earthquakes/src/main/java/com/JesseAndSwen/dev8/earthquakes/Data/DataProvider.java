/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JesseAndSwen.dev8.earthquakes.Data;

import com.JesseAndSwen.dev8.earthquakes.EarthquakeMap;
import com.JesseAndSwen.dev8.earthquakes.Models.Earthquake;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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

    public List<Earthquake> getEarthquakeData(DataType dataType) {
        List<Earthquake> earthquakes = new ArrayList<>();

        JSONArray jArray = new JSONArray();

        try {
            if (dataType == DataType.LIVE) {
                jArray = getData(new URL("http://apis.is/earthquake/is"));
            } else {
                ClassLoader classLoader = getClass().getClassLoader();
                File file = new File(classLoader.getResource("earthquake_data_TEST.json").getFile());
                jArray = getData(file.toURI().toURL());
            }
        } catch (Exception e) {
        }

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

            if (isInBounds(earthquake)) {
                earthquakes.add(earthquake);
            }
        }

        // Sort the collection so that the big earthquakes will be drawn first, with the little ones over them
        Collections.sort(earthquakes, (e1, e2) -> ((Double) (e2.size)).compareTo(e1.size));

        return earthquakes;
    }

    private JSONArray getData(URL url) {
        JSONArray array = new JSONArray();
        try {
            //URL url = new URL(urlString); // "http://apis.is/earthquake/is"

            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String jsonString = br.readLine();

            JSONObject jObject = JSONObject.parse(jsonString);
            array = jObject.getJSONArray("results");

        } catch (IOException e) {
            System.err.println("IOException occured");
        }

        return array;
    }

    private boolean isInBounds(Earthquake earthquake) {
        return (earthquake.mapLatitude > 0 && earthquake.mapLatitude < 799 && earthquake.mapLongitude > 0 && earthquake.mapLongitude < 649);
        // For coordinates
        //return (earthquake.longitude >= -25f && earthquake.longitude <= -13f && earthquake.latitude <= 66.8f && earthquake.latitude >= 63.1f);
    }

    public enum DataType {

        LIVE,
        TEST
    }
}
