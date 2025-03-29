package exercises2capinterview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {

    private UserDao userDao;


    @Test
    void testAddUser() {
        User user = new User(0, "Jane Doe", "janedoe@example.com");
        userDao.addUser(user);
        User fetchedUser = userDao.getUser(1);
        assertNotNull(fetchedUser);
        assertEquals("Jane Doe", fetchedUser.getName());
    }

    @Test
    void testGetAllUsers() {
        User user1 = new User(0, "Alice", "alice@example.com");
        User user2 = new User(0, "Bob", "bob@example.com");
        userDao.addUser(user1);
        userDao.addUser(user2);
        assertEquals(2, userDao.getAllUsers().size());
    }

    @Test
    void testUpdateUser() {
        User user = new User(0, "Charlie", "charlie@example.com");
        userDao.addUser(user);
        user.setName("Charlie Updated");
        userDao.updateUser(user);
        User updatedUser = userDao.getUser(user.getId());
        assertEquals("Charlie Updated", updatedUser.getName());
    }

    @Test
    void testDeleteUser() {
        User user = new User(0, "David", "david@example.com");
        userDao.addUser(user);
        userDao.deleteUser(user.getId());
        assertNull(userDao.getUser(user.getId()));
    }
}
