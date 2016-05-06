/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dev8.earthquakes;

import com.mycompany.dev8.earthquakes.Models.Earthquake;
import java.util.ArrayList;
import java.util.List;
import processing.core.PApplet;
import processing.core.PImage;

/**
 *
 * @author Jesse
 */
public class EarthquakeMap extends PApplet {
    DataProvider dataProvider;
    PImage image;
    
    public void setup(){
        size(1000, 812);
        
        dataProvider = new DataProvider(this);
        image = loadImage("2000px-Map_of_Iceland.svg.png");
        
        List<Earthquake> earthquakes = (ArrayList<Earthquake>)dataProvider.getEarthquakeData();
        
        background(image);
        drawLocations(earthquakes);
        
        
    }
    
    public void draw(){
        
    }
    
    public void drawLocations(List<Earthquake> earthquakes){
        for (Earthquake earthquake : earthquakes){
            earthquake.draw(width, height);
        }
        
    }
    
}
