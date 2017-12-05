package pers.mao.dao;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pers.mao.domain.Category;
import pers.mao.utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class AdminCategoryDao {

    public List<Category> getAllCategory() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from category order by cid";
        List<Category> categoryList = runner.query(sql,new BeanListHandler<Category>(Category.class));
        return categoryList;
    }

    public Category getCategory(String cid) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from category where cid = ?";
        Category category = runner.query(sql,new BeanHandler<Category>(Category.class),cid);
        return category;
    }

    public void addCategory(Category category) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into category values(?,?)";
        runner.update(sql,category.getCid(),category.getCname());
    }

    public void deleteCategory(String cid) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from category where cid = ?";
        runner.update(sql,cid);
    }

    public void updateCategory(Category category) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update category set cname = ? where cid = ?";
        runner.update(sql, category.getCname(),category.getCid());
    }
}
