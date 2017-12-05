package pers.mao.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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

    public void addProduct(Product product) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?)";
        runner.update(sql,
                product.getPid(),
                product.getPname(),
                product.getMarket_price(),
                product.getShop_price(),
                product.getPimage(),
                product.getPdate(),
                product.getIs_hot(),
                product.getPdesc(),
                product.getPflag(),
                product.getCid());
    }

    public Product findProduct(String pid) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where pid = ? order by cid";
        return runner.query(sql, new BeanHandler<Product>(Product.class), pid);
    }

    public void updateProduct(Product product) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update product set pname=?,market_price=?,shop_price=?,pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid=?";
        runner.update(sql,
                product.getPname(),
                product.getMarket_price(),
                product.getShop_price(),
                product.getPimage(),
                product.getPdate(),
                product.getIs_hot(),
                product.getPdesc(),
                product.getPflag(),
                product.getCid(),
                product.getPid());
    }

    public void deleteProduct(String pid) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from product where pid = ?";
        runner.update(sql,pid);
    }
}
