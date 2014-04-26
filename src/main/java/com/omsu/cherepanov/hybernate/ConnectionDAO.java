package com.omsu.cherepanov.hybernate;

/**
 * Created by Павел on 24.04.2014.
 */

import com.omsu.cherepanov.Connection.Connection;
import org.hibernate.Query;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 * Created by Павел on 22.04.2014.
 */
public class ConnectionDAO extends DAO {

    public Connection createConnection(byte newDefence, int id)
            throws Exception {
        try {
            begin();
            Connection connection = new Connection(newDefence, id);
            getSession().save(connection);
            commit();
            return connection;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not create Connection Defence:" + newDefence + ", Identifier:" + id, e);
        } finally {
            close();
        }
    }

    public void saveConnection(Connection connection)
            throws Exception {
        try {
            begin();
            getSession().save(connection);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not save Connection Defence:" + connection.getDefence() + ", Identifier:" + connection.getObjectID(), e);
        } finally {
            close();
        }
    }

    public Connection retrieveConnection(int id) throws Exception {
        try {
            begin();
            Query q = getSession().createQuery("from connection where objectID = :id");
            q.setInteger("id", id);
            Connection newConnection = (Connection) q.uniqueResult();
            commit();
            return newConnection;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get Connection Identifier:" + id, e);
        } finally {
            close();
        }
    }

    public void deleteConnection(Connection connection) throws Exception {
        try {
            begin();
            getSession().delete(connection);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not delete Connection Identifier:" + connection.getObjectID(), e);
        } finally {
            close();
        }
    }
}

