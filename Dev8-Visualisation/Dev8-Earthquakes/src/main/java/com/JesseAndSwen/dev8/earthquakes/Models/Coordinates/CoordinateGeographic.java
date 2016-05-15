/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JesseAndSwen.dev8.earthquakes.Models.Coordinates;

/**
 *
 * @author swenm_000
 */
public class CoordinateGeographic {
    private GeoCoordinate latitude;
    private GeoCoordinate longitude;

    public CoordinateGeographic(GeoCoordinate latitude, GeoCoordinate longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public GeoCoordinate getLatitude() {
        return latitude;
    }

    public void setLatitude(GeoCoordinate latitude) {
        this.latitude = latitude;
    }

    public GeoCoordinate getLongitude() {
        return longitude;
    }

    public void setLongitude(GeoCoordinate longitude) {
        this.longitude = longitude;
    }
    
    @Override
    public String toString() {
        return "CoordinateGeographic[latitude: " + latitude.toString() + "; longitude: " + longitude.toString() + "]";
    }
}
