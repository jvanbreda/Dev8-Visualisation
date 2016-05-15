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
public class ControlInfo {

    private String[] content;
    private int marginLeft;
    private EarthquakeMap earthquakeMap;
    
    private final Vector2<Float> position = new Vector2<>(0.0f, 110f);

    private final int width = 400;
    private final int height = 539;
    private final int lineSpacing = 20;
    
    private boolean visible = true;

    public ControlInfo(String[] content, EarthquakeMap earthquakeMap, int marginLeft) {
        this.content = content;
        this.earthquakeMap = earthquakeMap;
        this.marginLeft = marginLeft;
    }
        

    public void draw() {
        if(!visible)
            return;
        
        earthquakeMap.strokeWeight(1);
        earthquakeMap.stroke(0);

        earthquakeMap.fill(255);
        earthquakeMap.rect(marginLeft + position.x, position.y, width, height);

        earthquakeMap.fill(0);

        for(int i = 1; i <= content.length; i++){
            earthquakeMap.text(content[i-1], marginLeft + position.x + lineSpacing, position.y + (i * lineSpacing));
        }
    }
    
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visable) {
        this.visible = visable;
    }
}
