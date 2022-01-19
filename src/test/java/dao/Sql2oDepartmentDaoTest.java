package dao;

import models.Department;
import models.News;
import models.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sql2o.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Sql2oDepartmentDaoTest {
    private static Sql2oDepartmentDao sql2oDepartmentDao;
    private static Sql2oNewsDao sql2oNewsDao;
    private static Sql2oUserDao sql2oUserDao;
    private static Connection conn;

    @BeforeAll
    static void setUp() {
        String connectionString = "jdbc:postgresql://localhost:5432/portal_news_test";
        Sql2o sql2o = new Sql2o(connectionString, "adamu", "Adamu");
        sql2oDepartmentDao = new Sql2oDepartmentDao(sql2o);
        sql2oNewsDao = new Sql2oNewsDao(sql2o);
        sql2oUserDao = new Sql2oUserDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    void afterEach() {
        sql2oDepartmentDao.clearAll();
        sql2oNewsDao.clearAll();
        sql2oUserDao.clearAll();
        sql2oDepartmentDao.clearAllNewsAndDepartments();
        sql2oDepartmentDao.clearAllUsersAndDepartments();
    }

    @AfterAll
    static void tearDown() {
        conn.close();
    }

    @Test
    void departmentGetsSavedAndReturnedProperlyFromDB() {
        Department testDepartment = setUpDepartment();
        sql2oDepartmentDao.save(testDepartment);
        Department returnedDepartment = sql2oDepartmentDao.findById(testDepartment.getId());
        assertTrue(testDepartment.equals(returnedDepartment));
    }

    @Test
    void allNewsInDepartmentGetsSavedInDbAndReturned() {
        List<News> savedNews = new ArrayList<>();
        Department testDepartment = setUpDepartment();
        sql2oDepartmentDao.save(testDepartment);
        News testNews1 = new News("Coding", "Interview passed", testDepartment.getId());
        News testNews3 = new News("Adamu", "CTO Google", testDepartment.getId());
        sql2oNewsDao.save(testNews1);
        sql2oNewsDao.save(testNews3);
        sql2oDepartmentDao.saveNewsAndDepartment(testDepartment, testNews1);
        sql2oDepartmentDao.saveNewsAndDepartment(testDepartment, testNews3);
        List<News> returnedNews = sql2oDepartmentDao.getAllDepartmentNews(testDepartment.getId());
        savedNews.add(testNews1);
        savedNews.add(testNews3);
        assertEquals(savedNews, returnedNews);
    }

    @Test
    void allUsersInDepartmentGetsSavedInDbAndReturned() {
        List<User> savedUsers = new ArrayList<>();
        Department testDepartment = setUpDepartment();
        sql2oDepartmentDao.save(testDepartment);
        User testUser = new User("Adamu", testDepartment.getId(), "CTO", 5);
        User testUser2 = new User("Hassan", testDepartment.getId(), "CEO", 12);
        sql2oUserDao.save(testUser);
        sql2oUserDao.save(testUser2);
        sql2oDepartmentDao.saveUsersAndDepartment(testDepartment, testUser);
        sql2oDepartmentDao.saveUsersAndDepartment(testDepartment, testUser2);
        List<User> returnedUsers = sql2oDepartmentDao.getAllDepartmentUsers(testDepartment.getId());
        savedUsers.add(testUser);
        savedUsers.add(testUser2);
        assertEquals(savedUsers, returnedUsers);
    }

    public Department setUpDepartment() {
        Department testDepartment = new Department("IT", "Coding and programming");
        return testDepartment;
    }
}