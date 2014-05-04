/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omsu.cherepanov.Clients;

import javax.persistence.*;

/**
 * @author Павел
 */
@Entity
@Table(name = "people")
@PrimaryKeyJoinColumn(name="Mainclient_objectID", referencedColumnName="objectID")
public class People extends Mainclient {

    private String name;
    private String rank;

    public People() {
        super();
        name = "";
        rank = "";
    }

    public People(String newName, String newRank) {
        super();
        name = newName;
        rank = newRank;
    }

    public People(double newX, double newY, int newID, String newName, String newRank) {
        super(newX, newY, newID);
        name = newName;
        rank = newRank;
    }

    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "Rank")
    public String getRank() {
        return rank;
    }

    public void setRank(String newRank) {
        this.rank = newRank;
    }

    @Override
    public int hashCode() {
        return 7 * name.hashCode() + 11 * rank.hashCode();
    }

}
