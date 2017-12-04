package pers.mao.service;

import pers.mao.dao.AdminProductDao;
import pers.mao.domain.Product;

import java.sql.SQLException;
import java.util.List;

public class AdminProductService {

    public List<Product> getAllProductList() throws SQLException {
        AdminProductDao dao = new AdminProductDao();
        return dao.getAllProductList();
    }
}
