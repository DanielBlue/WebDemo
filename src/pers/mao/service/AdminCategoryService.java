package pers.mao.service;

import pers.mao.dao.AdminCategoryDao;
import pers.mao.domain.Category;

import java.sql.SQLException;
import java.util.List;

public class AdminCategoryService {
    public List<Category> getAllCategory() throws SQLException {
        AdminCategoryDao dao = new AdminCategoryDao();
        return dao.getAllCategory();
    }
}
