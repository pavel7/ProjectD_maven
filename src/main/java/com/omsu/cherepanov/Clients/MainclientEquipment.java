package com.omsu.cherepanov.Clients;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Created by Павел on 02.05.2014.
 */

@DynamicUpdate
@Table(name = "mainclientequ")
@AssociationOverrides({
        @AssociationOverride(name = "mainclientEquipmentID.mainclient",
                joinColumns = @JoinColumn(name = "Mainclient_objectID")),
        @AssociationOverride(name = "mainclientEquipmentID.equipment",
                joinColumns = @JoinColumn(name = "Equipment_EquipmentID"))})
public class MainclientEquipment {
    private MainclientEquipmentID mainclientEquipmentID;
    private int Amount;

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    @EmbeddedId
    public MainclientEquipmentID getMainclientEquipmentID() {
        return mainclientEquipmentID;
    }

    public void setMainclientEquipmentID(MainclientEquipmentID mainclientEquipmentID) {
        this.mainclientEquipmentID = mainclientEquipmentID;
    }

}
