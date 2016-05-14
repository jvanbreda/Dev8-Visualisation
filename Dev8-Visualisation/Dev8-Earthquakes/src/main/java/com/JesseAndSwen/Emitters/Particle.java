/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JesseAndSwen.Emitters;

import com.JesseAndSwen.dev8.earthquakes.Models.Vector2;
import javax.swing.text.Position;
import processing.core.PApplet;

/**
 *
 * @author swenm_000
 */
public abstract class Particle {
    protected PApplet applet;
    
    protected Vector2<Float> position;
    protected Vector2<Float> size;
    protected int alpha = 255;

    public Particle(PApplet applet, Vector2<Float> position, Vector2<Float> size) {
        this.applet = applet;
        this.position = position;
        this.size = size;
    }
    
    abstract public void Act();
    
    abstract public void Draw();
}
