package pers.mao.web;

import org.apache.commons.beanutils.BeanUtils;
import pers.mao.domain.Category;
import pers.mao.service.AdminCategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AdminAddCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Map<String, String[]> parameterMap = req.getParameterMap();
        Category category = new Category();
        try {
            BeanUtils.populate(category, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        AdminCategoryService service = new AdminCategoryService();
        List<Category> categoryList = null;
        try {
            categoryList = service.getAllCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        category.setCid(categoryList.size()+1);

        try {
            service.addCategory(category);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/adminCategoryList");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
