package com.yiaxiong.treattracker.persistence;

import com.yiaxiong.treattracker.entity.Resolve;
import com.yiaxiong.treattracker.entity.Resolve;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ResolveDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public ResolveDao() {}

    /**
     * Get Resolve by id
     */
    public Resolve getById(int id) {
        Session session = sessionFactory.openSession();
        Resolve resolve = session.get(Resolve.class, id);
        logger.debug("Resolve id # " + id + ": " + resolve);
        session.close();
        return resolve;
    }

    /**
     * Update Resolve
     * @param resolve  resolve to be updated
     */
    public void saveOrUpdate(Resolve resolve) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(resolve);
        transaction.commit();
        logger.debug("Updated Resolve: " + resolve);
        session.close();
    }

    /**
     * Insert Resolve
     * @param resolve  Resolve to be inserted
     */
    public int insert(Resolve resolve) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int) session.save(resolve);
        transaction.commit();
        logger.debug("Resolve Inserted: " + resolve);
        session.close();
        return id;
    }

    /**
     * Delete an Resolve
     * @param resolve Resolve to be deleted
     */
    public void delete(Resolve resolve) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(resolve);
        logger.debug("Deleted Resolve: " + resolve);
        transaction.commit();
        session.close();
    }

    /**
     * Return a list of all Resolves
     * @return All Resolves
     */
    public List<Resolve> getAllResolves() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Resolve> query = builder.createQuery(Resolve.class);
        Root<Resolve> root = query.from(Resolve.class);
        List<Resolve> resolves = session.createQuery(query).getResultList();
        logger.debug("List of all resolves: " + resolves);
        session.close();
        return resolves;
    }
}
