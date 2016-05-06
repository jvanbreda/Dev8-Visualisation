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
    
    private EarthquakeMap earthquakeMap;

    public Earthquake(EarthquakeMap earthquakeMap) {
        this.earthquakeMap = earthquakeMap;
    }

    @Override
    public String toString() {
        // Should return attributes
        return "Earthquake object";
    }

    public void draw(int width, int height) {
        float newlatitude = map((float) this.latitude, 63.1f, 66.8f, 0, width);
        float newlongitude = map((float) this.longitude, -25.0f, -13.0f, 0, height);

        earthquakeMap.ellipse(newlatitude, newlongitude, (float) this.size * 20, (float) this.size * 20);
    }

}
