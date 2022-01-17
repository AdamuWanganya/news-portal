package models;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String position;
    private String role;
    private int departmentId;

    public User(int id, String name, String position, String role, int departmentId) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.role = role;
        this.departmentId = departmentId;
    }
}