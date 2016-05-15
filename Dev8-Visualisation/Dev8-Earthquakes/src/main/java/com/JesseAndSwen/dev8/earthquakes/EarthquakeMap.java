/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JesseAndSwen.dev8.earthquakes;

import com.JesseAndSwen.dev8.earthquakes.Data.Converter;
import com.JesseAndSwen.dev8.earthquakes.Data.DataProvider;
import com.JesseAndSwen.dev8.earthquakes.Display.ControlInfo;
import com.JesseAndSwen.dev8.earthquakes.Models.Earthquake;
import com.JesseAndSwen.dev8.earthquakes.Display.Legend;
import com.JesseAndSwen.dev8.earthquakes.Display.Title;
import com.JesseAndSwen.dev8.earthquakes.Models.Coordinates.CoordinateRd;
import com.JesseAndSwen.dev8.earthquakes.Models.VisualisationMode;
import java.util.ArrayList;
import java.util.List;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

/**
 *
 * @author Jesse
 */
public class EarthquakeMap extends PApplet {
    private PImage image;

    private DataProvider dataProvider;

    private List<Earthquake> earthquakes;

    private Legend legend;
    private ControlInfo controlInfo;
    private Title title;

    public void setup() {
        legend = new Legend(this, new String[]{"Every circle represent an earthquake.", "The bigger the circles, the bigger the size of the earthquake", "Depths:"}, 799);
        controlInfo = new ControlInfo(new String[]{"Press 'H' to toggle the legend and this box.", "Press 'M' to switch between static and dymanic mode."}, this, 799);
        
        size(799 + legend.getWidth(), 649);

        title = new Title("Earthquakes in Iceland during the last 48h.", this);
        
        frame.setTitle("Earthquakes in and around Iceland from the past 48 hours");

        image = loadImage("2000px-map_of_iceland.png");

        dataProvider = new DataProvider(this);

        earthquakes = (ArrayList<Earthquake>) dataProvider.getEarthquakeData(DataProvider.DataType.TEST);
    }

    public void draw() {
        strokeWeight(1);
        stroke(0);

        background(255);
        
        image(image, 0, 0);
        
        drawDataSource();

        drawLocations();
        for (Earthquake earthquake : earthquakes) {
            earthquake.act();
        }
        
        legend.draw();
        controlInfo.draw();
        title.draw();
    }

    public void keyPressed() {
        if (key == 'h' || key == 'H') {
            if (legend.isVisible()) {
                legend.setVisible(false);
                controlInfo.setVisable(false);
            } else {
                legend.setVisible(true);
                controlInfo.setVisable(true);
            }
        }

        if (key == 'm' || key == 'M') {
            if (earthquakes.get(0).getVisualisationMode() == VisualisationMode.StaticMode) {
                legend.setVisible(false);
                controlInfo.setVisable(false);
                for (Earthquake earthquake : earthquakes) {
                    earthquake.setVisualisationMode(VisualisationMode.DynamicMode);
                }
            } else {
                legend.setVisible(true);
                controlInfo.setVisable(true);
                for (Earthquake earthquake : earthquakes) {
                    earthquake.setVisualisationMode(VisualisationMode.StaticMode);
                }
            }
        }
    }

    public void drawLocations() {
        for (Earthquake earthquake : earthquakes) {
            earthquake.draw();
        }
    }

    public void drawDataSource() {
        this.fill(0);
        this.text("This data is provided by the Icelandic Meteorological Office: http://www.vedur.is/", 5, height - 5);
    }
}
