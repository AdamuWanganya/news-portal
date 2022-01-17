package models;

import java.sql.Timestamp;
import java.util.Objects;

public class News {
    private int id;
    private int userid;
    private String type;
    private String content;
    private Timestamp postdate;

    public News(int id, int userId, String type, String content, Timestamp postdate) {
        this.id = id;
        this.userid = userId;
        this.type = type;
        this.content = content;
        this.postdate = postdate;
    }
}