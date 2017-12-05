package pers.mao.web;

import org.apache.commons.beanutils.BeanUtils;
import pers.mao.domain.Product;
import pers.mao.service.AdminProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class AdminUpdateProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Map<String, String[]> parameterMap = req.getParameterMap();

        Product product = new Product();
        try {
            BeanUtils.populate(product, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        product.setPimage("products/1/c_0033.jpg");
        product.setPflag(0);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String pdate = format.format(new Date());
        product.setPdate(pdate);

        AdminProductService service = new AdminProductService();
        try {
            service.updateProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect(req.getContextPath() + "/adminProductList");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
