package pers.mao.web;

import pers.mao.domain.Category;
import pers.mao.domain.Product;
import pers.mao.service.AdminCategoryService;
import pers.mao.service.AdminProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminEditProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        AdminProductService service = new AdminProductService();
        AdminCategoryService service1 = new AdminCategoryService();
        Product product = null;
        List<Category> categoryList= null;
        try {
            product = service.findProduct(pid);
            categoryList = service1.getAllCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (categoryList!=null&&categoryList.size()>0){
            for (Category c:categoryList){
                if (product.getCid().equals(String.valueOf(c.getCid()))){
                    categoryList.remove(c);
                    categoryList.add(0,c);
                    break;
                }
            }
        }

        req.setAttribute("product",product);
        req.setAttribute("categoryList",categoryList);
        req.getRequestDispatcher("/admin/product/edit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
