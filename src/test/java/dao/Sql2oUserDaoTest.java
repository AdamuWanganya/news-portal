package dao;

import models.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class Sql2oUserDaoTest {
    private static Sql2oUserDao sql2oUserDao;
    private static Connection conn;

    @BeforeAll
    static void setUp() {
        String connectionString = "jdbc:postgresql://localhost:5432/portal_news_test";
        Sql2o sql2o = new Sql2o(connectionString, "adamu", "Adamu");
        sql2oUserDao = new Sql2oUserDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    void afterEach() {
        sql2oUserDao.clearAll();
    }

    @AfterAll
    static void tearDown() {
        conn.close();
    }

    @Test
    void userSavedAndReturnedFromDb() {
        User testUser = setUpUser();
        sql2oUserDao.save(testUser);
        User savedUser = sql2oUserDao.findById(testUser.getId());
        assertTrue(testUser.equals(savedUser));
    }

    public User setUpUser() {
        User testUser = new User("Adamu", 1, "CTO", 5);
        return testUser;
    }

}