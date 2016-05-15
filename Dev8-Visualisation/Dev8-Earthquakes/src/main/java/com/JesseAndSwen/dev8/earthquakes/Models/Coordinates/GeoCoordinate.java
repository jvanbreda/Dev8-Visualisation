/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JesseAndSwen.dev8.earthquakes.Models.Coordinates;

/**
 *
 * @author Jesse
 * Class used to describe a geoCoordinate, which exists of degrees, minutes and seconds. 
 * Format: 52 9 8.9
 */
public class GeoCoordinate {

    private int degrees;
    private int minutes;
    private float seconds;

    public GeoCoordinate(int degrees, int minutes, float seconds) {
        this.degrees = degrees;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getDegrees() {
        return degrees;
    }

    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public float getSeconds() {
        return seconds;
    }

    public void setSeconds(float seconds) {
        this.seconds = seconds;
    }
    
    @Override
    public String toString() {
        return degrees + "° " + minutes + "' " + seconds + "\""; 
    }
}
