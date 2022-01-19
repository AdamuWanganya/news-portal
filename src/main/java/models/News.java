package models;

import java.util.Objects;

public class News {
    private String name;
    private String content;
    private int departmentId;
    private int id;

    public News(String name, String content, int departmentId) {
        this.name = name;
        this.content = content;
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return departmentId == news.departmentId && id == news.id && name.equals(news.name) && content.equals(news.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, content, departmentId, id);
    }
}
