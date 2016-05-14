/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JesseAndSwen.dev8.earthquakes.Models;

import com.JesseAndSwen.dev8.earthquakes.EarthquakeMap;
import java.util.List;
import processing.core.PApplet;

/**
 *
 * @author swenm_000
 */
public class Popover {

    private PApplet applet;
    private String[] content;

    // Default values
    private int padding = 8;
    private int textSize = 12;
    private int textSpacing = 4;

    private float width;
    private float height;

    public Popover(PApplet applet, String[] content) {
        this.applet = applet;
        this.content = content;

        Initialize();
    }

    public Popover(PApplet applet, String[] content, int padding) {
        this.applet = applet;
        this.content = content;
        this.padding = padding;
        
        Initialize();
    }

    public void draw() {
        applet.strokeWeight(1);
        applet.stroke(0);
        // Check if the popover fits on the screen
        if (applet.mouseX + width < applet.width) {
            // It fits, draw to the right side
            applet.fill(255);
            applet.rect(applet.mouseX, applet.mouseY, width, -height);

            applet.fill(0);
            for (int i = 1; i <= content.length; i++) {
                applet.text(content[i - 1], applet.mouseX + padding, applet.mouseY - height + padding + textSize * i + textSpacing * (i - 1));
            }
        } else {
            // It doesn't fit, draw to the left side
            applet.fill(255);
            applet.rect(applet.mouseX, applet.mouseY, -width, -height);

            applet.fill(0);
            for (int i = 1; i <= content.length; i++) {
                applet.text(content[i - 1], applet.mouseX + padding - width, applet.mouseY - height + padding + textSize * i + textSpacing * (i - 1));
            }
        }
    }

    private void Initialize() {
        float maxWidth = 0;

        for (String item : content) {
            float tempWidth = applet.textWidth(item);
            if (tempWidth > maxWidth) {
                maxWidth = tempWidth;
            }
        }

        width = 1 * 2 + padding * 2 + maxWidth;
        height = 1 * 2 + padding * 2 + textSize * content.length + textSpacing * (content.length - 1);
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
