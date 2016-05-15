/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JesseAndSwen.dev8.earthquakes.Data;

import com.JesseAndSwen.dev8.earthquakes.Models.Coordinates.CoordinateDecimal;
import com.JesseAndSwen.dev8.earthquakes.Models.Coordinates.CoordinateGeographic;
import com.JesseAndSwen.dev8.earthquakes.Models.Coordinates.CoordinateRd;
import com.JesseAndSwen.dev8.earthquakes.Models.Coordinates.GeoCoordinate;

/**
 *
 * @author swenm_000
 */
public class Converter {
    /**
    * Converts RD-coordinates to decimal coordinates
    * @coordinateRd CoordinateRD The RD-coordinate that needs to be converted
    * @return CoordinateDecimal The converted coordinate
    */
    public static CoordinateDecimal convertFromRdToDecimal(CoordinateRd coordinateRd) {
        // Position of Amsterdam in RD, this is used as a reference in the formula
        int referenceRdX = 155000;
        int referenceRdY = 463000;
    
        double dX = (coordinateRd.getRdX() - referenceRdX) * (Math.pow(10, -5));
        double dY = (coordinateRd.getRdY() - referenceRdY) * (Math.pow(10, -5));
    
        double sumN = (3235.65389 * dY) + (-32.58297 * Math.pow(dX, 2)) + (-0.2475 * Math.pow(dY, 2)) + (-0.84978 * Math.pow(dX, 2) * dY) + (-0.0655 * Math.pow(dY, 3)) + (-0.01709 * Math.pow(dX, 2) * Math.pow(dY, 2)) + (-0.00738 * dX) + (0.0053 * Math.pow(dX, 4)) + (-0.00039 * Math.pow(dX, 2) * Math.pow(dY, 3)) + (0.00033 * Math.pow(dX, 4) * dY) + (-0.00012 * dX * dY);
        double sumE = (5260.52916 * dX) + (105.94684 * dX * dY) + (2.45656 * dX * Math.pow(dY, 2)) + (-0.81885 * Math.pow(dX, 3)) + (0.05594 * dX * Math.pow(dY, 3)) + (-0.05607 * Math.pow(dX, 3) * dY) + (0.01199 * dY) + (-0.00256 * Math.pow(dX, 3) * Math.pow(dY, 2)) + (0.00128 * dX * Math.pow(dY, 4)) + (0.00022 * Math.pow(dY, 2)) + (-0.00022 * Math.pow(dX, 2)) + (0.00026 * Math.pow(dX, 5));
    
        double referenceWgs84X = 52.15517;
        double referenceWgs84Y = 5.387206;
    
        float latitude = (float)(referenceWgs84X + (sumN / 3600));
        float longitude = (float)(referenceWgs84Y + (sumE / 3600));
        
        return new CoordinateDecimal(latitude, longitude);
    }
    
    public static CoordinateDecimal convertFromGeographicToDecimal(CoordinateGeographic coordinateGeographic){
        GeoCoordinate latitude = coordinateGeographic.getLatitude();
        GeoCoordinate longitude = coordinateGeographic.getLongitude();
        
        int d1 = latitude.getDegrees();
        int m1 = latitude.getMinutes();
        float s1 = latitude.getSeconds();
        
        int d2 = longitude.getDegrees();
        int m2 = longitude.getMinutes();
        float s2 = longitude.getSeconds();
        
        float dd1 = ((s1/60f) + m1) / 60f + Math.abs(d1);
        float dd2 = ((s2/60f) + m2) / 60f + Math.abs(d2);
        
        if (d1 < 0)
            dd1 *= -1;
        if (d2 < 0)
            dd2 *= -1;
        
        return new CoordinateDecimal(dd1, dd2);
    }
    
    public static CoordinateGeographic convertFromDecimalToGeographic(CoordinateDecimal coordinateDecimal){
        float latitude = coordinateDecimal.getLatitude();
        float longitude = coordinateDecimal.getLongitude();
        
        int d1 = (int) latitude;
        int m1 = (int) (Math.abs(latitude) * 60) % 60;
        float s1 = Math.abs(latitude) * 3600 % 60f;
        
        int d2 = (int) longitude;
        int m2 = (int) (Math.abs(longitude) * 60) % 60;
        float s2 = Math.abs(longitude) * 3600 % 60f;
        
        GeoCoordinate g1 = new GeoCoordinate(d1, m1, s1);
        GeoCoordinate g2 = new GeoCoordinate(d2, m2, s2);
        
        return new CoordinateGeographic(g1, g2);
    }
}
