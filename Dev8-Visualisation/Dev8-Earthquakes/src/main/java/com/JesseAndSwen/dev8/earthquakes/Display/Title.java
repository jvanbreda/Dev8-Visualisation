/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JesseAndSwen.dev8.earthquakes.Display;

import com.JesseAndSwen.dev8.earthquakes.EarthquakeMap;
import com.JesseAndSwen.dev8.earthquakes.Models.Vector2;

/**
 *
 * @author Jesse
 */
public class Title {
    
    private String content;
    private EarthquakeMap earthquakeMap;
    
    private Vector2<Float> position = new Vector2<>(0f,0f);

    public Title(String content, EarthquakeMap earthquakeMap) {
        this.content = content;
        this.earthquakeMap = earthquakeMap;
        position.x = earthquakeMap.width / 8f;
        position.y = 75f;
    }
    
    public void draw(){
        earthquakeMap.fill(0);
        earthquakeMap.textSize(26);
        earthquakeMap.text(content, position.x, position.y);
        earthquakeMap.textSize(12);
    }
    
    
    
}
