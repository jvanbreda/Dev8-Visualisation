/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JesseAndSwen.dev8.earthquakes.Emitters;

import com.JesseAndSwen.dev8.earthquakes.Models.Vector2;
import processing.core.PApplet;

/**
 *
 * @author swenm_000
 */
public class CircleParticle extends Particle {
    private final float sizeIncrement = 0.2f;

    private Vector2<Float> bounds;

    public CircleParticle(PApplet applet, Vector2<Float> position, Vector2<Float> size, Vector2<Float> bounds) {
        super(applet, position, size);
        this.bounds = bounds;
    }

    @Override
    public void Act() {
        size.x += sizeIncrement;
        size.y += sizeIncrement;
        
        if (bounds.x - size.x < sizeIncrement * 30 || bounds.y - size.y < sizeIncrement * 30) {
            if(alpha > 255 / 30)
                alpha -= 255 / 30;
            else
                alpha = 0;
        }
    }
    
    @Override
    public void Draw() {
        applet.noFill();
        applet.stroke(0, alpha);
        applet.strokeWeight(0.8f);
        applet.ellipse(position.x, position.y, size.x, size.y);
    }

    public Vector2<Float> getBounds() {
        return bounds;
    }
}
