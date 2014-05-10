/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omsu.cherepanov.Clients;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Павел
 */

@Entity
@Table(name = "construction")
@PrimaryKeyJoinColumn(name = "Mainclient_objectID", referencedColumnName = "objectID")
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "construction_people", joinColumns = @JoinColumn(name = "Construction_Mainclient_objectID"), inverseJoinColumns = @JoinColumn(name = "People_Mainclient_objectID"))
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
