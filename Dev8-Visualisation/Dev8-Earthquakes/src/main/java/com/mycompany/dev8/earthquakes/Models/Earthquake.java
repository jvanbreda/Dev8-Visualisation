/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dev8.earthquakes.Models;

import java.util.Date;

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
    
    @Override
    public String toString() {
        // Should return attributes
        return "Earthquake object";
    }
}
