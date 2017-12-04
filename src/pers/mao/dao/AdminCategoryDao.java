package pers.mao.dao;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pers.mao.domain.Category;
import pers.mao.utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class AdminCategoryDao {

    public List<Category> getAllCategory() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from category";
        List<Category> categoryList = runner.query(sql,new BeanListHandler<Category>(Category.class));
        return categoryList;
    }
}
