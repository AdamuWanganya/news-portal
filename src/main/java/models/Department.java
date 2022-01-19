package models;

import java.util.Objects;

public class Department {
    private String name;
    private String description;
    private int noOfEmployees;
    private int id;

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public int getNoOfEmployees() {
        return noOfEmployees;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNoOfEmployees(int noOfEmployees) {
        this.noOfEmployees = noOfEmployees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return noOfEmployees == that.noOfEmployees && id == that.id && name.equals(that.name) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, noOfEmployees, id);
    }
}
