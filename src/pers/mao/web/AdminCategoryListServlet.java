package pers.mao.web;

import pers.mao.domain.Category;
import pers.mao.service.AdminCategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminCategoryListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminCategoryService service = new AdminCategoryService();
        List<Category> categoryList = null;
        try {
            categoryList = service.getAllCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("categoryList", categoryList);

        req.getRequestDispatcher("/admin/category/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
