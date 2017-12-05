package pers.mao.service;

import pers.mao.dao.AdminCategoryDao;
import pers.mao.domain.Category;

import java.sql.SQLException;
import java.util.List;

public class AdminCategoryService {
    AdminCategoryDao mDao;

    public List<Category> getAllCategory() throws SQLException {
        if (mDao == null) {
            mDao = new AdminCategoryDao();
        }
        return mDao.getAllCategory();
    }

    public void addCategory(Category category) throws SQLException {
        if (mDao == null) {
            mDao = new AdminCategoryDao();
        }
        mDao.addCategory(category);
    }

    public void deleteCategory(String cid) throws SQLException {
        if (mDao == null) {
            mDao = new AdminCategoryDao();
        }
        mDao.deleteCategory(cid);
    }

    public Category getCategory(String cid) throws SQLException {
        if (mDao == null) {
            mDao = new AdminCategoryDao();
        }
        return mDao.getCategory(cid);
    }

    public void updateCategory(Category category) throws SQLException {
        if (mDao == null) {
            mDao = new AdminCategoryDao();
        }
        mDao.updateCategory(category);
    }
}
