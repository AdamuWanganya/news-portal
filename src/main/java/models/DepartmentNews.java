package models;

import java.sql.Timestamp;
import java.util.Objects;

public class DepartmentNews extends News {
    //departmentID
    private int departmentId;

    public DepartmentNews(int id, int userId, String type, String content, Timestamp postdate, int departmentId) {
        super(id, userId, type, content, postdate);
        this.departmentId = departmentId;
    }
}