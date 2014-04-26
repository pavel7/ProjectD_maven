/*
 * Mainclient
 * Базис класс для всех объектов системы взаимодейсвия
 * and open the template in the editor.
 */
package com.omsu.cherepanov.Clients;

import javax.persistence.*;
import java.util.HashMap;

/**
 * @author Павел
 */
@Entity
@Table(name = "mainclient")
public class Mainclient {

    @Id
    private int objectID;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "Status_idStatus")
    private ObjectStatus isStatus;
    @Column(name = "xPoint")
    private double pointX;
    @Column(name = "yPoint")
    private double pointY;
    @ManyToMany
    @JoinTable(name="mainclientequ",joinColumns={@JoinColumn(name="Mainclient_objectID")},inverseJoinColumns={@JoinColumn(name="Amount")})
    @MapKeyJoinColumn(name="Equipment_EquipmentID")
    private HashMap<Equipment, Integer> equipment;

    public Mainclient() {
        objectID = 0;
        isStatus = ObjectStatus.isAlive;
        pointX = 0;
        pointY = 0;
        equipment = new HashMap<Equipment, Integer>();
    }

    public Mainclient(double newX, double newY, int newID) {
        objectID = newID;
        isStatus = ObjectStatus.isAlive;
        pointX = newX;
        pointY = newY;
        equipment = new HashMap<Equipment, Integer>();
    }

    public void setObjectID(int ID) {
        objectID = ID;
    }

    public int getObjectID() {
        return objectID;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    public ObjectStatus getStatus() {
        return isStatus;
    }

    public void setStatus(ObjectStatus newStatus) {
        isStatus = newStatus;
    }

    public HashMap<Equipment, Integer> getEquipment() {
        return equipment;
    }

    public void setEquipment(HashMap<Equipment, Integer> equipment) {
        this.equipment = equipment;
    }

    public void addEquipment(Equipment newEquipment, int newAmount) {
        if (equipment.containsKey(newEquipment)) {
            if (equipment.get(newEquipment) != null) {
                int temp = equipment.get(newEquipment);
                equipment.remove(newEquipment);
                equipment.put(newEquipment, newAmount + temp);
            } else {
                equipment.remove(newEquipment);
                equipment.put(newEquipment, newAmount);
            }

        } else {
            equipment.put(newEquipment, newAmount);
        }
    }

    public HashMap getAllEquipment() {
        return equipment;
    }

    public int getEquipment(Equipment curEquipment) {
        return equipment.get(curEquipment);
    }

    public void removeAllEquipment() {
        equipment.clear();
    }

    public void removeEquipment(Equipment curEquipment) {
        equipment.remove(curEquipment);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Mainclient temp = (Mainclient) obj;
        if (this.getObjectID() != temp.getObjectID()) {
            return false;
        }
        return true;
    }

    public ObjectStatus getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(ObjectStatus isStatus) {
        this.isStatus = isStatus;
    }

    @Override
    public int hashCode() {
        return 7 * objectID + 11 * isStatus.hashCode() + 13 * (int)pointX+ 17 * (int)pointY + 19 * equipment.hashCode();
    }

}
