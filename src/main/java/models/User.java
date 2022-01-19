package models;

import java.util.Objects;

public class User {
    private final String name;
    private int departmentId;
    private int id;
    private final String position;
    private final int yearsActive;

    public User(String name, int departmentId, String position, int yearsActive) {
        this.name = name;
        this.departmentId = departmentId;
        this.position = position;
        this.yearsActive = yearsActive;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getYearsActive() {
        return yearsActive;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getPosition() {
        return position;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return departmentId == user.departmentId && id == user.id && yearsActive == user.yearsActive && name.equals(user.name) && position.equals(user.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, departmentId, id, position, yearsActive);
    }
}
