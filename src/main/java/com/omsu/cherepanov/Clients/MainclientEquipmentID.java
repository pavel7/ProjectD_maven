package com.omsu.cherepanov.Clients;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Павел on 02.05.2014.
 */
@Embeddable
public class MainclientEquipmentID implements Serializable {
//    private Mainclient mainclient;
//    private Equipment equipment;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    public Equipment getEquipment() {
//        return equipment;
//    }
//
//    public void setEquipment(Equipment equipment) {
//        this.equipment = equipment;
//    }
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    public Mainclient getMainclient() {
//        return mainclient;
//    }
//
//    public void setMainclient(Mainclient mainclient) {
//        this.mainclient = mainclient;
//    }

    private static final long serialVersionUID = -6437671620548733621L;
    private int mainclientID;
    private int equipmentID;

    @Column(name = "Mainclient_objectID")
    public int getMainclientID() {
        return mainclientID;
    }

    public void setMainclientID(int mainclientID) {
        this.mainclientID = mainclientID;
    }

    @Column(name = "Equipment_EquipmentID")
    public int getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        this.equipmentID = equipmentID;
    }
}
