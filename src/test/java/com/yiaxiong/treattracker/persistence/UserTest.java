package com.yiaxiong.treattracker.persistence;

import com.yiaxiong.treattracker.entity.Role;
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
        assertTrue(users.size() == 6);
        assertTrue(users.get(0).getFirstName().equals("Layla"));
        assertTrue(users.get(0).getLastName().equals("Mcmanus"));
        assertTrue(users.get(0).getEmail().equals("lmcmanus@treattracker.com"));
        assertTrue(users.get(0).getUserName().equals("lmcmanus"));

        assertTrue(users.get(1).getFirstName().equals("Faye"));
        assertTrue(users.get(1).getLastName().equals("Odling"));
        assertTrue(users.get(1).getEmail().equals("folding@treattracker.com"));
        assertTrue(users.get(1).getUserName().equals("fodling"));

        assertTrue(users.get(2).getFirstName().equals("Kerys"));
        assertTrue(users.get(2).getLastName().equals("Yates"));
        assertTrue(users.get(2).getEmail().equals("kyates@treattracker.com"));
        assertTrue(users.get(2).getUserName().equals("kyates"));

        assertTrue(users.get(3).getFirstName().equals("Jeanne"));
        assertTrue(users.get(3).getLastName().equals("Bate"));
        assertTrue(users.get(3).getEmail().equals("jbate@treattracker.com"));
        assertTrue(users.get(3).getUserName().equals("jbate"));

        assertTrue(users.get(4).getFirstName().equals("Abid"));
        assertTrue(users.get(4).getLastName().equals("Duggan"));
        assertTrue(users.get(4).getEmail().equals("aduggan@treattracker.com"));
        assertTrue(users.get(4).getUserName().equals("aduggan"));

        assertTrue(users.get(5).getFirstName().equals("Abraham"));
        assertTrue(users.get(5).getLastName().equals("Warren"));
        assertTrue(users.get(5).getEmail().equals("awarren@treattracker.com"));
        assertTrue(users.get(5).getUserName().equals("awarren"));

        logger.debug("GetAllTestPass");
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

        User user = new User("Unit", "Test", "UnitTestB", "userdaotest@gmail.com", "supersecretTest");

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
        users = dao.findByPropertyEqual("last_name", "Yates");
        assertTrue(users.size() > 0);
        assertTrue(users.get(0).getFirstName().equals("Kerys"));
    }
}
