/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dev8.earthquakes.Models;

import com.mycompany.dev8.earthquakes.EarthquakeMap;
import java.util.List;

/**
 *
 * @author swenm_000
 */
public class Popover {

    private EarthquakeMap earthquakeMap;
    private String[] content;

    // Default values
    private int padding = 8;
    private int textSize = 12;
    private int textSpacing = 4;

    private float width;
    private float height;

    public Popover(EarthquakeMap earthquakeMap, String[] content) {
        this.earthquakeMap = earthquakeMap;
        this.content = content;

        Initialize();
    }

    public Popover(EarthquakeMap earthquakeMap, String[] content, int padding) {
        this.earthquakeMap = earthquakeMap;
        this.content = content;
        this.padding = padding;
        
        Initialize();
    }

    public void draw() {
        // Check if the popover fits on the screen
        if (earthquakeMap.mouseX + width < earthquakeMap.width) {
            // It fits, draw to the right side
            earthquakeMap.fill(255);
            earthquakeMap.rect(earthquakeMap.mouseX, earthquakeMap.mouseY, width, -height);

            earthquakeMap.fill(0);
            for (int i = 1; i <= content.length; i++) {
                earthquakeMap.text(content[i - 1], earthquakeMap.mouseX + padding, earthquakeMap.mouseY - height + padding + textSize * i + textSpacing * (i - 1));
            }
        } else {
            // It doesn't fit, draw to the left side
            earthquakeMap.fill(255);
            earthquakeMap.rect(earthquakeMap.mouseX, earthquakeMap.mouseY, -width, -height);

            earthquakeMap.fill(0);
            for (int i = 1; i <= content.length; i++) {
                earthquakeMap.text(content[i - 1], earthquakeMap.mouseX + padding - width, earthquakeMap.mouseY - height + padding + textSize * i + textSpacing * (i - 1));
            }
        }
    }

    private void Initialize() {
        float maxWidth = 0;

        for (String item : content) {
            float tempWidth = earthquakeMap.textWidth(item);
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
