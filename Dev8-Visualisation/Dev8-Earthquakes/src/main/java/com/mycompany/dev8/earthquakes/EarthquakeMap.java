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
    
    public void setup(){
        size(1000, 812);
        
        image = loadImage("2000px-Map_of_Iceland.svg.png");
        
        
        dataProvider = new DataProvider(this);
        
        earthquakes = (ArrayList<Earthquake>)dataProvider.getEarthquakeData();
        
        
    }
    
    public void draw(){
        background(image);
        drawLocations();
        
        for (Earthquake earthquake : earthquakes){
            earthquake.act();
        }
    }
    
    public void drawLocations(){
        for (Earthquake earthquake : earthquakes){
            earthquake.draw();
        }
    }
}
