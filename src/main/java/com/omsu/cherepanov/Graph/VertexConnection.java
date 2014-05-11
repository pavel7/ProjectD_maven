package com.omsu.cherepanov.Graph;

import com.omsu.cherepanov.Clients.Mainclient;
import com.omsu.cherepanov.Connection.Connection;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Павел on 11.05.2014.
 */
@Entity
@Table(name = "vertexconnection")
public class VertexConnection {

    private int id;
    private Mainclient mainclient;
    private List<ElementOfGraph> vertexConnection = new ArrayList<ElementOfGraph>(0);

    public VertexConnection() {

    }

    public VertexConnection(VertexConnection vertexConnection) {
        this.id = vertexConnection.getId();
        this.mainclient = vertexConnection.getMainclient();
        this.vertexConnection = vertexConnection.getVertexConnection();
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,
            targetEntity = ElementOfGraph.class, mappedBy = "vertexConnection")
    public List<ElementOfGraph> getVertexConnection() {
        return vertexConnection;
    }

    public void setVertexConnection(List<ElementOfGraph> vertexConnection) {
        this.vertexConnection = vertexConnection;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Mainclient getMainclient() {
        return mainclient;
    }

    public void setMainclient(Mainclient mainclient) {
        this.mainclient = mainclient;
    }

    public boolean addVertex(Mainclient mainclient, Connection connection) {
        if ((mainclient == null) || (connection == null)) {
            return false;
        }
        int indexOfElem = -1;
        for (int i = 0; i < vertexConnection.size(); i++) {
            if ((vertexConnection.get(i).getEdge().equals(connection)) && (vertexConnection.get(i).getVertex().equals(mainclient))) {
                indexOfElem = i;
                break;
            }
        }
        if (indexOfElem == -1) {
            ElementOfGraphID elementOfGraphID = new ElementOfGraphID();
            ElementOfGraph elementOfGraph = new ElementOfGraph();
            elementOfGraphID.setMainclientID(mainclient.getObjectID());
            elementOfGraphID.setConnectionID(connection.getObjectID());
            elementOfGraphID.setVertexconnectionID(this.getId());
            elementOfGraph.setEdge(connection);
            elementOfGraph.setVertex(mainclient);
            elementOfGraph.setElementOfGraphID(elementOfGraphID);
            elementOfGraph.setVertexConnection(this);
            vertexConnection.add(elementOfGraph);
        }
        return true;
    }
}
