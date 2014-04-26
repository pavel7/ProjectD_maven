/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.omsu.cherepanov.Clients;

/**
 * @author Павел
 */
public class Coordinates {
    private double x;
    private double y;

    public Coordinates() {
        x = 0;
        y = 0;
    }

    public Coordinates(double newX, double newY) {
        x = newX;
        y = newY;
    }

    public void setX(int newX) {
        this.x = newX;
    }

    public double getX() {
        return x;
    }

    public void setY(int newY) {
        this.y = newY;
    }

    public double getY() {
        return y;
    }
}
