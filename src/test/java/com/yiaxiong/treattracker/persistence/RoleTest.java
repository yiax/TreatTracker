package com.yiaxiong.treattracker.persistence;

import com.yiaxiong.treattracker.entity.Role;
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
public class RoleTest {

    GenericDao dao;
    List<Role> roles;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        dao = new GenericDao(Role.class);
        Database database = Database.getInstance();
        database.runSQL("create.sql");
        roles = dao.getAll();
    }

    /**
     * Test get all users.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetAllRoles() throws Exception {
        assertTrue(roles.size() > 0);
        assertTrue(roles.size() == 2);
        logger.info(roles.get(0).getRole());
        for (Role role : roles ) {
            if (role.getId() == 1) {
                assertTrue(role.getRole().equals("basic"));
            }
            if (role.getId() == 2) {
                assertTrue(role.getRole().equals("admin"));
            }
        }
    }

    /**
     * Test update user.
     *
     * @throws Exception the exception
     */
    @Test
    public void testUpdateRole() throws Exception {
        Role role = roles.get(0);
        int id = role.getId();

        String newRole = role.getRole() + "test";
        role.setRole(newRole);

        dao.saveOrUpdate(role);

        Role updatedRole = (Role) dao.getById(id);
        logger.debug("user: " + role.toString());
        logger.debug("updatedUser: " + updatedRole.toString());
        assertTrue(role.equals(updatedRole));
    }

    /**
     * Test delete user.
     *
     * @throws Exception the exception
     */
    @Test
    public void testDeleteRole() throws Exception {
        int sizeBeforeDelete = roles.size();
        Role roleToDelete = roles.get(1);
        int id = roleToDelete.getId();
        dao.delete(roleToDelete);
        int sizeAfterDelete = dao.getAll().size();

        Role deletedRole = (Role) dao.getById(id);

        assertEquals(sizeBeforeDelete - 1, sizeAfterDelete);
        assertNull(deletedRole);
    }

    /**
     * Test add user.
     *
     * @throws Exception the exception
     */
    @Test
    public void testAddRole() throws Exception {

        int insertedRoleId = 0;

        Role role = new Role();
        role.setRole("testRole");

        insertedRoleId = dao.insert(role);
        Role retrievedUser = (Role) dao.getById(insertedRoleId);

        assertTrue(insertedRoleId > 0);
        assertEquals(role, retrievedUser);
    }
}
