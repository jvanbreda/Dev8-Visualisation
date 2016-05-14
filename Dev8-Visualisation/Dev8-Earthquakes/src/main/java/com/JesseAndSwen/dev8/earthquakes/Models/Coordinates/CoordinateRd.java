/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JesseAndSwen.dev8.earthquakes.Models.Coordinates;

/**
 *
 * @author swenm_000
 */
public class CoordinateRd {
    private long rdX;
    private long rdY;

    public CoordinateRd(long rdX, long rdY) {
        this.rdX = rdX;
        this.rdY = rdY;
    }

    public long getRdX() {
        return rdX;
    }

    public void setRdX(long rdX) {
        this.rdX = rdX;
    }

    public long getRdY() {
        return rdY;
    }

    public void setRdY(long rdY) {
        this.rdY = rdY;
    }
    
    
}
