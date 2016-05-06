/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dev8.earthquakes;

import processing.core.PApplet;
import processing.core.PImage;

/**
 *
 * @author Jesse
 */
public class EarthquakeMap extends PApplet {
    
    PImage image;
   
    public void setup(){
        size(1000, 812);
        image = loadImage("2000px-Map_of_Iceland.svg.png");
    }
    
    public void draw(){
        background(image);
    }
    
}
