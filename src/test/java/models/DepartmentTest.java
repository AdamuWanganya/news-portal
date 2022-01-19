package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @Test
    void departmentInstantiatedCorrectly() {
        Department testDepartment = setUpDepartment();
        assertTrue(testDepartment instanceof Department);
    }

    @Test
    void equalsWorksTrue() {
        Department testDepartment1 = setUpDepartment();
        Department testDepartment4 = new Department("Information Technology", "troubleshooting");
        assertFalse(testDepartment1.equals(testDepartment4));
    }

    public Department setUpDepartment() {
        Department testDepartment = new Department("Software Engineering", "coding and programming");
        return testDepartment;
    }
}