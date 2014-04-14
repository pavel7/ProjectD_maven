/*
 * Mainclient
 * Базис класс для всех объектов системы взаимодейсвия
 * and open the template in the editor.
 */
package com.omsu.cherepanov.Clients;

import java.util.HashMap;

/**
 *
 * @author Павел
 */
public class Mainclient {

    private int objectID;
    private static int numberOfClients = 0;
    private ObjectStatus isStatus;
    private Coordinates point;
    private HashMap<Equipment, Integer> equipment;

    public Mainclient() {
        objectID = 0;
        isStatus = ObjectStatus.isAlive;
        point = new Coordinates();
        equipment = new HashMap<Equipment, Integer>();
    }

    public Mainclient(double newX, double newY) {
        objectID = numberOfClients;
        numberOfClients++;
        isStatus = ObjectStatus.isAlive;
        point = new Coordinates(newX, newY);
        equipment = new HashMap<Equipment, Integer>();
    }

    public void setObjectID(int ID) {
        objectID = ID;
    }

    public int getObjectID() {
        return objectID;
    }

    protected int getNumberOfClients() {
        return numberOfClients;
    }

    public ObjectStatus getStatus() {
        return isStatus;
    }

    public void setStatus(ObjectStatus newStatus) {
        isStatus = newStatus;
    }

    public Coordinates getPoint() {
        return point;
    }

    public void setPoint(Coordinates point) {
        this.point = point;
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
        return 7*objectID + 11*isStatus.hashCode() + 13*point.hashCode() + 17*equipment.hashCode();
    }

}
