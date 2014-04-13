/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omsu.cherepanov.Clients;

import java.util.HashSet;

/**
 *
 * @author Павел
 */
public class Construction extends Mainclient {

    private final String name;
    private HashSet<People> staff;

    public Construction(String newName, int newX, int newY) {
        super(newX, newY);
        name = newName;
        //staff = new HashSet<People>();
        staff = new HashSet();
    }

    public String getName() {
        return name;
    }

    public void addStaff(People newPeople) {
        staff.add(newPeople);
    }

    public void removeStaff(People curPeople) {
        staff.remove(curPeople);
    }

    public void removeAllStaff() {
        staff.clear();
    }

}