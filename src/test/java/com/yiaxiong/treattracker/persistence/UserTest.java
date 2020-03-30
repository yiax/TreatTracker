package com.yiaxiong.treattracker.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.yiaxiong.treattracker.entity.User;
import com.yiaxiong.treattracker.util.Database;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by yiaxiong.
 */
public class UserTest {

    GenericDao dao;
    List<User> users;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Sets up.
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        dao = new GenericDao(User.class);
        Database database = Database.getInstance();
        database.runSQL("create.sql");
        users = dao.getAll();
    }

    /**
     * Test get all users.
     * @throws Exception the exception
     */
    @Test
    public void testGetAllUsers() throws Exception {
        assertTrue(users.size() > 0);
        assertFalse(users.get(1).getFirstName().equals("Layla"));
        assertFalse(users.get(1).getLastName().equals("Mcmanus"));
        assertFalse(users.get(1).getEmail().equals("lmcmanus@treattracker.com"));
        assertFalse(users.get(1).getUserName().equals("lmcmanus"));
    }

    /**
     * Test update user.
     * @throws Exception the exception
     */
    @Test
    public void testUpdateUser() throws Exception {
        User user = users.get(0);
        int id = user.getId();

        String newEmail = user.getEmail() + "test";
        user.setEmail(newEmail);

        dao.saveOrUpdate(user);

        User updatedUser = (User) dao.getById(id);
        logger.debug("user: " + user.toString());
        logger.debug("updatedUser: " + updatedUser.toString());
        assertTrue(user.equals(updatedUser));
    }

    /**
     * Test delete user.
     * @throws Exception the exception
     */
    @Test
    public void testDeleteUser() throws Exception {
        int sizeBeforeDelete = users.size();
        User userToDelete = users.get(3);
        int id = userToDelete.getId();
        dao.delete(userToDelete);
        int sizeAfterDelete = dao.getAll().size();

        User deletedUser = (User) dao.getById(id);

        assertEquals(sizeBeforeDelete - 1, sizeAfterDelete);
        assertNull(deletedUser);
    }

    /**
     * Test add user.
     *
     * @throws Exception the exception
     */
    @Test
    public void testAddUser() throws Exception {

        int insertedUserId = 0;

        User user = new User();
        user.setFirstName("Unit");
        user.setLastName("Test");
        user.setUserName("UnitTesterB");
        user.setEmail("UserDaoTesterB@gmail.com");
        user.setPassword("supersecret");

        insertedUserId = dao.insert(user);
        User retrievedUser = (User) dao.getById(insertedUserId);

        assertTrue(insertedUserId > 0);
        assertEquals(user, retrievedUser);
    }

    /**
     * Test get all users with last name exact.
     * @throws Exception the exception
     */
    @Test
    public void testGetAllUsersWithLastNameExact() throws Exception {
        users = dao.findByPropertyEqual("lastName", "Yates");
        assertTrue(users.size() > 0);
        assertTrue(users.get(0).getFirstName().equals("Kerys"));
    }
}
