/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dev8.earthquakes;

import Data.DataProvider;
import com.mycompany.dev8.earthquakes.Models.Earthquake;
import com.mycompany.dev8.earthquakes.Models.Legend;
import java.util.ArrayList;
import java.util.List;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

/**
 *
 * @author Jesse
 */
public class EarthquakeMap extends PApplet {
    private PImage image;
    
    private DataProvider dataProvider;
    
    private List<Earthquake> earthquakes;
    
    private Legend legend;
    
    public void setup(){
        size(799, 649);
        
        frame.setTitle("Earthquakes in and around Iceland from the past 48 hours");
        
        image = loadImage("799x649px-map_of_iceland.png");
        
        dataProvider = new DataProvider(this);
        
        earthquakes = (ArrayList<Earthquake>)dataProvider.getEarthquakeData();
        
        legend = new Legend(this, new String[]{"Every circle represent an earthquake.", "The bigger the circles, the bigger the size of the earthquake", "Depths:"});
    }
    
    public void draw(){
        background(image);
        drawLocations();
        legend.draw();
        drawDataSource();
        
        for (Earthquake earthquake : earthquakes){
            earthquake.act();
        }
    }
    
    public void drawLocations(){
        for (Earthquake earthquake : earthquakes){
            earthquake.draw();
        }
    }
    
    public void drawDataSource(){
        this.text("This data is provided by the Icelandic Meteorological Office: http://www.vedur.is/", 5, height - 5);
    }
}
