/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JesseAndSwen.dev8.earthquakes.Emitters;

import com.JesseAndSwen.dev8.earthquakes.Models.Vector2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import processing.core.PApplet;

/**
 *
 * @author swenm_000
 */
public class Emitter {
    private PApplet applet;
    private EmitterType type = EmitterType.Circle;
    private Vector2<Float> position;
    private Vector2<Float> size;

    private List<Particle> particles = new ArrayList<>();
    
    private int counter = 0;
    
    private final int maxParticles = 10;

    public Emitter(PApplet applet, Vector2<Float> position, Vector2<Float> size) {
        this.applet = applet;
        this.position = position;
        this.size = size;
    }

    public void setType(EmitterType type) {
        this.type = type;
    }

    public void Draw() {
        for (Particle particle : particles) {
            particle.Draw();
        }
    }

    public void Act() {
        if (type.equals(EmitterType.Circle)) {
            if(counter % 90 == 0 && particles.size() < maxParticles)
                particles.add(new CircleParticle(applet, position, new Vector2<Float>(0f, 0f), size));
            
            Iterator<Particle> iterator = particles.iterator();
            
            while (iterator.hasNext()) {
                Particle particle = iterator.next();
                if (particle.size.x < ((CircleParticle) particle).getBounds().x && particle.size.y < ((CircleParticle) particle).getBounds().y) {
                    particle.Act();
                } else {
                    iterator.remove();
                }
            }
        }
        if(counter < Integer.MAX_VALUE)
            counter++;
        else
            counter = 0;
    }
}
