package exercises.capinterview;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserDaoTest {

    private UserDao userDao;  // The DAO we're testing
    private User user;        

    @BeforeEach
     void setUp() {
        // Mocking the UserDao class and setting up the test scenario
        userDao = mock(UserDao.class);
        user = new User(1, "John", "john@example.com");
    }

    @Test
    void testAddUser() {
        // Simulate adding a user
        doNothing().when(userDao).addUser(user);  // Mock the addUser method

        // Run the method and check the result
        userDao.addUser(user);
        verify(userDao, times(1)).addUser(user);  // Verify that addUser was called exactly once
    }

    @Test
     void testGetUser() {
        // Simulate the behavior of getting a user by ID
        when(userDao.getUser(1)).thenReturn(user);

        // Run the method and assert the result
        User retrievedUser = userDao.getUser(1);
        assertNotNull(retrievedUser, "User should not be null");
        assertEquals("John", retrievedUser.getName(), "User name should be John");
    }

    @Test
    void testGetAllUsers() {
        // Create a list of users and mock the return value
        List<User> userList = Arrays.asList(new User(1, "John", "john@example.com"), new User(2, "Jane", "jane@example.com"));
        when(userDao.getAllUsers()).thenReturn(userList);

        // Run the method and verify the result
        List<User> users = userDao.getAllUsers();
        assertNotNull(users, "Users list should not be null");
        assertEquals(2, users.size(), "Users list should contain 2 users");
    }

    @Test
    void testUpdateUser() {
        // Update the user's details and mock the update method
        user.setEmail("newemail@example.com");
        doNothing().when(userDao).updateUser(user);  // Mock the updateUser method

        // Run the method and verify the result
        userDao.updateUser(user);
        verify(userDao, times(1)).updateUser(user);  // Verify that updateUser was called exactly once
    }

    @Test
    void testDeleteUser() {
        // Simulate deleting a user by ID
        doNothing().when(userDao).deleteUser(1);  // Mock the deleteUser method

        // Run the method and verify the result
        userDao.deleteUser(1);
        verify(userDao, times(1)).deleteUser(1);  // Verify that deleteUser was called exactly once
    }

    @AfterEach
     void tearDown() {
        // Clean up after each test
        userDao = null;
        user = null;
    }
}
