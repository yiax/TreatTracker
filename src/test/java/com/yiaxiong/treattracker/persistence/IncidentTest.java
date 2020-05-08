package com.yiaxiong.treattracker.persistence;

import com.yiaxiong.treattracker.entity.Incident;
import com.yiaxiong.treattracker.entity.User;
import com.yiaxiong.treattracker.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by yiaxiong.
 */
public class IncidentTest {

    GenericDao dao;
    List<Incident> incidents;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Sets up.
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        dao = new GenericDao(Incident.class);
        Database database = Database.getInstance();
        database.runSQL("create.sql");
        incidents = dao.getAll();
    }

    @After
    public void clean() throws Exception {
        Database database = Database.getInstance();
        database.runSQL("create.sql");
    }

    /**
     * Test get all users.
     * @throws Exception the exception
     */
   /* @Test
    public void testGetAllIncidents() throws Exception {
        assertTrue(incidents.size() == 4);
        assertTrue(incidents.get(0).getUser().getEmail().equals("lmcmanus@treattracker.com"));
        assertTrue(incidents.get(0).getDescription().equals("treats for all"));

        logger.debug("GetAllTestPass");
    }*/

    /**
     * Test update user.
     * @throws Exception the exception
     */
  /*  @Test
    public void testUpdateIncident() throws Exception {
        Incident incidents = this.incidents.get(0);
        int id = incidents.getId();

        String newDescription = incidents.getDescription() + "test";
        incidents.setDescription(newDescription);

        dao.saveOrUpdate(incidents);

        Incident updatedIncident = (Incident) dao.getById(id);
        logger.debug("incidents: " + incidents.toString());
        logger.debug("updatedIncident: " + updatedIncident.toString());
        assertTrue(incidents.equals(updatedIncident));
    }*/

    /**
     * Test delete user.
     * @throws Exception the exception
     */
  /*  @Test
    public void testDeleteIncident() throws Exception {
        int sizeBeforeDelete = incidents.size();
        Incident incidentToDelete = incidents.get(1);
        int id = incidentToDelete.getId();
        dao.delete(incidentToDelete);
        int sizeAfterDelete = dao.getAll().size();

        Incident deletedIncident = (Incident) dao.getById(id);

        assertEquals(sizeBeforeDelete - 1, sizeAfterDelete);
        assertNull(deletedIncident);
    }*/

    /**
     * Test add user.
     *
     * @throws Exception the exception
     */
   /* @Test
    public void testAddIncident() throws Exception {

        int insertedIncidentId = 0;
        GenericDao userDAO = new GenericDao(User.class);
        User user = (User) userDAO.getById(1);
        Incident incident = new Incident();
        incident.setUser(user);
        incident.setDescription("testingAddIncident");

        insertedIncidentId = dao.insert(incident);
        Incident retrievedIncident = (Incident) dao.getById(insertedIncidentId);

        assertTrue(insertedIncidentId > 0);
        assertEquals(incident, retrievedIncident);
    }*/

    /**
     * Test get all incidents that belong to a particular user.
     * @throws Exception the exception
     */
    @Test
   public void testGetAllIncidentsFromAUser() throws Exception {
        incidents = dao.findByPropertyEqual("user", 4);
        assertTrue(incidents.size() > 0);
        assertTrue(incidents.get(0).getDescription().equals("yummy treats soon"));
        assertTrue(incidents.get(1).getDescription().equals("treats treats treats"));
    }
}
