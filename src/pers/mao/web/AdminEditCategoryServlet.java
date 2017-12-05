package pers.mao.web;

import pers.mao.domain.Category;
import pers.mao.service.AdminCategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AdminEditCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String cid = request.getParameter("cid");
        AdminCategoryService service = new AdminCategoryService();
        Category category = null;
        try {
            category = service.getCategory(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("category",category);

        request.getRequestDispatcher("/admin/category/edit.jsp").forward(request,response);
    }
}
