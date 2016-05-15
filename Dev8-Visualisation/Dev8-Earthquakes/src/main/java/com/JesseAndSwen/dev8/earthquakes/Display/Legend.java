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
public class Legend {
    private boolean visible = true;
    private EarthquakeMap earthquakeMap;
    
    private Vector2<Float> position = new Vector2<>(0f, 0f);
    private final int width = 400;
    private final int height = 110;
    private final int padding = 8;
    
    private int marginLeft = 0;
    
    private final int lineSpacing = 20;
    
    private final ColorBar colorBar;
    private final String[] content;
    
    public Legend(EarthquakeMap earthquakeMap, String[] content, int marginLeft) {      
        this.earthquakeMap = earthquakeMap;
        this.content = content;
        this.marginLeft = marginLeft;
        
        colorBar = new ColorBar();
    }
    
    public void draw(){
        if(!visible)
            return;
        
        earthquakeMap.strokeWeight(1);
        earthquakeMap.stroke(0);
        
        earthquakeMap.fill(255);
        earthquakeMap.rect(marginLeft + position.x, position.y, width, height);
                
        earthquakeMap.fill(0);
        
        for(int i = 1; i <= content.length; i++){
            earthquakeMap.text(content[i-1], marginLeft + position.x + padding, position.y + (i * lineSpacing));
        }
        
        colorBar.draw();
    }
    
    private class ColorBar {
        
        private final int intervals = 5;
        
        private final int width = 255;
        private final int height = 10;
        
        private String[] numbers = {"0km", "2km", "4km", "6km", "8km", "10km", "12km"};
        
        public void draw(){
            earthquakeMap.strokeWeight(1);
            earthquakeMap.stroke(0);
            int counter = 0;
            for(int i = 0; i <= width; i += width / intervals){
                earthquakeMap.fill(255, 255 - i, 0);
                earthquakeMap.rect(marginLeft + position.x + padding + i, 75 , width/intervals, height);
                earthquakeMap.fill(0);
                earthquakeMap.text(numbers[counter], marginLeft + position.x + padding + i, 100);
                counter++;
            }
            earthquakeMap.text(numbers[counter], marginLeft + position.x + width + (width / intervals), 100);
        }
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getWidth() {
        return width;
    }
}
