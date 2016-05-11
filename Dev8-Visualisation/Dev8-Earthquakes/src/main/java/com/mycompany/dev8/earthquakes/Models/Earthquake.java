/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dev8.earthquakes.Models;

import com.Emitters.Emitter;
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

    private Emitter emitter;

    private VisualisationMode visualisationMode = VisualisationMode.DynamicMode;

    private PApplet applet;

    public Earthquake(PApplet applet) {
        this.applet = applet;
    }

    public void MapCoordinates() {
        mapLatitude = map((float) this.latitude, 63.1f, 66.8f, 0, applet.width);
        mapLongitude = map((float) this.longitude, -25.0f, -13.0f, 0, applet.height);

        mapWidth = (float) Math.abs(this.size) * 20f; // Absolute value of size, because size can be negative
        mapHeigth = (float) Math.abs(this.size) * 20f; // Absolute value of size, because size can be negative
        
        // Each next level on the richter scale is 10 times stronger than the previous level
//        mapWidth = (float) Math.pow(this.size, this.size) * 20f; // Absolute value of size, because size can be negative
//        mapHeigth = (float) Math.pow(this.size, this.size) * 20f; // Absolute value of size, because size can be negative

        // A size of -1 should be smaller than 1
        if (this.size < 0) {
            mapWidth = 5f;
            mapHeigth = 5f;
        }

        emitter = new Emitter(applet, new Vector2<Float>(mapLatitude, mapLongitude), new Vector2<Float>(mapWidth, mapHeigth));
    }

    public void act() {
        if (isOverEllipse()) {
            // Use String.Format
            new Popover(applet, new String[]{"Timestamp: " + timestamp.toString(), "Coordinates: (" + latitude + "|" + longitude + ")", "Size: " + size + " Richter Scale", "Depth: " + depth + " km"}).draw();
        }

        emitter.Act();
    }

    public void draw() {
        switch (visualisationMode) {
            case StaticMode:
                // Little calculation to match darkness of color to depth of earthquake
                // Fully red means 12 km deep. To get fully red, the 'green' number in the rgb color encoding needs to be 0.
                // 255 / 12 = 21.25, so for every km deeper, the green color number has to be decreased by an extra factor of 21.25
                applet.fill(255, 255 - ((float) this.depth * 21.25f), 0);
                applet.ellipse(mapLatitude, mapLongitude, mapWidth, mapHeigth);
                break;
            case DynamicMode:
                emitter.Draw();
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        // Should return attributes with String.Format
        return "Earthquake [timestamp: " + timestamp + "]";
    }

    private boolean isOverEllipse() {
        return applet.mouseX > mapLatitude - mapWidth / 2 && applet.mouseX < mapLatitude + mapWidth / 2 && applet.mouseY > mapLongitude - mapHeigth / 2 && applet.mouseY < mapLongitude + mapHeigth / 2;
    }

    public VisualisationMode getVisualisationMode() {
        return visualisationMode;
    }

    public void setVisualisationMode(VisualisationMode visualisationMode) {
        this.visualisationMode = visualisationMode;
    }
}
