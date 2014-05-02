package com.omsu.cherepanov.Clients;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * Created by Павел on 02.05.2014.
 */
@Embeddable
public class MainclientEquipmentID {
    private Mainclient mainclient;
    private Equipment equipment;

    @ManyToOne
    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @ManyToOne
    public Mainclient getMainclient() {
        return mainclient;
    }

    public void setMainclient(Mainclient mainclient) {
        this.mainclient = mainclient;
    }

}
