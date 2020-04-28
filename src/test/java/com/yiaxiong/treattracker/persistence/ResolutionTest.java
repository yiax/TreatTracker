package com.yiaxiong.treattracker.persistence;

import com.yiaxiong.treattracker.entity.Resolution;
import com.yiaxiong.treattracker.entity.User;
import com.yiaxiong.treattracker.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by yiaxiong.
 */
public class ResolutionTest {

    GenericDao dao;
    List<Resolution> resolutions;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Sets up.
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        dao = new GenericDao(Resolution.class);
        Database database = Database.getInstance();
        database.runSQL("create.sql");
        resolutions = dao.getAll();
    }

    /**
     * Test get all resolutions.
     * @throws Exception the exception
     */
    @Test
    public void testGetAllResolutions() throws Exception {
        assertTrue(resolutions.size() == 2);
        assertTrue(resolutions.get(0).getUser().getUser_name().equals("jbate"));
        assertTrue(resolutions.get(0).getDescription().equals("treats in break room"));

        assertTrue(resolutions.get(1).getUser().getUser_name().equals("aduggan"));
        assertTrue(resolutions.get(1).getDescription().equals("donuts at my desk"));

        logger.debug("GetAllTestPass");
    }

    /**
     * Test update user.
     * @throws Exception the exception
     */
    @Test
    public void testUpdateResolution() throws Exception {
        Resolution resolution = this.resolutions.get(0);
        int id = resolution.getId();

        String newDescription = resolution.getDescription() + "test";
        resolution.setDescription(newDescription);

        dao.saveOrUpdate(resolution);

        Resolution updatedResolution = (Resolution) dao.getById(id);
        logger.debug("resolution: " + resolution.toString());
        logger.debug("updatedResolution: " + updatedResolution.toString());
        assertTrue(resolution.equals(updatedResolution));
    }

    /**
     * Test delete user.
     * @throws Exception the exception
     */
    @Test
    public void testDeleteResolution() throws Exception {
        int sizeBeforeDelete = resolutions.size();
        Resolution resolutionToDelete = resolutions.get(1);
        int id = resolutionToDelete.getId();
        dao.delete(resolutionToDelete);
        int sizeAfterDelete = dao.getAll().size();

        Resolution deletedUser = (Resolution) dao.getById(id);

        assertEquals(sizeBeforeDelete - 1, sizeAfterDelete);
        assertNull(deletedUser);
    }

    /**
     * Test add user.
     *
     * @throws Exception the exception
     */
    @Test
    public void testAddResolution() throws Exception {

        int insertedResolutionId = 0;
        User testUser = new User("TestFirstName", "TestLastName", "testemail@treattracker.com", "testUserName", "testPassword");
        dao.insert(testUser);

        Resolution resolution = new Resolution();
        resolution.setDescription("test description");
        resolution.setUser(testUser);

        insertedResolutionId = dao.insert(resolution);
        Resolution retrievedResolution = (Resolution) dao.getById(insertedResolutionId);

        assertTrue(insertedResolutionId > 0);
        assertEquals(resolution, retrievedResolution);
    }

    /**
     * Test get all resolution with exact user name.
     * @throws Exception the exception
     */
   /* @Test
    public void testGetAllResolutionsWithUserNameExact() throws Exception {

        resolutions = dao.findByPropertyEqual("user", "jbate");
        assertTrue(resolutions.size() > 0);
        assertTrue(resolutions.get(0).getUser().getUserName().equals("treats in break room"));
    }*/
}
