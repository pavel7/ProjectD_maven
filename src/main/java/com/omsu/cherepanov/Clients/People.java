/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omsu.cherepanov.Clients;

/**
 *
 * @author Павел
 */
public class People extends Mainclient {

    private final String name;
    private String rank;

    public People(String newName, Coordinates newPoint, String newRank) {
        super(newPoint.getX(), newPoint.getY());
        name = newName;
        rank = newRank;
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String newRank) {
        rank = newRank;
    }

    @Override
    public int hashCode() {
        return 7*name.hashCode() + 11*rank.hashCode();
    }

}
