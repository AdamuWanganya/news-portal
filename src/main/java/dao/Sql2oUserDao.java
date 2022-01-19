package dao;

import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUserDao implements UserDao{

    private final Sql2o sql2o;

    public Sql2oUserDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void save(User user) {
        try(Connection con = sql2o.open()) {
            String sql = "INSERT INTO users (name, position, yearsactive, departmentid) VALUES (:name, :position, :yearsActive, :departmentId)";
            int id = (int) con.createQuery(sql)
                    .bind(user)
                    .addParameter("name", user.getName())
                    .addParameter("position", user.getPosition())
                    .addParameter("yearsActive", user.getYearsActive())
                    .addParameter("departmentId", user.getDepartmentId())
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        }
    }

    @Override
    public User findById(int id) {
        try(Connection con = sql2o.open()) {
            String sql = "SELECT * FROM users WHERE id = :id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(User.class);
        }
    }

    @Override
    public List<User> getAll() {
        try(Connection con = sql2o.open()) {
            String sql = "SELECT * FROM users";
            return con.createQuery(sql).executeAndFetch(User.class);
        }
    }

    @Override
    public void clearAll() {
        String sql1 = "TRUNCATE TABLE users";
        String sql2 = "ALTER SEQUENCE users_id_seq RESTART";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql1).executeUpdate();
            con.createQuery(sql2).executeUpdate();
        } catch (Sql2oException e) {
            System.out.println(e);
        }
    }
}
