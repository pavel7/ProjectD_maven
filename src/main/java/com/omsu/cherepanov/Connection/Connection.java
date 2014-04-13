/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omsu.cherepanov.Connection;

import com.omsu.cherepanov.Clients.ObjectStatus;

/**
 *
 * @author Павел
 */
public class Connection {

    private int objectID;
    private static int numberOfClients = 0;
    private byte defence;
    private ObjectStatus isStatus;

    public Connection(byte newDefence) {
        objectID = numberOfClients;
        numberOfClients++;
        defence = newDefence;
        isStatus = ObjectStatus.isAlive;
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

    public byte getDefence() {
        return defence;
    }

    public void setStatus(ObjectStatus newStatus) {
        isStatus = newStatus;
    }

    public ObjectStatus getStatus() {
        return isStatus;
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
        Connection temp = (Connection) obj;
        if (this.getObjectID() != temp.getObjectID()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + objectID + defence + isStatus.hashCode();
    }

}
