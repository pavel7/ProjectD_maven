
import com.omsu.cherepanov.Algorithms.Dijkstra;
import com.omsu.cherepanov.Clients.Equipment;
import com.omsu.cherepanov.Clients.Mainclient;
import com.omsu.cherepanov.Clients.ObjectStatus;
import com.omsu.cherepanov.Connection.Connection;
import com.omsu.cherepanov.Graph.DirectedGraph;
import com.omsu.cherepanov.Graph.ElementOfGraph;
import com.omsu.cherepanov.hybernate.ConnectionDAO;
import com.omsu.cherepanov.hybernate.HibernateUtil;

import java.util.HashMap;
import java.util.Iterator;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Павел
 */
public class ProjectX {

    public static void main(String[] args) {
        System.out.println("qwe");
        Mainclient test = new Mainclient(0,0);
        Mainclient test1 = new Mainclient(0,0);
        Connection testC = new Connection ((byte)50,1);
        Connection testC1 = new Connection ((byte)75,2);
//        ElementOfGraph testE = new ElementOfGraph(test,test,testC);
//        ElementOfGraph testE1 = new ElementOfGraph(test,test1,testC);
//       System.out.println(test.getObjectID());
//       System.out.println(test1.getObjectID());
//       System.out.println(test.getStatus());
//       System.out.println("isAlive".equals(test.getStatus().toString()) ? "true":"false");
        HashMap apples = new HashMap(); // будем хранить тут количество яблок у детей
        Equipment temp=new Equipment("Weapon","Gun",1);
        apples.put(temp,1);
        apples.put("Mike", 4);
        apples.put("John", 7);

// теперь можно посмотреть сколько яблок у Тома
        System.out.println("Tom have " + apples.get(temp) + " count");
        System.out.println(test.equals(test));
        System.out.println(test.equals(test1));
        System.out.println(test1.equals(test));
        System.out.println(test1.equals(null));
        System.out.println(testC.equals(testC));
        System.out.println(testC.equals(testC1));
        System.out.println(testC1.equals(testC));
        System.out.println(testC1.equals(null));
//        System.out.println(testE.equals(testE));
//        System.out.println(testE.equals(testE1));
//        System.out.println(testE1.equals(testE));
//        System.out.println(testE1.equals(null));
        ElementOfGraph test2=new ElementOfGraph(test,testC);
        ElementOfGraph test3=new ElementOfGraph(test1,testC1);
        ElementOfGraph test4=new ElementOfGraph(test1,testC);
        ElementOfGraph test5=new ElementOfGraph();
        Connection testC2=new Connection((byte)90,3);
//        DirectedGraph test12=new DirectedGraph(2);
//        test12.addVertex(test2);
//        test12.addVertex(test3);
//        test12.addVertex(test4);
//        test12.addVertexToVertex(test2, test3);
//        test12.addVertexToVertex(test2, test4);
//        DirectedGraph test123=new DirectedGraph(2);
//        Map tt=new Map(1,2);
//        Dijkstra temp11=new Dijkstra(test12,test,test1);
//        Iterator testt=test12.getIteratorOfElem(0);
//        int[]path=temp11.pathFromTo();
        Mainclient test10 = new Mainclient(0,0);
        Mainclient test11 = new Mainclient(0,1);
        Mainclient test12 = new Mainclient(0,2);
        Mainclient test13 = new Mainclient(0,3);
        Mainclient test14 = new Mainclient(0,4);
        Mainclient test15 = new Mainclient(0,5);
        Connection testC11 = new Connection ((byte)50,4);
        Connection testC12 = new Connection ((byte)20,5);
        Connection testC13 = new Connection ((byte)40,6);
        Connection testC14 = new Connection ((byte)25,7);
        Connection testC15 = new Connection ((byte)70,8);
        Connection testC16 = new Connection ((byte)50,9);
        Connection testC17 = new Connection ((byte)60,10);
        Connection testC18 = new Connection ((byte)40,11);
        Connection testC19 = new Connection ((byte)45,12);//changes
        Connection testC20 = new Connection ((byte)100,13);
        ElementOfGraph tes1=new ElementOfGraph(test10);
        ElementOfGraph tes2=new ElementOfGraph(test11);
        ElementOfGraph tes3=new ElementOfGraph(test12);
        ElementOfGraph tes4=new ElementOfGraph(test13);
        ElementOfGraph tes5=new ElementOfGraph(test14);
        ElementOfGraph tes6=new ElementOfGraph(test15);
        DirectedGraph test200=new DirectedGraph(2);
        test200.addVertex(tes1);
        test200.addVertex(tes2);
        test200.addVertex(tes3);
        test200.addVertex(tes4);
        test200.addVertex(tes5);
        test200.addVertex(tes6);
        ElementOfGraph tes21=new ElementOfGraph(test11,testC12);
        test200.addVertexToVertex(tes1, tes21);
        ElementOfGraph tes31=new ElementOfGraph(test12,testC11);
        test200.addVertexToVertex(tes1, tes31);
        ElementOfGraph tes41=new ElementOfGraph(test13,testC13);
        test200.addVertexToVertex(tes1, tes41);
        ElementOfGraph tes42=new ElementOfGraph(test13,testC15);
        test200.addVertexToVertex(tes2, tes42);
        ElementOfGraph tes43=new ElementOfGraph(test13,testC16);
        test200.addVertexToVertex(tes3, tes43);
        ElementOfGraph tes52=new ElementOfGraph(test14,testC14);
        test200.addVertexToVertex(tes2, tes52);
        ElementOfGraph tes53=new ElementOfGraph(test14,testC20);
        test200.addVertexToVertex(tes3, tes53);
        ElementOfGraph tes63=new ElementOfGraph(test15,testC18);
        test200.addVertexToVertex(tes3, tes63);
        ElementOfGraph tes64=new ElementOfGraph(test15,testC17);
        test200.addVertexToVertex(tes4, tes64);
        ElementOfGraph tes65=new ElementOfGraph(test15,testC19);
        test200.addVertexToVertex(tes5, tes65);
        Dijkstra temp11=new Dijkstra(test200,test10,test15);
        Iterator testt=test200.getIteratorOfElem(0);
        int[]path=temp11.pathFromTo();

        Equipment test5555=new Equipment("qwe","qwe",1);
        ConnectionDAO userDAO = new ConnectionDAO();
        try {
            testC11.setIsStatus(ObjectStatus.isDead);
            userDAO.saveConnection(testC11);
            testC12.setIsStatus(ObjectStatus.isUnknow);
            userDAO.saveConnection(testC12);
            System.out.print("1");

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print("1");
        Mainclient test151 = new Mainclient(0,6);
        Connection testC111 = new Connection ((byte)150,14);
        test200.addVertex(new ElementOfGraph(test151,testC111));
        Dijkstra temp111=new Dijkstra(test200,test10,test151);
        int[]path1=temp111.pathFromTo();
        System.out.print("1");
        HibernateUtil.closeSession();
    }
}
