package dao;

import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNewsDao implements NewsDao {

    private final Sql2o sql2o;

    public Sql2oNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void save(News news) {
        try(Connection con = sql2o.open()) {
            String sql = "INSERT INTO news (name, content, departmentid) VALUES (:name, :content, :departmentId)";
            int id = (int) con.createQuery(sql).bind(news)
                    .addParameter("name", news.getName())
                    .addParameter("content", news.getContent())
                    .addParameter("departmentId", news.getDepartmentId()).executeUpdate().getKey();
            news.setId(id);
        } catch (Sql2oException e) {
            System.out.println(e);
        }
    }

    @Override
    public News findById(int id) {
        try(Connection con = sql2o.open()) {
            String sql = "SELECT * FROM news WHERE id = :id";
            return con.createQuery(sql).addParameter("id", id).executeAndFetchFirst(News.class);
        }
    }

    @Override
    public List<News> getAll() {
        try(Connection con = sql2o.open()) {
            String sql = "SELECT * FROM news";
            return con.createQuery(sql).executeAndFetch(News.class);
        }
    }

    @Override
    public void clearAll() {
        String sql1 = "TRUNCATE TABLE news";
        String sql2 = "ALTER SEQUENCE news_id_seq RESTART";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql1).executeUpdate();
            con.createQuery(sql2).executeUpdate();
        } catch (Sql2oException e) {
            System.out.println(e);
        }
    }

}
