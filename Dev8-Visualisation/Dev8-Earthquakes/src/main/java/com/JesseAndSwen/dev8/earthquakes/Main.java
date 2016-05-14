/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JesseAndSwen.dev8.earthquakes;

import com.JesseAndSwen.dev8.earthquakes.Data.Converter;
import com.JesseAndSwen.dev8.earthquakes.Models.Coordinates.CoordinateDecimal;
import com.JesseAndSwen.dev8.earthquakes.Models.Coordinates.CoordinateGeographic;
import com.JesseAndSwen.dev8.earthquakes.Models.Coordinates.GeoCoordinate;

/**
 *
 * @author Jesse
 */
public class Main {

    public static void main(String[] args) {
        //EarthquakeMap.main("com.JesseAndSwen.dev8.earthquakes.EarthquakeMap");
        GeoCoordinate g1 = new GeoCoordinate(52, 9, 8.9f);
        GeoCoordinate g2 = new GeoCoordinate(4, 31, 11.3f);
        
        //Converter.convertFromGeographicToDecimal(new CoordinateGeographic(g1, g2));
        System.out.println(Converter.convertFromDecimalToGeographic(new CoordinateDecimal(-33.92487f,18.42406f)));
    }
}
