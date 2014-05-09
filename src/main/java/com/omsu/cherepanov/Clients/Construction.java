/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omsu.cherepanov.Clients;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Павел
 */
public class Construction extends Mainclient {

    private String name;
    private List<People> staff = new ArrayList<People>(0);

    public Construction() {
        super();
        name = "";
    }

    public Construction(String newName) {
        name = newName;
        //staff = new HashSet();
    }

    public void setStaff(List<People> staff) {
        this.staff = staff;
    }

    public List<People> getStaff() {

        return staff;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStaff(People newPeople) {
        this.staff.add(newPeople);
    }

    public void removeStaff(People curPeople) {
        this.staff.remove(curPeople);
    }

    public void removeAllStaff() {
        this.staff.clear();
    }

}
