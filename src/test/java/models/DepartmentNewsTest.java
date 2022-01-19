package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentNewsTest {

    @Test
    void DepartmentInstantiatedCorrectly() {
        DepartmentNews testDepartmentNews = setUpDepartmentNews();
        assertTrue(testDepartmentNews instanceof DepartmentNews);
    }

    @Test
    void gettersWorking_true() {
        DepartmentNews testDepartmentNews = setUpDepartmentNews();
        assertEquals("quit", testDepartmentNews.getName());
    }

    @Test
    void equalsWorksAccordingly() {
        DepartmentNews testDepartmentNews1 = setUpDepartmentNews();
        DepartmentNews testDepartmentNews2 = setUpDepartmentNews();
        assertTrue(testDepartmentNews1.equals(testDepartmentNews2));
    }

    public DepartmentNews setUpDepartmentNews() {
        DepartmentNews testDepartmentNews = new DepartmentNews("quit", "bored by working conditions");
        return testDepartmentNews;
    }

}