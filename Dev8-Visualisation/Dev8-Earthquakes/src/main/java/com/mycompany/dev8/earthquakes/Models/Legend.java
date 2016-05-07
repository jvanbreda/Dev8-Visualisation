/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dev8.earthquakes.Models;

import com.mycompany.dev8.earthquakes.EarthquakeMap;

/**
 *
 * @author Jesse
 */
public class Legend {
    
    private EarthquakeMap earthquakeMap;
    
    private final int width = 400;
    private final int height = 110;
    private final int padding = 8;
    private final int margin = 20;
    
    private final String[] content;
    
    public Legend(EarthquakeMap earthquakeMap, String[] content) {
        this.earthquakeMap = earthquakeMap;
        this.content = content;
    }
    
    public void draw(){
        earthquakeMap.fill(255);
        earthquakeMap.rect(0, 0, width ,height);
                
        earthquakeMap.fill(0);
        
        for(int i = 1; i <= content.length; i++){
            earthquakeMap.text(content[i-1], padding, (i * margin));
        }
        
        new ColorBar().draw();
    }
    
    private class ColorBar {
        
        private final int intervals = 5;
        
        private final int width = 255;
        private final int height = 10;
        
        private String[] numbers = {"0km", "2km", "4km", "6km", "8km", "10km", "12km"};
        private int counter = 0;
        
        public void draw(){
            for(int i = 0; i <= width; i += width / intervals){
                earthquakeMap.fill(255, 255 - i, 0);
                earthquakeMap.rect(padding + i, 75 , width/intervals, height);
                earthquakeMap.fill(0);
                earthquakeMap.text(numbers[counter], padding + i, 100);
                counter++;
            }
            earthquakeMap.text(numbers[counter], width + (width / intervals), 100);
            
        }
        
    }
 
    
}
