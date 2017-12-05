package pers.mao.service;

import com.sun.pisces.PiscesRenderer;
import pers.mao.dao.AdminProductDao;
import pers.mao.domain.Product;

import java.sql.SQLException;
import java.util.List;

public class AdminProductService {
    AdminProductDao mDao;

    public List<Product> getAllProductList() throws SQLException {
        if (mDao ==null) {
            mDao = new AdminProductDao();
        }
        return mDao.getAllProductList();
    }

    public boolean addProduct(Product product){
        if (mDao ==null) {
            mDao = new AdminProductDao();
        }
        try {
            mDao.addProduct(product);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Product findProduct(String pid) throws SQLException {
        if (mDao ==null) {
            mDao = new AdminProductDao();
        }
        return mDao.findProduct(pid);
    }

    public void updateProduct(Product product) throws SQLException{
        if (mDao ==null) {
            mDao = new AdminProductDao();
        }
        mDao.updateProduct(product);
    }

    public void deleteProduct(String pid) throws SQLException {
        if (mDao ==null) {
            mDao = new AdminProductDao();
        }
        mDao.deleteProduct(pid);
    }
}
