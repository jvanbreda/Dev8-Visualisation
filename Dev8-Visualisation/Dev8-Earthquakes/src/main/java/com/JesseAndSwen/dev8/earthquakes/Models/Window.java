/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JesseAndSwen.dev8.earthquakes.Models;

import processing.core.PApplet;

/**
 *
 * @author swenm_000
 */
public class Window {
    protected Vector2<Float> position;
    protected Vector2<Float> size;
    
    private final int padding = 8;
    private final int barHeight = 32;
    
    private PApplet applet;
    
    //private Vector2<Float> grabPosition;
    private boolean isDraggable = true;

    public Window(PApplet applet) {
        this.applet = applet;
    }

    public Window(PApplet applet, Vector2<Float> position, Vector2<Float> size) {
        this.applet = applet;
        this.position = position;
        this.size = size;
    }
    
    public Window(PApplet applet, Vector2<Float> position, Vector2<Float> size, boolean isDraggable) {
        this.applet = applet;
        this.position = position;
        this.size = size;
        this.isDraggable = isDraggable;
    }
    
    public void Act() {
        if(isDraggable && applet.mousePressed) {
            if(applet.mouseX > position.x && applet.mouseX < position.x + size.x && applet.mouseY > position.y && applet.mouseY < position.y + barHeight) {
                position = new Vector2<Float>((float)applet.mouseX, (float)applet.mouseY);
            }
        }
    }
    
    public void Draw() {
        applet.fill(255);
        applet.rect(position.x, position.y, size.x, position.y + barHeight);
    }

    public int getBarHeight() {
        return barHeight;
    }
}
