/*
 * Mainclient
 * Базис класс для всех объектов системы взаимодейсвия
 * and open the template in the editor.
 */
package com.omsu.cherepanov.Clients;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Павел
 */
@DynamicUpdate
@Table(name = "mainclient")
public class Mainclient {

    private int objectID;
    private ObjectStatus isStatus;
    private double pointX;
    private double pointY;
    private List<MainclientEquipment> equipment = new ArrayList<MainclientEquipment>(0);

    public Mainclient() {
        objectID = 0;
        isStatus = ObjectStatus.isAlive;
        pointX = 0;
        pointY = 0;
    }

    public Mainclient(double newX, double newY, int newID) {
        objectID = newID;
        isStatus = ObjectStatus.isAlive;
        pointX = newX;
        pointY = newY;
    }

    public void setObjectID(int ID) {
        objectID = ID;
    }

    @Id
    public int getObjectID() {
        return objectID;
    }

    @Column(name = "xPoint")
    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    @Column(name = "yPoint")
    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "Status_idStatus")
    public ObjectStatus getStatus() {
        return isStatus;
    }

    public void setStatus(ObjectStatus newStatus) {
        isStatus = newStatus;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            targetEntity = MainclientEquipment.class, mappedBy = "MainclientEquipmentID.mainclient")
    public List<MainclientEquipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<MainclientEquipment> equipment) {
        this.equipment = equipment;
    }

    public void addEquipment(Equipment newEquipment, int Amount) {
//        newMainclientEquipment (equipmentAmount.contains(newMainclientEquipment)) {
//            int indexOfCurrentElem = equipmentAmount.indexOf(newMainclientEquipment);
//            if (equipmentAmount.ge= null) {
//                int temp = equipment.get(newEquipment);
//                equipment.remove(newEquipment);
//                equipment.put(newEquipment, newAmount + temp);
//            } else {
//                equipment.remove(newEquipment);
//                equipment.put(newEquipment, newAmount);
//            }
//
//        } else {
//            equipment.put(newEquipment, newAmount);
//        }
        int indexOfElem = -1;
        for (int i = 0; i < equipment.size(); i++) {
            if (equipment.get(i).getMainclientEquipmentID().getEquipment().equals(newEquipment)) {
                indexOfElem = i;
                break;
            }
        }
        if (indexOfElem != -1) {
            int prevAmount = equipment.get(indexOfElem).getAmount();
            equipment.get(indexOfElem).setAmount(prevAmount + Amount);
        } else {
            MainclientEquipment newMainclientEquipment = new MainclientEquipment();
            newMainclientEquipment.getMainclientEquipmentID().setEquipment(newEquipment);
            newMainclientEquipment.getMainclientEquipmentID().setMainclient(this);
            newMainclientEquipment.setAmount(Amount);
        }
    }

    public List getAllEquipment() {
        return equipment;
    }

    public int getEquipmentAmount(Equipment curEquipment) {
        int equipmentAmount = -1;
        for (int i = 0; i < equipment.size(); i++) {
            if (equipment.get(i).getMainclientEquipmentID().getEquipment().equals(curEquipment)) {
                equipmentAmount = equipment.get(i).getAmount();
                break;
            }
        }
        return equipmentAmount;
    }

    public void removeAllEquipment() {
        equipment.clear();
    }

    public void removeEquipment(Equipment curEquipment) {
        int indexOfElem = -1;
        for (int i = 0; i < equipment.size(); i++) {
            if (equipment.get(i).getMainclientEquipmentID().getEquipment().equals(curEquipment)) {
                indexOfElem = i;
                break;
            }
        }
        if (indexOfElem != -1) {
            equipment.remove(indexOfElem);
        }
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
        return 7 * objectID + 11 * isStatus.hashCode() + 13 * (int) pointX + 17 * (int) pointY + 19 * equipment.hashCode();
    }

}
