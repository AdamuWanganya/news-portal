package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void instantiatesUserCorrectly() {
        User testUser = setUpUser();
        assertTrue(testUser instanceof User);
    }

    @Test
    void gettersWorkCorrectly() {
        User testUser = setUpUser();
        assertEquals("Adamu", testUser.getName());
    }

    @Test
    void equalsWorksCorrectly() {
        User testUser1 = setUpUser();
        User testUser8 = setUpUser();
        assertTrue(testUser1.equals(testUser8));
    }

    public User setUpUser() {
        User testUser = new User("Adamu", 3, "CTO", 5);
        return testUser;
    }

}