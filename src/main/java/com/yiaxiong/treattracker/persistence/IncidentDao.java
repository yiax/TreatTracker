package com.yiaxiong.treattracker.persistence;

import com.yiaxiong.treattracker.entity.Incident;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class IncidentDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public IncidentDao() {}

    /**
     * Get Incident by id
     */
    public Incident getById(int id) {
        Session session = sessionFactory.openSession();
        Incident incident = session.get(Incident.class, id);
        logger.debug("Incident id # " + id + ": " + incident);
        session.close();
        return incident;
    }

    /**
     * Update Incident
     * @param incident  incident to be updated
     */
    public void saveOrUpdate(Incident incident) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(incident);
        transaction.commit();
        logger.debug("Updated Incident: " + incident);
        session.close();
    }

    /**
     * Insert Incident
     * @param incident  Incident to be inserted
     */
    public int insert(Incident incident) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int) session.save(incident);
        transaction.commit();
        logger.debug("Incident Inserted: " + incident);
        session.close();
        return id;
    }

    /**
     * Delete an Incident
     * @param incident Incident to be deleted
     */
    public void delete(Incident incident) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(incident);
        logger.debug("Deleted Incident: " + incident);
        transaction.commit();
        session.close();
    }

    /**
     * Return a list of all Incidents
     * @return All Incidents
     */
    public List<Incident> getAllIncidents() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Incident> query = builder.createQuery(Incident.class);
        Root<Incident> root = query.from(Incident.class);
        List<Incident> incidents = session.createQuery(query).getResultList();
        logger.debug("List of all incidents: " + incidents);
        session.close();
        return incidents;
    }
}
