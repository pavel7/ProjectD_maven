
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omsu.cherepanov.Graph;

import com.omsu.cherepanov.Clients.Mainclient;
import com.omsu.cherepanov.Connection.Connection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Павел
 */
//добавления виртуальных целей
public class DirectedGraph {

    private int amountOfVertex;
    private int amountOfEdge;
    private final static byte maxDefence = 100;
    private static Connection selfEdge = new Connection(maxDefence);
    private ArrayList<ArrayList<ElementOfGraph>> graph;

    public DirectedGraph(int amountOfVertex) {
        if (amountOfVertex < 0) {
            throw new IllegalArgumentException("Number of vertices must be nonnegative");
        }
        this.amountOfVertex = amountOfVertex;
        amountOfEdge = 0;
        //this.amountOfEdge = amountOfEdge;
        graph = new ArrayList<ArrayList<ElementOfGraph>>(amountOfVertex);
        //graph = new ArrayList(amountOfVertex);
        for (int i = 0; i < amountOfVertex; i++) {
            graph.add((ArrayList<ElementOfGraph>) new ArrayList());
//            for(int j = 0; j<graph.get(i).size();j++)
//            {
//                graph.get(i).set(j,new ArrayList<ElementOfGraph>());
//            }
        }
    }

    public int getAmountOfVertex() {
        return amountOfVertex;
    }

    public int getAmountOfEdge() {
        return amountOfEdge;
    }

    public boolean isPresent(Mainclient client) {
        if (graph.isEmpty()) {
            return false;
        }
        for (int i = 0; i < amountOfVertex; i++) {
            if (graph.get(i).isEmpty() == false) {
                if (graph.get(i).get(0).getVertex().equals(client)) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean addVertex(ElementOfGraph vertex) {
        if (vertex == null) {
            return false;
        }
        if (this.isPresent(vertex.getVertex())) {
            return false;
        }
        //vertex.setEdge(selfEdge);
        try {
            for (int i = 0; i < amountOfVertex; i++) {
                if (graph.get(i).isEmpty()) {
                    //graph.get(i).set(i, (ArrayList<ElementOfGraph>) new ArrayList());
                    try {
                        graph.get(i).add(vertex.clone());
                        graph.get(i).get(0).setEdge(selfEdge);
                        return true;
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(DirectedGraph.class.getName()).log(Level.SEVERE, null, ex);
                        return false;
                    }
                }
            }
            try {
                graph.add((ArrayList<ElementOfGraph>) new ArrayList());
                graph.get(amountOfVertex).add(vertex.clone());
                graph.get(amountOfVertex).get(0).setEdge(selfEdge);
                amountOfVertex++;
                return true;
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(DirectedGraph.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } catch (RuntimeException e) {
            Logger.getLogger(DirectedGraph.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

    }

    public boolean addVertexToVertex(ElementOfGraph fromVertex, ElementOfGraph toVertex) {
        if ((fromVertex == null) || (toVertex == null)) {
            return false;
        }

        if ((this.isPresent(fromVertex.getVertex())) && (this.isPresent(toVertex.getVertex()))) {
            int position = this.indexOfElementGraph(fromVertex.getVertex());
            if (position >= 0) {
                try {
                    graph.get(position).add(toVertex.clone());
                    amountOfEdge++;
                    return true;
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(DirectedGraph.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }

            }
            return false;
        } else if ((this.isPresent(fromVertex.getVertex())) && (this.isPresent(toVertex.getVertex()) == false)) {
            this.addVertex(toVertex);
            int position = this.indexOfElementGraph(fromVertex.getVertex());
            if (position >= 0) {
                try {
                    graph.get(position).add(toVertex.clone());
                    amountOfEdge++;
                    return true;
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(DirectedGraph.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }
            return false;
        } else if ((this.isPresent(fromVertex.getVertex()) == false) && (this.isPresent(toVertex.getVertex()))) {
            this.addVertex(fromVertex);
            int position = this.indexOfElementGraph(fromVertex.getVertex());
            if (position >= 0) {
                try {
                    graph.get(position).add(toVertex.clone());
                    amountOfEdge++;
                    return true;
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(DirectedGraph.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }
            return false;
        } else if ((this.isPresent(fromVertex.getVertex()) == false) && (this.isPresent(toVertex.getVertex()) == false)) {
            this.addVertex(fromVertex);
            this.addVertex(toVertex);
            int position = this.indexOfElementGraph(fromVertex.getVertex());
            if (position >= 0) {
                try {
                    graph.get(position).add(toVertex.clone());
                    amountOfEdge++;
                    return true;
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(DirectedGraph.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }
            return false;
        }

        return false;

    }

//    public boolean addEdgeBetweenVertices(ElementOfGraph fromVertex, ElementOfGraph toVertex, Connection edge) {
//        if ((fromVertex == null) || (toVertex == null) || (edge == null)) {
//            return false;
//        }
//        if ((this.isPresent(fromVertex)) && (this.isPresent(toVertex))) {
//            int position = this.indexOfElementGraph(fromVertex);
//            if (position >= 0) {
//                int positionOfTo = graph.get(position).indexOf(toVertex);
//                graph.get(position).get(positionOfTo).setEdge(edge);
//                amountOfEdge++;
//                return true;
//            }
//            return false;
//        } else if ((this.isPresent(fromVertex)) && (this.isPresent(toVertex) == false)) {
//            this.addVertex(toVertex);
//            this.addVertexToVertex(fromVertex, toVertex);
//            int position = this.indexOfElementGraph(fromVertex);
//            if (position >= 0) {
//                int positionOfTo = graph.get(position).indexOf(toVertex);
//                graph.get(position).get(positionOfTo).setEdge(edge);
//                amountOfEdge++;
//                return true;
//            }
//            return false;
//        } else if ((this.isPresent(fromVertex) == false) && (this.isPresent(toVertex))) {
//            this.addVertex(fromVertex);
//            this.addVertexToVertex(fromVertex, toVertex);
//            int position = this.indexOfElementGraph(fromVertex);
//            if (position >= 0) {
//                int positionOfTo = graph.get(position).indexOf(toVertex);
//                graph.get(position).get(positionOfTo).setEdge(edge);
//                amountOfEdge++;
//                return true;
//            }
//            return false;
//        } else if ((this.isPresent(fromVertex) == false) && (this.isPresent(toVertex) == false)) {
//            this.addVertex(fromVertex);
//            this.addVertex(toVertex);
//            this.addVertexToVertex(fromVertex, toVertex);
//            int position = this.indexOfElementGraph(fromVertex);
//            if (position >= 0) {
//                int positionOfTo = graph.get(position).indexOf(toVertex);
//                graph.get(position).get(positionOfTo).setEdge(edge);
//                amountOfEdge++;
//                return true;
//            }
//            return false;
//        }
//        return false;
//    }
    public int indexOfElementGraph(Mainclient desiredClient) {
        if (desiredClient == null) {
            return -1;
        }
        if (this.isPresent(desiredClient) == false) {
            return -1;
        }
        for (int i = 0; i < amountOfVertex; i++) {
            if (graph.get(i).isEmpty() == false) {
                if (graph.get(i).get(0).getVertex().equals(desiredClient)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public Iterator getIteratorOfElem(int indexOfElem) {
        return graph.get(indexOfElem).iterator();
    }

}
