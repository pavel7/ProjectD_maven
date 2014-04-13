/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omsu.cherepanov.Graph;

import com.omsu.cherepanov.Clients.Mainclient;
import com.omsu.cherepanov.Clients.ObjectStatus;
import com.omsu.cherepanov.Connection.Connection;

/**
 *
 * @author Павел
 */
public class ElementOfGraph implements Cloneable {

    private Mainclient vertex;
    private Connection edge;
    private final static byte initialDefenceMin = 0;
    private final static byte initialDefenceMax = 100;
    private final static Mainclient deadClient = new Mainclient(0, 0);
    private final static Connection destroyedConnection = new Connection(initialDefenceMin);
    private static Connection selfConnection = new Connection(initialDefenceMax);

    static {
        deadClient.setStatus(ObjectStatus.isDead);
        destroyedConnection.setStatus(ObjectStatus.isDead);
    }

    public ElementOfGraph() {
        vertex = deadClient;
        edge = destroyedConnection;
    }

    public ElementOfGraph(Mainclient newVertex, Connection newEdge) {
        vertex = newVertex;
        edge = newEdge;
    }

    public ElementOfGraph(Mainclient newVertex) {
        vertex = newVertex;
        edge = selfConnection;
    }

    public Mainclient getVertex() {
        return vertex;
    }

    public void setVertex(Mainclient newVertex) {
        vertex = newVertex;
    }

    public Connection getEdge() {
        return edge;
    }

    public void setEdge(Connection newEdge) {
        edge = newEdge;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ElementOfGraph temp = (ElementOfGraph) obj;
        if (this.edge.equals(temp.edge) && this.vertex.equals(temp.vertex)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + vertex.hashCode() + edge.hashCode();
    }
    
    @Override
    public ElementOfGraph clone() throws CloneNotSupportedException {
        ElementOfGraph newElem = (ElementOfGraph) super.clone();
        newElem.setEdge(this.getEdge());
        newElem.setVertex(this.getVertex());
        return newElem;
    }

}