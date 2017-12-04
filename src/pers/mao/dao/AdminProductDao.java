package pers.mao.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pers.mao.domain.Product;
import pers.mao.utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

public class AdminProductDao {


    public List<Product> getAllProductList() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product";
        List<Product> productList = runner.query(sql,new BeanListHandler<Product>(Product.class));
        return productList;
    }
}
