/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dev8.earthquakes.Models;

import com.mycompany.dev8.earthquakes.EarthquakeMap;
import java.util.Date;
import processing.core.PApplet;
import static processing.core.PApplet.map;
import processing.core.PFont;

/**
 *
 * @author swenm_000
 */
public class Earthquake {
    public Date timestamp;
    public double latitude;
    public double longitude;
    public double depth;
    public double size;
    public double quality;
    public String humanReadableLocation;
    
    public float mapLatitude; // Horizontal
    public float mapLongitude; // Vertical
    public float mapWidth;
    public float mapHeigth;
    
    private EarthquakeMap earthquakeMap;

    public Earthquake(EarthquakeMap earthquakeMap) {
        this.earthquakeMap = earthquakeMap;
    }

    public void MapCoordinates() {
        mapLatitude = map((float) this.latitude, 63.1f, 66.8f, 0, earthquakeMap.width);
        mapLongitude = map((float) this.longitude, -25.0f, -13.0f, 0, earthquakeMap.height);
        
        mapWidth = (float) this.size * 20;
        mapHeigth = (float) this.size * 20;
    }

    public void act() {
        if(isOverEllipse()) {
            // Use String.Format
            new Popover(earthquakeMap, new String[] { "Timestamp: " + timestamp.toString(), "Coordinates: (" + latitude + "|" + longitude + ")", "Size: " + size, "Depth: " + depth }).draw();
        }
    }
    
    public void draw() {
        earthquakeMap.fill(255);
        earthquakeMap.ellipse(mapLatitude, mapLongitude, mapWidth, mapHeigth);
    }
    
    @Override
    public String toString() {
        // Should return attributes with String.Format
        return "Earthquake [timestamp: " + timestamp + "]";
    }
    
    private boolean isOverEllipse() {
        return earthquakeMap.mouseX > mapLatitude - mapWidth / 2 && earthquakeMap.mouseX < mapLatitude + mapWidth / 2 && earthquakeMap.mouseY > mapLongitude - mapHeigth / 2 && earthquakeMap.mouseY < mapLongitude + mapHeigth / 2;
    }
}
