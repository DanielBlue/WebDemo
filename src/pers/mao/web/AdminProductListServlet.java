package pers.mao.web;

import pers.mao.domain.Product;
import pers.mao.service.AdminProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminProductListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminProductService service = new AdminProductService();
        List<Product> productList=null;
        try {
            productList = service.getAllProductList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("productList",productList);
        req.getRequestDispatcher("/admin/product/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
