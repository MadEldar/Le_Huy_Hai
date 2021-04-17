package com.Le_Huy_Hai.Servlet;

import com.Le_Huy_Hai.Dao.PhoneDao;
import com.Le_Huy_Hai.Entity.PhoneEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddPhoneServlet", urlPatterns = {"/phone-add"})
public class AddPhoneServlet extends HttpServlet {
    PhoneDao dao = new PhoneDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");

        if (name.isEmpty() || brand.isEmpty() || description.isEmpty() || price <= 0) {
            response.sendRedirect("/");
        }

        PhoneEntity phone = new PhoneEntity(name, brand, price, description);

        dao.insertPhone(phone);

        response.sendRedirect("home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("phone-add.jsp").forward(request, response);
    }
}
