package com.omsu.cherepanov.Clients;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Павел on 02.05.2014.
 */

@Entity
@Table(name = "mainclientequ")
//@AssociationOverrides({
//        @AssociationOverride(name = "mainclientEquipmentID.mainclient",
//                joinColumns = @JoinColumn(name = "Mainclient_objectID")),
//        @AssociationOverride(name = "mainclientEquipmentID.equipment",
//                joinColumns = @JoinColumn(name = "Equipment_EquipmentID"))})
public class MainclientEquipment implements Serializable {

    private MainclientEquipmentID mainclientEquipmentID;
    private Mainclient mainclient;
    private Equipment equipment;
    private int amount;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "Mainclient_objectID")
    @MapsId("mainclientID")
    public Mainclient getMainclient() {
        return mainclient;
    }

    public void setMainclient(Mainclient mainclient) {
        this.mainclient = mainclient;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "Equipment_EquipmentID")
    @MapsId("equipmentID")
    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Column(name = "Amount")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @EmbeddedId
    public MainclientEquipmentID getMainclientEquipmentID() {
        return mainclientEquipmentID;
    }

    public void setMainclientEquipmentID(MainclientEquipmentID mainclientEquipmentID) {
        this.mainclientEquipmentID = mainclientEquipmentID;
    }

}
