/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dev8.earthquakes;

import com.mycompany.dev8.earthquakes.Models.Earthquake;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONArray;
import processing.data.JSONObject;

/**
 *
 * @author Jesse
 */
public class EarthquakeMap extends PApplet {
    DataProvider dataProvider;
    PImage image;
    
    public void setup(){
        size(1000, 812);
        
        dataProvider = new DataProvider();
        image = loadImage("2000px-Map_of_Iceland.svg.png");
        
        List<Earthquake> earthquakes = (ArrayList<Earthquake>)dataProvider.getEarthquakeData();
        for (Earthquake earthquake : earthquakes) {
            System.out.println(earthquake.depth);
        }
    }
    
    public void draw(){
        background(image);
    }
    
}
